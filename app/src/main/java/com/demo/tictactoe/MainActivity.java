package com.demo.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonSinglePlayer;
    private Button buttonMultiPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSinglePlayer=(Button)findViewById(R.id.btn_single_player);
        buttonMultiPlayer=(Button)findViewById(R.id.btn_multi_player);

        buttonSinglePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SinglePlayer.class);
                startActivity(intent);
            }
        });

        buttonMultiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MultiPlayerActivity.class);
                startActivity(intent);
            }
        });

    }
}
