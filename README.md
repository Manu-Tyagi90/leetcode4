# Merge Two Sorted Lists

This repository contains the implementation of a solution to merge two sorted linked lists into one sorted linked list. The solution is implemented in Java using the following `ListNode` class:

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

## Problem Statement

You are given the heads of two sorted linked lists, `list1` and `list2`. Your task is to merge these two lists into a single sorted list. The merged list should also be sorted. The function signature is as follows:

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2)
```

## Approach

1. Create a dummy node to serve as the starting point of the merged linked list.
2. Use a pointer `current` to track the current position in the merged list.
3. Iterate through both linked lists until one of them is fully traversed:
    - Compare the values of the nodes in `list1` and `list2`.
    - Append the smaller value to the merged list.
    - Move the pointer of the list with the smaller value to the next node.
4. Append the remaining nodes of either `list1` or `list2` to the merged list.
5. Return the merged list starting from `dummy.next`.

## Code

Here is the implementation of the solution:

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class p2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        p2 solution = new p2();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
```

## Example

Input:
```
list1 = [1,2,4]
list2 = [1,3,4]
```

Output:
```
[1,1,2,3,4,4]
```

Below is a visual representation of the process:

![Merge Example](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

## Complexity

- **Time Complexity**: O(n + m), where n is the length of `list1` and m is the length of `list2`.
- **Space Complexity**: O(1) (in-place merging).

## How to Run

1. Clone the repository.
2. Compile and run the Java program with your test cases.
    ```sh
    javac p2.java
    java p2
    ```

## License

This project is licensed under the MIT License. Feel free to use and modify the code as needed.

---
