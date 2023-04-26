package com.jmikh.core.impl;

import com.jmikh.core.Dashboard;
import com.jmikh.core.Scoring;

import java.util.*;
import java.util.stream.Collectors;

public class DashboardImpl implements Dashboard {

    private final Map<String, Integer> nameAndPoints = new HashMap<>();
    private final Map<String, List<String>> nameAndPhrases = new HashMap<>();

    private final Scoring scoring;

    public DashboardImpl(Scoring scoring) {
        this.scoring = scoring;
    }


    @Override
    public boolean checkExistencePalindromePhrase(String name, String phrase) {
        nameAndPoints.putIfAbsent(name, 0);

        List<String> phrases = new ArrayList<>();
        nameAndPhrases.putIfAbsent(name, phrases);

        return nameAndPhrases.get(name).stream().anyMatch(p -> p.equals(phrase));
    }

    @Override
    public int addPalindromePhrase(String name, String phrase) {
        nameAndPhrases.get(name).add(phrase);
        nameAndPoints.replace(name, nameAndPoints.get(name) + scoring.scorePoints(phrase));
        return nameAndPoints.get(name);
    }

    @Override
    public List<Map.Entry<String, Integer>> getTopResults() {
        return nameAndPoints.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
