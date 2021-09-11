/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataencoding;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author pc
 */
public class DataEncoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        String input = "";
        int[] bits = new int[12];
        
        do{
            System.out.print("==============Codificacao de Dados===============\n"
                    + "1 - Binario\\AMI\n"
                    + "2 - NRZ-L\n"
                    + "3 - NRZ-I\n"
                    + "0 - Sair\n>>"); opcao = scan.nextInt();
                    
            switch(opcao){
                case 1:
                    limparTela();
                    System.out.println("=============AMI===============");
                    System.out.print("Introduza os bits(maximo 12). Separar por - :"); input = scan.nextLine();
                    StringTokenizer tokens = new StringTokenizer(input, "-");
                    
                    int i = 0;
                    
                    while(tokens.hasMoreTokens()){
                       bits[i] = Integer.parseInt(tokens.nextToken());
                       i++;
                    }
                    
                    for(i=0; i<bits.length; i++){
                        if(bits[i]==1 && (i==0 || bits[i-1]==0)){
                            System.out.print("|--|");
                        }else if(bits[i]==0){
                            System.out.print("__");
                        }
                    }
                    break;
                    
                case 2:
                    limparTela();
                    System.out.println("=============NRZ-L===============");
                    break;
                    
                case 3:
                    limparTela();
                    System.out.println("=============NRZ-I===============");
                    break;
                    
                default: System.out.println("Opcao Invalida!Tente Novamente.\n\n");
            }
        }while(opcao!=0);
        
    }
    
    public static void limparTela(){
        for(int i=0; i<50; i++) System.out.println("\n");
    }
    
}
