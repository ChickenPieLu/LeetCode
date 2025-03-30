// LeetCode Problem 2: Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        boolean det = false;//indicates 进位
        int val = l1.val + l2.val;
        if (val>=10){
            det = true;
        }
        if (l1.next == null){
            if (l2.next == null){
                if (det) result = new ListNode(val%10,new ListNode(1));
                else result = new ListNode(val);
            }
            else{
                if (det) result = new ListNode(val%10,addTwoNumbers(new ListNode(1),l2.next));
                else result = new ListNode(val,l2.next);
            }
        }
        else if (l2.next == null){
            result = addTwoNumbers(l2, l1);
        }
        else{
            if (det){
                l2.next.val += 1;
            }
            result = new ListNode(val%10, addTwoNumbers(l1.next, l2.next));
        }
        return result;
    }

    public static ListNode createList(int num){
        ListNode result;
        if (num>=10){
            result = new ListNode(num%10,createList(num/10));
        }
        else{
            result = new ListNode(num);
        }
        return result;
    }

    public static void printList(ListNode node){
        if (node.next == null) print(node.val+" ");
        else{
            print(node.val+" ");
            printList(node.next);
        }
    }

    public static void print(String message){
        System.out.print(message);
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
        ListNode test1 = createList(10086);
        ListNode test2 = createList(2048);
        println("adding numbers:");
        printList(test1);
        print("\nand \n");
        printList(test2);
        println("\nresult: ");
        printList(addTwoNumbers(test1,test2));
    }
}