/**
 * 测试类
 */
package org.queue;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        //testSeqQueue();
        testLinkQueue();
    }
    public static void printMenu()
    {
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n","please input:","1.front",
                "2.enQueue","3.deQueue","4.clear","5.quit");
    }
    public static void testQueue(Queue queue)
    {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            printMenu();
            String s = in.nextLine();
            if(s.equals("1"))
            {
                System.out.println(queue.front());
            }
            else if(s.equals("2"))
            {
                System.out.print("please input item:");
                System.out.println(queue.enQueue(in.nextLine()));
            }
            else if(s.equals("3"))
            {
                System.out.println(queue.deQueue());
            }
            else if(s.equals("4"))
            {
                queue.clear();
            }
            else if(s.equals("5"))
            {
                break;
            }
        }
    }
    public static void testSeqQueue()
    {
        SeqQueue q = new SeqQueue(10);
        testQueue(q);
    }
    public static void testLinkQueue()
    {
        LinkQueue lq = new LinkQueue();
        testQueue(lq);
    }
}

