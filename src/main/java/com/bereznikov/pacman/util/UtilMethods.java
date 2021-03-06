package com.bereznikov.pacman.util;

public class UtilMethods {
    public static void changeSymbols() {

        short[] s = {
                19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
                21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                21, 0, 0, 0, 17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,
                17, 18, 18, 18, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 20,
                17, 16, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 16, 24, 20,
                25, 16, 16, 16, 24, 24, 28, 0, 25, 24, 24, 16, 20, 0, 21,
                1, 17, 16, 20, 0, 0, 0, 0, 0, 0, 0, 17, 20, 0, 21,
                1, 17, 16, 16, 18, 18, 22, 0, 19, 18, 18, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 21,
                1, 25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
                9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 25, 24, 24, 24, 28
        };

        for (int i = 0; i < s.length; i++) {
            if(i % 15 == 0) {
                System.out.println();
            }
            if (s[i] == 16) {
                s[i] = 0;
            } else if(s[i] > 16) {
                s[i] = (short) (s[i] - 16);
            }
            System.out.print(s[i] + ", ");
        }
    }

    public static void findIndexes() {

        short[] s = {
                3, 10, 10, 10, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 6,
                5, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                5, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                5, 0, 0, 0, 1, 0, 0, 8, 0, 0, 0, 0, 0, 0, 4,
                1, 2, 2, 2, 0, 0, 4, 0, 1, 0, 0, 0, 0, 0, 4,
                9, 0, 0, 0, 0, 0, 4, 0, 1, 0, 0, 0, 0, 8, 4,
                1, 1, 3, 1, 8, 8, 12, 0, 9, 8, 8, 0, 4, 0, 5,
                1, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, 5,
                1, 1, 1, 1, 2, 2, 6, 0, 3, 2, 2, 0, 4, 0, 5,
                1, 1, 1, 1, 0, 0, 4, 0, 1, 0, 0, 0, 4, 0, 5,
                1, 1, 1, 1, 0, 0, 4, 0, 1, 0, 0, 0, 4, 0, 5,
                1, 1, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 4, 0, 5,
                1, 1, 18, 1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 5,
                1, 10, 11, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 2, 4,
                9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 8, 8, 8, 12
        };

        for (int i = 1; i < s.length + 1; i++) {
            if((i-1) % 15 == 0) {
                System.out.println();
            }

            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        changeSymbols();
    }
}
