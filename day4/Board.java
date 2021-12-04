import java.util.Scanner;

public class Board {
    private int[] board = new int[25];
    private int[] moves;
    private int nrMoves = 0;
    private int winningMove = -1;

    public Board(String str, int[] moves) {
        this.moves = moves;
        Scanner scanner = new Scanner(str);
        int i = 0;
        while(scanner.hasNext()) {
            board[i++] = scanner.nextInt();
        }
        scanner.close();
        nrMoves = movesUntilWin();
    }
    
    public int getNrMoves() {
        return nrMoves;
    }

    public int getWinningMove(){
        return winningMove;
    }

    private boolean hasWon() {
        for (int i = 0; i < 5; i++) {
            boolean fullRow = true;
            for (int j = 0; j < 5; j++) {
                fullRow = fullRow && (board[i * 5 + j] < 0);
            }
            if (fullRow)
                return true;
        }

        for (int i = 0; i < 5; i++) {
            boolean fullCol = true;
            for (int j = 0; j < 5; j++) {
                fullCol = fullCol && (board[i + j * 5] < 0);
            }

            if (fullCol)
                return true;
        }
        return false;
    }

    public int movesUntilWin () {
        for (int i = 0; i < moves.length; i++) {
            nextNum(moves[i]);
            if (hasWon()) {
                winningMove = moves[i];
                return i+1;
            }
        }
        return 0;
    }

    private int sumOfBoard() {
        int sum = 0;
        for (int i : board){
            sum = sum + (i >= 0 ? i : 0);
        }
        return sum;
    }
    private void nextNum(int num) {
        for (int i = 0; i < 25; i++) {
            if (board[i] == num) {
                board[i] = -num;
                return;
            }
        }
    }

    public int boardScore() {
        return winningMove*sumOfBoard();
    }
}
