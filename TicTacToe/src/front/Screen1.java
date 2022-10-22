import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import front.IconManager;
import screen1.CheckForClick;
import screen1.CheckBoard;
import screen1.TextLimit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;
import java.awt.event.ActionEvent;

/**
 * Creates a JPanel which implemets a Action Listener.
 * Contains a hashmap out of 11 buttons (9 tictactoe click buttons, start button
 * and the reset button)
 * 
 * @author Kirils_Turkins/MrMystery
 * @version 1.0
 * @category Gui
 */

public class Screen1 extends JPanel implements ActionListener {

    private CheckForClick checkForClick = new CheckForClick();
    private CheckBoard checkBoard = new CheckBoard();
    private IconManager iconManager = new IconManager();
    private TextLimit textLimit = new TextLimit();
    private Player player = new Player();

    private int[] tb = new int[9];

    private boolean gameStarted;

    private String[] playerIcon = { "X", "O", "¿", "+", "—" };

    private byte clicks = 0;
    private byte timer = 20;

    // Hashmap with all 11 buttons. Every button is using the button blueprint
    private HashMap<JButton, Consumer<ActionEvent>> buttons = new HashMap<>();
    private JButton button1 = button(95, 339, 105, 105, "", 70, 1);
    private JButton button2 = button(245, 339, 105, 105, "", 70, 1);
    private JButton button3 = button(395, 339, 105, 105, "", 70, 1);
    private JButton button4 = button(95, 489, 105, 105, "", 70, 1);
    private JButton button5 = button(245, 489, 105, 105, "", 70, 1);
    private JButton button6 = button(395, 489, 105, 105, "", 70, 1);
    private JButton button7 = button(95, 639, 105, 105, "", 70, 1);
    private JButton button8 = button(245, 639, 105, 105, "", 70, 1);
    private JButton button9 = button(395, 639, 105, 105, "", 70, 1);
    private JButton startGame = button(260, 110, 200, 110, "", 30, 2);
    private JButton resetGame = button(530, 700, 70, 70, "", 30, 3);
    private JButton colorPlayer1 = button(55, 225, 170, 25, "Change Color", 20, 1);
    private JButton colorPlayer2 = button(350, 225, 170, 25, "Change Color", 20, 1);

    // Fields for the names to write the name you want
    private JTextField player1Name = textField(0, 107, 170, 50, "Player1", 20);
    private JTextField player2Name = textField(0, 163, 165, 52, "Player2", 20);

    private JComboBox<String> choosePlayerIcon1 = comboBox(25, 300, 50, 20);
    private JComboBox<String> choosePlayerIcon2 = comboBox(520, 300, 50, 20);

    // Labels over the TicTacToe board to tell which player have turn
    private JLabel player1Label = label(55, 260, 170, 30, player1Name.getText());
    private JLabel player2Label = label(350, 260, 190, 30, player2Name.getText());

    /**
     * Sets the basic stats of the JPanel.
     * Puts all buttons inside of the hashmap with a Lambda expression,
     * adds all of them (JtextFields and JLabel also included) to the JPanel.
     * 
     * @param width
     * @param height
     */
    protected Screen1(short width, short height) {

        // Sets the basic stats of the JPanel
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setLayout(null);

        // Puts all buttons inside of the hashmap with a Lambda expression
        buttons.put(button1, event -> checkForClick(event));
        buttons.put(button2, event -> checkForClick(event));
        buttons.put(button3, event -> checkForClick(event));
        buttons.put(button4, event -> checkForClick(event));
        buttons.put(button5, event -> checkForClick(event));
        buttons.put(button6, event -> checkForClick(event));
        buttons.put(button7, event -> checkForClick(event));
        buttons.put(button8, event -> checkForClick(event));
        buttons.put(button9, event -> checkForClick(event));
        buttons.put(startGame, event -> startGame());
        buttons.put(resetGame, event -> reset(Reset.FULL));
        buttons.put(colorPlayer1, event -> {
            player.setColorPlayer1(player.selectColor());
            repaint();
        });
        buttons.put(colorPlayer2, event -> {
            player.setColorPlayer2(player.selectColor());
            repaint();
        });

        // Adds all JButtons, JTextFields and JLabel to the JPanel
        for (JButton key : buttons.keySet()) {
            add(key);
        }

        add(player1Name);
        add(player2Name);

        add(choosePlayerIcon1);
        add(choosePlayerIcon2);

        add(player1Label);
        add(player2Label);

        checkBoard();
        timer();
    }

