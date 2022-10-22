package screen1;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.function.Consumer;

import javax.swing.Icon;
import javax.swing.JButton;

public class CheckForClick {

    private boolean p1turn;
    private boolean needPermission;
    private JButton keyyy;
    private int[] tbb = new int[9];

    /**
     * Executed when click during the game got detected.
     * Sets the icon and value of the detected button.
     */
    public void doClick(ActionEvent event, int tb[], HashMap<JButton, Consumer<ActionEvent>> buttons, boolean turn,
            JButton button1, JButton button2,
            JButton button3, JButton button4, JButton button5, JButton button6, JButton button7, JButton button8,
            JButton button9, Icon iconX, Icon iconO, boolean started) {

        p1turn = turn;

        for (JButton key : buttons.keySet()) {

            if (event.getSource() == key) {

                if (started) {
                    if (key.getIcon() == null) {

                        if (p1turn == true) {

                            key.setIcon(iconX);
                            if (key == button1) {
                                tb[0] = 20;
                            }
                            if (key == button2) {
                                tb[1] = 20;
                            }
                            if (key == button3) {
                                tb[2] = 20;
                            }
                            if (key == button4) {
                                tb[3] = 20;
                            }
                            if (key == button5) {
                                tb[4] = 20;
                            }
                            if (key == button6) {
                                tb[5] = 20;
                            }
                            if (key == button7) {
                                tb[6] = 20;
                            }
                            if (key == button8) {
                                tb[7] = 20;
                            }
                            if (key == button9) {
                                tb[8] = 20;
                            }
                            p1turn = false;
                        } else {

                            key.setIcon(iconO);
                            if (key == button1) {
                                tb[0] = 5;
                            }
                            if (key == button2) {
                                tb[1] = 5;
                            }
                            if (key == button3) {
                                tb[2] = 5;
                            }
                            if (key == button4) {
                                tb[3] = 5;
                            }
                            if (key == button5) {
                                tb[4] = 5;
                            }
                            if (key == button6) {
                                tb[5] = 5;
                            }
                            if (key == button7) {
                                tb[6] = 5;
                            }
                            if (key == button8) {
                                tb[7] = 5;
                            }
                            if (key == button9) {
                                tb[8] = 5;
                            }
                            p1turn = true;
                        }
                        tbb = tb;
                        keyyy = key;

                    } else {
                        needPermission = true;
                    }
                } else {
                    keyyy = key;
                }
            }
        }
    }

    /** Gets the current turn */
    public boolean getTurn() {
        return p1turn;
    }

    /** Check if this click require permission */
    public boolean checkPermission() {
        if (needPermission) {
            needPermission = false;
            return true;
        }
        return needPermission;
    }

    /** Gets the selected button */
    public JButton getKey() {
        return keyyy;
    }

    /** Gets value from all buttons */
    public int[] getTB() {
        return tbb;
    }

}
