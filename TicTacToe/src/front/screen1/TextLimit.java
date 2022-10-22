package screen1;

import javax.swing.JTextField;

public class TextLimit {

    private String limit = "";
    /**
     * Checks if one of the textFields are way to short or way to long.
     * When text is way to long, sets the last text update which had 20 characters.
     * When text is way to short, prevent the game from getting started
     */
    public JTextField checkLimit(JTextField playerField){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (playerField.getText().length() <= 20) {
                limit = playerField.getText();
            } else {
                playerField.setText(limit);
            } return playerField;
    }

    /** Checks if the name is not to short */
    public boolean name(JTextField pl1Field, JTextField pl2Field) {

        if (pl1Field.getText().length() > 2 && pl2Field.getText().length() > 2) {
            return true;
        } else {
            return false;
        }
    }
}
