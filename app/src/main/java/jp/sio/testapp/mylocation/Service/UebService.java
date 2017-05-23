package jp.sio.testapp.mylocation.Service;

import android.content.Intent;
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
}
