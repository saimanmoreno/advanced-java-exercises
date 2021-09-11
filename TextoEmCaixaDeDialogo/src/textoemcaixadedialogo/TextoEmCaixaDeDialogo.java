package textoemcaixadedialogo;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TextoEmCaixaDeDialogo {
    public static void main(String[] args) {
        
        //Scanner ler = new Scanner(System.in);
        String name = JOptionPane.showInputDialog("Qual o seu nome?");
        String messagem = String.format("Bemvindo %s, ao apreender Java!", name);
        JOptionPane.showMessageDialog(null, messagem);
        //JOptionPane.showMessageDialog(null, "Welcome to Java");
        //JOptionPane.showConfirmDialog(null, "Confirmar?");
    }
    
}
