import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day_01{
    public static void part01(int[] input) {
        int previousDepth;
        int currentDepth;
        

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
    
    public static void part02(int[] input){
        int previousSum;
        int currentSum;

        int counter = 0;
        for (int i = 2; i < input.length - 1; i++) {
            previousSum = input[i-2] + input[i-1] + input[i];
            currentSum = input[i-1] + input[i] + input[i+1];
            if(currentSum > previousSum){
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) throws Exception {    
        int[] input = new int[2000];

        BufferedReader br = new BufferedReader(new FileReader(new File("Day_01.txt")));
        String st;
        int index = 0;
        while((st = br.readLine()) != null){
            input[index] = Integer.parseInt(st);
            index++;
        }
        part01(input);
        part02(input);
    }
}