package jp.sio.testapp.mylocation.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jp.sio.testapp.mylocation.Presenter.SettingPresenter;
import jp.sio.testapp.mylocation.R;

/**
 * Settingの画面
 * 処理はSettingUsecaseへ渡す
 */
public class SettingActivity extends AppCompatActivity {

    SettingPresenter settingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
