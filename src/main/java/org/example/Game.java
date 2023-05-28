package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {
    int num_mines;
    int n = 3, m = 3;
    String[][] Field = new String[n + 2][m+2];
    String[][] Field1 = new String[n][m];
    public boolean Gamestr() throws InterruptedException {
        Random random = new Random();
        boolean finish = false,victory = false;
        Main.TextOutput("                " + "количество верных точек: 6",false);
        Scanner in = new Scanner(System.in);
        num_mines = 6;
        prepare();
        while (!finish) {
            Main.TextOutput("                " + "Введите номер строки N и столбца M:",true);
            Main.TextOutput("                " + "N=",false);
            int N,M;
            for(;;) {
                N = in.nextInt();
                if (N<=3&N>0){
                    break;
                }else {
                    Main.TextOutput("                " + Main.MassErrors[random.nextInt(0, Main.MassErrors.length)]+"\t                ",true);
                }
            }
            Main.TextOutput("                " + "M=",false);
            for(;;) {
                M = in.nextInt();
                if (M<=3&M>0){
                    break;
                }else {
                    Main.TextOutput("                " + Main.MassErrors[random.nextInt(0, Main.MassErrors.length)]+"\t                ",true);
                }
            }
            int rez = readCell(N, M);
            finish = true;
            if (rez == 1) {
                Main.TextOutput("                " + "Вы ПОБЕДИЛИ",true);
                victory=true;
            } else {
                Main.TextOutput("                " + "Вы проиграли!",true);
            }
        }
        return victory;
    }
    public void prepare() throws InterruptedException {
        int n_mine, m_mine, mine_counter;
        for (int i = 0; i < n + 2; ++i) {
            for (int j = 0; j < m + 2; ++j){
                Field[i][j] = "0";
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j){
                Field1[i][j] = "0";
            }
        }
        while (num_mines > 0) {
            n_mine = 1 + (int) (Math.random() * ((4-1)));
            m_mine = 1 + (int) (Math.random() * ((4-1)));
            if (!"M".equals(Field[n_mine][m_mine])) {
                Field[n_mine][m_mine] = "M";
                num_mines--;
            }
        }
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if (Field[i][j].equals("M")) {
                    continue;
                }
                mine_counter = 0;
                if (Field[i][j-1].equals("M")) mine_counter++;
                if (Field[i][j+1].equals("M")) mine_counter++;
                if (Field[i-1][j].equals("M")) mine_counter++;
                if (Field[i+1][j].equals("M")) mine_counter++;
                if (Field[i-1][j-1].equals("M")) mine_counter++;
                if (Field[i-1][j+1].equals("M")) mine_counter++;
                if (Field[i+1][j-1].equals("M")) mine_counter++;
                if (Field[i+1][j+1].equals("M")) mine_counter++;

                Field[i][j] = "" + mine_counter;
            }
        }
        System.out.println();
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                Main.TextOutput("                " + "? ",false);
            }
            System.out.println();
        }

    }
    public int readCell(int N, int M) throws InterruptedException {
        int rez;
        if ((Field[N][M]).equals("M")) rez = 1;
        else rez = 0;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if ((i == N) && (j == M)) {
                    Main.TextOutput("                " + Field[i][j] + " ",false);

                }
                else Main.TextOutput("                " + "? ",false);

            }
            System.out.println();
        }
        return rez;
    }
}