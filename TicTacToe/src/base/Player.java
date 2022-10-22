import java.awt.Color;

import javax.swing.JColorChooser;

public class Player {
    
    private Color pl1Color = Color.GREEN;
    private Color pl2Color = Color.GREEN;

    private boolean player1 = true;

    private byte score1, score2;

    /** Returns which players turn it is currently */
    public boolean getPlayerTurn(){

        return player1;
    }

    /** Set players turn */
    public void setPlayerTurn(boolean turn){

        player1 = turn;
    }

    /** Returns players color which is currently selected */
    public Color getColorPlayer1(){

        return pl1Color;
    }

    /** Returns players color which is currently selected */
    public Color getColorPlayer2(){

        return pl2Color;
    }

    /** Set players color */
    public void setColorPlayer1(Color color){

        pl1Color = color;
    }

    /** Set players color */
    public void setColorPlayer2(Color color){

        pl2Color = color;
    }

    /**
     * If game is started returns a JColorChooser window to be able to change the
     * player color
     * 
     * @return
     */
    public Color selectColor() {
        
        return JColorChooser.showDialog(null, "Select Color", null);
    }

    /** Increases the score from player 1, by 1 */
    public void increaceScore1(){
        score1 ++;
    }

    /** Increases the score from player 2, by 1 */
    public void increaceScore2(){
        score2 ++;
    }

    /** Returns the current score for player 1 */
    public byte getScore1(){

        return score1;
    }

    /** Returns the current score for player 2 */
    public byte getScore2(){

        return score2;
    }

    /** Reset both scores */
    public void resetScores(){
        score1 = 0;
        score2 = 0;
    }

}
