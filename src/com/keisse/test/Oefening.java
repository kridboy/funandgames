package com.keisse.test;

import java.util.Scanner;

public class Oefening {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Uur van start? : "); // UUR VAN START

        int startUren = keyboard.nextInt(); // INPUT

        double loonPerMinuut = 0.1916; // 11.5 gedeeld door 60 voor euro per minuut
        double loonPerUur = 11.5; //

        if (startUren <= 24) {
            System.out.println("Minuten van start? : ");
        } else {
            System.out.println("that's not valid m8 try again"); //MINUTEN VAN START
            return;
        }

        int startMinuten = keyboard.nextInt(); // INPUT

        if (startMinuten <= 60) {
            System.out.println("Ge zijt " + startUren + ':' + startMinuten + " begonnen"); // WANNEER GE BEGONNEN ZIJT ZIN
        } else {
            System.out.println("that's not valid m8 try again");
        }

        System.out.println("Uur van stopzetting? : "); // VRAAG WELK UUR GESTOPT

        int stopUren = keyboard.nextInt(); // INPUT

        if (stopUren <= 24) {
            System.out.println("Minuten van stopzetting? : ");  //VRAAG MINUTEN GESTOPT
        } else {
            System.out.println("that's not valid m8 try again");
            return;
        }
        int stopMinuten = keyboard.nextInt(); // INPUT

        System.out.println("ge zijt om " + stopUren + ":" + stopMinuten + " gestopt"); // GE ZIJT OM XTIJD GESTOPT

        int sumMin;
        int sumUur;
        int minuten = 60;

        if (stopMinuten < startMinuten) { // ALS GESTOPTE MINUTEN KLEINER ZIJN DAN STARTMINUTEN / TREK 1 VAN HET UUR AF EN DOE MINUTEN - DE SUM
            sumUur = stopUren - startUren;
            sumMin = minuten - startMinuten + stopMinuten;

            sumUur = --sumUur;

        } else if (stopMinuten > startMinuten) {
            sumMin = stopMinuten - startMinuten;
            sumUur = stopUren - startUren;

        } else {
            sumMin = 0;
            sumUur = stopUren - startUren;

        }

        System.out.println("ge hebt " + sumUur + " uur " + sumMin + " minuten gewerkt");

        int loonBerekenenUur = (int) loonPerUur * sumUur;
        int loonBrekenenMinuut = (int) loonPerMinuut * sumMin;

        System.out.println("Welke dag zijde weesten weirke pisserke? (moogt afkortingen gebruiken) : "); // VRAAG WANNEER WEESTEN WERKEN
        double ditHeeftSwsEenBetereManier = loonPerUur * sumUur;
        double sameHere = loonPerMinuut * sumMin;
        double why = ditHeeftSwsEenBetereManier + sameHere;

        String aStringhaha = keyboard.next(); // INPUT DAG VAN TE WERKEN
        boolean aBoolyyy = aStringhaha.contains("ma" + "di" + "wo" + "do" + "vr" + "za" + "zo");
        if (aBoolyyy) {  //AFKORTINGEN VOOR DAGEN VAN DE WEEK + WAT HIJ MOET DOEN ALS DIE LETTERS ERIN ZITTEN
            switch (aStringhaha) {
                case "maandag":
                case "dinsdag":
                case "woensdag":
                case "donderdagg":
                case "vrijdag":

                    break; //1.00*


                case "zaterdag":
                    why = why * 1.25;//1.25*
                    break;
                case "zondag":
                    why = why*1.5;
                    break;//1.50*
            }
        }
        System.out.println(aStringhaha + " dus normaal zou u bedrag " + why + " euro zijn");
    }
    public void run() {
        int[] singles = {3, 3, 5, 4, 4, 3, 5, 5, 4};
        int[] tenner = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
        int[] tens = {3, 6, 6, 5, 5, 5, 7, 6, 6};
        int[] other = {3, 7, 8};
        String str = "";
        String[] n;
        long sum = 0L;

        for (int i = 1; i < 1001; i++) {
            str = String.valueOf(i);
            n = str.split("");
            switch (n.length) {
                case 1:
                    sum += singles[Integer.valueOf(n[0]) - 1];
                    break;
                case 2:
                    if (i < 20) {
                        //this issue basically happens every +100 iterations so we will have to abstract this in a way it will always work, ugh :/
                        sum += tenner[Integer.valueOf(n[1])];
                    } else {
                        sum += tens[Integer.valueOf(n[0]) - 1];
                        if (!(Integer.valueOf(n[1]) == 0))
                            sum += singles[Integer.valueOf(n[1]) - 1];
                    }
                    break;

                case 3:
                    sum += singles[Integer.valueOf(n[0]) - 1];
                    if (!(Integer.valueOf(n[1]) == 0))
                        sum += tens[Integer.valueOf(n[1]) - 1];
                    if (!(Integer.valueOf(n[2]) == 0))
                        sum += singles[Integer.valueOf(n[2]) - 1];
                    sum += other[1];
                    if (!((Integer.valueOf(n[1]) == 0) && (Integer.valueOf(n[2]) == 0)))
                        sum += other[0];
                    if (i == 115)
                        System.out.println("");
                    break;

                case 4:
                    sum += other[2];
                    break;
            }
        }
        System.out.printf("total of letters used is: %d", sum);
    }
}


//        int gewerkteUren =
//        int gewerkteMinuten =
//
//        if (stopMinuten < startMinuten) {
//            gewerkteMinuten = startMinuten-stopMinuten;
////        }
//
////        if (gewerkteUren )
//
//
//
//        System.out.println("ge hebt " + gewerkteUren + ":" + gewerkteMinuten + " gewerkt");


//        if (startMinuten <= 60) {   //hier zit de fout
//
//            System.out.println("dus ge hebt in totaal " + uur + " uur " + minuut + " minuten gewerkt bro");
//
//        }
//        if (startMinuten < stopMinuten) { // hier zit de fout
//            System.out.println("dus ge hebt in totaal " + (minuut - uur) + " minuten gewerkt bro");