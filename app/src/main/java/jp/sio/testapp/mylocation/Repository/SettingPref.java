package jp.sio.testapp.mylocation.Repository;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by NTT docomo on 2017/05/23.
 */

public class SettingPref {
    SharedPreferences settingPref;
    Context context;

    /**
     * MainActivityのContextを取得する
     * @param context
     */
    public void SettingPref(Context context){
        this.context = context;
    }
}
