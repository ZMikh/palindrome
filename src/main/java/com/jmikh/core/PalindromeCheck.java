package com.jmikh.core;

/**
 * Контракт проверки слова/фразы на палиндром
 */
public interface PalindromeCheck {
    /**
     * Проверка слова/фразы на палиндром
     *
     * @param phrase Слово/фраза
     * @return Является ли слова/фраза палиндромом
     */
    Boolean checkPalindrome(String phrase);
}
