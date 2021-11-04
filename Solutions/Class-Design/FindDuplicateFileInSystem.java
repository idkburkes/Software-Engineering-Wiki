 
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

 class FindDuplicateFileInSystem {
     

    public List<List<String>> findDuplicate(String[] paths) {

            /**
             *  Use a Map to store key-value pairs with O(1) lookup
             *      key - content
             *      value - List of directory/file paths
             * 
             */

            Map<String, List<String>> map = new HashMap<>();

            // For each path, use content as key value to 
            // store in list of files with matching content
            for(String path : paths) {
                String[] values = path.split(" ");
                String dir = values[0];

                // For each file in this directory
                for(int i = 1; i < values.length; i++) {
                    // Parse name of file and file content
                    String[] name_content = values[i].split("(");
                    String name = name_content[0];
                    String content = name_content[1].replace(")", "");

                    // Append this file to list of all files with matching content
                    // Create new list if no exisiting files with matching content
                    List<String> matches = map.getOrDefault(content, new ArrayList<String>());
                    matches.add(dir + "/" + name);
                    map.put(content, matches);
                }

            }

            List<List<String>> result = new ArrayList<List<String>>();

            // Store all lists of files that have matches
            for(String key : map.keySet()) {
                if(map.get(key).size() > 1) {
                    result.add(map.get(key));
                }
            }

        return result;
    }


        public static void main(String[] args) {


                int[][] array = new int[][] {{1,2}, {0, 5}};
                Arrays.sort(array, (a,b) -> a[0] - b[0]);
                for(int[] pair : array) {
                    System.out.println(pair[0] + " " + pair[1]);
                }
        }
 }