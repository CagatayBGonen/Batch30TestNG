package TicTacToeGame;

import java.util.*;

public class C01_Game {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Sizin siraniz (1-9): ");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos)||cpuPositions.contains(playerPos)){ // yerin dolu ya da bos oldugunu kontrol ediyoruz.
                System.out.println("Yer dolu! Baska bir yer sec");
                playerPos = scan.nextInt();
            }
            System.out.println(playerPos);
            actions(playerPos, gameBoard, "player");
            printGameBoard(gameBoard);
            if(!winningConditions()){ // boolean  default olarak true dondurur, kazanma kosullu olarak false halini kullanıyoruz.
                break;
            }
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            actions(cpuPos, gameBoard, "cpu");
            printGameBoard(gameBoard);
            if(!winningConditions()){
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] sira : gameBoard) {
            for (char w : sira) {
                System.out.print(w);
            }
            System.out.println();
        }
    }

    public static void actions(int pos, char[][] gameBoard, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            playerPositions.add(pos);
            symbol = 'X';
        } else if (user.equals("cpu")) {
            cpuPositions.add(pos);
            symbol = 'O';
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static boolean winningConditions(){
        List ustSira = Arrays.asList(1, 2, 3);
        List ortaSira = Arrays.asList(4, 5, 6);
        List altSira = Arrays.asList(7, 8, 9);
        List solSutun = Arrays.asList(1, 4, 7);
        List ortaSutun = Arrays.asList(2, 5, 8);
        List sagSutun = Arrays.asList(3, 6, 9);
        List capraz1 = Arrays.asList(1, 5, 9);
        List capraz2 = Arrays.asList(3, 5, 7);

        List<List> winningCond = new ArrayList<>(Arrays.asList(ustSira,ortaSira,altSira,solSutun,ortaSutun,sagSutun,capraz1,capraz2));
        for (List w:winningCond) {
            if (playerPositions.containsAll(w)){
                System.out.println("Player Won");
                return false;
            } else if(cpuPositions.containsAll(w)){
                System.out.println("CPU Won, Player Lost");
                return false;
            } else if (playerPositions.size()+cpuPositions.size()==9){
                System.out.println("Draw");
                return false;
            }
        }
        return true;
    }
}
