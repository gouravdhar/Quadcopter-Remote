package com.example.gourav.remote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    private EditText ekproll, ekpyaw, ekiroll, ekiyaw, ekdroll, ekdyaw ;
    private SeekBar seekBar, seekBar2;
    private TextView textView, textView2;

    public void seekBar(){
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        textView2 = (TextView) findViewById(R.id.textView2);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    float progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                        progress_value = progress;
                        progress_value=(int)(progress*40/100-20);
                        textView2.setText("Roll : " + progress_value);
                        roll(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
//                        Toast.makeText(MainActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
//                        progress_value = 50 ;
                        textView2.setText("Roll : 0" );
                        roll(50);
//                        Toast.makeText(MainActivity.this,"SeekBar in StopTracking",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
    public void seekBar2(){
        seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        textView = (TextView) findViewById(R.id.textView);
        seekBar2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    float progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value=(int)(progress*40/100-20);
                        textView.setText("Pitch : " + progress_value );
                        pitch(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
//                        Toast.makeText(MainActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
//                        progress_value = 50 ;
                        textView.setText("Pitch : 0" );
                        pitch(50);
//                        Toast.makeText(MainActivity.this,"SeekBar in StopTracking",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
    public void roll(float roll){
        int roll_an = (int)roll;
        String s= Integer.toString( roll_an ) ;
//        String http = "http://192.168.43.1:8080?command= r0" ;
//        int n = s.length();
//        if( n == 1 ){
//            http = "http://192.168.43.1:8080?command= r0" ;
//        }
//        if( n == 2 ){
//            http = "http://192.168.43.1:8080?command= r" ;
//        }

//        String url = http + s ;
        WebView browser = (WebView)findViewById(R.id.webview);
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        String url = "http://192.168.43.1:8080/?command=sroll&ra="+s;
//        String url ="http://192.168.43.1:8080/?command=start" ;
        browser.loadUrl(url);
    }
    public void pitch(float pitch){
        int pitch_an = (int)pitch;
        String s= Integer.toString( pitch_an ) ;
//        String http = "http://192.168.43.1:8080?command= p0" ;
//        int n = s.length();
//        if( n == 1 ){
//            http = "http://192.168.43.1:8080?command= p0" ;
//        }
//        if( n == 2 ){
//            http = "http://192.168.43.1:8080?command= p" ;
//        }
//        String url = http + s ;
        WebView browser = (WebView)findViewById(R.id.webview);
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        String url = "http://192.168.43.1:8080/?command=spitch&pa="+s;
        browser.loadUrl(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar();
        seekBar2();
    }
}
