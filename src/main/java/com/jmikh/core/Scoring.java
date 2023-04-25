package com.jmikh.core;

/**
 * Контракт по подсчету очков
 */
public interface Scoring {
    /**
     * Подсчет очков исходя из длины слова/фразы-палиндрома
     *
     * @param phrase Слово/фраза-палиндром
     * @return Количество очков за введенное слово/фразу-палиндром
     */
    int scorePoints(String phrase);
}
