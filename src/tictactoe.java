import javax.swing.*;
import java.awt.*;

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
            places[i].addActionListener(e -> {
                JButton placeClicked = (JButton) e.getSource();

                if (isPlaceValid(placeClicked)) {
                    if (player == 'X') {
                        placeClicked.setText(String.valueOf(player));
                        placeClicked.setBackground(Color.YELLOW);
                        player = 'O';
                    } else {
                        placeClicked.setText(String.valueOf(player));
                        placeClicked.setBackground(Color.ORANGE);
                        player = 'X';
                    }
                    displayWinner();
                }
            });
            add(places[i]);
        }
    }

    public boolean isPlaceValid(JButton placeClicked) {
        return(placeClicked.getText().equals("-"));
    }

    public boolean checkRows() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (places[i].getText().equals(places[i+1].getText()) && places[i+1].getText().equals(places[i+2].getText()) && places[i].getText().charAt(0) != '-') {
                return true;
            }
            i = i + 3;
        }
        return false;
    }

    public boolean checkCols() {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (places[i].getText().equals(places[i+3].getText()) && places[i+3].getText().equals(places[i+6].getText()) && places[i].getText().charAt(0) != '-') {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean checkDiags() {
        if (places[0].getText().equals(places[4].getText()) && places[4].getText().equals(places[8].getText()) && places[0].getText().charAt(0) != '-') {
            return true;
        } else return places[2].getText().equals(places[4].getText()) && places[4].getText().equals(places[6].getText()) && places[2].getText().charAt(0) != '-';
    }

    public boolean checkDraw() {
        boolean full = true;
        for (int i = 0; i < 9; i++) {
            if (places[i].getText().charAt(0) == '-') {
                full = false;
            }
        }
        return full;
    }

    public boolean checkWinner() {
        return (checkRows() || checkCols() || checkDiags());
    }

    public void displayWinner() {


        if (checkWinner()) {
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }


            JOptionPane gameOver = new JOptionPane();
            int result = JOptionPane.showConfirmDialog(gameOver, "Game Over! " + player +  " Wins. Do you want to play again? ", "Game Over", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        }
        else if(checkDraw()) {
            JOptionPane gameOver = new JOptionPane();
            int result = JOptionPane.showConfirmDialog(gameOver, "Game Over! It's a tie! Do you want to play again? ", "Game Over", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        }
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            places[i].setText("-");
            places[i].setBackground(Color.WHITE);
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
