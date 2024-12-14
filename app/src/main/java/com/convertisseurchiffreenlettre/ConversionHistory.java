package com.convertisseurchiffreenlettre;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConversionHistory {
    private static final String PREFS_NAME = "conversion_history";
    private static final String KEY_HISTORY = "history";

    private SharedPreferences sharedPreferences;

    public ConversionHistory(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void addHistoryEntry(String entry) {
        Set<String> history = getHistorySet();
        history.add(entry);
        sharedPreferences.edit().putStringSet(KEY_HISTORY, history).apply();
    }

    public List<String> getHistory() {
        Set<String> historySet = sharedPreferences.getStringSet(KEY_HISTORY, new HashSet<>());
        return new ArrayList<>(historySet);
    }

    private Set<String> getHistorySet() {
        return sharedPreferences.getStringSet(KEY_HISTORY, new HashSet<>());
    }
}
