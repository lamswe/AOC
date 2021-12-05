import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class HydrothermalVenture {
    static int mapDim = 1000;
    static int[] map = new int[mapDim * mapDim];
    static List<Line> lineList = new ArrayList<Line>();

    public static void main(String[] args) {
        System.out.println("Day5 - Hydrothermal Venture");
        readInput();
        part2();
    }

    private static void printMap() {
        for (int i = 0; i < mapDim; i++) {
            for (int j = 0; j < mapDim; j++) {
                System.out.print(map[i*mapDim + j] + " ");
            }
            System.out.println();
        }
    }

    private static void readInput() {
        String fileName = "input.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (br.ready()) {
                String[] str = br.readLine().split(" -> ");
                String[] num1 = str[0].split(",");
                String[] num2 = str[1].split(",");
                lineList.add(new Line(Integer.parseInt(num1[0]), Integer.parseInt(num1[1]),
                        Integer.parseInt(num2[0]), Integer.parseInt(num2[1])));
            }
            br.close();
        } catch (Exception err) {
            System.err.println(err);
        }
    }

    private static void part1() {
        for (int i = 0; i < lineList.size(); i++) {
            Line line = lineList.get(i);
            if (line.getStartPoint().x == line.getEndPoint().x ||
                    line.getStartPoint().y == line.getEndPoint().y) {
                Point[] points = line.getPoints();
                for (Point p : points) {
                    map[p.x * mapDim + p.y]++;
                }
            }
        }
        int count = 0;
        for(int j : map)
            count += j > 1 ? 1 :0; 
        System.out.println("Part 1: " + count);
        System.out.println("Done");
    }

    private static void part2() {
        for (int i = 0; i < lineList.size(); i++) {
            Line line = lineList.get(i);
            System.out.println(line.getStartPoint());
            Point[] points = line.getPoints();
            for (Point p : points) {
                map[p.x * mapDim + p.y]++;
            }
        }
        int count = 0;
        for(int j : map)
            count += j > 1 ? 1 :0; 
        System.out.println("Part 2: " + count);
        System.out.println("Done");
    }


}