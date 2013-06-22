/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

/**
 *
 * @author Admin
 */
public class BankBean {

    int id;
    String name;
    float balance;
    
    public BankBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
