package front;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import javax.imageio.ImageIO;

/** Image container for the TicTacToe game */
public class ImageLoader {
    
    BufferedImage background, x, o, questionMark, plus, minus, restart_button, start_button;

    /** Loads all for the game needed images */
    public ImageLoader(){
        loadImage();
    }
    
    private void loadImage(){

        try {
            background = ImageIO.read(getClass().getResourceAsStream("/images/background.png"));
            x = ImageIO.read(getClass().getResourceAsStream("/images/x.png"));
            o = ImageIO.read(getClass().getResourceAsStream("/images/o.png"));
            questionMark = ImageIO.read(getClass().getResourceAsStream("/images/questionMark.png"));
            plus = ImageIO.read(getClass().getResourceAsStream("/images/+.png"));
            minus = ImageIO.read(getClass().getResourceAsStream("/images/-.png"));
            restart_button = ImageIO.read(getClass().getResourceAsStream("/images/restart_button.png"));
            start_button = ImageIO.read(getClass().getResourceAsStream("/images/start_button.png"));
        } catch (IOException e) {
            new UncheckedIOException(e);
        }
    }
}
