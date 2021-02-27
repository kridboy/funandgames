package com.keisse.test;

public class Numbers {

    public static void main(String[] args) {
        new Numbers().run();
    }

    public void run() {
        //one two three four five six seven eight nine
        //               0,1,2,3,4,5,6,7,8
        int[] singles = {3, 3, 5, 4, 4, 3, 5, 5, 4};

        //ten,eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen
        int[] tenner = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};

        //ten twenty thirty forty fifty sixty seventy eighty ninety
        //             0,1,2,3,4,5,6,7,8
        int[] tens = {3, 6, 6, 5, 5, 5, 7, 6, 6};

        ///and,hundred,thousand
        //             0,1,2
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
