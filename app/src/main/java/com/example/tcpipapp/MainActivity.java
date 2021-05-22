package com.example.tcpipapp;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editTextIP);
        e2=(EditText)findViewById(R.id.editTextMessage);


    }
    public void button_click(View v){
        BackgroundTask b=new BackgroundTask();
        b.execute(e1.getText().toString(), e2.getText().toString());


        }
    class BackgroundTask extends AsyncTask<String,Void,Void>
    {
        Socket s;

        PrintWriter out;
        String ip,message;
        private BufferedReader in;
        public String sendMessage(String msg) {
            try {
                out.println(msg);
                String resp = null;

                resp = in.readLine();
                System.out.println(resp);
                return resp;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;


        }
        @Override
        protected Void doInBackground(String... params) {
            ip=params[0];
            message=params[1];

            try {
                s=new Socket(ip, 6666);
                //dos=new DataOutputStream(s.getOutputStream());
                out = new PrintWriter(s.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    //dos.writeUTF(message);
                    //dos.writeChars(message);
                    sendMessage(message);

                    //System.out.println(message);
                    out.flush();

                out.close();
                //dos.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


    }



}