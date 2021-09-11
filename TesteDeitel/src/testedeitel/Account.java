package testedeitel;

import javax.swing.JOptionPane;

public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        if(this.balance>0.0) this.balance=balance;
    }
    
    public void displayAccount(Account name){
        String message = String.format("Nome: %s", this.getName());
        JOptionPane.showMessageDialog(null, message);
        //System.out.println("Nome >> "+ this.getName());
        message = String.format("Saldo: %.2f", this.getBalance());
        JOptionPane.showMessageDialog(null, message);
        //System.out.printf("Saldo >> %.2f\n\n", this.getBalance());
    }
    public void deposit(double depositAmount){
        if(depositAmount > 0.0){
            this.balance=this.balance+depositAmount;
        }
    }

    public double getBalance() {
        return balance;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
