import javax.swing.*;
import java.awt.*;


public class GUI {

    private JButton[][] spaces = new JButton[8][8];
    public JPanel chessboard = new JPanel(new GridLayout(8, 8));

    GUI(){
        setUpBoard();
    }

    /**
     * Makes all of board checkered white and black
     * Adds pieces to board
     */
    public void setUpBoard() {
        chessboard.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

        //create Icons for piece images
        ImageIcon whitepawn = new ImageIcon("src/ChessImages/white_pawn.png", "pawn");
        ImageIcon whiteking = new ImageIcon("src/ChessImages/white_king.png", "king");
        ImageIcon whitequeen = new ImageIcon("src/ChessImages/white_queen.png", "queen");
        ImageIcon whiteknight = new ImageIcon("src/ChessImages/white_knight.png", "knight");
        ImageIcon whitebishop = new ImageIcon("src/ChessImages/white_bishop.png", "bishop");
        ImageIcon whiterook = new ImageIcon("src/ChessImages/white_rook.png", "rook");

        ImageIcon blackpawn = new ImageIcon("src/ChessImages/black_pawn.png", "pawn");
        ImageIcon blackking = new ImageIcon("src/ChessImages/black_king.png", "king");
        ImageIcon blackqueen = new ImageIcon("src/ChessImages/black_queen.png", "queen");
        ImageIcon blackknight = new ImageIcon("src/ChessImages/black_knight.png", "knight");
        ImageIcon blackbishop = new ImageIcon("src/ChessImages/black_bishop.png", "bishop");
        ImageIcon blackrook = new ImageIcon("src/ChessImages/black_rook.png", "rook");

        //Creates border for spaces and sets to white or black
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                JButton square = new JButton();
                if(i == 0) {
                    if( j == 0) {
                        square.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    } else{
                        square.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
                    }
                } else{
                    if(j == 0){
                        square.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
                    } else{
                        square.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
                    }
                }
                if((j % 2 == 1 && i % 2 == 1) ||(j % 2 == 0 && i % 2 == 0)){
                    square.setBackground(Color.WHITE);
                } else{
                    square.setOpaque(true);
                    square.setBackground(Color.BLACK);
                }
                spaces[i][j] = square;
                chessboard.add(square);
            }
        }
        //sets all pieces on board
        for(int y = 0; y < 8; y++){
            spaces[1][y].setIcon(whitepawn);
            spaces[6][y].setIcon(blackpawn);
        }
        spaces[0][0].setIcon(whiterook);
        spaces[0][1].setIcon(whiteknight);
        spaces[0][2].setIcon(whitebishop);
        spaces[0][3].setIcon(whitequeen);
        spaces[0][4].setIcon(whiteking);
        spaces[0][5].setIcon(whitebishop);
        spaces[0][6].setIcon(whiteknight);
        spaces[0][7].setIcon(whiterook);

        spaces[7][0].setIcon(blackrook);
        spaces[7][1].setIcon(blackknight);
        spaces[7][2].setIcon(blackbishop);
        spaces[7][3].setIcon(blackqueen);
        spaces[7][4].setIcon(blackking);
        spaces[7][5].setIcon(blackbishop);
        spaces[7][6].setIcon(blackknight);
        spaces[7][7].setIcon(blackrook);

    }

    public static void main(String[] args){
        GUI g = new GUI();
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(g.chessboard);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setVisible(true);
    }
}

