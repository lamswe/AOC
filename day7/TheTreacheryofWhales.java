import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;

public class TheTreacheryofWhales {
    static int[] crabPos;
    public static void main (String[] args) {
        System.out.println("Day 7: The Treachery of Whales");
        readInput();
        //part1();
        part2();
    }

    private static void readInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String[] strs = br.readLine().split(",");
            crabPos = new int[strs.length];
            for (int i = 0; i < crabPos.length; i++) {
                crabPos[i] = Integer.parseInt(strs[i]);
                //System.out.print(crabPos[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void part1 () {
        BigInteger smallestDis = new BigInteger("0");
        for (int i = 0; i < crabPos.length; i ++) {
            BigInteger sum = new BigInteger("0");
            for (int j = 0; j < crabPos.length; j++)
                sum = sum.add(new BigInteger("" + Math.abs(crabPos[j]-crabPos[i])));
            if (smallestDis.equals(new BigInteger("0")))
                smallestDis = sum;
            smallestDis = sum.compareTo(smallestDis) < 0 ? sum : smallestDis;
        }
        System.out.println("Part 1's result: " + smallestDis);
    }

    private static void part2() {
        int leastFuel = Integer.MAX_VALUE;
        for ( int i = 0; i < 2000; i++) {
            int sum = 0;
            for (int j = 0; j < crabPos.length; j++) {
                int n = Math.abs(crabPos[j]-i);
                sum += n*(n+1)/2;
            }
            //System.out.println("central crab: "+ crabPos[i] +"      sum: " + sum);
            //System.out.println("------------------");
            leastFuel = sum < leastFuel ? sum : leastFuel;
        }
        System.out.println("Part 2's result: " + leastFuel);
    }
}