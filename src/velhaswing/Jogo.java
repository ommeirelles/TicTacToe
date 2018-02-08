package velhaswing;

/**
 * Alunos
 * Leonardo Pangaio
 * Lucas Amiune
 * Data da Criação 27/09/2014
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Jogo implements ActionListener {
    /*Combinações de vitória */
    /*private int[][] winCombinations = new int[][] {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, //linha
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, //coluna 
            {1, 5, 9}, {3, 5, 7}             //vertical wins
    }; */
    private JFrame window = new JFrame("Super Jogo da Velha");
    private JButton buttons[] = new JButton[10];
    private int count = 0;
    private String letter = "";
    private int vez;
    private boolean win = false;
    private int max =9;
    Brain leo = new Brain();


    public Jogo(){
    /*Cria o Tabuleiro*/
    window.setPreferredSize(new Dimension(300,300));
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new GridLayout(3,3));
    

    /*Adiciona as casas no tabuleiro*/
    for(int i = 1; i<=9; i++){
        buttons[i] = new JButton();
        window.add(buttons[i]);
        buttons[i].addActionListener(this);
    }
    
    /*Rever
    Perguntar quem começa*/
    vez =  JOptionPane.showConfirmDialog(null, "Deseja começar jogando?");
    if (vez == JOptionPane.NO_OPTION) {
        max = 11;
        count++;
        AI();
    } else {
        max = 9;
    } 
    
    /*Exibe o Tabuleito*/
    window.setVisible(true);
    window.pack();
    }

    public void actionPerformed(ActionEvent a) {
        /*
        Escreve a marca do jogador, e desabilita o botão
        Assim evita que seja escolhido por outro jogador.
        Já evita a validação.
        */ 
        for(int i = 1; i<= 9; i++){
            if(a.getSource() == buttons[i]){
                buttons[i].setText("X");
                buttons[i].setEnabled(false);
            }
        }
        count++;
        AI();
    }

    public void AI(){
        count++;
        if(buttons[1].getText().equals("O") && 
buttons[2].getText().equals("O") && buttons[3].getText().equals("")){
            buttons[3].setText("O");
            buttons[3].setEnabled(false);
        } else if(buttons[4].getText().equals("O") && 
buttons[5].getText().equals("O") && buttons[6].getText().equals("")){
            buttons[6].setText("O");
            buttons[6].setEnabled(false);
        } else if(buttons[7].getText().equals("O") && 
buttons[8].getText().equals("O") && buttons[9].getText().equals("")){
            buttons[9].setText("O");
            buttons[9].setEnabled(false);
        }

        else if(buttons[2].getText().equals("O") && 
buttons[3].getText().equals("O") && buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        } else if(buttons[5].getText().equals("O") && 
buttons[6].getText().equals("O") && buttons[4].getText().equals("")){
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        } else if(buttons[8].getText().equals("O") && 
buttons[9].getText().equals("O") && buttons[7].getText().equals("")){
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        }

        else if(buttons[1].getText().equals("O") && 
buttons[3].getText().equals("O") && buttons[2].getText().equals("")){
            buttons[2].setText("O");
            buttons[2].setEnabled(false);
        } else if(buttons[4].getText().equals("O") && 
buttons[6].getText().equals("O") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        } else if(buttons[7].getText().equals("O") && 
buttons[9].getText().equals("O") && buttons[8].getText().equals("")){
            buttons[8].setText("O");
            buttons[8].setEnabled(false);
        }

        else if(buttons[1].getText().equals("O") && 
buttons[4].getText().equals("O") && buttons[7].getText().equals("")){
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        } else if(buttons[2].getText().equals("O") && 
buttons[5].getText().equals("O") && buttons[8].getText().equals("")){
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        } else if(buttons[3].getText().equals("O") && 
buttons[6].getText().equals("O") && buttons[9].getText().equals("")){
            buttons[9].setText("O");
            buttons[9].setEnabled(false);
        }

        else if(buttons[4].getText().equals("O") && 
buttons[7].getText().equals("O") && buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        } else if(buttons[5].getText().equals("O") && 
buttons[8].getText().equals("O") && buttons[2].getText().equals("")){
            buttons[2].setText("O");
            buttons[2].setEnabled(false);
        } else if(buttons[6].getText().equals("O") && 
buttons[9].getText().equals("O") && buttons[3].getText().equals("")){
            buttons[3].setText("O");
            buttons[3].setEnabled(false);
        }

        else if(buttons[1].getText().equals("O") && 
buttons[7].getText().equals("O") && buttons[4].getText().equals("")){
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        } else if(buttons[2].getText().equals("O") && 
buttons[8].getText().equals("O") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        } else if(buttons[3].getText().equals("O") && 
buttons[9].getText().equals("O") && buttons[6].getText().equals("")){
            buttons[6].setText("O");
            buttons[6].setEnabled(false);
        }

        else if(buttons[1].getText().equals("O") && 
buttons[5].getText().equals("O") && buttons[9].getText().equals("")){
            buttons[9].setText("O");
            buttons[9].setEnabled(false);
        } else if(buttons[5].getText().equals("O") && 
buttons[9].getText().equals("O") && buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        } else if(buttons[1].getText().equals("O") && 
buttons[9].getText().equals("O") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        }

        else if(buttons[3].getText().equals("O") && 
buttons[5].getText().equals("O") && buttons[7].getText().equals("")){
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        } else if(buttons[7].getText().equals("O") && 
buttons[5].getText().equals("O") && buttons[3].getText().equals("")){
            buttons[3].setText("O");
            buttons[3].setEnabled(false);
        } else if(buttons[7].getText().equals("O") && 
buttons[3].getText().equals("O") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        }

        else if(buttons[1].getText().equals("X") && 
buttons[2].getText().equals("X") && buttons[3].getText().equals("")){
            buttons[3].setText("O");
            buttons[3].setEnabled(false);
        } else if(buttons[4].getText().equals("X") && 
buttons[5].getText().equals("X") && buttons[6].getText().equals("")){
            buttons[6].setText("O");
            buttons[6].setEnabled(false);
        } else if(buttons[7].getText().equals("X") && 
buttons[8].getText().equals("X") && buttons[9].getText().equals("")){
            buttons[9].setText("O");
            buttons[9].setEnabled(false);
        }

        else if(buttons[2].getText().equals("X") && 
buttons[3].getText().equals("X") && buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        } else if(buttons[5].getText().equals("X") && 
buttons[6].getText().equals("X") && buttons[4].getText().equals("")){
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        } else if(buttons[8].getText().equals("X") && 
buttons[9].getText().equals("X") && buttons[7].getText().equals("")){
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        }

        else if(buttons[1].getText().equals("X") && 
buttons[3].getText().equals("X") && buttons[2].getText().equals("")){
            buttons[2].setText("O");
            buttons[2].setEnabled(false);
        } else if(buttons[4].getText().equals("X") && 
buttons[6].getText().equals("X") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        } else if(buttons[7].getText().equals("X") && 
buttons[9].getText().equals("X") && buttons[8].getText().equals("")){
            buttons[8].setText("O");
            buttons[8].setEnabled(false);
        }

        else if(buttons[1].getText().equals("X") && 
buttons[4].getText().equals("X") && buttons[7].getText().equals("")){
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        } else if(buttons[2].getText().equals("X") && 
buttons[5].getText().equals("X") && buttons[8].getText().equals("")){
            buttons[8].setText("O");
            buttons[8].setEnabled(false);
        } else if(buttons[3].getText().equals("X") && 
buttons[6].getText().equals("X") && buttons[9].getText().equals("")){
            buttons[9].setText("O");
            buttons[9].setEnabled(false);
        }

        else if(buttons[4].getText().equals("X") && 
buttons[7].getText().equals("X") && buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        } else if(buttons[5].getText().equals("X") && 
buttons[8].getText().equals("X") && buttons[2].getText().equals("")){
            buttons[2].setText("O");
            buttons[2].setEnabled(false);
        } else if(buttons[6].getText().equals("X") && 
buttons[9].getText().equals("X") && buttons[3].getText().equals("")){
            buttons[3].setText("O");
            buttons[3].setEnabled(false);
        }

        else if(buttons[1].getText().equals("X") && 
buttons[7].getText().equals("X") && buttons[4].getText().equals("")){
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        } else if(buttons[2].getText().equals("X") && 
buttons[8].getText().equals("X") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        } else if(buttons[3].getText().equals("X") && 
buttons[9].getText().equals("X") && buttons[6].getText().equals("")){
            buttons[6].setText("O");
            buttons[6].setEnabled(false);
        }

        else if(buttons[1].getText().equals("X") && 
buttons[5].getText().equals("X") && buttons[9].getText().equals("")){
            buttons[9].setText("O");
            buttons[9].setEnabled(false);
        } else if(buttons[5].getText().equals("X") && 
buttons[9].getText().equals("X") && buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        } else if(buttons[1].getText().equals("X") && 
buttons[9].getText().equals("X") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        }

        else if(buttons[3].getText().equals("X") && 
buttons[5].getText().equals("X") && buttons[7].getText().equals("")){
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        } else if(buttons[7].getText().equals("X") && 
buttons[5].getText().equals("X") && buttons[3].getText().equals("")){
            buttons[3].setText("O");
            buttons[3].setEnabled(false);
        } else if(buttons[7].getText().equals("X") && 
buttons[3].getText().equals("X") && buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        }

        else if(buttons[1].getText().equals("X") && 
buttons[5].getText().equals("O") && buttons[9].getText().equals("X")) {
            buttons[6].setText("O");
            buttons[6].setEnabled(false);
        }

        else if(buttons[3].getText().equals("X") && 
buttons[5].getText().equals("O") && buttons[7].getText().equals("X")) {
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        }

        else if(buttons[5].getText().equals("")){
            buttons[5].setText("O");
            buttons[5].setEnabled(false);
        }

        else if(buttons[1].getText().equals("")){
            buttons[1].setText("O");
            buttons[1].setEnabled(false);
        }
        else {
            if(count >= max)
                verificarVitoria();
            else
                jogarAleatorio();
        }

        verificarVitoria();

    }

    public void jogarAleatorio(){
        Random x = new Random();
        int y = 1 + x.nextInt(9);
        if(buttons[y].getText().equals("O") || buttons[y].getText().equals("X") ){
            jogarAleatorio();
        } else {
            buttons[y].setText("O");
            buttons[y].setEnabled(false);
        }
    }

    public void verificarVitoria(){
        for(int i=0; i<=7; i++){
            if( 
buttons[leo.winCombinations[i][0]].getText().equals(buttons[leo.winCombinations[i][1]].getText()) 
&&
buttons[leo.winCombinations[i][1]].getText().equals(buttons[leo.winCombinations[i][2]].getText()) 
&&
!buttons[leo.winCombinations[i][0]].getText().equals("")) {
                win = true;
            }
        }

        if(count % 2 == 0)
            letter = "O";
        else
            letter = "X";

        /*Show a dialog when game is over*/
        if(win == true){
            if (letter == "X"){
            JOptionPane.showMessageDialog(null," Parabéns você venceu!");
            System.exit(0);
            }
            if (letter == "O"){
            JOptionPane.showMessageDialog(null,"O computador venceu!");
            System.exit(0);
            }    
        } else if(count >= 9 && win == false){
            JOptionPane.showMessageDialog(null, "Esse jogo foi empate!");
            System.exit(0);
        }
    }
}
