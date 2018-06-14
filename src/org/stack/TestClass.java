package org.stack;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        SeqStack s = new SeqStack(10);
        testStack(s);
    }
    public static void printMenu()
    {
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n","please input:","1.top",
                "2.push","3.pop","4.clear","5.quit");
    }
    public static void testStack(Stack stack)
    {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            printMenu();
            String s = in.nextLine();
            if(s.equals("1"))
            {
                System.out.println(stack.top());
            }
            else if(s.equals("2"))
            {
                System.out.print("please input item:");
                System.out.println(stack.push(in.nextLine()));
            }
            else if(s.equals("3"))
            {
                System.out.println(stack.pop());
            }
            else if(s.equals("4"))
            {
                stack.clear();
            }
            else if(s.equals("5"))
            {
                break;
            }
        }
    }
}
