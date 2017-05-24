package jp.sio.testapp.mylocation.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jp.sio.testapp.mylocation.Presenter.MyLocationPresenter;
import jp.sio.testapp.mylocation.R;


public class MyLocationActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private TextView tvResult;
    private Context context = this;
    private MyLocationPresenter presenter;

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

    public void pushBtnStart(){
        showTextView("start");
        presenter.locationStart();
    }
    public void pushBtnStop(){
        showTextView("stop");
    }

    public void onBtnStart(){
        buttonStart.setEnabled(true);
    }
    public void offBtnStart(){
        buttonStart.setEnabled(false);
    }

    public void onBtnStop(){
        buttonStop.setEnabled(true);
    }
    public void offBtnStop(){
        buttonStop.setEnabled(false);
    }
    public void showTextView(String str){
        tvResult.setText(str);
    }

}