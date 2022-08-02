
import java.sql.SQLOutput;
import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char [][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}
        };



        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter you placement 1-9: ");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions))
                System.out.println("Position taken, Enter a correct Position");
            playerPos = scan.nextInt();

            placePiece(gameBoard, playerPos, "player");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            System.out.println(cpuPos);
            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);

            String result = checkWinner();
            System.out.println(result);
        }
    }

    public static void printGameBoard(char [][] gameBoard) {
        for(char[] row: gameBoard) {
            for(char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard, int pos, String user) {
       char symbol = ' ';
        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> {
            }
        }
    }
public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
    List midRow = Arrays.asList(4,5,6);
    List botRow = Arrays.asList(7,8,9);
    List leftCol = Arrays.asList(1,4,7);
    List midCol = Arrays.asList(2,5,8);
    List rightCol = Arrays.asList(3,6,9);
    List cross1 = Arrays.asList(1,5,9);
    List cross2 = Arrays.asList(3,5,7);

    List<List> winning = new ArrayList<List>();
    winning.add(topRow);
    winning.add(midRow);
    winning.add(botRow);
    winning.add(leftCol);
    winning.add(midCol);
    winning.add(rightCol);
    winning.add(cross1);
    winning.add(cross2);

    for(List l: winning) {
        if(playerPositions.containsAll(l)) {
            return "Congratulations you won!";
        }else if(cpuPositions.contains(l)){
            return "Cpu wins! Sorry :)";
        }else if(playerPositions.size()+cpuPositions.size()==9) {
            return "its tie";
        }
    }

        return "";
}
}
