package com.example.niraj.newsapp;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public static class NewsPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting_main);
            //Retrieves the key value from category´s Preference instance
            Preference category = findPreference(getString(R.string.settings_category_key));
            //Update the summary ( Visualization ) of the category preference when preference changes
            bindPreferenceSummaryToValue(category);

            //Retrieves the key value from orderBy´s Preference instance
            Preference orderBy = findPreference(getString(R.string.settings_order_by_key));
            //Update the summary ( Visualization ) of the orderBy preference when preference changes
            bindPreferenceSummaryToValue(orderBy);

        }

        //Callback method executed when OnPreferenceChangeListener is executed and just returns a boolean value
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {

            String stringValue = value.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;
        }

        //Method that updates the summary on the settings Activity
        private void bindPreferenceSummaryToValue(Preference preference) {

            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceString);
        }
    }
}
