import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessControl extends JApplet {

    private int playerTurn;
    private Game currGame;
    private GUI display;
    private DispSpace[][] dispBoard;
    private Space selected;

    public void init(){
        display = new GUI();
        currGame = new Game("White", "Black", 0);
        Board board = currGame.getBoard();
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(display.chessboard);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getSize());

        JButton[][] guiBoard = display.getSpaces();
        Space holdSpace;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                holdSpace = board.getSpace(i,j);
                display.addBtnListener(guiBoard[i][j], new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selected = board.getSpace(i, j);
                    }
                });
                dispBoard[i][j] = new DispSpace(holdSpace, guiBoard[i][j]);
            }
        }


        frame.setVisible(true);
    }

}
