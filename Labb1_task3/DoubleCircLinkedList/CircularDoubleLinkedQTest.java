package DoubleCircLinkedList;

import java.util.Scanner;
public class CircularDoubleLinkedQTest
{
    public static void main(String[] args)
    {
        CircularDoubleQ<String> queue = new CircularDoubleQ<String>();
        queue.enqueue("IteratorInitialzier");
        DoublyLinkedIterator itr = queue.DoublyLinkedIterator();

        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        System.out.println("1 to enqueue, 2 to dequeue, 3 to iterate back, 4 to iterate forward.\n" +
                "Anything else displays size");
        while(true)
        {
            System.out.println("Enter ");
            int i = intScan.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Enter what you want to enqueue ");
                    String str = strScan.nextLine();
                    queue.enqueue(str);
                    System.out.println(queue.toString());
                    break;

                case 2:
                    System.out.println("Dequeueing");
                    queue.dequeue();
                    System.out.println(queue.toString());
                    break;

                case 3:
                    itr.next();
                    break;

                case 4:
                    itr.prev();
                    break;

                default:
                    System.out.println("size is: " + queue.getSize());
                    break;
            }
        }


    }
}
