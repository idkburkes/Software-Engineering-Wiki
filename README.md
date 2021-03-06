

# Object Oriented Programming #
![OOP](./images/oop.png)

#### Encapsulation
- Encapsulation is used to hide the values or state of a structured data object inside a class, preventing direct access to them by clients in a way that could expose hidden implementation details or violate state invariance maintained by the methods.

#### Polymorphism
- Lets assume there are methods with same method signature in classes in a class hierarchy (parent-child relationships), these methods are in different forms (this is known as method overriding).
- Then when an object is assigned to a class reference and when a method of the object is called, the method in the object’s class is executed. Not the method of the reference class (if the reference is a parent class).
- [Detailed Example](https://medium.com/@shanikae/polymorphism-explained-simply-7294c8deeef7)
#### Abstraction
- Programming methodology in which details of the programming codes are hidden away from the user, and only the essential things are displayed to the user.

#### Inheritance
- Inheritance is a mechanism that allows one class to gain the properties of another class.
- Inheritance allows programmers to create a new class that reuses the data members and methods of an existing class.
- [Detailed Example](https://www.guru99.com/java-class-inheritance.html)

# Software Development Life Cycle # 
![SDLC](./images/sdlc.png)


# System Design #
![System-Design](./images/systemdesign.jpeg)

Helpful PDFs/ Articles
- [Top 10 System Design Interview Questions and Answers - geeksforgeeks](https://www.geeksforgeeks.org/top-10-system-design-interview-questions-and-answers/)
- [System Design Interview Questions – Concepts You Should Know - freecodecamp](https://www.freecodecamp.org/news/systems-design-for-interviews/)
- 
Courses
- [Grokking the System Design Interview - educative.io ](https://www.educative.io/courses/grokking-the-system-design-interview)
- [System Design Course for Beginners - YouTube](https://www.youtube.com/watch?v=MbjObHmDbZo)

# Data Structures & Algorithms # 
![Data Structures & Algorithms](./images/datastructuresalgorithms.png)

Helpful PDFs/Articles
- [hackernoon.com - 14 Patterns to Ace Any Coding Interview](https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed)
- [Cracking the Coding Interview](https://cin.ufpe.br/~fbma/Crack/Cracking%20the%20Coding%20Interview%20189%20Programming%20Questions%20and%20Solutions.pdf)

Courses
- [Grokking the Coding Interview: Patterns for Coding Questions - educative.io](https://www.educative.io/courses/grokking-the-coding-interview)
- [CodeAcademy - Pass the technical interview with Java](https://www.codecademy.com/learn/paths/pass-the-technical-interview-with-java)



 Problem | Description  | Difficulty | Algorithm/Strategy Applied | Solution
--- | --- | --- | --- | --- |
#34 - Find First and Last Position of Element in Sorted Array | [Problem Description](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Medium | Binary Search |  [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/Binary%20Search/FindFirstAndLastPositionOfElementInSortedArray.java) |
#215 - KthLargestElementInAnArray| [Problem Description](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Medium | Quick Sort | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/QuickSort/KthLargestElementInAnArray.java)  |   
#3 - Longest Substring without Repeating Characters    |  [Problem Description](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium  | Sliding Window | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/Sliding%20Window/LongestSubstringWithoutRepeatingCharacter.java) |  
#151 - Reverse Words in a String | [Problem Description](https://leetcode.com/problems/reverse-words-in-a-string/) | Medium | Sliding Window | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/Sliding%20Window/ReverseWordsInAString.java) |
#207 - Course Schedule | [Problem Description](https://leetcode.com/problems/course-schedule/) | Medium | Breadth-First Search | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/Graph/CourseSchedule.java) | 
#463 - Island Perimeter | [Problem Description](https://leetcode.com/problems/island-perimeter/) | Easy | Depth-First Search | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/Graph/IslandPerimeter.java) | 
#5 - Longest Palindromic Substring | [Problem Description](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | Dynamic Programming | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/Dynamic%20Programming/LongestPalindromicSubstring.java) |
#210 - Course Schedule II | [Problem Description](https://leetcode.com/problems/course-schedule-ii/) | Medium | Breadth-First Search | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/Graph/CourseSchedule2.java) |
#148 Sort List | [Problem Description](https://leetcode.com/problems/sort-list/) | Medium | Merge Sort / Fast&Slow Pointer | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/LinkedList/SortList.java) |
#206 Reverse Linked List | [Problem Description](https://leetcode.com/problems/reverse-linked-list/) | Easy | LinkedList Pointer Manipulation | [Java](https://github.com/idkburkes/Algorithm-Practice/blob/master/Solutions/LinkedList/ReverseLinkedList.java) |
#141 Linked List Cycle | [Problem Description](https://leetcode.com/problems/linked-list-cycle/) | Easy | Fast&Slow Pointer | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/LinkedList/LinkedListCycle.java) | 
#21 Merge Two Sorted Lists | [Problem Description](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Merge Sort on LinkedList | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/LinkedList/MergeTwoSortedLists.java)
#23 Merge K Lists | [Problem Description](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Merge Sort on LinkedList | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/LinkedList/MergeKLists.java)
#19 Remove Nth Node from end of list | [Problem Description](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Fast&Slow Pointer | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/LinkedList/RemoveNthFromEnd.java) |
#143 Reorder List | [Problem Description](https://leetcode.com/problems/reorder-list/) | Medium | Fast&Slow Pointer | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/LinkedList/ReorderList.java) |
#104 Max Depth of Binary Tree | [Problem Description](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Easy | Recursive Pre-Order Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/Tree/MaxDepthOfBinaryTree.java) |
#100 Same Tree | [Problem Description](https://leetcode.com/problems/same-tree/) | Easy | Recursive Pre-Order Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Tree/SameTree.java) |
#226 Invert Binary Tree | [Problem Description](https://leetcode.com/problems/invert-binary-tree/) | Easy | Recursive Post-Order Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/Tree/InvertBinaryTree.java) |
#102 Binary Tree Level Order Traversal | [Problem Description](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Medium | Breadth-First Search/ Post-Order Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/Tree/BinaryTreeLevelOrderTraversal.java) |
#572 Subtree of Another Tree | [Problem Description](https://leetcode.com/problems/subtree-of-another-tree/) | Easy | Recursive Pre-Order Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/Tree/SubtreeOfAnotherTree.java) |
#105 Construct Binary Tree from Inorder and Preorder Traversal | [Problem Description](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | Recursively build subtrees based on given traversal orders | [Java](https://github.com/idkburkes/Software-Engineering-Interview-Prep/blob/master/Solutions/Tree/ConstructBinaryTreeFromPreorderAndInorderTraversal.java) |
#98 Validate Binary Search Tree | [Problem Description](https://leetcode.com/problems/validate-binary-search-tree/) | Medium | Iterative Inorder Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Tree/ValidateBinarySearchTree.java) |
#94 Binary Tree Inorder Traversal | [Problem Description](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Easy | Inorder Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Tree/BinaryTreeInorderTraversal.java) |
#230 Kth Smallest Element in a BST | [Problem Description](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Medium | Iterative Inorder Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Tree/KthSmallestElementInABST.java) |
#235 Lowest Common Ancestor of Binary Search Tree | [Problem Description](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | Easy | BST Properties | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Tree/LowestCommonAncestorOfABinarySearchTree.java) |
#235 Lowest Common Ancestor of Binary Tree | [Problem Description](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Medium | Recrusive Pre-Order Traversal | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Tree/LowestCommonAncestorOfABinaryTree.java) |
#1 Two Sum | [Problem Description](https://leetcode.com/problems/two-sum/submissions/) | Easy | Dynamic Programming | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Arrays/TwoSum.java) |
#121 Best Time to Buy and Sell Stock | [Problem Description](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Two Pointers | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Arrays/BestTimeToBuyAndSellStock.java) | 
#217 Contains Duplicate | [Problem Description](https://leetcode.com/problems/contains-duplicate/) | Easy | Linear Traverse w/ Set | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Arrays/ContainsDuplicate.java) |
#238. Product of Array Except Self | [Problem Description](https://leetcode.com/problems/product-of-array-except-self/) | Medium | Dynamic Programming In-place | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Arrays/ProductExceptSelf.java)
#53 Maximum Subarray | [Problem Description](https://leetcode.com/problems/maximum-subarray/) | Easy | Kadane's Algorithm / Dynamic Programming | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Arrays/MaxSubarray.java) |
#56 Merge Intervals | [Problem Description](https://leetcode.com/problems/merge-intervals/) | Medium | Merge Intervals | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Intervals/MergeIntervals.java) |
#57 Insert Interval | [Problem Description](https://leetcode.com/problems/insert-interval/) | Medium | Merge Intervals | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Intervals/InsertInterval.java) |
#435 Non-overlapping Intervals | [Problem Description](https://leetcode.com/problems/non-overlapping-intervals/) | Medium | Merge Intervals | [Java](https://github.com/idkburkes/Software-Engineering-Wiki/blob/master/Solutions/Intervals/NonOverlappingIntervals.java) |
