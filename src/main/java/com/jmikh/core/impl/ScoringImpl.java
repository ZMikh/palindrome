package com.jmikh.core.impl;

import com.jmikh.core.Scoring;

public class ScoringImpl implements Scoring {
    @Override
    public int scorePoints(String phrase) {
        return phrase.length();
    }
}
