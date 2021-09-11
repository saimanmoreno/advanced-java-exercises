package testedeitel;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner ler = new Scanner (System.in);
        
        Account myAccount1 = new Account("Saiman Moreno", 34.90);
        myAccount1.displayAccount(myAccount1);
        System.out.print("Qto depositar? >> "); double dep = ler.nextDouble();
        System.out.println("\n\n");
        myAccount1.deposit(dep);
        myAccount1.displayAccount(myAccount1);
    }
    
}
