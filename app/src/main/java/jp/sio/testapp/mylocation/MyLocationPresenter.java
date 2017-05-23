package jp.sio.testapp.mylocation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
/**
 * Created by NTT docomo on 2017/05/23.
 * ActivityとServiceの橋渡し
 * Activityはなるべく描画だけに専念させたいから分けるため
 */

public class MyLocationPresenter {
    private MainActivity activity;
    private String testStr;
    SettingUsecase settingUsecase = new SettingUsecase();

    public void setActivity(MainActivity activity){
        this.activity = activity;
        settingUsecase.setSetting(activity.getApplicationContext());
    }

    public void locationStart(){
        testStr = settingUsecase.getSettingParam();
        activity.showTextView(testStr);
    }
}
