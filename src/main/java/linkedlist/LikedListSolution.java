package linkedlist;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Liked
 *
 * @Author s·D·bs
 */
@SuppressWarnings("ALL")
public class LikedListSolution {


    /**
     * @return
     * @Author s·D·bs
     * @Description //reverse List 时间复杂度为O(n) 空间复杂度为O(n)
     * @Date 2019-12-24 18:00
     * @Param
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;//当前节点指针
        ListNode prev = null;//前一个节点指针
        //每次循环都把当前节点指向前一个节点，把前节点和当前节点后移
        while (cur != null) {
            ListNode temp = cur.next;//用于后移
            //当前节点指向前一个节点并且后移
            cur.next = prev;
            //前节点后移
            prev = cur;
            //进行下一次循环
            cur = temp;
        }
        return prev;
    }

    /**
     * @return
     * @Author s·D·bs
     * @Description 判断一个链表中是否含有环
     * 时间复杂度为O(n) 空间复杂度为O(1)
     * @Date 2020年01月02日10:37:44
     * @Param
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //使用快慢指针和前一个指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * @return
     * @Author s·D·bs
     * @Description 判断一个链表中是否含有环
     * 时间复杂度为O(n) 空间复杂度为O(1)
     * 这里简单说一下最好时间复杂度是O(1)最坏是O(n)
     * @Date 2020年01月02日10:37:44
     * @Param
     */
    public boolean hasCycle3(ListNode head) {
        //2-使用set装节点判断是否存在set中
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * @return
     * @Author s·D·bs
     * @Description 判断一个链表中是否含有环
     * 时间复杂度为O(n) 空间复杂度为O(1)
     * 这里简单说一下最好时间复杂度是O(1)最坏是O(n)
     * @Date 2020年01月02日10:37:44
     * @Param
     */
    public boolean hasCycle4(ListNode head) {
        //4 使用快慢指针和前一个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     * @Author s·D·bs
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * @Description //时间复杂度为O(n) 空间复杂度为O(n)
     * @Date 2020-01-02 10:39
     * @Param
     */
    public static ListNode swapPairs(ListNode head) {
        //需要成双成对交换，就要从第一个跳到第三个
        ListNode p = head;
        while (p != null && p.next != null) {
            int temp = p.val;
            p.val = p.next.val;
            p.next.val = temp;
            p = p.next.next;
        }
        return head;
    }


    /**
     * @return
     * @Author s·D·bs
     * 返回环链表的第一个节点
     * @Description //时间复杂度为O(n) 空间复杂度为O(1)
     * @Date 2020-01-02 10:40
     * @Param
     */
    public ListNode detectCycle(ListNode head) {
        //4 使用快慢指针和前一个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head; //从头开始记录
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * @return
     * @Author s·D·bs  难
     * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
     * 只要是倍数就要交换两个节点
     * @Description //思路：1:分组 2:链表翻转  3:拼接翻转后的片段 4:特殊->末尾不满一组的子链表，保持原样不进行翻转。
     * 时间复杂度O(n^2)
     * @Date 2020-01-02 10:42
     * @Param
     */
    public static ListNode reversekGroup(ListNode head, int k) {

        // 增加虚拟头结点 其实就是使用哨兵模式对不确定边界进行确定
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义 prev 和 end 结点
        ListNode prev = dummy;//prev变化会影响head
        ListNode end = dummy; //作为分组的跟随节点
        while (end.next != null) {
            // 以 k 个结点为条件，分组子链表
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 特殊->末尾不满一组的子链表，保持原样不进行翻转
            if (end == null) {
                break;
            }
            //处理子链表
            ListNode start = prev.next;
            //已经赋值给next，end变化不会影响next
            ListNode next = end.next; //第一（n）次的最后的节点
            //翻转子链表需要最后节点为null
            end.next = null;
            //翻转子链表+拼接链表
            prev.next = reverseList(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }
    //理解哨兵模式简化代码

    /**
     * 理解哨兵模式简化代码
     * 有序链表合并 Leetcode 21
     * 删除倒数第k节点
     * 求链表的中间结点
     */

    //求链表的中间结点
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //删除倒数第k节点
    public static ListNode deleteLastKth(ListNode list, int k) {
        ListNode fast = list;
        //找到前k个链表
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return list;
        }
        //同时循环 找到倒数第k个位置
        ListNode slow = list;
        ListNode prev = null;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        //判断prev的值
        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    //有序链表的合并
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //使用哨兵
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //此时较短的链表已经循环完毕，剩下的直接选取一截
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;//头结点的存在
    }
}
