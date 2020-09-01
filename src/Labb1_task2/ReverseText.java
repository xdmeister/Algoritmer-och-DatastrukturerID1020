package Labb1_task2;

import java.util.Scanner;
import java.util.Stack;

public class ReverseText
{
    public static void main(String[] args)
    {
        Scanner sys = new Scanner(System.in);

        System.out.println("Enter your text ");
        Stack stack = new Stack();
        String text = sys.nextLine();
        char[] arr = new char[text.length()];
        for(int i = 0; i < text.length(); i++)
            stack.push(text.charAt(i));

        for(int i = 0; i < text.length(); i++)
            arr[i] = text.charAt(i);

        System.out.println("Type 1 for iterative, else recursive");
        int i = sys.nextInt();
        if(i == 1)
            System.out.println(iterativeReverse(stack));
        else
            recursiveReverse(arr, arr.length - 1);

    }

    public static String iterativeReverse(Stack stack)
    {
        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }

    public static void recursiveReverse(char[] arr, int size)
    {
        if(size >= 0)
        {
            System.out.print(arr[size]);
            recursiveReverse(arr, --size);
        }
    }

}

