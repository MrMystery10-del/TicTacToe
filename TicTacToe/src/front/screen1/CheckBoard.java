package screen1;

import java.awt.Color;

import javax.swing.JButton;

public class CheckBoard {

    private boolean needReset = false;
    private boolean scorePlayer1;

    private JButton[] buttons = new JButton[10];

    private boolean draw;

    /** Check the TicTacToe board if a player won or no one won (draw) */
    public void checkBoard(int[] tb, Color pl1Color, Color pl2Color, JButton button1, JButton button2,
            JButton button3, JButton button4, JButton button5, JButton button6, JButton button7, JButton button8,
            JButton button9) {

        draw = true;
        buttons[1] = button1;
        buttons[2] = button2;
        buttons[3] = button3;
        buttons[4] = button4;
        buttons[5] = button5;
        buttons[6] = button6;
        buttons[7] = button7;
        buttons[8] = button8;
        buttons[9] = button9;

        if (tb[0] + tb[1] + tb[2] == 60) {
            buttons[1].setBackground(pl1Color);
            buttons[2].setBackground(pl1Color);
            buttons[3].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[0] + tb[1] + tb[2] == 15) {
            buttons[1].setBackground(pl2Color);
            buttons[2].setBackground(pl2Color);
            buttons[3].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[3] + tb[4] + tb[5] == 60) {
            buttons[4].setBackground(pl1Color);
            buttons[5].setBackground(pl1Color);
            buttons[6].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[3] + tb[4] + tb[5] == 15) {
            buttons[4].setBackground(pl2Color);
            buttons[5].setBackground(pl2Color);
            buttons[6].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[6] + tb[7] + tb[8] == 60) {
            buttons[7].setBackground(pl1Color);
            buttons[8].setBackground(pl1Color);
            buttons[9].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[6] + tb[7] + tb[8] == 15) {
            buttons[7].setBackground(pl2Color);
            buttons[8].setBackground(pl2Color);
            buttons[9].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[0] + tb[3] + tb[6] == 60) {
            buttons[1].setBackground(pl1Color);
            buttons[4].setBackground(pl1Color);
            buttons[7].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[0] + tb[3] + tb[6] == 15) {
            buttons[1].setBackground(pl2Color);
            buttons[4].setBackground(pl2Color);
            buttons[7].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[1] + tb[4] + tb[7] == 60) {
            buttons[2].setBackground(pl1Color);
            buttons[5].setBackground(pl1Color);
            buttons[8].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[1] + tb[4] + tb[7] == 15) {
            buttons[2].setBackground(pl2Color);
            buttons[5].setBackground(pl2Color);
            buttons[8].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[2] + tb[5] + tb[8] == 60) {
            buttons[3].setBackground(pl1Color);
            buttons[6].setBackground(pl1Color);
            buttons[9].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[2] + tb[5] + tb[8] == 15) {
            buttons[3].setBackground(pl2Color);
            buttons[6].setBackground(pl2Color);
            buttons[9].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[0] + tb[4] + tb[8] == 60) {
            buttons[1].setBackground(pl1Color);
            buttons[5].setBackground(pl1Color);
            buttons[9].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[0] + tb[4] + tb[8] == 15) {
            buttons[1].setBackground(pl2Color);
            buttons[5].setBackground(pl2Color);
            buttons[9].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }
        if (tb[6] + tb[4] + tb[2] == 60) {
            buttons[7].setBackground(pl1Color);
            buttons[5].setBackground(pl1Color);
            buttons[3].setBackground(pl1Color);
            scorePlayer1 = true;
            needReset = true;
        } else if (tb[6] + tb[4] + tb[2] == 15) {
            buttons[7].setBackground(pl2Color);
            buttons[5].setBackground(pl2Color);
            buttons[3].setBackground(pl2Color);
            scorePlayer1 = false;
            needReset = true;
        }

        for (int i = 1; i < 9; i++) {
            if (tb[i] == 0) {
                draw = false;
            }
        }
    }

    /** Gets the selected button */
    public JButton getButton(int button) {

        switch (button) {
            case 1:

                return buttons[1];

            case 2:

                return buttons[2];

            case 3:

                return buttons[3];

            case 4:

                return buttons[4];

            case 5:

                return buttons[5];

            case 6:

                return buttons[6];

            case 7:
                return buttons[7];

            case 8:
                return buttons[8];

            case 9:
                return buttons[9];

        }
        return null;
    }

    /** Returns if the game need a reset or not */
    public boolean needReset() {
        if (needReset == true) {
            needReset = false;
            return true;
        }
        return needReset;
    }

    /** Returns the score of player 1 */
    public boolean getScore() {
        return scorePlayer1;
    }

    /** Check if the game is a draw and no one won */
    public boolean checkForDraw() {
        if (draw) {
            draw = false;
            return true;
        }
        return draw;
    }

}
