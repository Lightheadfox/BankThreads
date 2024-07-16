import java.util.Scanner;


public class ConcurrentGame {

    private static int myMoney = 0;

    private static int amount = 0;


    private static boolean exit = false;

    public static void main(String[] args) {

        while (!exit) {

            // Creating operations service object
            OperaionsService operations = new OperaionsService();
            // Opening Threads for operations


//            Thread depositThread = new Thread();
//            Thread withdrawThread = new Thread();
//            Thread transferThread = new Thread();
//            Thread balanceThread = new Thread();


            Scanner scan = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("\n 1 - Deposit money" +
                    "\n 2 - Withdraw money" +
                    "\n 3 - Transfer money" +
                    "\n 4 - Show balance" +
                    "\n 5 - Exit");
            int choise;
            choise = scan.nextInt();

            switch (choise) {
                case 1:
                    operations.amountOperation();
                    operations.moneyDeposit(amount);
                    break;
                case 2:
                    operations.amountOperation();
                    operations.moneyWithdraw(amount);
                    break;
                case 3:
                    operations.amountOperation();
                    operations.moneyTransfer(amount);
                    break;
                case 4:
                    operations.showBalance();
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

    static class OperaionsService {
        public  void amountOperation() {
            synchronized (this) {
                System.out.println("How much?");
                Scanner scanner = new Scanner(System.in);
                amount = scanner.nextInt();

                //scanner.close();
            }
        }

        public int moneyDeposit(int money) {
            synchronized (this) {
                myMoney = myMoney + money;
                return myMoney;
            }
        }

        public int moneyWithdraw(int money) {
            synchronized (this) {

                if (myMoney > 0) {
                    if ((myMoney - money) >= 0) {
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
        }

        public int moneyTransfer(int money) {
            synchronized (this) {
                if (myMoney > 0) {
                    if ((myMoney - money) >= 0) {
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
        }
        public void showBalance() {
            synchronized(this) {
                System.out.println("Your balance is: " + myMoney);
            }
        }

    }
}