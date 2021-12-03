import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day3{

    public static void part1(String[] input){
        int[] commonBits = new int[input[0].length()];
        for (String string : input) {
            for (int i = 0; i < commonBits.length; i++) {
                switch (string.charAt(i)) {
                    case '1':
                        commonBits[i]++;
                        break;
                
                    case '0':
                        commonBits[i]--;
                        break;
                }
            }    
        }
        String gammaRate = "";
        String epsilonRate = "";
        for (int i : commonBits) {
            if(i < 0){
                gammaRate += 0;
                epsilonRate += 1;
            }else{
                gammaRate += 1;
                epsilonRate += 0;
            }
        }
        System.out.println("Power consumption: " + (Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)));
    }

    public static String oxygen(String[] input, int globalIndex){
        if(input.length == 1){
            return input[0];
        }else{
            int decider = 0;

            String[] zeros = new String[input.length];       
            int zerosCounter = 0;
            
            String[] ones = new String[input.length];
            int onesCounter = 0;

            for (int i = 0; i < input.length; i++) {
                if(input[i].charAt(globalIndex) == '1'){
                    decider++;
                    ones[onesCounter++] = input[i];
                }else{
                    decider--;
                    zeros[zerosCounter++] = input[i];
                }
            }

            int nullCounter = 0;
            int i = 0;
            while(zeros[i] != null){
                nullCounter++;
                i++;
            }
            String[] newZeros = new String[nullCounter];

            for (int j = 0; j < newZeros.length; j++) {
                newZeros[j] = zeros[j];
            }


            //----------------------------------------
            nullCounter = 0;
            i = 0;
            while(ones[i] != null){
                nullCounter++;
                i++;
            }
            String[] newOnes = new String[nullCounter];

            for (int j = 0; j < newOnes.length; j++) {
                newOnes[j] = ones[j];
            }
            
            return decider >= 0 ? oxygen(newOnes, ++globalIndex) : oxygen(newZeros, ++globalIndex);
        }
    }

    public static String co2(String[] input, int globalIndex){
        if(input.length == 1){
            return input[0];
        }else{
            int decider = 0;

            String[] zeros = new String[input.length];       
            int zerosCounter = 0;
            
            String[] ones = new String[input.length];
            int onesCounter = 0;

            for (int i = 0; i < input.length; i++) {
                if(input[i].charAt(globalIndex) == '1'){
                    decider++;
                    ones[onesCounter++] = input[i];
                }else{
                    decider--;
                    zeros[zerosCounter++] = input[i];
                }
            }

            int nullCounter = 0;
            int i = 0;
            while(zeros[i] != null){
                nullCounter++;
                i++;
            }
            String[] newZeros = new String[nullCounter];

            for (int j = 0; j < newZeros.length; j++) {
                newZeros[j] = zeros[j];
            }


            //----------------------------------------
            nullCounter = 0;
            i = 0;
            while(ones[i] != null){
                nullCounter++;
                i++;
            }
            String[] newOnes = new String[nullCounter];

            for (int j = 0; j < newOnes.length; j++) {
                newOnes[j] = ones[j];
            }
            return decider >= 0 ? co2(newZeros, ++globalIndex) : co2(newOnes, ++globalIndex);
        }
    }

    
    public static void main(String[] args) throws Exception{
        String[] input = new String[1000];
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int index = 0;
        String st;

        while((st = br.readLine()) != null){
            input[index] = st;
            index++;
        }

        part1(input);
        System.out.println(Integer.parseInt(oxygen(input, 0), 2) * Integer.parseInt(co2(input, 0), 2));
    }
}