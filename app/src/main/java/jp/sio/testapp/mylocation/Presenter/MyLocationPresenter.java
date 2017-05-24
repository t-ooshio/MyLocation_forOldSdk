package jp.sio.testapp.mylocation.Presenter;

import jp.sio.testapp.mylocation.Activity.MyLocationActivity;
import jp.sio.testapp.mylocation.Usecase.SettingUsecase ;
/**
 * Created by NTT docomo on 2017/05/23.
 * ActivityとServiceの橋渡し
 * Activityはなるべく描画だけに専念させたいから分けるため
 */

public class MyLocationPresenter {
    private MyLocationActivity activity;
    SettingUsecase settingUsecase = new SettingUsecase ();

    private String testStr;

    public void setActivity(MyLocationActivity activity){
        this.activity = activity;
    }

    public void locationStart(){
        settingUsecase.
        activity.showTextView(testStr);
    }
}
