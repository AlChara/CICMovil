package org.cic.cicmovil.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by PERSONAL on 26/03/2017.
 */

public class SharedValues {

    public static SharedPreferences getShared(Context mContext){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public static void save_preferences(Context c, String key, Object value){
        SharedPreferences.Editor editor = getShared(c).edit();
        switch (key){
            case Constants.token:
                editor.putString(key, (String) value);
                editor.apply();
                break;
        }
    }

    public static boolean isLogin(Context mContext){
        SharedPreferences shared = getShared(mContext);
        return shared.getBoolean(Constants.login, false);
    }
}
