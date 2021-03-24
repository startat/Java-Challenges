//Given a time in -hour AM/PM format, convert it to military (24-hour) time.

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ConvertTime {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
          String change ="";
        //us hh, mm, ss, apm to represent each element
        String[] all = s.split(":");
        System.out.println(Arrays.toString(all));
        
        int hh = Integer.valueOf(all[0]);
        int mm = Integer.valueOf(all[1]);
        char[] rest = all[2].toCharArray();
        
        //if rest[2] is A and hh<=11, nothing changes; 
        //if it's P and hh=12, also nothing changes
        int HH=hh;
        int MM=mm;
        
        if((rest[2]=='A'&&hh<=11)||(rest[2]=='P'&&hh==12)) {
            change = hh+":"+mm+":"+rest[0]+rest[1];
            
        
        } else {
            change = hh+12 +":"+mm+":"+rest[0] +rest[1];
            HH=hh+12;
            if(HH==24){
                HH=0;
            }
        }
        
        //add zero if needed
        System.out.println(HH +" "+MM);
        if(HH<=9&&MM>9) {
            change = "0"+change;
        }
        if(MM<=9&&HH>9) {
            change = HH+":0"+mm+":"+rest[0] +rest[1];
        }
        if(HH<=9&&MM<=9) {
            change = "0"+HH+":0"+mm+":"+rest[0] +rest[1];
        }
        String[] finalSplit = change.split(":");
        if(Integer.valueOf(finalSplit[0])==24) {
            finalSplit[0]="00";
            change = finalSplit[0]+":"+finalSplit[1]+":"+finalSplit[2];
        }
        return change;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
