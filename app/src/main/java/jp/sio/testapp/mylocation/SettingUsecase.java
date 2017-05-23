package jp.sio.testapp.mylocation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by NTT docomo on 2017/05/23.
 * 測位設定を管理する
 */

public class SettingUsecase {
    private static SettingUsecase instance = null;
    private Context context;

    SharedPreferences settingPref;
    SharedPreferences.Editor settingEditor;

    public final String SETTING_NAME = "MyLocationSetting";
    public final String SETTING_TAG1 = "TAG1";

    protected void setSetting(Context context){
        this.context = context;
    }

    /**
     * 設定の準備、初期処理
     */
    public void startSetting(){
        settingPref = context.getSharedPreferences(SETTING_NAME,Context.MODE_PRIVATE);
        settingEditor = settingPref.edit();
    }

    /**
     * デフォルトの設定
     */
    public void defaultSetting(){
        settingEditor.putString(SETTING_TAG1,"DEFAULT_STRING");
        settingEditor.apply();
        settingEditor.commit();
    }
    /**
     * 設定の変更
     */
    public void changeSetting(){
        settingEditor.putString(SETTING_TAG1,"CHANGE_STRING");
        settingEditor.apply();
        settingEditor.commit();
    }

    public String getSettingParam(){
        startSetting();
        defaultSetting();
        return settingPref.getString(SETTING_TAG1,"NO_TAG");
    }
}