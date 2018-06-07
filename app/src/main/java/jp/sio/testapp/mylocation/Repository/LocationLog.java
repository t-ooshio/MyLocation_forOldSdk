package jp.sio.testapp.mylocation.Repository;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import jp.sio.testapp.mylocation.L;

/**
 * Logファイルに関するクラス
 * Created by NTT docomo on 2017/05/22.
 */

public class LocationLog {
    private long createLogTime;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

    private File file;
    private String fileName;
    private String filePath;
    private String dirPath;
    private BufferedWriter writer;
    private OutputStreamWriter outputStreamWriter;

    private InputStream inputStream;
    private OutputStream outputStream;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;


    //ファイルインデックス強制作成用
    private MediaScannerConnection scanner;
    private MediaScannerConnection.MediaScannerConnectionClient scannerConnectionClient;
    private Context context;

    public LocationLog(Context context){
        this.context = context;
    }

    /**
     * Logファイルを作成
     */
    public void makeLogFile(String settingHeader){
        if(isExternalStrageWriteable()){
            createLogTime = System.currentTimeMillis();
            fileName = simpleDateFormat.format(createLogTime) + ".txt";
            dirPath = Environment.getExternalStorageDirectory().getPath() + "/MyLocation/";
            filePath = dirPath + fileName;
            file = new File(filePath);

            try {
                if(!file.exists()){
                    file.getParentFile().mkdir();
                }
                fileOutputStream = new FileOutputStream(file,true);
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                L.d("settingHeader:" + settingHeader);
                outputStreamWriter.append(settingHeader+"\n");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            L.d("LogFilePath:" + filePath);

        }else{
            L.d("ExternalStrage書き込み不可");
        }
    }

    /**
     * Logファイルへの書き込み
     */
    public void writeLog(String log){
        try {
            L.d("Log:" + log);
            outputStreamWriter.write(log + "\n");
            //outputStreamWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Logファイルを閉じる(Readerとかを閉じる処理を想定)
     *
     */
    public void endLogFile(){
            scanFile();
        try {
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ログファイルを端末再起動無しでも読み込むための処理
     * ファイルインデックスを作成しなおせば良いと見たのでそれを実装
     */
    public void scanFile() {

        Uri contentUri = Uri.fromFile(file);
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, contentUri);
        context.sendBroadcast(mediaScanIntent);

    }

    //externalStrageのReadとWriteが可能かチェック
    private boolean isExternalStrageWriteable(){
        boolean result = false;
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            result = true;
        }
        L.d("isExternalStrageWriteable:"+result);
        return result;
    }
}