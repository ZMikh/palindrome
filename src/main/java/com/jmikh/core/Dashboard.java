package com.jmikh.core;

import java.util.List;
import java.util.Map;

/**
 * Контракт по взаимодействию с пользователем
 */
public interface Dashboard {
    /**
     * Проверка существования палиндрома у данного пользователя
     *
     * @param name Имя пользователя
     * @param phrase Слово/фраза-палиндром
     * @return Было ли ранее введено пользователем данное слово/фраза-палиндром
     */
    boolean checkExistencePalindromePhrase(String name, String phrase);

    /**
     * Добавление палиндрома и вывод очков пользователя
     *
     * @param name Имя пользователя
     * @param phrase Слово/фраза-палиндром
     * @return Общее количество очков пользователя
     */
    int addPalindromePhrase(String name, String phrase);

    /**
     * Показ доски лидеров
     *
     * @return Список пяти пользователей с максимальным количеством очков, отсортированных по убыванию количества очков
     */
    List<Map.Entry<String, Integer>> getTopResults();
}
