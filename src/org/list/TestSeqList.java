/**
 * 测试顺序表基本功能
 */
package org.list;

import java.util.Scanner;

public class TestSeqList {
    public static void main(String[] args) {
        SeqList seqlist = new SeqList(10);
        doTest(seqlist);
    }
    public static void printMenu()
    {
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n","please choose:",
                "1.find","2.search","3.insert","4.delete","5.update","6.output","7.clear","8.quit");
    }
    public static void doTest(LinearList list)
    {
        Scanner input = new Scanner(System.in);
        while(true) {
            printMenu();
            String s = input.nextLine();
            if (s.equals("1")) {
                System.out.print("input index:");
                System.out.println(list.find(Integer.valueOf(input.nextLine())));
            } else if (s.equals("2")) {
                System.out.print("input element:");
                System.out.println(list.search(Integer.valueOf(input.nextLine())));
            } else if (s.equals("3")) {
                System.out.print("input index:");
                int index = Integer.valueOf(input.nextLine());
                System.out.print("input element:");
                System.out.println(list.insert(index, Integer.valueOf(input.nextLine())));
            } else if (s.equals("4")) {
                System.out.print("input index:");
                System.out.println(list.delete(Integer.valueOf(input.nextLine())));
            } else if (s.equals("5")) {
                System.out.print("input index:");
                int index = Integer.valueOf(input.nextLine());
                System.out.print("input element:");
                System.out.println(list.update(index, Integer.valueOf(input.nextLine())));
            } else if (s.equals("6")) {
                list.output();
            } else if (s.equals("7")) {
                list.clear();
            }
            else if(s.equals("8")){
                break;
            }
        }
    }
}
