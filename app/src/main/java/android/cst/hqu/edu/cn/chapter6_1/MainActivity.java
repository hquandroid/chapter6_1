package android.cst.hqu.edu.cn.chapter6_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends Activity {

    EditText showTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTxt=findViewById(R.id.showTxt);
        new Thread(){
            @Override
            public void run() {
                try {
                    Socket ss=new Socket("192.168.31.59",30000);
                    BufferedReader br=new BufferedReader(new InputStreamReader(ss.getInputStream()));
                    String line=br.readLine();
                    showTxt.setText("来自服务器的消息:"+line);
                    br.close();
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
