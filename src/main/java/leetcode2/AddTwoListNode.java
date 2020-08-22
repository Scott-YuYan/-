package leetcode2;


import java.util.ArrayList;
import java.util.List;

public class AddTwoListNode {
    public static void main(String[] args) {
        ListNode node1 = createNodeBehind(getNumFromNumber(0L));
        System.out.println("参数1：" + getListNodeValue(node1));
        ListNode node2 = createNodeBehind(getNumFromNumber(0L));
        System.out.println("参数2：" + getListNodeValue(node2));
        ListNode node3 = addTwoNumbers(node1, node2);
        System.out.println("结果：" + getListNodeValue(node3));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> a = getListNodeValue(l1);
        List<Integer> b = getListNodeValue(l2);
        List<Integer> result = getNumFromNumber(a, b);
        return createNodeBehind(result);
    }

    /**
     * 遍历节点，获得链表节点中的各个节点属性值
     *
     * @param headNode 头节点
     * @return 输出结果
     */
    public static long showListNodeValue(ListNode headNode) {
        long result = 0;
        int flag = 0;
        while (headNode != null) {
            result = (long) (result + headNode.val * Math.pow(10, flag));
            headNode = headNode.next;
            flag++;
        }
        return result;
    }


    /**
     * 获取某个数中的各个位数
     *
     * @param number long整数
     * @return 该整数的各位数字结果集
     */
    public static List<Integer> getNumFromNumber(long number) {
        List<Integer> result = new ArrayList<>();
        if (number == 0) {
            result.add(0);
            return result;
        }
        if (number >= 0) {
            while (number > 0) {
                result.add((int) (number % 10));
                number = number / 10;
            }
            return result;
        }
        return result;
    }


    public static List<Integer> getNumFromNumber(List<Integer> number1, List<Integer> number2) {
        List<Integer> result = new ArrayList<>();
        int size = Math.max(number1.size(), number2.size());
        for (int i = 0; i < size; i++) {
            int param1, param2, sum;
            param1 = (i >= number1.size()) ? 0 : number1.get(i);
            param2 = (i >= number2.size()) ? 0 : number2.get(i);
            sum = param1 + param2;
            result.add(0);
            //结果集扩容一位
            if ((sum + result.get(i) >= 10)) {
                //将当前位置为0，进一位
                result.set(i, (sum + result.get(i) - 10));
                result.add(0);
                result.set(i + 1, 1);
            } else {
                result.set(i, (param1 + param2) + result.get(i));
            }
        }
        for (int i = result.size(); i > 0; i--) {
            if (result.get(i - 1) != 0) {
                return result.subList(0, i);
            }
        }
        return result;
    }

    /**
     * 尾插法创建链表
     *
     * @param list int整数的各个位数
     * @return 尾插法创建的正序链表
     */
    public static ListNode createNodeBehind(List<Integer> list) {
        ListNode headNode = null;
        if (list.size() > 0) {
            headNode = new ListNode(list.get(0));
            ListNode tailNode = headNode;
            for (int i = 1; i < list.size(); i++) {
                ListNode newNode = new ListNode(list.get(i));
                tailNode.next = newNode;
                tailNode = newNode;
            }
        }
        return headNode;
    }

    /**
     * 前插法创建单链表
     *
     * @param list 属性值集合
     * @return 单链表
     */
    public static ListNode createNodeBefore(List<Integer> list) {
        ListNode head = null;
        for (Integer value : list
        ) {
            ListNode newNode = new ListNode(value);
            if (head != null) {
                newNode.next = head;
            }
            head = newNode;
        }
        return head;
    }


    public static List<Integer> getListNodeValue(ListNode headNode) {
        List<Integer> result = new ArrayList<>();
        while (headNode != null) {
            result.add(headNode.val);
            headNode = headNode.next;
        }
        return result;
    }


    /**
     * 递归调用的链表反转
     *
     * @param head 链表头节点
     * @return 反转后的链表
     */
    public static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newNode = reverseNode(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }
    }
}