    /**
     * Button blueprint to create new buttons way faster and smarter by calling this
     * method and giving all necessary parameters.
     * Adds a ActionListener of type "this" if ActionListener is implemented.
     * 
     * @return JButton
     */
    private JButton button(int x, int y, int widht, int height, String text, int size, int type) {

        JButton button = new JButton();

        button.setBounds(x, y, widht, height);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        button.setText(text);
        button.setFocusable(false);

        // Check for special type of button and set them a icon
        if (type == 2) {
            button.setIcon(new ImageIcon(iconManager.getStartButton()));
        }
        if (type == 3) {
            button.setIcon(new ImageIcon(iconManager.getRestartButton()));
        }
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addActionListener(this);

        return button;
    }

    /**
     * JTextField blueprint to create new textField way faster and smarter by
     * calling this method and giving all necessary parameters.
     * 
     * @return JTextField
     */
    private JTextField textField(int x, int y, int widht, int height, String text, int size) {

        JTextField textF = new JTextField();

        textF.setBounds(x, y, widht, height);
        textF.setForeground(Color.BLACK);
        textF.setFont(new Font("Arial", Font.BOLD, size));
        textF.setText(text);
        textF.setBorder(BorderFactory.createEmptyBorder());

        return textF;
    }

    /**
     * ComboBox blueprint to create new comboboxes way faster and smarter by calling
     * this
     * method and giving all necessary parameters.
     * Adds a ActionListener of type "this" if ActionListener is implemented.
     * 
     * @return JButton
     */
    private JComboBox<String> comboBox(int x, int y, int widht, int height) {

        JComboBox<String> box = new JComboBox<>(playerIcon);

        box.setBounds(x, y, widht, height);
        box.setBackground(Color.WHITE);
        box.setForeground(Color.BLACK);
        box.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        box.addActionListener(this);

        return box;
    }

    /**
     * JLabel blueprint to create new label way faster and smarter by calling this
     * method and giving all necessary parameters.
     * 
     * @return JLabel
     */
    private JLabel label(int x, int y, int widht, int height, String text) {

        JLabel label = new JLabel();

        label.setBounds(x, y, widht, height);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        return label;
    }

    /**
     * Starts the TicTacToe game.
     * This method is only used on start or after a full restart happend
     */
    private void startGame() {

        for (int x = 0; x < 9; x++) {
            tb[x] = 0;
        }
        if (textLimit.name(player1Name, player2Name)) {
            randomPlayerAnimation();
            startGame.setEnabled(false);
            colorPlayer1.setEnabled(false);
            colorPlayer2.setEnabled(false);
            choosePlayerIcon1.setEnabled(false);
            choosePlayerIcon2.setEnabled(false);
            player1Label.setText(player1Name.getText());
            player2Label.setText(player2Name.getText());
            player1Name.setEditable(false);
            player2Name.setEditable(false);
        } else {
            player1Name.setText("Way to short!");
            player2Name.setText("Way to short!");
        }
    }

