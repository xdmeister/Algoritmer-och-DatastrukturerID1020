package Labb_3.Task2;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/*
    Uses a ordered array symbol table to find the most occurring word, the number of distinct words as well as
    storing them in the table. Execution time is tracked using System.nanoTime(). Allows the user to choose
    how many words to read in.
*/
public class FrequencyCounterOrdArrST
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int minlen = 3;
        File theText = new File("C:\\Users\\ali_z\\IdeaProjects\\KTH-Algoritmer-Datastrukturer-ID1020\\src\\Labb_3\\TheText.txt");
        Scanner reader = new Scanner(theText);
        Scanner input = new Scanner(System.in);
        System.out.println("How many words do you want to read? Enter now: ");
        int n = input.nextInt();

        OrderedArrayST<String, Integer> st = new OrderedArrayST<String, Integer>(n);
        int iterations = 0, distinct = 0;
        String key, mostFreq = "";
        st.put(mostFreq,0);
        long startTime = System.nanoTime();
        while(reader.hasNextLine() && iterations < n)
        {
            key = reader.next();
            if(key.length() < minlen)
                continue;
            if(!Character.isAlphabetic(key.charAt(key.length()-1)))
                key = key.substring(0,key.length()-1);
            if(!st.contains(key))
            {
                st.put(key, 1);
                distinct++;
            }
            else
                st.put(key,st.get(key) + 1);

            if(st.get(key) > st.get(mostFreq))
                mostFreq = key;

            iterations++;
        }
        long finishTime = System.nanoTime();

        System.out.println("Time elapsed: " + (double)(finishTime-startTime)/1000000000);
        System.out.println("Most frequent word was '" + mostFreq + "'," + " it appeared "
                + st.get(mostFreq) + " times.");
        System.out.println("Nr of distinct words: " + distinct);
        System.out.println("Number of words: " + iterations);
    }
}
