import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tictactoe extends JPanel {
    char player = 'X';
    JButton[] places = new JButton[9];

    public tictactoe() {
        setLayout(new GridLayout(3,3));
        initialiseGame();
    }

    public void initialiseGame() {
        for (int i = 0; i <= 8; i++) {
            places[i] = new JButton();
            places[i].setText("-");
            places[i].setFont(new Font("Arial", Font.BOLD, 22));
            places[i].setBackground(Color.white);
            places[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton placeClicked = (JButton) e.getSource();

                    if (player == 'X') {
                        placeClicked.setText(String.valueOf(player));
                        placeClicked.setBackground(Color.YELLOW);
                        player = 'O';
                    }
                    else if (player == 'O') {
                        placeClicked.setText(String.valueOf(player));
                        placeClicked.setBackground(Color.ORANGE);
                        player = 'X';
                    }
                }
            });
            add(places[i]);
        }
    }

    public static void main(String[] args) {
        JFrame game = new JFrame();
        game.setTitle("Tic-Tac-Toe");
        game.setBounds(400,400,400,400);
        game.setResizable(false);
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.getContentPane().add(new tictactoe());
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
