import javax.swing.*;

public class DispSpace {

    private Space thespace;
    private JButton button;

    public DispSpace(Space currSpace, JButton thebutton){
        this.thespace = currSpace;
        this.button = thebutton;
    }

    public Space getSpace(){
        return this.thespace;
    }

    public JButton getButton(){
        return this.button;
    }


}
