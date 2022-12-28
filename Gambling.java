import java.util.Random;
import java.util.Scanner;

public class Gambling {
    static final int WON = 1;
    static final int LOST = 0;
    static  int totalAmountDiff = 0;

    public static void main(String[] args) {
        Random r = new Random();
        int maximumWon[] = new int[100];
        int maximumLost[] = new int[100];
        Scanner sc = new Scanner(System.in);
        int totalAmount = 0;
        int daysWon = 0;
        int daysLost = 0;
        int month = 1;

        boolean flag = true;
        while (flag) {
            System.out.println("Gambling starts for month "+month);
            System.out.println("Enter Stake Amount");
            int stakeAmount = sc.nextInt();
            System.out.println("Stake Amount of Gambler is : "+stakeAmount);

            System.out.println("Enter the bet amount : ");
            int betAmount = sc.nextInt();

            for (int i = 1; i <= 20; i++) {
                int cashInHand = stakeAmount;

                while (cashInHand > stakeAmount / 2 && cashInHand < stakeAmount * 1.5) {
                    int play = r.nextInt(2);
                    System.out.println("Gamblers Play " + play);
                    switch (play) {
                        case WON:
                            cashInHand = cashInHand + betAmount;
                            System.out.println("Total cash gambler has is " + cashInHand);
                            break;

                        case LOST:
                            cashInHand = cashInHand - betAmount;
                            System.out.println("Total cash in hand after loosing :" + cashInHand);
                            break;
                    }
                }
                if (cashInHand == (stakeAmount / 2) || cashInHand == (stakeAmount * 1.5)) {
                    System.out.println("Player resigns for the day" +i);
                }
                if (cashInHand > stakeAmount) {
                    int amountWon = cashInHand - stakeAmount;
                    System.out.println("Gambler Won :" + amountWon);
                } else if (cashInHand < stakeAmount) {
                    int amountLost = stakeAmount - cashInHand;
                    System.out.println("Gambler lost " + amountLost);
                }
                if (cashInHand == stakeAmount * 1.5) {
                    maximumWon[i] = cashInHand;
                } else if (cashInHand == 50) {
                    maximumLost[i] = cashInHand;
                }
                totalAmount = totalAmount + cashInHand;
            }


            System.out.println("Luckiest day for gambler is :");
            for (int i = 1; i < 20; i++) {
                if (maximumWon[i] == stakeAmount * 1.5) {
                    System.out.println("Day" + i + " Won" + maximumWon[i]);
                    daysWon++;
                }
            }
            System.out.println("Unluckiest Day for Gambler is : ");
            for (int i = 1; i < 20; i++){
                if (maximumLost[i] == stakeAmount / 2) {
                    System.out.println("Day "+i+" lost "+maximumLost[i]);
                    daysLost++;
                }
            }
            System.out.println("Total days lost are " +daysLost);
            System.out.println("Totaldays won are " +daysWon);
            System.out.println("Total amount Won by Gambler is : "+totalAmount);
            System.out.println();

            totalAmountDiff = totalAmount - stakeAmount * 20;
            if(totalAmountDiff < 0 ){
                System.out.println("Gambler lost :"+totalAmountDiff+"$");
            }
            else{
                System.out.println("Gambler won "+totalAmountDiff+"$");
            }
            System.out.println("Toatal amount difference after a months is "+totalAmountDiff);

            System.out.println("Do you wish to continue ");
            System.out.println();
            System.out.println("If you wish to continue press 1 \n If you wish to exit press 2");
            int Y = sc.nextInt();
            if (Y == 1) {
                flag = true;
                month++;
            } else {
                flag = false;
                System.out.println("Game Exit !! ");
            }



        }
    }
}





