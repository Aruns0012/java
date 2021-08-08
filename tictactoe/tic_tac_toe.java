import java.util.*;
class tic_tac {
     ArrayList<Integer> playerPos = new ArrayList<>();
     ArrayList<Integer> cpuPos = new ArrayList<>();
//    this method prints board
    public void prBoard(char[][] board){
        for (char[] row:board) {
            for (char c:row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    //    this method prints move in board
    public void placeMove(char[][] board, int position, String player) {
        char symbol = ' ';
        if(player.equalsIgnoreCase("hooman")){
            symbol = 'x';
            playerPos.add(position);
        } else if(player.equalsIgnoreCase("cpu")) {
            symbol = 'o';
            cpuPos.add(position);
        }

        switch (position) {
            case 1 -> board[0][0] = symbol;
            case 2 -> board[0][2] = symbol;
            case 3 -> board[0][4] = symbol;
            case 4 -> board[2][0] = symbol;
            case 5 -> board[2][2] = symbol;
            case 6 -> board[2][4] = symbol;
            case 7 -> board[4][0] = symbol;
            case 8 -> board[4][2] = symbol;
            case 9 -> board[4][4] = symbol;
        }
    }
    //    this method checks for winner
    public String  checkWinner() {
        List<Integer> top = Arrays.asList(1,2,3);
        List<Integer> mid = Arrays.asList(4,5,6);
        List<Integer> bot = Arrays.asList(7,8,9);
        List<Integer> col1 = Arrays.asList(1,4,7);
        List<Integer> col2 = Arrays.asList(2,5,8);
        List<Integer> col3 = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(3,5,7);

        List<List> winner = new ArrayList<>();
        winner.add(top);
        winner.add(mid);
        winner.add(bot);
        winner.add(col1);
        winner.add(col2);
        winner.add(col3);
        winner.add(cross1);
        winner.add(cross2);
        boolean flag = true;
        for (List l:winner) {
            if(playerPos.containsAll(l)){
                flag = false;
                return "CONGRATULATION!, YOU WON";
            }else if (cpuPos.containsAll(l)){
                flag = false;
                return "COMPUTER  WON!!";
            } else if (playerPos.size() + cpuPos.size() == 9 && flag) {
                return "it was a draw";
            }
        }
        return "";

    }


}

public class tic_tac_toe {
    public static void main(String[] args) throws InterruptedException{
        char[] [] board = {{' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '}};

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        tic_tac game = new tic_tac();
        game.prBoard(board);
        System.out.println("Lets start the game");
        System.out.println("-----------------------------------");

        while (true){

//            moves for human
                    System.out.println("Enter your move");
                    int hposition = sc.nextInt();
                    while (game.playerPos.contains(hposition) || game.cpuPos.contains(hposition)) {
                        System.out.println("POSITION ALREADY TAKEN!!!");
                        hposition = sc.nextInt();
                    }
                    game.placeMove(board, hposition,"hooman");
                    String result = game.checkWinner();
                    if(result.length() > 0) {
                        System.out.println(result);
                        break;
                    }

//            moves for cpu
            Thread.sleep(500);
                    int cposition = rand.nextInt(9)+1;
                    while (game.playerPos.contains(cposition) || game.cpuPos.contains(cposition)) {
        //                System.out.println("position taken try again from cpu");
                        cposition = rand.nextInt(9)+1;
                    }
                    game.placeMove(board, cposition, "cpu");
                    result = game.checkWinner();
            game.prBoard(board);

            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
