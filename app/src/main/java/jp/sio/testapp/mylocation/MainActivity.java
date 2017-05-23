package jp.sio.testapp.mylocation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private TextView tvResult;
    private Context context = this;
    private MyLocationPresenter presenter;
    SharedPreferences settingPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MyLocationPresenter();
        presenter.setActivity(this);

        buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStop = (Button)findViewById(R.id.buttonStop);
        tvResult = (TextView)findViewById(R.id.textViewResult);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offBtnStart();
                onBtnStop();
                pushBtnStart();
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnStart();
                offBtnStop();
                pushBtnStop();
            }
        });
    }

    protected void pushBtnStart(){
        showTextView("start");
        presenter.locationStart();
    }
    protected void pushBtnStop(){
        showTextView("stop");
    }

    protected void onBtnStart(){
        buttonStart.setEnabled(true);
    }
    protected void offBtnStart(){
        buttonStart.setEnabled(false);
    }

    protected void onBtnStop(){
        buttonStop.setEnabled(true);
    }
    protected void offBtnStop(){
        buttonStop.setEnabled(false);
    }
    protected void showTextView(String str){
        tvResult.setText(str);
    }

}