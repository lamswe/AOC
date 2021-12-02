import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Dive{

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Day2 - Dive!");
        String filename = "input.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int hpos = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i < 1000; i ++){
            String cmdStr = br.readLine();
            String cmd = cmdStr.split(" ")[0];
            int steps = Integer.parseInt(cmdStr.split(" ")[1]);
            switch (cmd) {
                case "forward":
                    hpos += steps;
                    depth += aim*steps;
                    break;
                case "down":
                    aim += steps;
                    break;
                default:
                    aim -= steps;
            }
        }
        System.out.println("Result: " + (hpos*depth));
    }
}