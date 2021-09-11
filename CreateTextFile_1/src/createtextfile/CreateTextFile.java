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
        System.out.print("Escreva: ");String msg=input.nextLine();
        try{
            output.format("%s", msg);
            System.out.println("Escrita com sucesso!");
        }catch (FormatterClosedException formattercloseexception){
            System.out.println("Erro writing to file. Terminatting.");
        }catch (NoSuchElementException elementException){
            System.out.println("Invalid input. Terminatting.");
            input.nextLine(); //descarta entrada paa o usuario tentar de novo
        } 
    }    
    
    
    //fecha o arquivo
    public static void closeFile(){
        if(output != null) output.close();
    }
}
