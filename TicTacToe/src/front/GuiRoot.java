import javax.swing.JFrame;

    /**
    * Frame, screen container, gui root
    * @category Gui
    */

public class GuiRoot extends JFrame{
    
    private Screen1 screen1;

    public GuiRoot(short width, short height, Screen1 screen1){

        this.screen1 = screen1;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TicTacToe by Kirils Turkins/MrMystery");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Set up the gui
    public void setUp(){

        setContentPane(screen1);
        
        pack();

        setVisible(true);
    }

}