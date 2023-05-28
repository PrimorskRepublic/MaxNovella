package org.example;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static String[] MassErrors =new String []{
            "����������� �� ������� ����! ��� ������������ ���� � ������� 20$!",
            "׸� ����� �� ���, �� �� ���� �� ����� ���",
            "������� ����� ������� ��� ������������� ����!(�� ��������� ����� ��������)",
            "��� ����� ���� ����� ����� ����� ����������� �������� ������� ������",
            "*���� ��� �� ��������*",
            "�����",
            "��������",
            "����������, �� ������� ���� � ������� ��� ����!",
            "��������� ���� ���������. ��� ������: 228",
            "����� ���������� ������ ��������� ���������� 5$!",
            "!!!��� ��������� �� IP � �� ���� ������ ����� � ��� ��������!!!"};
    public static String[] TEXT = new String[545];
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Game game = new Game();
        File file = new File("src/main/resources/NowellText.txt");
        BufferedReader br;
        try{
            if (!file.exists()){
                TextOutput("                ����� ���� ����������\t",true);
                System.exit(1);
            }else {
                TextOutput("                ����� ���� � �������\t",true);
            }
            br = new BufferedReader(new FileReader("src/main/resources/NowellText.txt"));
            int i=0;
            while ((TEXT[i]=br.readLine())!=null) {
                i++;
            }
        }catch (IOException e ){
            System.out.println("Error "+ e);
        }
        int LoveTZ=0,LoveUZ=0;
        boolean EzMode;
        TextOutput("""
                                ������� �����
                                1 : ����
                                2 : ���
                """,true);
        for (;;){
            System.out.print("                ");
            int temp=scanner.nextInt();
            if(temp==1){
                TextOutput("                ������� ����� ��������\t",true);
                EzMode=false;
                break;
            }
            else if(temp==2){
                TextOutput("                ������� ����� �������\t",true);
                EzMode=true;
                break;
            }else {
                TextOutput("                "+ MassErrors[random.nextInt(0, MassErrors.length)],true);
            }
        }
        TextOutput_TXT("����������:");
        if (EzMode){
            TextOutput_TXT("1 ����� EzMode On");
        }else {
            TextOutput_TXT("1 ����� EzMode Off");
        }
        for(;;) {
            System.out.print("                ");
            int temp = scanner.nextInt();
            if (temp == 1) {
                TextOutput_TXT("����� 1 ������� 1 �������");
                LoveTZ++;
                break;
            } else if (temp == 2) {
                TextOutput_TXT("����� 1 ������� 2 ����������");
                System.exit(0);
            } else if (temp == 3) {
                TextOutput_TXT("����� 1 ������� 3 ���������");
                if (EzMode){
                    TextOutput_TXT("����� 2 EzMode On");
                }else {
                    TextOutput_TXT("����� 2 EzMode Off");
                }
                for(;;) {
                    System.out.print("                ");
                    int temp2 = scanner.nextInt();
                    if(temp2==1){
                        TextOutput_TXT("����� 2 ������� 1 : ����� � ������ ����������");
                        LoveUZ++;
                        break;
                    }else if (temp2==2){
                        TextOutput_TXT("����� 2 ������� 2 : ����� �����");
                        break;
                    } else if (temp2 == 3) {
                        TextOutput_TXT("����� 2 ������� 3 : ���������� �� ���� ��������");
                        if(game.Gamestr()){
                            TextOutput_TXT("����-���� ������");
                            LoveUZ++;
                            LoveTZ++;
                        }else {
                            TextOutput_TXT("����-���� ���������");
                        }
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                break;
            } else {
                TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
            }
        }
        TextOutput_TXT("������������ 1 �����");
        if(EzMode){
            TextOutput("                ������ : "+LoveTZ+"\t                ����� : "+LoveUZ,true);
        }
        //2 �����
        TextOutput_TXT("���������� 2");
        if (EzMode){
            TextOutput_TXT("3 ����� EzMode On");
        }else {
            TextOutput_TXT("3 ����� EzMode Off");
        }
        for(;;) {
            System.out.print("                ");
            int temp3 = scanner.nextInt();
            if (temp3 == 1) {
                TextOutput_TXT("3 ����� ������� 1 : ������� � ������� � ����");
                int LoveUZTMP=0;
                if (EzMode){
                    TextOutput_TXT("3.1.1 ����� EzMode On");
                }else {
                    TextOutput_TXT("3.1.1 ����� EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.1 ����� ������� 1. ����� � ����");
                        LoveUZTMP++;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.1 ����� ������� 2. �� ������");
                        LoveUZTMP--;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (LoveUZ==1){
                    TextOutput_TXT("3.1 ���� ������ ��� 1");
                }else {
                    TextOutput_TXT("3.1 ���� ������ ��� 0");
                }
                if (EzMode){
                    TextOutput_TXT("3.1.2 ����� EzMode On");
                }else {
                    TextOutput_TXT("3.1.2 ����� EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.2 ����� ������� 1. � ������ ���������, �� ���� ���� ����������.");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.2 ����� ������� 2. � ������ ����� ���, ��������� �");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (EzMode){
                    TextOutput_TXT("3.1.3 ����� EzMode On");
                }else {
                    TextOutput_TXT("3.1.3 ����� EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.3 ����� ������� 1. ����� ���� ��� ���� ������ ��� ����� � ���� ����� �����");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.3 ����� ������� 2. �������, ��� ������ ������. ����� ���������� ���������");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (EzMode){
                    TextOutput_TXT("3.1.4 ����� EzMode On");
                }else {
                    TextOutput_TXT("3.1.4 ����� EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.4 ����� ������� 1. �����, �������� �������");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.4 ����� ������� 2. �� �����, � �� ��������� ��� ����");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }

                }
                if (EzMode){
                    TextOutput_TXT("3.1.5 ����� EzMode On");
                }else {
                    TextOutput_TXT("3.1.5 ����� EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.5 ����� ������� 1. ��� �� ���� ������� ����, � ���� �� �*� ���*���� ������");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.5 ����� ������� 2. �� ���� � �� ����� ������� ��������!");
                        LoveUZTMP++;
                        break;
                    }else if(temp4==3) {
                        TextOutput_TXT("3.1.5 ����� ������� 3. ��� �� ���� ������� ����, � ���� �� ������ ������");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (LoveUZTMP<0){
                    LoveUZ--;
                } else if (LoveUZTMP>0) {
                    LoveUZ++;
                }
                if (LoveUZ==-1){
                    TextOutput_TXT("3.1 �������� ��� -1");
                    System.exit(0);
                } else if (LoveUZ==0) {
                    TextOutput_TXT("3.1 �������� ��� 0");
                    System.exit(0);
                } else if (LoveUZ==1) {
                    TextOutput_TXT("3.1 �������� ��� 1");
                    System.exit(0);
                } else if (LoveUZ==2) {
                    TextOutput_TXT("3.1 �������� ��� 2");
                    System.exit(0);
                }
                break;
            } else if (temp3 == 2) {
                TextOutput_TXT("3 ����� ������� 2 : �������� �� ������");
                if (LoveUZ == 1) {
                    TextOutput_TXT("3.2 ���� ������� ��� 1");
                } else {
                    TextOutput_TXT("3.2 ���� ������� ��� 0");
                }
                int LoveTZTMP = 0;
                if (EzMode) {
                    TextOutput_TXT("3.2.1 ����� EzMode On");
                } else {
                    TextOutput_TXT("3.2.1 ����� EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.1 ����� ������� 1. �� �� ���� ���� ����������, ������ ������� � ����");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.1 ����� ������� 2. �� ��� ����� ���� ���������, ���������� ��� �� ���");
                        LoveTZTMP++;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.2 ����� EzMode On");
                } else {
                    TextOutput_TXT("3.2.2 ����� EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.2 ����� ������� 1. �� � ������ ������ ��������, � � ���� ��� �������");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.2 ����� ������� 2. �����, ��� � ���� � ������ �� �����!");
                        LoveTZTMP++;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.3 ����� EzMode On");
                } else {
                    TextOutput_TXT("3.2.3 ����� EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.3 ����� ������� 1. ��������");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.3 ����� ������� 2. ����������");
                        break;
                    }else if (temp4 == 3) {
                        TextOutput_TXT("3.2.3 ����� ������� 3. �������� ��� ��������");
                        LoveTZTMP++;
                        break;
                    }
                    else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.4 ����� EzMode On");
                } else {
                    TextOutput_TXT("3.2.4 ����� EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.4 ����� ������� 1. � �� ���� ��� ����� ����� ������ � ����� �������� ������ ���������?");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.4 ����� ������� 2. ��� ����� ����� ��� ���� ��� ��������� � ���� ���������� �������!");
                        LoveTZTMP++;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.5 ����� EzMode On");
                } else {
                    TextOutput_TXT("3.2.5 ����� EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.5 ����� ������� 1. 1. ��, �������");
                        LoveTZTMP++;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.5 ����� ������� 2. ������, �� ���");
                        LoveTZTMP--;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (LoveTZTMP<0){
                    LoveTZ--;
                } else if (LoveTZTMP>0) {
                    LoveTZ++;
                }
                if (LoveTZ==-1){
                    TextOutput_TXT("3.2 �������� ��� -1");
                    System.exit(0);
                } else if (LoveTZ==0) {
                    TextOutput_TXT("3.2 �������� ��� 0");
                    System.exit(0);
                } else if (LoveTZ==1) {
                    TextOutput_TXT("3.2 �������� ��� 1");
                    System.exit(0);
                } else if (LoveTZ==2) {
                    TextOutput_TXT("3.2 �������� ��� 2");
                    System.exit(0);
                }
                break;
            } else if (temp3 == 3) {
                TextOutput_TXT("3 ����� ������� 3 : ����� ������");
                break;
            }
        }
    }
    public static void TextOutput(String Text ,boolean PL) throws InterruptedException {
        char[] strToArray = Text.toCharArray();
        for (char c : strToArray) {
            System.out.print(c);
            if (c!=' ') {
                Thread.sleep(0);
            }
            //250ms
        }
        if (PL) {
            System.out.println();
        }
    }
    public static void TextOutput_TXT(String begin) throws InterruptedException {
        System.out.println();
        int j = 1;
        while (!Objects.equals(TEXT[j], "                " + begin)) {
            j++;
        }
        j++;
        while (!TEXT[j].equals("                &")) {
            TextOutput(TEXT[j], true);
            j++;
        }
    }
}