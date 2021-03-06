//Chensu Zhu 
//the purpose of this file is to find out if a String is pangrams

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {

    static String pangrams(String s) {
         String result = "pangram";
         String lowercase = s.toLowerCase();
          char[] letters = lowercase.toCharArray();
            HashSet<Character> mySet = new HashSet<>();
          for(int i=0; i<letters.length;i++) {
              mySet.add(letters[i]);
             
          }
          if(mySet.size()<27) {
              result = "not pangram";
             
          }
          return result;
        }
      
        

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
