package front;

import front.ImageLoader;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;

public class IconManager {
    
    private ImageLoader imageLoader = new ImageLoader();
    private Icon iconX = new ImageIcon(imageLoader.x);
    private Icon iconO = new ImageIcon(imageLoader.o);

    private BufferedImage background = imageLoader.background;
    private BufferedImage start_button = imageLoader.start_button;
    private BufferedImage restart_button = imageLoader.restart_button;

    /** Returns the current selected Icon for Player 1 */
    public Icon getIconX(){
        return iconX;
    }

    /** Returns the current selected Icon for Player 2 */
    public Icon getIconO(){
        return iconO;
    }

    /** Returns the current selected Background */
    public BufferedImage getBackground(){
        return background;
    }

    /** Returns the current selected Start Button */
    public BufferedImage getStartButton(){
        return start_button;
    }

    /** Returns the current selected Restart Button */
    public BufferedImage getRestartButton(){
        return restart_button;
    }

    /** Sets the icon of a player */
    public void setPlayer1Icon(String choice){

        if(choice.equals("X")){
            iconX = new ImageIcon(imageLoader.x);
        } else if (choice.equals("O")){
            iconX = new ImageIcon(imageLoader.o);
        } else if (choice.equals("¿")){
            iconX = new ImageIcon(imageLoader.questionMark);
        } else if (choice.equals("+")){
            iconX = new ImageIcon(imageLoader.plus);
        } else if (choice.equals("—")){
            iconX = new ImageIcon(imageLoader.minus);
        }
    }

    /** Sets the icon of a player */
    public void setPlayer2Icon(String choice){

        if(choice.equals("X")){
            iconO = new ImageIcon(imageLoader.x);
        } else if (choice.equals("O")){
            iconO = new ImageIcon(imageLoader.o);
        } else if (choice.equals("¿")){
            iconO = new ImageIcon(imageLoader.questionMark);
        } else if (choice.equals("+")){
            iconO = new ImageIcon(imageLoader.plus);
        } else if (choice.equals("—")){
            iconO = new ImageIcon(imageLoader.minus);
        }
    }
}
