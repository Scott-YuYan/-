package leetcode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static leetcode2.AddTwoListNode.addTwoNumbers;
import static leetcode2.AddTwoListNode.createNodeBehind;
import static leetcode2.AddTwoListNode.getNumFromNumber;
import static leetcode2.AddTwoListNode.showListNodeValue;

public class TestLc2 {
    @Test
    public void test() {
        ListNode node1 = createNodeBehind(getNumFromNumber(0L));
        ListNode node2 = createNodeBehind(getNumFromNumber(0L));
        ListNode node3 = addTwoNumbers(node1, node2);
        Assertions.assertEquals(0, showListNodeValue(node3));
    }
}
