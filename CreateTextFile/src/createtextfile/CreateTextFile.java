package createtextfile;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    
    private static Formatter output; //envia uma saida de texto para um arquivo
    
    public static void main(String[] args) throws FileNotFoundException {
        openFile();
        addRecords();
        closeFile();
    }
    
    //abre o arquivo clients.txt
    public static void openFile() throws FileNotFoundException{
        try{
            output = new Formatter("clients.txt");//abre o arquivo
        }catch (SecurityException securityException){
            System.err.println("Write permission denied. Terminatting.");
            System.exit(1);//termina o programa
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening file. Terminatting.");
            System.exit(1);//termina o programa
        }
    }
    
    //adiciona registro ao arquivo
    public static void addRecords(){
        Scanner input = new Scanner(System.in);
        //System.out.printf("%s%n%s%n?","Enter account number, first name, last name and balance.","Enter end-of-file indicator to end input");
        System.out.print("Escreva: ");String msg=input.nextLine();
        
        while(input.hasNext())//faz um loop até o indicador de fim de arquivo
        {
            try{
                //gera saido do novo regsto paa o arquivo, supoe entrada valida
                //output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
                output.format("%s", msg);
            }catch (FormatterClosedException formattercloseexception){
                System.out.println("Erro writing to file. Terminatting.");
                break;
            }catch (NoSuchElementException elementException){
                System.out.println("Invalid input. Terminatting.");
                input.nextLine(); //descarta entrada paa o usuario tentar de novo
            } 
            System.out.println("? ");
        }    
    }
    
    //fecha o arquivo
    public static void closeFile(){
        if(output != null) output.close();
    }
}
