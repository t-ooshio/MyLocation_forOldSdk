package jp.sio.testapp.mylocation.Repository;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by NTT docomo on 2017/05/23.
 */

public class SettingPref {
    SharedPreferences settingPref;
    SharedPreferences.Editor editor;
    Context context;

    //SharedPreference名
    public final String PREFNAME = "MyLocationSetting";
    //設定項目
    public final String TESTPARAM = "testparam";

    /**
     * MainActivityのContextを取得する
     * @param context
     */
    public void SettingPref(Context context){
        this.context = context;
    }
    public void createPref(){
        settingPref = context.getSharedPreferences(PREFNAME,Context.MODE_PRIVATE);
        editor = settingPref.edit();
    }

    public void setTestParam(String str){
        editor.putString(TESTPARAM,str);
        editor.apply();
        editor.commit();
    }
    public String getTestParam(){
        return settingPref.getString(TESTPARAM,"default");
    }
    public String testMethod(String str){
        createPref();
        editor.putString(TESTPARAM,str);
        return settingPref.getString(TESTPARAM,"default");
    }
}