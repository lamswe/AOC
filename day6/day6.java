import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class day6 {

    static List<Integer> fishList = new ArrayList<Integer>();
    public static void main (String[] args) {
        System.out.println("Day 6 - ");
        readInput();
        // part1(100);
        part2(256);
    }

    private static void readInput() {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String[] strArr = br.readLine().split(",");
            for (String str : strArr) {
                fishList.add(Integer.parseInt(str));
            }       
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void printList() {
        for (int i : fishList)
            System.out.print(i +" ");
        System.out.println();
        System.out.println("fishList's size: " +fishList.size());
    }

    private static void part1(int dayCount) {
        if(dayCount < 1)
            return;
        // printList();

        List<Integer> newFishes = new ArrayList<Integer>();
        for (int i = 0; i < fishList.size(); i++) {
            int fish = fishList.get(i);
            if (fish == 0){
                fishList.set(i, 6);
                newFishes.add(8);
            } else{
                fishList.set(i, fish-1);
            }
        }
        fishList.addAll(newFishes);
        part1(dayCount-1);
    }

    private static void part2(int dayCount) {
        BigInteger totalFish = new BigInteger("0");
        BigInteger[] nrFishes = new BigInteger[5];
        for(int i = 1; i < 6; i++) {
            System.out.println("------------------------");
            nrFishes[i-1] = new BigInteger(""+ totalFish(dayCount, i));
            System.out.println(nrFishes[i-1]);
        }

        for(int i = 0; i < fishList.size(); i++) {
            int fish = fishList.get(i);
            totalFish = totalFish.add(nrFishes[fish-1]);
        }
        System.out.println(totalFish);


    }

    private static BigInteger totalFish (int ttl, int fish) {
        BigInteger total = new BigInteger("1");
        ttl -= fish;
        while(ttl > 0) {
            total = total.add(totalFish(ttl-1, 8));
            ttl -= 7;
        }
        return total;   
    }
}
