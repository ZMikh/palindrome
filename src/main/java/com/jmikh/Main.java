package com.jmikh;

import com.jmikh.core.Dashboard;
import com.jmikh.core.impl.DashboardImpl;
import com.jmikh.core.impl.PalindromeCheckImpl;
import com.jmikh.core.impl.ScoringImpl;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PalindromeCheckImpl palindromeCheck = new PalindromeCheckImpl();
        Dashboard dashboard = new DashboardImpl(new ScoringImpl());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Привет!
                    Введите номер действия:
                    1 - Начать игру
                    2 - Посмотреть доску лидеров
                    3 - Завершить игру""");
            String action = scanner.nextLine();

            if (Objects.equals(action, "1")) {
                System.out.println("Введите имя");
                String name = scanner.nextLine();

                System.out.println("Введите слово/фразу");
                String phrase = scanner.nextLine();
                Boolean palindrome = palindromeCheck.checkPalindrome(phrase);

                if (palindrome) {
                    boolean existingPalindrome = dashboard.checkExistencePalindromePhrase(name, phrase);
                    if (existingPalindrome) System.out.println("Данный палиндромом был введен вами ранее");
                    int score = dashboard.addPalindromePhrase(name, phrase, existingPalindrome);
                    System.out.println("Общее количество ваших очков: " + score);
                } else System.out.println("Введенная фраза не является палиндромом");

            } else if (Objects.equals(action, "2")) {
                System.out.println(dashboard.getTopResults());
            } else if (Objects.equals(action, "3")) break;
            else System.out.println("Введите номер действия");
        }
    }
}