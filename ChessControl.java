import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessControl extends JApplet {

    private int playerTurn;
    private Game currGame;
    private GUI display;
    private JButton selected;

    public void init(){
        display = new GUI();
        currGame = new Game("White", "Black", 0);
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(display.chessboard);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getSize());

        JButton[][] guiBoard = display.getSpaces();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                display.addBtnListener(guiBoard[i][j], new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
            }
        }


        frame.setVisible(true);
    }

}
