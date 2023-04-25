package com.jmikh.core.impl;

import com.jmikh.core.PalindromeCheck;

public class PalindromeCheckImpl implements PalindromeCheck {
    @Override
    public Boolean checkPalindrome(String phrase) {
        if (phrase == null || phrase.length() == 0) return false;

        String phraseModified = phrase.toLowerCase().replaceAll(" ", "");
        for (int i = 0; i < phraseModified.length() / 2; i++) {
            if (phraseModified.charAt(i) != phraseModified.charAt(phraseModified.length() - i - 1))
                return false;
        }
        return true;
    }
}
