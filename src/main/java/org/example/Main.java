package org.example;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static String[] MassErrors =new String []{
            "Поздравляем вы сломали игру! Вам предоставлен счёт в размере 20$!",
            "Чёт пошло не так, но мы сами не знаем что",
            "Введите цифры которые вам предоставлены выше!(не пытайтесь найти пасхалки)",
            "Как можно быть таким тупым чтобы неправильно написать вариант ответа",
            "*Типо код не работает*",
            "еррор",
            "Ошибочка",
            "Пожалуйста, не ломайте игру и играйте как надо!",
            "Произошел сбой программы. Код ошибки: 228",
            "Чтобы продолжить играть отправьте сценаристу 5$!",
            "!!!Вас вычислили по IP и за вами выехал узбек с его братками!!!"};
    public static String[] TEXT = new String[545];
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Game game = new Game();
        File file = new File("src/main/resources/NowellText.txt");
        BufferedReader br;
        try{
            if (!file.exists()){
                TextOutput("                Файлы игры повреждены\t",true);
                System.exit(1);
            }else {
                TextOutput("                Файлы игры в порядке\t",true);
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
                                Простой режим
                                1 : Выкл
                                2 : Вкл
                """,true);
        for (;;){
            System.out.print("                ");
            int temp=scanner.nextInt();
            if(temp==1){
                TextOutput("                Простой режим выключен\t",true);
                EzMode=false;
                break;
            }
            else if(temp==2){
                TextOutput("                Простой режим включен\t",true);
                EzMode=true;
                break;
            }else {
                TextOutput("                "+ MassErrors[random.nextInt(0, MassErrors.length)],true);
            }
        }
        TextOutput_TXT("Вступление:");
        if (EzMode){
            TextOutput_TXT("1 Выбор EzMode On");
        }else {
            TextOutput_TXT("1 Выбор EzMode Off");
        }
        for(;;) {
            System.out.print("                ");
            int temp = scanner.nextInt();
            if (temp == 1) {
                TextOutput_TXT("Выбор 1 Вариант 1 Убежать");
                LoveTZ++;
                break;
            } else if (temp == 2) {
                TextOutput_TXT("Выбор 1 Вариант 2 Обматерить");
                System.exit(0);
            } else if (temp == 3) {
                TextOutput_TXT("Выбор 1 Вариант 3 Успокоить");
                if (EzMode){
                    TextOutput_TXT("Выбор 2 EzMode On");
                }else {
                    TextOutput_TXT("Выбор 2 EzMode Off");
                }
                for(;;) {
                    System.out.print("                ");
                    int temp2 = scanner.nextInt();
                    if(temp2==1){
                        TextOutput_TXT("Выбор 2 Вариант 1 : Пойти в другую шаурмечную");
                        LoveUZ++;
                        break;
                    }else if (temp2==2){
                        TextOutput_TXT("Выбор 2 Вариант 2 : Пойти домой");
                        break;
                    } else if (temp2 == 3) {
                        TextOutput_TXT("Выбор 2 Вариант 3 : Посмотреть на кота дворнягу");
                        if(game.Gamestr()){
                            TextOutput_TXT("Мини-игра Победа");
                            LoveUZ++;
                            LoveTZ++;
                        }else {
                            TextOutput_TXT("Мини-игра Поражение");
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
        TextOutput_TXT("Поздравление 1 Глава");
        if(EzMode){
            TextOutput("                Таджик : "+LoveTZ+"\t                Узбек : "+LoveUZ,true);
        }
        //2 Глава
        TextOutput_TXT("Вступление 2");
        if (EzMode){
            TextOutput_TXT("3 Выбор EzMode On");
        }else {
            TextOutput_TXT("3 Выбор EzMode Off");
        }
        for(;;) {
            System.out.print("                ");
            int temp3 = scanner.nextInt();
            if (temp3 == 1) {
                TextOutput_TXT("3 Выбор Вариант 1 : Поехать в деревню к маме");
                int LoveUZTMP=0;
                if (EzMode){
                    TextOutput_TXT("3.1.1 Выбор EzMode On");
                }else {
                    TextOutput_TXT("3.1.1 Выбор EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.1 Выбор Вариант 1. Вечер в хату");
                        LoveUZTMP++;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.1 Выбор Вариант 2. Ну привет");
                        LoveUZTMP--;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (LoveUZ==1){
                    TextOutput_TXT("3.1 Комм узбека при 1");
                }else {
                    TextOutput_TXT("3.1 Комм узбека при 0");
                }
                if (EzMode){
                    TextOutput_TXT("3.1.2 Выбор EzMode On");
                }else {
                    TextOutput_TXT("3.1.2 Выбор EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.2 Выбор Вариант 1. В канаву ближайшую, на мать твою посмотреть.");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.2 Выбор Вариант 2. К матери своей еду, навестить её");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (EzMode){
                    TextOutput_TXT("3.1.3 Выбор EzMode On");
                }else {
                    TextOutput_TXT("3.1.3 Выбор EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.3 Выбор Вариант 1. После того как тебя увидел все плохо в моей жизни стало");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.3 Выбор Вариант 2. Неплохо, вот солнце светит. Сразу настроение поднялось");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }
                }
                if (EzMode){
                    TextOutput_TXT("3.1.4 Выбор EzMode On");
                }else {
                    TextOutput_TXT("3.1.4 Выбор EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.4 Выбор Вариант 1. Бывал, пятнашку отсидел");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.4 Выбор Вариант 2. Не бывал, и не собираюсь там быть");
                        LoveUZTMP++;
                        break;
                    }else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)],true);
                    }

                }
                if (EzMode){
                    TextOutput_TXT("3.1.5 Выбор EzMode On");
                }else {
                    TextOutput_TXT("3.1.5 Выбор EzMode Off");
                }
                for(;;){
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if(temp4==1){
                        TextOutput_TXT("3.1.5 Выбор Вариант 1. Сам на пики точёные сяду, а мать на х*и дро*еные посажу");
                        LoveUZTMP--;
                        break;
                    }else if(temp4==2){
                        TextOutput_TXT("3.1.5 Выбор Вариант 2. Не буду я на такие вопросы отвечать!");
                        LoveUZTMP++;
                        break;
                    }else if(temp4==3) {
                        TextOutput_TXT("3.1.5 Выбор Вариант 3. Сам на пики точёные сяду, а мать на колени посажу");
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
                    TextOutput_TXT("3.1 Концовка При -1");
                    System.exit(0);
                } else if (LoveUZ==0) {
                    TextOutput_TXT("3.1 Концовка При 0");
                    System.exit(0);
                } else if (LoveUZ==1) {
                    TextOutput_TXT("3.1 Концовка При 1");
                    System.exit(0);
                } else if (LoveUZ==2) {
                    TextOutput_TXT("3.1 Концовка При 2");
                    System.exit(0);
                }
                break;
            } else if (temp3 == 2) {
                TextOutput_TXT("3 Выбор Вариант 2 : Погулять по городу");
                if (LoveUZ == 1) {
                    TextOutput_TXT("3.2 Комм таджика при 1");
                } else {
                    TextOutput_TXT("3.2 Комм таджика при 0");
                }
                int LoveTZTMP = 0;
                if (EzMode) {
                    TextOutput_TXT("3.2.1 Выбор EzMode On");
                } else {
                    TextOutput_TXT("3.2.1 Выбор EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.1 Выбор Вариант 1. Да на твою рожу посмотреть, шавуху схавать и уйти");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.1 Выбор Вариант 2. Да вот решил тебя навестить, посмотреть как ты тут");
                        LoveTZTMP++;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.2 Выбор EzMode On");
                } else {
                    TextOutput_TXT("3.2.2 Выбор EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.2 Выбор Вариант 1. Да я вообще шаурму ненавижу, а у тебя она ужасная");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.2 Выбор Вариант 2. Лучше, чем у тебя я шаурмы не видел!");
                        LoveTZTMP++;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.3 Выбор EzMode On");
                } else {
                    TextOutput_TXT("3.2.3 Выбор EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.3 Выбор Вариант 1. Говядину");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.3 Выбор Вариант 2. Человечину");
                        break;
                    }else if (temp4 == 3) {
                        TextOutput_TXT("3.2.3 Выбор Вариант 3. Котячину или собачину");
                        LoveTZTMP++;
                        break;
                    }
                    else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.4 Выбор EzMode On");
                } else {
                    TextOutput_TXT("3.2.4 Выбор EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.4 Выбор Вариант 1. А ты знал что после твоей шавухи у твоих клиентов хвосты вырастают?");
                        LoveTZTMP--;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.4 Выбор Вариант 2. Тут ходят слухи что даже сам президент в твою шаурмечную заходит!");
                        LoveTZTMP++;
                        break;
                    } else {
                        TextOutput("                " + MassErrors[random.nextInt(0, MassErrors.length)], true);
                    }
                }
                if (EzMode) {
                    TextOutput_TXT("3.2.5 Выбор EzMode On");
                } else {
                    TextOutput_TXT("3.2.5 Выбор EzMode Off");
                }
                for (; ; ) {
                    System.out.print("                ");
                    int temp4 = scanner.nextInt();
                    if (temp4 == 1) {
                        TextOutput_TXT("3.2.5 Выбор Вариант 1. 1. Да, конечно");
                        LoveTZTMP++;
                        break;
                    } else if (temp4 == 2) {
                        TextOutput_TXT("3.2.5 Выбор Вариант 2. Извини, но нет");
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
                    TextOutput_TXT("3.2 Концовка При -1");
                    System.exit(0);
                } else if (LoveTZ==0) {
                    TextOutput_TXT("3.2 Концовка При 0");
                    System.exit(0);
                } else if (LoveTZ==1) {
                    TextOutput_TXT("3.2 Концовка При 1");
                    System.exit(0);
                } else if (LoveTZ==2) {
                    TextOutput_TXT("3.2 Концовка При 2");
                    System.exit(0);
                }
                break;
            } else if (temp3 == 3) {
                TextOutput_TXT("3 Выбор Вариант 3 : Спать дальше");
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