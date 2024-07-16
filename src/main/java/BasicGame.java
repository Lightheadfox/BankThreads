import java.util.Scanner;

public class BasicGame {

    private static int myMoney = 0;

    private static int amount = 0;

    private static boolean exit = false;

    public static void main(String[] args) {

        while(!exit){

            Scanner scan = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("\n 1 - Deposit money" +
                    "\n 2 - Withdraw money" +
                    "\n 3 - Transfer money" +
                    "\n 4 - Show balance" +
                    "\n 5 - Exit");
            int choise;
            choise = scan.nextInt();

            switch(choise){
                case 1:
                    amountOperation();
                    moneyDeposit(amount);
                    break;
                case 2:
                    amountOperation();
                    moneyWithdraw(amount);
                    break;
                case 3:
                    amountOperation();
                    moneyTransfer(amount);
                    break;
                case 4:
                    showBalance();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong number entered");
                    break;

            }
            //scan.close();
        }

    }

    private static void amountOperation(){

        System.out.println("How much?");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();
        //scanner.close();

    }
    private static int moneyDeposit(int money){
        myMoney = myMoney + money;
        return myMoney;
    }

    private static int moneyWithdraw(int money){

        if(myMoney > 0){
            if((myMoney - money) >= 0){
                myMoney = myMoney - money;
                System.out.println("You have withdrawn: " + money);
                System.out.println("Your balance is: " + myMoney);

            } else {
                System.out.println("Not enough to withdraw");
            }
        } else {
            System.out.println("Not enough to withdraw");
        }

        return myMoney;
    }

    private static int moneyTransfer(int money){

        if(myMoney > 0){
            if((myMoney - money) >= 0){
                myMoney = myMoney - money;
                System.out.println("You have transferred: " + money);
                System.out.println("Your balance is: " + myMoney);
            } else {
                System.out.println("Not enough to withdraw");
            }
        } else {
            System.out.println("Not enough to transfer");
        }

        return myMoney;
    }

    private static void showBalance(){
        System.out.println("Your balance is: " + myMoney);
    }

}