    /**
     * This method get called by the restart button or when a player won the game.
     * Contains 2 types of restart, first type of restart is the full restart,
     * which fully sets all possible stats and points back, removes all images from
     * used TicTacToe Fields.
     * The second restart type is a half restart which only removes all images from
     * used TicTacToe Fields,
     * sets timer back to 20 for the new round.
     */
    private void reset(Reset type) {

        // Small delay to show green/red fields on win and not directly clear them
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Full restart when press restart button
        if (type == Reset.FULL) {
            timer = 20;
            clicks = 0;
            player.setPlayerTurn(true);
            player1Name.setText("Player 1");
            player2Name.setText("Player 2");
            player1Name.setEditable(true);
            player2Name.setEditable(true);
            choosePlayerIcon1.setEnabled(true);
            choosePlayerIcon2.setEnabled(true);
            for (byte x = 0; x < 9; x++) {
                tb[x] = 0;
            }
            for (JButton key : buttons.keySet()) {
                if (key.getIcon() == iconManager.getIconX() || key.getIcon() == iconManager.getIconO())
                    key.setIcon(null);
                key.setBackground(Color.WHITE);
            }
            gameStarted = false;
            startGame.setEnabled(true);
            colorPlayer1.setEnabled(true);
            colorPlayer2.setEnabled(true);
            player.resetScores();

            // Small restart when a player won the game or if its a draw
        } else if (type == Reset.HALF) {
            timer = 20;
            player.setPlayerTurn(true);
            for (byte x = 0; x < 9; x++) {
                tb[x] = 0;
            }
            for (JButton key : buttons.keySet()) {
                if (key.getIcon() == iconManager.getIconX() || key.getIcon() == iconManager.getIconO())
                    key.setIcon(null);
                key.setBackground(Color.WHITE);
            }
        }
    }

