/**
 * 表达式操作包括:中缀表达式转后缀表达式&&后缀表达式的计算
 */
package org.expression;

import org.stack.SeqStack;
import org.stack.Stack;

import java.util.HashMap;
import java.util.Map;

public class ExpressionOption {
    //栈外操作符优先级
    private static HashMap<String,Integer> icp = new HashMap<String,Integer>(){
        {
            put("#",0);
            put("(",7);
            put("*",4);
            put("/",4);
            put("+",2);
            put("-",2);
            put(")",1);
        }
    };
    //栈内操作符优先级
    private static HashMap<String,Integer> isp = new HashMap<String, Integer>(){
        {
            put("#",0);
            put("(",1);
            put("*",5);
            put("/",5);
            put("+",3);
            put("-",3);
            put(")",7);
        }
    };
    //中缀表达式转后缀
    public static String infixToPostfix(String infix){
        StringBuffer res = new StringBuffer();
        int size = infix.length()+1;
        SeqStack stack = new SeqStack(size);
        stack.push("#");
        infix+="#";
        char[] buffer = infix.toCharArray();
        for(int i=0;i<buffer.length;i++)
        {
            char cur = buffer[i];
            if((cur>='0'&&cur<='9')||
                    (cur>='a'&&cur<='z')||
                    (cur>='A'&&cur<='Z'))
            {
                res.append(cur);
            }
            else if(cur=='#')
            {
                while(!stack.isEmpty())//!(stack.top().equals("#"))
                {
                    res.append(stack.top());
                    stack.pop();
                }
            }
            else if(cur==')')
            {
                while(!stack.top().equals("("))//stack.top()!="(",注意字符串的==不能乱用
                {
                    res.append(stack.top());
                    stack.pop();
                }
                stack.pop();
            }
            else
            {
                while(icp.get(String.valueOf(cur))<=isp.get(stack.top().toString()))
                {
                    res.append(stack.top());
                    stack.pop();
                }
                stack.push(String.valueOf(cur));
            }
        }
        return res.toString();
    }
    //后缀表达式计算
    public static Double calculatePostfix(String postfix)
    {
        char[] buffer = postfix.toCharArray();
        SeqStack s = new SeqStack(buffer.length);
        double res = 0;
        for(char cur:buffer)
        {
            if(cur>='0'&&cur<='9')
            {
                s.push(String.valueOf(cur));
            }
            else if(cur=='#')
            {
                res = Double.valueOf(s.top().toString());
            }
            else
            {
                Double d1 = Double.valueOf(s.top().toString());
                s.pop();
                Double d2 = Double.valueOf(s.top().toString());
                s.pop();
                if(cur=='+')
                {
                    s.push(d2+d1);
                }
                else if(cur=='-')
                {
                    s.push(d2-d1);
                }
                else if(cur=='*')
                {
                    s.push(d2*d1);
                }
                else if(cur=='/')
                {
                    s.push(d2/d1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a/(b-c)+d*e"));
        System.out.println(calculatePostfix(infixToPostfix("6/(4-2)+2*3")));
    }
}

