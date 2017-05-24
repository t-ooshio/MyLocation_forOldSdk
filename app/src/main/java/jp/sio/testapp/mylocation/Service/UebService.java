package jp.sio.testapp.mylocation.Service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Service;
import android.os.IBinder;
import android.support.annotation.Nullable;

import jp.sio.testapp.mylocation.Repository.LocationLog;

/**
 * UEB測位を行うためのService
 * Created by NTT docomo on 2017/05/22.
 */

public class UebService extends Service implements LocationListener{

    LocationManager locationManager;
    LocationLog locationLog;

    @Override
    public void onCreate(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid){
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    /**
     * Created by NTT docomo on 2017/05/23.
     * 測位設定を管理する
     */

    public static class SettingUsecase {
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
            settingPref = context.getSharedPreferences(SETTING_NAME, MODE_PRIVATE);
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
}
