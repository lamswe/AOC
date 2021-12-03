import java.io.BufferedReader;
import java.io.FileReader;


public class BinaryDiagnostic{

    private static void part1() {
        System.out.println("Day3 - Binary Diagnostic");
        String gammal = "";
        String epsilon = "";
        String[] data = new String[1000];

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            int[] count = new int[12];
            for(int i = 0; i < 1000; i ++) {
                data[i] = br.readLine();
                for(int j = 0; j < 12; j++) {
                    if (data[i].charAt(j) == '0')
                        count[j]--;
                    else 
                        count[j]++;
                }
            }
            for (int i = 11; i >= 0; i--) {
                if (count[i] < 0){
                    gammal += '0';
                    epsilon += '1';
                } else {
                    gammal += '1';
                    epsilon += '0';
                }     
            }

            System.out.println("Result - Part 1: " + (Integer.parseInt(gammal, 2)* Integer.parseInt(epsilon,2)));
        } catch (Exception err) {
            System.err.println(err);
        }
    }

    private static void part2() {
        System.out.println("Day3 - Binary Diagnostic");
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String temp = "";
            while((temp = br.readLine()) != null) {
                data += temp;
            }
            System.out.println("Result - Part 2: " + (Integer.parseInt(oxygen(data), 2) * (Integer.parseInt(co2(data),2))));

        } catch (Exception err) {
            err.printStackTrace();
        }

    }



    private static String oxygen(String data) {
        
        for (int index = 0; index < 12; index++) {
            int count = 0;
            if (data.length() == 12)
                break;
            int zeroes = 0;
            int ones = 0;
            char bit = '0';
            for (int i = 0; i + index < data.length(); i += 12) {
                if(data.charAt(i+index) == '0')
                    zeroes++;
                else
                    ones++;
            }
            System.out.println("#0: " + zeroes);
            System.out.println("#1: " + ones);

            if (zeroes <= ones)
                bit = '1';
            else
                bit = '0';

            for (int i = 0; i < data.length(); ){
                if (data.charAt(i+index) != bit) {
                    data = data.substring(0, i) + data.substring((i+12));
                    count++;
                } else
                    i+=12;
            }
            System.out.println("valid bit: " + bit);
            System.out.println("# deleted: " + count);
        }
        System.out.println("------------------------");
        return data;
    }
    private static String co2(String data) {
        for (int index = 0; index < 12; index++) {
            int count = 0;
            if (data.length() == 12)
                break;
            int zeroes = 0;
            int ones = 0;
            char bit = '0';
            for (int i = 0; i + index < data.length(); i += 12) {
                if(data.charAt(i+index) == '0')
                    zeroes++;
                else
                    ones++;
            }
            System.out.println("#0: " + zeroes);
            System.out.println("#1: " + ones);

            if (zeroes <= ones)
                bit = '0';
            else
                bit = '1';

            for (int i = 0; i < data.length(); ){
                if (data.charAt(i+index) != bit) {
                    data = data.substring(0, i) + data.substring((i+12));
                    count++;
                } else
                    i+=12;
            }
            System.out.println("valid bit: " + bit);
            System.out.println("# deleted: " + count);
        }
        System.out.println("------------------------");
        return data;
    }

    public static void main(String[] args) {
        part2();

    }


}