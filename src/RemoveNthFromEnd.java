import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xiaodp
 * @date 2019/11/12 22:46
 */
 class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        int count = 0;
        int len = 0;
        ListNode current1 = head;
        while (current1.next != null) {
            len++;
            current1 = current1.next;
        }
        ListNode current2 = head;
        while (count < len - n) {
            current2 = current2.next;
            count++;
        }
        current2.next = current2.next.next;
        return dum.next;
    }

}

public class RemoveNthFromEnd {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            ListNode head = stringToListNode(line);
//            line = in.readLine();
//            int n = Integer.parseInt(line);
//
//            ListNode ret = new Solution().removeNthFromEnd(head, n);
//
//            String out = listNodeToString(ret);
//
//            System.out.print(out);
//        }

        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        head.next = one;
        one.next = null;

        ListNode ret = new Solution().removeNthFromEnd(head, 1);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}