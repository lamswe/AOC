import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SevenSegmentSearch {
    static String input = "";
    static String output = "";
    static int sum = 0;
    public static void main(String[] args) {
        System.out.println("Day 7 - Seven Segment Search");
        readInput();
        // part1();
        part2();
    }
    
    public static void readInput() {
            try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
                while (br.ready()) {
                    String[] data = br.readLine().split(" \\| ");
                    input += data[0] +" ";
                    output += data[1] + " ";
                    sum += decode(data[0], data[1]);     
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    }


    private static int decode (String input, String output) {
        String standard = "abcdefg";
        String data0 = input.replace(" ", "");
        int[] count = new int[7];
        char[] decoded = new char[7];
        for (int i = 0; i < data0.length(); i++) {
            switch (data0.charAt(i)){
                case 'a': count[0]++; break;
                case 'b': count[1]++; break;
                case 'c': count[2]++; break;
                case 'd': count[3]++; break;
                case 'e': count[4]++; break;
                case 'f': count[5]++; break;
                case 'g': count[6]++; break;
                default: System.out.println("Something is wrong"); break;
            }
        }
        String str1 = "", str4 = "", str7 = "", str8 ="";
        String[] data1 = input.split(" ");
        for (String str : data1) {
            switch (str.length()) {
                case 2: str1 = str; break;
                case 4: str4 = str; break;
                case 3: str7 = str; break;
                case 7: str8 = str; break;
                default: break;

            }
        }

        for (int i = 0; i < 7; i++) {
            switch (count[i]) {
                case 8: if (str1.contains("" + standard.charAt(i)))
                            decoded[2] = standard.charAt(i);
                        else
                            decoded[0] = standard.charAt(i);
                        break;
                case 4: decoded[4] = standard.charAt(i); break;
                case 6: decoded[1] = standard.charAt(i); break;
                case 9: decoded[5] = standard.charAt(i); break;
                case 7: if (str4.contains("" + standard.charAt(i)))
                            decoded[3] = standard.charAt(i);
                        else
                            decoded[6] = standard.charAt(i);
                        break;
            }
        }

        String[] data2 = output.split(" ");
        String num = "";
        for (String str : data2) {
            String bits = "";
            for (char c : decoded) {
                if (str.contains("" + c))
                    bits += "1";
                else
                    bits += 0;
            }
            switch (bits) {
                case "1110111": num += 0; break;
                case "0010010": num += 1; break;
                case "1011101": num += 2; break;
                case "1011011": num += 3; break;
                case "0111010": num += 4; break;
                case "1101011": num += 5; break;
                case "1101111": num += 6; break;
                case "1010010": num += 7; break;
                case "1111111": num += 8; break;
                case "1111011": num += 9; break;
                default: num = "-1"; break;
            }


        }
        System.out.println(num);
        return Integer.parseInt(num);
    }
    

    public static void part1() {
        int count = 0;
        String[] data = output.split(" ");
        for (String str : data) {
            int len = str.length();
            // System.out.println(str + "      len = " + len);
            if (len == 2 || len == 4 || len == 3 || len == 7)
                count ++;
        }
        // System.out.println(count);
    }


    public static void part2() {
        System.out.println("Sum: " + sum);
    }

}