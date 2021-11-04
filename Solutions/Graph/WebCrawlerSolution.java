import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class WebCrawlerSolution {




    /**
     * 
     * Basic solution - Will use BFS
     * 
     * 
     *  This is the HtmlParser's API interface.
     *  You should not implement it, or speculate about its implementation
     *  interface HtmlParser {
     *     public List<String> getUrls(String url) {}
     * }
     * 
     * 
     */


       // Provided API will implement HtmlParser for interview
    class HtmlParser {
        public List<String> getUrls(String url) { return null;}
    }

class WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        // Queue of urls will be necessary for BFS solution
        Queue<String> urlQueue = new LinkedList<>();

        // Set of unique urls found with same hostname as startUrl
        Set<String> validUrls = new HashSet<>();

        // Find hostname of startUrl
        String hostname = getHostname(startUrl);

        urlQueue.offer(startUrl);
        validUrls.add(startUrl);

        // BFS of all 'neighboring' URLs
        while(!urlQueue.isEmpty()) {
            String sourceUrl = urlQueue.poll();
            // Check neighboring urls and add them to queue if valid
            for(String currentUrl : htmlParser.getUrls(sourceUrl)) {
                    String curHostname = getHostname(currentUrl);
                    if(curHostname.equals(hostname) && !validUrls.contains(currentUrl)) {
                        validUrls.add(currentUrl);
                        urlQueue.offer(currentUrl);
                    }
            }
        }
        // Returns the set as an array 
        return new ArrayList<String>(validUrls);
    }

    // Parse hostname from a given url
    public String getHostname(String url) {
        //Validate input
        if(!url.contains("http://")) return "";

        // Use forward slash as delimiter
        String[] split = url.split("/");
        return split[2];
    }

}


/** 
 * 
 * Implementation using Multi-threaded optimization
 * 
 */
class WebCrawlerMultithreaded {
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

    //Queue of URLs for BFS
    BlockingQueue<String> urlQueue = new LinkedBlockingQueue<>();
    urlQueue.offer(startUrl);
    String hostName = getHostName(startUrl);

    // Set of valid urls
    Set<String> visited = new HashSet<>();

    // Dequeue of future tasks
    Deque<Future> tasks = new ArrayDeque<>();


    //Create thread pool
    ExecutorService es = Executors.newFixedThreadPool(5, r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    // Perform BFS in while loop with true condition
    while(true) {
        String url = urlQueue.poll();
         // Check if there are current urls in queue
        if(url != null) {
            if(getHostName(url).equals(hostName) && !visited.contains(url)) {
                visited.add(url);

                // Submit thread task to be completed
                tasks.add(es.submit(() -> {
                    //Add all urls to queue
                for(String newUrl : htmlParser.getUrls(url)) {
                    urlQueue.offer(newUrl);
                }
                }));

               
            }
        } else {
        // No URLs currently found in the queue
        // Check if there are any remaining tasks
            if(!tasks.isEmpty()) {
                Future nextTask = tasks.poll();
                try {
                    nextTask.get();
                } catch( InterruptedException | ExecutionException e) {}
            } else {
            // Exit loop when there are no remaining urls in queue or remaining tasks
                break;
            }
        }

    }
       
    // Return all valid urls that were visited
    return new ArrayList<String>(visited);
    }


    private String getHostName(String url) {
        //Optional input validation 

        String[] split = url.split("/");
        return split[2];
    }
}


 


}