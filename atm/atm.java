import java.util.*;

class catm {
    private double availible = 10000;
    private double withdraw;
    private double balance;
//    private double accountNo;
//    private int password;

    public catm() {
        System.out.println("well come to atm");
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your acount number");
//        accountNo = sc.nextInt();
//        System.out.println("Enter your password");
//        password = sc.nextInt();

    }
    public void setWithdrawAmt(double x) {
        this.withdraw = x;
    }
    public double getWithdraw() {
        return withdraw;
    }

    public boolean authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your account number");
        int uaccno = sc.nextInt();
        int accno = 123455;
        if (uaccno == accno) {
            System.out.println("enter your 4 digit password");
            int password = sc.nextInt();
            int ogPass = 1244;
            if (password == ogPass) {
                System.out.println("welcome user");
                return true;
            } else
                System.out.println("wrong password");
        } else
            System.out.println("wrong account number");
        return false;
    }
    // this initiates the withdrawal process
    public void withdrawal() {
        if (withdraw < availible) {         // checks if the amount to be withdrawed is availible or not
            System.out.println("your amount is withdrawed");
            availible = availible - withdraw;
            System.out.println("your remaning balance is : "+availible);
            System.out.println("collect your cash and remove your card");

        } else if (withdraw >availible){
            System.out.println("you have shortage of funds to withdraw");
            System.out.println("jaa ke kaam kar!");
        }
    }

    public void addBalance(double x) {
        availible = availible + x;
        System.out.println("amount is adding....");
        System.out.println("your total balance is : "+availible);
    }

    public void checkBalance() {
        System.out.println(" your availible balance is : " + availible);
    }
}


public class atm {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        catm per1 = new catm();
        if(per1.authenticate()) {
//            String work = sc.next();
            while (true) {
            System.out.println("Enter 'w' for withdrawal and enter 'd' for deposit, 'c' for checking balance");
            char option = sc.next().charAt(0);
                if (option == 'w') {
                    System.out.println("Enter the amount for withdrawal");
                    double amount = sc.nextDouble();
                    per1.setWithdrawAmt(amount);
                    per1.withdrawal();
                } else if (option == 'd') {
                    System.out.println("Enter the amount to be added");
                    double cash = sc.nextDouble();
                    per1.addBalance(cash);
                        } else if (option == 'c') {     //123455
                        Thread.sleep(1000);
                    per1.checkBalance();
                }
                System.out.println("do you want to exit ");
                String work = sc.next();
                if(work.equalsIgnoreCase("exit") || work.equalsIgnoreCase("y")) {
                    break;
                }
                /*
                you could even use the hashset or hashmap to store password and accno
                 */
            }
        }
    }
}