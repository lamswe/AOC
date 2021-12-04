import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class GiantSquid {
    static List<Board> boardList = new ArrayList<Board>();
    static int[] moves;
    public static void main (String[] args) {
        System.out.println("Day 4 - Giant Squid");
        readData();       
        part1();
        part2();
    }

    private static void part1() {
        int winningBoard = 0;
        int nrMove = 101;
        for (int i = 0; i < boardList.size(); i++) {
            Board board = boardList.get(i);
            int bNrMove = board.getNrMoves();
            if (nrMove > bNrMove) {
                winningBoard = i;
                nrMove = bNrMove;
            }
        }
        System.out.println(boardList.get(winningBoard).boardScore());
    }

    private static void part2() {
        int losingBoard = 0;
        int nrMove = 0;
        for (int i = 0; i < boardList.size(); i++) {
            Board board = boardList.get(i);
            int bNrMove = board.getNrMoves();
            if (nrMove < bNrMove) {
                losingBoard = i;
                nrMove = bNrMove;
            }
        }
        System.out.println(boardList.get(losingBoard).boardScore());

    }

    private static void readData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            // Read moves
            String[] moveStr = br.readLine().split(",");
            moves = new int[moveStr.length];
            for (int i = 0; i < moveStr.length; i++) {
                moves[i] = Integer.parseInt(moveStr[i]);
            }

            // Read boards
            while(br.ready()) {
                br.readLine();
                String str = "";
                for(int i = 0; i < 5; i++)
                    str += (br.readLine() + " ");
                boardList.add(new Board(str, moves));
            }
        } catch (Exception err) {
            System.err.println(err);
        }
    }


}

