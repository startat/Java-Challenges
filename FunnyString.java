/*In this challenge, you will determine whether a string is funny or not. 
To determine whether a string is funny, create a copy of the string in reverse 
e.g. . Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end. 
If the list of absolute differences is the same for both strings, they are funny.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FunnyString {

    // Complete the anagram function below.
    static int anagram(String s) {
        int result = 0;
        //if odd, return -1
        if(s.length()%2==1){
            result = -1;
        }
        
        //if even, we will compare
        else{
            //first split
            String left = s.substring(0, s.length()/2);
            String right = s.substring(s.length()/2, s.length());
            System.out.println(left+"; "+right);
            
            HashMap<Character, Integer> leftCount = new HashMap<>();
            
            //find out # of different letters
            for(char letter:left.toCharArray()){
                
                //need hashmap to count frequency of each letter
                if(!leftCount.containsKey(letter)){
                    leftCount.put(letter, 1);
                
                } else{
                    leftCount.put(letter, leftCount.get(letter)+1);
                }
                
            }
            System.out.println(leftCount);
            
            //run through letter from right string, count diff
            for(char rightLetter:right.toCharArray()){
                if(leftCount.containsKey(rightLetter)){
                    leftCount.put(rightLetter, leftCount.get(rightLetter)-1);
                } 
            }
            //now add the ones not equal to 0
            Set<Map.Entry <Character, Integer>> mySet = leftCount.entrySet();
            for(Map.Entry <Character, Integer> eachPair : mySet){
                if(eachPair.getValue()>0)
                    result+=eachPair.getValue();
                
            }
            
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
