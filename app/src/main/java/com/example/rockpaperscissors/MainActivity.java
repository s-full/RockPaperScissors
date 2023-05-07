package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.color.utilities.Score;


public class MainActivity extends AppCompatActivity {

    Button btnRockP1, btnPaperP1, btnScissorsP1, btnRockP2, btnPaperP2, btnScissorsP2, playAgain;
    TextView tvResult, tvScore1, tvScore2;

    ImageView p1choice, p2choice;

    private int currentPlayer = 1;
    private int player1Choice = -1;
    private int player2Choice = -1;
    private int player1Score = 0;
    private int player2Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAgain = findViewById(R.id.button_playagain);
        playAgain.setVisibility(View.INVISIBLE);

        p1choice = findViewById(R.id.P1_image);
        p1choice.setVisibility(View.INVISIBLE);
        p2choice = findViewById(R.id.P2_image);
        p2choice.setVisibility(View.INVISIBLE);

        btnRockP1 = findViewById(R.id.btnRock1);
        btnPaperP1 = findViewById(R.id.btnPaper1);
        btnScissorsP1 = findViewById(R.id.btnScissors1);
        btnRockP2 = findViewById(R.id.btnRock2);
        btnPaperP2 = findViewById(R.id.btnPaper2);
        btnScissorsP2 = findViewById(R.id.btnScissors2);
        tvResult = findViewById(R.id.tvResult);
        tvScore1 = findViewById(R.id.tvScore1);
        tvScore2 = findViewById(R.id.tvScore2);

        tvScore1.setText(String.valueOf(player1Score));
        tvScore2.setText(String.valueOf(player2Score));

        player1Turn();

    }

    private void player1Turn() {
//        p1choice.setVisibility(View.INVISIBLE);
//        p2choice.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        tvResult.setText(R.string.P1_Turn);
        disableButtonsForPlayer(2);
        enableButtonsForPlayer(1);
        currentPlayer = 1;
        btnRockP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlayer == 1) {
                    player1Choice = 0;
                    p1choice.setImageResource(R.drawable.rock);
                    player2Turn();;
                }
            }
        });

        btnPaperP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlayer == 1) {
                    player1Choice = 1;
                    p1choice.setImageResource(R.drawable.paper);
                    player2Turn();;
                }
            }
        });

        btnScissorsP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlayer == 1) {
                    player1Choice = 2;
                    p1choice.setImageResource(R.drawable.scissors);
                    player2Turn();;
                }
            }

        });

    }

    private void disableButtonsForPlayer(int i) {

        if (i == 1) {
            btnRockP1.setEnabled(false);
            btnRockP1.setAlpha(0.5f);
            btnRockP1.setTextColor(getResources().getColor(R.color.disabled_text_color));

            btnPaperP1.setEnabled(false);
            btnPaperP1.setAlpha(0.5f);
            btnPaperP1.setTextColor(getResources().getColor(R.color.disabled_text_color));

            btnScissorsP1.setEnabled(false);
            btnScissorsP1.setAlpha(0.5f);
            btnScissorsP1.setTextColor(getResources().getColor(R.color.disabled_text_color));
        }
        else {
            btnRockP2.setEnabled(false);
            btnRockP2.setAlpha(0.5f);
            btnRockP2.setTextColor(getResources().getColor(R.color.disabled_text_color));

            btnPaperP2.setEnabled(false);
            btnPaperP2.setAlpha(0.5f);
            btnPaperP2.setTextColor(getResources().getColor(R.color.disabled_text_color));

            btnScissorsP2.setEnabled(false);
            btnScissorsP2.setAlpha(0.5f);
            btnScissorsP2.setTextColor(getResources().getColor(R.color.disabled_text_color));
        }
    }

//    private void switchPlayers() {
//        currentPlayer = 2;
//        disableButtonsForPlayer(1);
//        enableButtonsForPlayer(2);
//        tvResult.setText(R.string.P2_Turn);
//        player2Turn();
//
//    }

    private void player2Turn() {
        tvResult.setText(R.string.P2_Turn);
        disableButtonsForPlayer(1);
        enableButtonsForPlayer(2);
        currentPlayer = 2;
        btnRockP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlayer == 2) {
                    player2Choice = 0;
                    p2choice.setImageResource(R.drawable.rock);
                    checkWinner();
                }
            }
        });

        btnPaperP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlayer == 2) {
                    player2Choice = 1;
                    p2choice.setImageResource(R.drawable.paper);
                    checkWinner();
                }
            }
        });

        btnScissorsP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlayer == 2) {
                    player2Choice = 2;
                    p2choice.setImageResource(R.drawable.scissors);
                    checkWinner();
                }
            }
        });
    }

    private void enableButtonsForPlayer(int i) {
        if (i == 1) {
            btnRockP1.setEnabled(true);
            btnRockP1.setAlpha(1f);
            btnRockP1.setTextColor(getResources().getColor(R.color.enabled_text_color));

            btnPaperP1.setEnabled(true);
            btnPaperP1.setAlpha(1f);
            btnPaperP1.setTextColor(getResources().getColor(R.color.enabled_text_color));

            btnScissorsP1.setEnabled(true);
            btnScissorsP1.setAlpha(1f);
            btnScissorsP1.setTextColor(getResources().getColor(R.color.enabled_text_color));
        }
        else {
            btnRockP2.setEnabled(true);
            btnRockP2.setAlpha(1f);
            btnRockP2.setTextColor(getResources().getColor(R.color.enabled_text_color));

            btnPaperP2.setEnabled(true);
            btnPaperP2.setAlpha(1f);
            btnPaperP2.setTextColor(getResources().getColor(R.color.enabled_text_color));

            btnScissorsP2.setEnabled(true);
            btnScissorsP2.setAlpha(1f);
            btnScissorsP2.setTextColor(getResources().getColor(R.color.enabled_text_color));
        }
    }

    private void checkWinner() {
        if (player1Choice != -1 && player2Choice != -1) {
            String[] choices = {"Rock", "Paper", "Scissors"};

            String result;
            Animation p1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            Animation p2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            p1choice.setAnimation(p1);
            p2choice.setAnimation(p2);
            p1.start();
            p2.start();
            p1choice.setVisibility(View.VISIBLE);
            p2choice.setVisibility(View.VISIBLE);

            if (player1Choice == player2Choice) {
                result = "Tie!";
            } else if (player1Choice == 0 && player2Choice == 2 ||
                    player1Choice == 1 && player2Choice == 0 ||
                    player1Choice == 2 && player2Choice == 1) {
                result = "Player 1 wins!";
                player1Score++;
            } else {
                result = "Player 2 wins!";
                player2Score++;
            }

            // Update the text views for the result and scores
            tvResult.setText(result);
            tvScore1.setText(String.valueOf(player1Score));
            tvScore2.setText(String.valueOf(player2Score));

            // Reset the choices to -1 for the next round
            player1Choice = -1;
            player2Choice = -1;

            resetState();
        }
    }

    private void resetState() {
        player1Choice = -1;
        player2Choice = -1;
        disableButtonsForPlayer(1);
        disableButtonsForPlayer(2);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player1Turn();
                p1choice.setVisibility(View.INVISIBLE);
                p2choice.setVisibility(View.INVISIBLE);
            }
        });
    }
}