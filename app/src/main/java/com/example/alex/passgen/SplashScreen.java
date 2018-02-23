package com.example.alex.passgen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView titulo;
    TextView subtitulo;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        titulo=findViewById(R.drawable.passgen);
        subtitulo=findViewById(R.id.tV_subTit);
        //Animation animacion= AnimationUtils.loadAnimation(this,R.anim.transicion);
        //titulo.startAnimation(animacion);
        final Intent intent=new Intent(this,MainActivity.class);

       Thread timer= new Thread(){
           public void run(){
               try{
                   sleep(2000);
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
               finally {
                   startActivity(intent);
                   finish();

               }
           }
       };
       timer.start();
    }
}
