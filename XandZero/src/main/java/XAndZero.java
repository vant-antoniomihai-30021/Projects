import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class XAndZero extends JFrame {
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton start;
    JLabel toMove;
    JButton restart;
    ArrayList<JButton> buttons = new ArrayList<>();
    private int player;
    HashMap<Integer, Integer> board = new HashMap<>();

    public XAndZero() {
        setTitle("Press The Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setSize(700, 700);
        setVisible(true);
        player = -1;
        //initializing the board
        board.put(1, -1);
        board.put(2, -1);
        board.put(3, -1);
        board.put(4, -1);
        board.put(5, -1);
        board.put(6, -1);
        board.put(7, -1);
        board.put(8, -1);
        board.put(9, -1);

    }

    void init() {
        //placing the buttons
        this.setLayout(null);
        one = new JButton("");
        one.setBounds(200, 90, 50, 50);
        two = new JButton("");
        two.setBounds(300, 90, 50, 50);
        three = new JButton("");
        three.setBounds(400, 90, 50, 50);
        four = new JButton("");
        four.setBounds(200, 190, 50, 50);
        five = new JButton("");
        five.setBounds(300, 190, 50, 50);
        six = new JButton("");
        six.setBounds(400, 190, 50, 50);
        seven = new JButton("");
        seven.setBounds(200, 290, 50, 50);
        eight = new JButton("");
        eight.setBounds(300, 290, 50, 50);
        nine = new JButton("");
        nine.setBounds(400, 290, 50, 50);

        toMove = new JLabel("");
        toMove.setBounds(200, 440, 350, 120);
        toMove.setFont(new Font("", 1, 25));

        restart = new JButton("RESTART");
        restart.setBounds(260, 400, 150, 50);
        start = new JButton("START GAME");
        start.setBounds(260, 440, 150, 50);
        restart.setVisible(false);
        restart.setEnabled(false);

        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);

        //making the move x/o
        for (JButton jb :
                buttons) {
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (player == 1 || player == 0)
                        jb.setEnabled(false);
                    if (player == 1) {
                        jb.setText("X");
                        place(jb, 1);
                        toMove.setText("Current player: player 0");
                        checkForWinOrEnd();
                    } else if (player == 0) {
                        jb.setText("O");
                        place(jb, 0);
                        toMove.setText("Current player: player 1");
                        checkForWinOrEnd();
                    }
                    if (player == 1)
                        player = 0;
                    else if (player == 0)
                        player = 1;
                }
            });
        }
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                start.setVisible(false);
                restart.setVisible(false);
                restart.setEnabled(false);
                toMove.setText("Current player: player 1");
                toMove.setBounds(200, 440, 350, 120);
                toMove.setVisible(true);
                player = 1;
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                start.setEnabled(false);
                start.setVisible(false);
                toMove.setText("Current player: player 1");
                toMove.setBounds(200, 440, 350, 120);
                toMove.setVisible(true);
                player = 1;


            }
        });
        //adding the components to the panel
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
        add(start);
        add(toMove);
        add(restart);
    }

    void place(JButton button, int player) {
        if (button == one)
            board.put(1, player);
        if (button == two)
            board.put(2, player);
        if (button == three)
            board.put(3, player);
        if (button == four)
            board.put(4, player);
        if (button == five)
            board.put(5, player);
        if (button == six)
            board.put(6, player);
        if (button == seven)
            board.put(7, player);
        if (button == eight)
            board.put(8, player);
        if (button == nine)
            board.put(9, player);
    }

    void checkForWinOrEnd() {

        if ((board.get(1) == 1 && board.get(2) == 1 && board.get(3) == 1) ||
                (board.get(4) == 1 && board.get(5) == 1 && board.get(6) == 1) ||
                (board.get(7) == 1 && board.get(8) == 1 && board.get(9) == 1) ||
                (board.get(1) == 1 && board.get(5) == 1 && board.get(9) == 1) ||
                (board.get(3) == 1 && board.get(5) == 1 && board.get(7) == 1) ||
                (board.get(1) == 1 && board.get(4) == 1 && board.get(7) == 1) ||
                (board.get(2) == 1 && board.get(5) == 1 && board.get(8) == 1) ||
                (board.get(3) == 1 && board.get(6) == 1 && board.get(9) == 1)) {

            toMove.setText("PLAYER X WON!");
            System.out.println("PLAYER X WON");
            reset();
            player = -1;
        }
        if ((board.get(1) == 0 && board.get(2) == 0 && board.get(3) == 0) ||
                (board.get(4) == 0 && board.get(5) == 0 && board.get(6) == 0) ||
                (board.get(7) == 0 && board.get(8) == 0 && board.get(9) == 0) ||
                (board.get(1) == 0 && board.get(5) == 0 && board.get(9) == 0) ||
                (board.get(3) == 0 && board.get(5) == 0 && board.get(7) == 0) ||
                (board.get(1) == 0 && board.get(4) == 0 && board.get(7) == 0) ||
                (board.get(2) == 0 && board.get(5) == 0 && board.get(8) == 0) ||
                (board.get(3) == 0 && board.get(6) == 0 && board.get(9) == 0)) {

            toMove.setText("PLAYER 0 WON!");
            System.out.println("PLAYER 0 WON");
            reset();
            player = -1;
        }
        if (board.get(1) != -1 && board.get(2) != -1 && board.get(3) != -1 &&
                board.get(4) != -1 && board.get(5) != -1 && board.get(6) != -1 &&
                board.get(7) != -1 && board.get(8) != -1 && board.get(9) != -1 &&
                board.get(1) != -1 && board.get(5) != -1 && board.get(9) != -1 &&
                board.get(3) != -1 && board.get(5) != -1 && board.get(7) != -1 &&
                board.get(1) != -1 && board.get(4) != -1 && board.get(7) != -1 &&
                board.get(2) != -1 && board.get(5) != -1 && board.get(8) != -1 &&
                board.get(3) != -1 && board.get(6) != -1 && board.get(9) != -1) {
            toMove.setText("IT'S A DRAW!");
            System.out.println("NON WON");
            reset();
            player = -1;
        }

    }

    void reset() {
        //cleaning the board
        board.put(1, -1);
        board.put(2, -1);
        board.put(3, -1);
        board.put(4, -1);
        board.put(5, -1);
        board.put(6, -1);
        board.put(7, -1);
        board.put(8, -1);
        board.put(9, -1);
        for (JButton jb :
                buttons) {
            jb.setText("");
            jb.setEnabled(true);
        }
        toMove.setBounds(240, 440, 350, 120);
        restart.setEnabled(true);
        restart.setVisible(true);


    }

    public static void main(String[] args) {
        XAndZero game = new XAndZero();
    }

}