    /**
     * Mark the button red for short time if the player not have permission to click
     * on it
     */
    private void noPermission(JButton button) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    button.setBackground(Color.RED);
                    Thread.sleep(100);
                    button.setBackground(Color.WHITE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * Action on button click, calls the lambda expression from the buttons hashmap
     * using the consumer function
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == choosePlayerIcon1) {

            iconManager.setPlayer1Icon(choosePlayerIcon1.getSelectedItem().toString());
        } else if (event.getSource() == choosePlayerIcon2) {

            iconManager.setPlayer2Icon(choosePlayerIcon2.getSelectedItem().toString());
        } else {
            buttons.get(event.getSource()).accept(event);
        }
    }

    /**
     * Check if the click is possible (if ticTacToe button already have a value or
     * game is not started ignore click).
     * This method gets only called by the consumer function from a button
     */
    public void checkForClick(ActionEvent event) {

        if (gameStarted == true) {

            checkForClick.doClick(event, tb, buttons, player.getPlayerTurn(), button1, button2, button3, button4,
                    button5, button6, button7, button8, button9, iconManager.getIconX(), iconManager.getIconO(), true);

            player.setPlayerTurn(checkForClick.getTurn());
            tb = checkForClick.getTB();

            if (checkForClick.checkPermission() == false) {
                clicks++;
                timer = 20;
            } else {
                checkForClick.doClick(event, tb, buttons, player.getPlayerTurn(), button1, button2, button3, button4,
                        button5, button6, button7, button8, button9, iconManager.getIconX(), iconManager.getIconO(),
                        false);
                noPermission(checkForClick.getKey());
            }

            repaint();
            checkBoard();

        } else {
            checkForClick.doClick(event, tb, buttons, player.getPlayerTurn(), button1, button2, button3, button4,
                    button5, button6, button7, button8, button9, iconManager.getIconX(), iconManager.getIconO(), false);
            noPermission(checkForClick.getKey());
        }

    }

    /**
     * This method contains a new Thread with a infinity while loop, if game is
     * started it will count from 20 to 0,
     * when timer reach 0, timer gets back to 20 and next player get selected
     */
    private void timer() {
        new Thread(new Runnable() {

            public void run() {

                while (true) {

                    player1Name = textLimit.checkLimit(player1Name);
                    player2Name = textLimit.checkLimit(player2Name);
                    if (gameStarted) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        timer--;

                        repaint();
                        if (timer <= 0) {
                            timer = 20;
                            if (player.getPlayerTurn()) {
                                player.setPlayerTurn(false);
                            } else {
                                player.setPlayerTurn(true);
                            }
                        }
                    }
                }
            }
        }).start();
    }

    /**
     * Check the TicTacToe board if a player won or no one won (draw)
     * if a player won or draw, score get increased and the board gets reseted
     */
    private void checkBoard() {

        new Thread(new Runnable() {
            public void run() {

                checkBoard.checkBoard(tb, player.getColorPlayer1(), player.getColorPlayer2(), button1, button2, button3,
                        button4, button5, button6,
                        button7, button8, button9);
                if (checkBoard.needReset() == true) {
                    if (checkBoard.getScore()) {
                        player.increaceScore1();
                    } else {
                        player.increaceScore2();
                    }
                    reset(Reset.HALF);
                }

                // Check if the board is on draw state and no one won, then do a small Red
                // animation and clear the board
                if (checkBoard.checkForDraw()) {
                    for (JButton key : buttons.keySet()) {
                        if (key.getIcon() == iconManager.getIconX() || key.getIcon() == iconManager.getIconO()
                                || key.getIcon() == null && key.getText().equals("")) {
                            key.setBackground(Color.RED);
                        }
                    }
                    reset(Reset.HALF);
                }

                for (JButton keyy : buttons.keySet()) {
                    if (keyy.getIcon() == iconManager.getIconX() || keyy.getIcon() == iconManager.getIconO()
                            || keyy.getIcon() == null && keyy.getText().equals("")) {

                        for (byte x = 1; x < 9; x++) {
                            keyy = checkBoard.getButton(x);
                        }
                    }

                }
            }
        }).start();

    }

    /** Animation when choose a random player to start */
    private void randomPlayerAnimation() {
        new Thread(new Runnable() {
            public void run() {

                byte count = 0;
                try {
                    while (count < 10) {
                        count++;
                        Thread.sleep(40);
                        player.setPlayerTurn(true);
                        repaint();
                        Thread.sleep(40);
                        player.setPlayerTurn(false);
                        repaint();
                    }
                    count = 0;
                    while (count < 5) {
                        count++;
                        Thread.sleep(80);
                        player.setPlayerTurn(true);
                        repaint();
                        Thread.sleep(80);
                        player.setPlayerTurn(false);
                        repaint();
                    }
                    count = 0;
                    while (count < 4) {
                        count++;
                        Thread.sleep(130);
                        player.setPlayerTurn(true);
                        repaint();
                        Thread.sleep(130);
                        player.setPlayerTurn(false);
                        repaint();
                    }
                    Random random = new Random();
                    if (random.nextInt(10) >= 5) {
                        player.setPlayerTurn(true);
                    }
                    gameStarted = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * Main paint method which calls all sub-methods.
     * This method gets only called by repaint(); or self when update is necessary.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        drawBase(g2d);
        drawText(g2d);
    }

    /** Draw the base of the program (background) */
    private void drawBase(Graphics2D g2d) {

        g2d.drawImage(iconManager.getBackground(), 0, 0, 600, 800, null);
    }

    /** Draw the textes for the program */
    private void drawText(Graphics2D g2d) {

        // Display the timer
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g2d.drawString("" + timer, 550, 380);

        // Display selected player
        if (player.getPlayerTurn()) {
            g2d.setColor(player.getColorPlayer1());
            g2d.fillOval(55, 250, 170, 46);
        } else {
            g2d.setColor(player.getColorPlayer2());
            g2d.fillOval(350, 250, 190, 46);
        }

        // Display total clicks
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        g2d.drawString("" + clicks, 500, 150);

        // Display the current score
        g2d.setColor(Color.CYAN);
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        g2d.drawString("" + player.getScore1(), 390, 70);
        g2d.drawString("" + player.getScore2(), 500, 70);
    }
}