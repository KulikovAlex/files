package com.kulikov;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringTask {

    public static void task1(){
        Scanner sc = new Scanner(System.in);
        String s1,s2;
        int index = 0;
        System.out.println("Введите строку: ");
        s1= sc.nextLine();
        boolean again = true;
        while(again) {
            System.out.println("Введите индекс символа в строке: ");
            try {
                index = sc.nextInt();
                s2 = s1.substring(index-1,index);
                System.out.println("Ваш символ: "+ s2);
                again = false;
            } catch (InputMismatchException e) {
                System.out.println("Индекс должен быть целым и неотрицательным!");
                sc.next();
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("Индекс должен быть в пределах вашей строки!");
            }
        }
        sc.close();
    }

    public static void task2(){
        char mass[] = {'b','u','l'};
        String str = String.valueOf(mass);
        System.out.println("Массив char: " + str + "\nВведите вашу строку: ");
        Scanner sc = new Scanner(System.in);
        String mystr = sc.nextLine();
        System.out.println("Ваша строка " + (mystr.contains(str)?"содержит ":"не содержит ") +
                "заданный массив char");
    }
    public static void main(String[] args) {

        //task1();
        //task2();

    }
}
