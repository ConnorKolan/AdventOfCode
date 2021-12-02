import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day_01{
    public static void main(String[] args) throws Exception {    
        
        BufferedReader br = new BufferedReader(new FileReader(new File("Day_01.txt")));
        int previousDepth;
        int currentDepth;
        
        int[] input = new int[2000];
 
        String st;
        int index = 0;
        while((st = br.readLine()) != null){
            input[index] = Integer.parseInt(st);
            index++;
        }

        int counter = 0;
        for (int i = 1; i < input.length; i++) {
            previousDepth = input[i-1];
            currentDepth = input[i];
            if(currentDepth > previousDepth){
                counter++;
            }
        }
        System.out.println(counter);
    }
}