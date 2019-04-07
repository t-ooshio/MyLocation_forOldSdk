package jp.sio.testapp.mylocation.Activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import jp.sio.testapp.mylocation.Presenter.SettingPresenter;
import jp.sio.testapp.mylocation.R;

/**
 * Settingの画面
 * 処理はSettingUsecaseへ渡す
 */
public class SettingActivity extends AppCompatActivity {

    SettingPresenter settingPresenter;

    private EditText editTextCount;
    private EditText editTextTimeout;
    private EditText editTextInterval;
    private EditText editTextSuplEndWaitTime;
    private EditText editTextDelAssistDataTime;
    private RadioButton radioButtonUeb;
    private RadioButton radioButtonUea;
    private RadioButton radioButtonNetwork;
    private RadioButton radioButtoniArea;
    private RadioButton radioButtonTracking;
    private CheckBox checkBoxisCold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //縦方向に固定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        settingPresenter = new SettingPresenter(this);

        editTextCount = (EditText)findViewById(R.id.editTextCount);
        editTextTimeout = (EditText)findViewById(R.id.editTextTimeout);
        editTextInterval = (EditText)findViewById(R.id.editTextInterval);
        editTextSuplEndWaitTime = (EditText)findViewById(R.id.editTextSuplEndWaitTime);
        editTextDelAssistDataTime = (EditText)findViewById(R.id.editTextDelAssistDataTime);
        radioButtonUeb = (RadioButton)findViewById(R.id.rbUeb);
        radioButtonUea = (RadioButton)findViewById(R.id.rbUea);
        radioButtonNetwork = (RadioButton)findViewById(R.id.rbNw);
        radioButtoniArea = (RadioButton)findViewById(R.id.rbiArea);
        radioButtonTracking = (RadioButton)findViewById(R.id.rbTracking);
        checkBoxisCold = (CheckBox)findViewById(R.id.checkboxIsCold);
    }

    @Override
    protected void onStart(){
        super.onStart();
        settingPresenter.loadSetting();
    }
    @Override
    protected void onResume(){
        settingPresenter.loadSetting();
        super.onResume();
    }

    public void onButtonSet(){

    }
    public void setCount(int count){
        editTextCount.setText(Integer.toString(count));
    }
    public void setTimeout(long timeout){
        editTextTimeout.setText(Long.toString(timeout));
    }
    public void setInterval(long interval){
        editTextInterval.setText(Long.toString(interval));
    }
    public void setSuplEndWaitTime(int suplEndWaitTime){
        editTextSuplEndWaitTime.setText(Integer.toString(suplEndWaitTime));
    }
    public void setDelAssistDataTime(int delAssistDataTime){
        editTextDelAssistDataTime.setText(Integer.toString(delAssistDataTime));
    }
    public void enableRadioButtonUeb(){
        radioButtonUeb.setChecked(true);
    }
    public void enableRadioButtonUea(){
        radioButtonUea.setChecked(true);
    }
    public void enableRadioButtonNetwork(){
        radioButtonNetwork.setChecked(true);
    }
    public void enableRadioButtoniArea(){
        radioButtoniArea.setChecked(true);
    }
    public void enableRadioButtonTracking(){
        radioButtonTracking.setChecked(true);
    }

    public void enableIsCold(){
        checkBoxisCold.setChecked(true);
    }
    public void disableIsCold(){
        checkBoxisCold.setChecked(false);
    }
    public int getCount(){
        String count;
        count = editTextCount.getText().toString();
        return Integer.parseInt(count);
    }
    public long getTimeout(){
        String timeout;
        timeout = editTextTimeout.getText().toString();
        return Long.parseLong(timeout);
    }
    public long getInterval(){
        String interval;
        interval = editTextInterval.getText().toString();
        return Long.parseLong(interval);
    }
    public int getSuplEndWaitTime(){
        String suplendwaittime;
        suplendwaittime = editTextSuplEndWaitTime.getText().toString();
        return Integer.parseInt(suplendwaittime);
    }
    public int getDelAssistDataTime(){
        String delassistdatatime;
        delassistdatatime = editTextDelAssistDataTime.getText().toString();
        return Integer.parseInt(delassistdatatime);
    }
    public boolean isRadioButtonUeb(){
        return radioButtonUeb.isChecked();
    }
    public boolean isRadioButtonUea(){
        return radioButtonUea.isChecked();
    }
    public boolean isRadioButtonNetwork(){
        return radioButtonNetwork.isChecked();
    }
    public boolean isRadioButtoniArea(){
        return radioButtoniArea.isChecked();
    }
    public boolean isRadioButtonTracking(){
        return radioButtonTracking.isChecked();
    }

    public boolean isColdCheck(){
        return checkBoxisCold.isChecked();
    }
    @Override
    protected void onDestroy(){
        //TODO: 戻るボタンを押されたときにSetting
        settingPresenter.commitSetting();
        super.onDestroy();
    }
    @Override
    protected void onPause(){
        settingPresenter.commitSetting();
        super.onPause();
    }
}
