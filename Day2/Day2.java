import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day2{

    public static void part1(String[] input){
        String direction;
        int value;
        int horizontalPosition = 0;
        int verticalPosition = 0;

        for (String string : input) {
            direction = string.split(" ")[0];
            value = Integer.parseInt(string.split(" ")[1]);

            switch (direction) {
                case "up":
                    verticalPosition -= value;
                    break;

                case "down":
                    verticalPosition += value;
                    break;

                case "forward":
                    horizontalPosition += value;
                    break;
            }
        }
        System.out.println((horizontalPosition * verticalPosition));
    }

    public static void part2(String[] input){
        String direction;
        int value;

        int aim = 0;
        int horizontalPosition = 0;
        int verticalPosition = 0;

        for (String string : input) {
            direction = string.split(" ")[0];
            value = Integer.parseInt(string.split(" ")[1]);

            switch (direction) {
                case "up":
                    aim -= value;
                    break;

                case "down":
                    aim += value;
                    break;

                case "forward":
                    horizontalPosition += value;
                    verticalPosition += aim * value;
                    break;
            }
        }
        System.out.println((horizontalPosition * verticalPosition));
    }
    

    public static void main(String[] args) throws Exception {
        String[] input = new String[1000];
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int index = 0;
        String st;
        while((st = br.readLine()) != null){
            input[index] = st;
            index++;
        }
        part1(input);
        part2(input);

    }
}