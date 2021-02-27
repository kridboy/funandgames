package com.keisse.test;

import java.util.Scanner;

public class Test {
    //Variable is made final and static because value will never change during operation of program.
    static final double WAGE_PER_MINUTE = (11.5 / 60);

    public static void main(String[] args) {
        //we use a run method in a created method to signify we are working OOP. Contents of run method can also be placed here.
        //new Test().run();

        String[] testarr0 = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] testarr1 = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen","seventeen", "eighteen", "nineteen"};
        String[] testarr2 = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};


        for (String str : testarr0) {
            System.out.printf("%d,",str.length());
        }
        System.out.println();
        for (String str : testarr1) {
            System.out.printf("%d,",str.length());
        }
        System.out.println();
        for (String str : testarr2) {
            System.out.printf("%d,",str.length());
        }
    }

    void run() {
        //open scanner in 'try-with-resources' so we do not need to call scanner.close() at the end of operation.
        try (Scanner scanner = new Scanner(System.in)) {
            String[] timestamps = askTime(scanner);
            System.out.printf("total minutes worked: %d min %n", calcWorkTimeInMinutes(timestamps));
            String day = askDay(scanner);
            System.out.printf("total money earned:€ %.2f %n", calcWorkTimeInMinutes(timestamps) * (WAGE_PER_MINUTE * returnDayRate(day)));
        }
    }

    //We create separate methods to keep code clean and readable.
    String[] askTime(Scanner scanner) {
        //this method expects a timestamp in the format of hh:mm, this could be 06:55 for example. There is no error checking!
        String[] timestamps = new String[2];
        System.out.println("Give starting time (hh:mm)");
        timestamps[0] = scanner.nextLine();

        System.out.println("Give ending time (hh:mm)");
        timestamps[1] = scanner.nextLine();
        return timestamps;
    }

    String askDay(Scanner scanner) {
        //this method expects a weekday to be given in 2 letter format as seen in switch below.
        System.out.println("Provide weekday of labour:");
        return scanner.nextLine();
    }

    double returnDayRate(String day) {
        switch (day) {
            case "ma":
            case "di":
            case "wo":
            case "do":
            case "vr":
                return 1;
            case "za":
                return 1.25;
            case "zo":
                return 1.5;
        }
        //shouldn't be reached, if it was, input was wrong
        return 0;
    }

    //This method contains most of the logic used in the program. (Calculates how many minutes were worked based on timestamps)
    int calcWorkTimeInMinutes(String[] timestamps) {
        int[] startTime = new int[2], endTime = new int[2];
        int hoursWorked = 0, minutesWorked = 0;
        //String.split(String regex) takes a string and will split it on a given target.
        // If we have a string called 'x' with the following value= "18:55", then x.split(":") will become 2 strings: "18" and "55" we save these values in an Array 'timestamp'.
        String[] timestamp = timestamps[0].split(":");
        //Integer.parseInt(String str) takes a string value and turns it into an int.
        startTime[0] = Integer.parseInt(timestamp[0]);
        startTime[1] = Integer.parseInt(timestamp[1]);

        timestamp = timestamps[1].split(":");
        endTime[0] = Integer.parseInt(timestamp[0]);
        endTime[1] = Integer.parseInt(timestamp[1]);

        if (startTime[0] > endTime[0]) {
            hoursWorked = (24 - startTime[0]) + endTime[0];
        } else {
            hoursWorked = endTime[0] - startTime[0];
        }

        if (endTime[1] < startTime[1]) {
            hoursWorked--;
            minutesWorked = (60 - startTime[1]) + endTime[1];
        } else {
            minutesWorked = endTime[1] - startTime[1];
        }
        return (hoursWorked * 60) + minutesWorked;
    }
}
