package com.example.settingpreference;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class MainActivity extends AppCompatActivity {
    public static final String TARGET_SETTING_PAGE = "target";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SettingPreferenceFragment settingsFragment = new SettingPreferenceFragment();
        Intent intent = getIntent();
        if (intent != null) {
            String rootKey = intent.getStringExtra(TARGET_SETTING_PAGE);
            if (rootKey != null) {
                Bundle args = new Bundle();
                args.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, rootKey);
                settingsFragment.setArguments(args);
            }
        }

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, settingsFragment, null)
                .commit();
    }
}
