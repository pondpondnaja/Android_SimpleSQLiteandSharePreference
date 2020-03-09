package com.example.sqlite;

import android.content.Context;
import android.content.SharedPreferences;

public class dataHelper {
    Context context;
    SharedPreferences sharedPerfs;
    SharedPreferences.Editor editor;

    // Prefs Keys
    static String perfsName = "UserHelper";
    static int perfsMode = 0;

    public dataHelper(Context context) {
        this.context = context;
        this.sharedPerfs = this.context.getSharedPreferences(perfsName, perfsMode);
        this.editor = sharedPerfs.edit();
    }

    public void createSession(String sUserName, String sTel) {
        editor.putString("Name", sUserName);
        editor.putString("Telephone", sTel);
        editor.commit();
    }

    public void deleteSession() {
        editor.clear();
        editor.commit();
    }

    public String getUserName() {
        return sharedPerfs.getString("Name", null);
    }

    public String getPhone() {
        return sharedPerfs.getString("Telephone", null);
    }
}
