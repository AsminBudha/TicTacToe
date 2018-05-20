package com.demo.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MultiPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageButton[][] position;
    private int player = R.drawable.ic_cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorButton));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MultiPlayerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        position = new ImageButton[][]{
                {(ImageButton) findViewById(R.id.imageButton), (ImageButton) findViewById(R.id.imageButton2), (ImageButton) findViewById(R.id.imageButton3)},
                {(ImageButton) findViewById(R.id.imageButton4), (ImageButton) findViewById(R.id.imageButton5), (ImageButton) findViewById(R.id.imageButton6)},
                {(ImageButton) findViewById(R.id.imageButton7), (ImageButton) findViewById(R.id.imageButton8), (ImageButton) findViewById(R.id.imageButton9)}
        };

        initGame();

    }

    private void initGame() {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                ImageButton imageButton = position[i][j];
                imageButton.setOnClickListener(this);
                imageButton.setImageDrawable(null);
                imageButton.setTag(null);
                Toast.makeText(MultiPlayerActivity.this, player + " your move", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void move(ImageButton imageButton) {
        imageButton.setTag(player);
        imageButton.setImageResource(player);

        boolean won = hasWon(player);
        if (won) {
            Toast.makeText(MultiPlayerActivity.this, player + " has won", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean draw = draw();
        if (draw) {
            Toast.makeText(MultiPlayerActivity.this, "Draw", Toast.LENGTH_SHORT).show();
        } else {
            player = player == R.drawable.ic_cross ? R.drawable.ic_circle : R.drawable.ic_cross;
            Toast.makeText(MultiPlayerActivity.this, player + " your move", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean draw() {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                if (position[i][j].getDrawable() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWon(int player) {
//        if (position[0][0].getTag() == null ? false : position[0][0].getTag().equals(player)
//                && position[0][1].getTag() == null ? false : position[0][1].getTag().equals(player)
//                && position[0][2].getTag() == null ? false : position[0][2].getTag().equals(player)) {
//            return true;
//        } else if (position[1][0].getTag() == null ? false : position[1][0].getTag().equals(player)
//                && position[1][1].getTag() == null ? false : position[1][1].getTag().equals(player)
//                && position[1][2].getTag() == null ? false : position[1][2].getTag().equals(player)) {
//            return true;
//        } else if (position[2][0].getTag() == null ? false : position[2][0].getTag().equals(player)
//                && position[2][1].getTag() == null ? false : position[2][1].getTag().equals(player)
//                && position[2][2].getTag() == null ? false : position[2][2].getTag().equals(player)) {
//            return true;
//        } else if (position[0][0].getTag() == null ? false : position[0][0].getTag().equals(player)
//                && position[1][1].getTag() == null ? false : position[1][1].getTag().equals(player)
//                && position[2][2].getTag() == null ? false : position[2][2].getTag().equals(player)) {
//            return true;
//        } else if (position[2][0].getTag() == null ? false : position[2][0].getTag().equals(player)
//                && position[1][1].getTag() == null ? false : position[1][1].getTag().equals(player)
//                && position[0][2].getTag() == null ? false : position[0][2].getTag().equals(player)) {
//            return true;
//        }
        if (checkSeed(position[0][0]) && checkSeed(position[0][1]) && checkSeed(position[0][2])) {
            return true;
        } else if (checkSeed(position[1][0]) && checkSeed(position[1][1]) && checkSeed(position[1][2])) {
            return true;
        } else if (checkSeed(position[2][0]) && checkSeed(position[2][1]) && checkSeed(position[2][2])) {
            return true;
        } else if (checkSeed(position[0][0]) && checkSeed(position[1][1]) && checkSeed(position[2][2])) {
            return true;
        } else if (checkSeed(position[2][0]) && checkSeed(position[1][1]) && checkSeed(position[0][2])) {
            return true;
        }
        return false;
    }

    private boolean checkSeed(ImageButton imageButton){
        try {
            if (imageButton.getTag().equals(player)) {
                return true;
            }
        }
        catch (Exception ex){

        }
        return false;
    }

    @Override
    public void onClick(View view) {
        ImageButton imageButton = (ImageButton) view;
        if (imageButton.getTag() == null) {
            move(imageButton);
        } else {
            Toast.makeText(MultiPlayerActivity.this, "Invalid Move", Toast.LENGTH_SHORT).show();
        }
    }
}
