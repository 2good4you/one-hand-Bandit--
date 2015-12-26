package roulette1;

import java.util.Random;
import java.util.Scanner;

public class roulette {
    public static void createBar(String drum[]) {
        for (int i = 0; i < 25; i++) {
            if (i < 1) {
                drum[i] = "BAR";
            }
            if (i >= 1 && i < 3) {
                drum[i] = "777";
            }
            if (i >= 3 && i < 7) {
                drum[i] = "Peach";
            }
            if (i >= 7 && i < 12) {
                drum[i] = "Pear";
            }
            if (i >= 12 && i < 18) {
                drum[i] = "Cherry";
            }
            if (i >= 18 && i < 25) {
                drum[i] = "Lemon";
            }
        }
    }

    public static int painIn() {
        int value = 0;

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            value = sc.nextInt();
        } else {
            System.out.println("Your currency is not adopted by");
        }
        return value;

    }

    public  static int win(int balance,int matches, String slot) {
        int a = 0;
        if ( slot == "BAR" ) {
            a = 1;
        } else if ( slot == "777" ) {
            a = 2;
        } else if ( slot == "Peach" ) {
            a = 3;
        } else if ( slot == "Pear" ) {
            a = 4;
        } else if ( slot == "Cherry" ) {
            a = 5;
        } else if ( slot == "Lemon" ) {
            a = 6;
        }

         switch ( a ) {
            case 1:
//                System.out.println("==========u win " + balance*matches*6/2 + " coins!==========");
                return balance*matches*6/2;
            case 2:
//                System.out.println("==========u win " + balance*matches*6/2 + " coins!==========");
                return balance*matches*6/4;
            case 3:
//                System.out.println("==========u win " + balance*matches*6/2 + " coins!==========");
                return balance*matches*6/8;
            case 4:
//                System.out.println("==========u win " + balance*matches*6/2 + " coins!==========");
                return balance*matches*6/10;
            case 5:
//                System.out.println("==========u win " + balance*matches*6/2 + " coins!==========");
                return balance*matches*6/12;
            case 6:
//                System.out.println("==========u win " + balance*matches*6/2 + " coins!==========");
                return balance*matches*6/14;
            default:
        }

        return balance;
    }


    public static void main(String[] args) {
        int balance = painIn();
        int totalGames = balance/3;
        int rent = balance % 3;
        String drum[] = new String[25];
        int bonus = 0;

        createBar(drum);

        for ( int i = 0; i < totalGames; i ++ ) {
            Random rand = new Random();
            String firstDrum = drum[rand.nextInt(25)];
            String secondDrum = drum[rand.nextInt(25)];
            String thirdDrum = drum[rand.nextInt(25)];

            System.out.println(firstDrum + " " + secondDrum + " " + thirdDrum);

            if ( firstDrum == secondDrum && firstDrum == thirdDrum ) {
                bonus += win(balance,3, firstDrum);
                System.out.println(bonus);
            } else if ( firstDrum == secondDrum || firstDrum == thirdDrum ) {
                bonus += win(balance,2, firstDrum);
                System.out.println(bonus);
            } else if ( secondDrum == thirdDrum ) {
                bonus += win(balance,2, secondDrum);
                System.out.println(bonus);
            } else;

        }

    }
}

