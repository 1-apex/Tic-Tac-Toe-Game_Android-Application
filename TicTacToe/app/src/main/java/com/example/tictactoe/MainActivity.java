package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0, p1 = 0, p2 = 0;
    private String ch = "X";

    private TextView p1_score, p2_score, winner;

    private Button zero_0, zero_1, zero_2, one_0, one_1, one_2, two_0, two_1, two_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1_score = findViewById(R.id.player_one_score);
        p2_score = findViewById(R.id.player_two_score);
        winner = findViewById(R.id.winner_banner);
        Button new_game = findViewById(R.id.restart);

        zero_0 = findViewById(R.id.zero_zero);
        zero_1 = findViewById(R.id.zero_one);
        zero_2 = findViewById(R.id.zero_two);
        one_0 = findViewById(R.id.one_zero);
        one_1 = findViewById(R.id.one_one);
        one_2 = findViewById(R.id.one_two);
        two_0 = findViewById(R.id.two_zero);
        two_1 = findViewById(R.id.two_one);
        two_2 = findViewById(R.id.two_two);

        set_null();

        zero_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(zero_0);
            }
        });
        zero_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(zero_1);
            }
        });
        zero_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(zero_2);
            }
        });
        one_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(one_0);
            }
        });
        one_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(one_1);
            }
        });
        one_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(one_2);
            }
        });
        two_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(two_0);
            }
        });
        two_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(two_1);
            }
        });
        two_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(two_2);
            }
        });
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_game();
            }
        });
    }

    private void setButton(Button button) {
        if (button.getText().toString().isEmpty()) {
            button.setText(ch);
            count++;
            check_winner();
            switch_player();
        }
    }

    private void switch_player() {
        if (ch.equals("O")) {
            ch = "X";
        } else {
            ch = "O";
        }
    }

    @SuppressLint("SetTextI18n")
    private void check_winner() {
        if (count >= 5) {
            if (check_row(zero_0, zero_1, zero_2) || check_row(one_0, one_1, one_2) ||
                    check_row(two_0, two_1, two_2) || check_row(zero_0, one_0, two_0) ||
                    check_row(zero_1, one_1, two_1) || check_row(zero_2, one_2, two_2) ||
                    check_row(zero_0, one_1, two_2) || check_row(zero_2, one_1, two_0)) {
                display_winner();
            }
            else if (count == 9) {
                winner.setText("Tie");
                disable_buttons();
                enable_buttons();
                clear_buttons();
                count = 0;
            }
        }
    }

    private boolean check_row(Button b1, Button b2, Button b3) {
        return b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()) && !b1.getText().toString().isEmpty();
    }

    private void set_null() {
        zero_0.setText(null);
        zero_1.setText(null);
        zero_2.setText(null);
        one_0.setText(null);
        one_1.setText(null);
        one_2.setText(null);
        two_0.setText(null);
        two_1.setText(null);
        two_2.setText(null);
        winner.setText(null);
    }

    @SuppressLint("SetTextI18n")
    private void display_winner()
    {
        if(ch.equals("X"))
        {
            winner.setText("Player 1 wins");
            p1++;
            p1_score.setText(String.valueOf(p1));
        }
        else
        {
            winner.setText("Player 2 wins");
            p2++;
            p2_score.setText(String.valueOf(p2));
        }
        count = 0;
        clear_buttons();
    }

    private void disable_buttons() {
        zero_0.setEnabled(false);
        zero_1.setEnabled(false);
        zero_2.setEnabled(false);
        one_0.setEnabled(false);
        one_1.setEnabled(false);
        one_2.setEnabled(false);
        two_0.setEnabled(false);
        two_1.setEnabled(false);
        two_2.setEnabled(false);
    }

    private void enable_buttons() {
        zero_0.setEnabled(true);
        zero_1.setEnabled(true);
        zero_2.setEnabled(true);
        one_0.setEnabled(true);
        one_1.setEnabled(true);
        one_2.setEnabled(true);
        two_0.setEnabled(true);
        two_1.setEnabled(true);
        two_2.setEnabled(true);
    }

    private void clear_buttons() {
        zero_0.setText(null);
        zero_1.setText(null);
        zero_2.setText(null);
        one_0.setText(null);
        one_1.setText(null);
        one_2.setText(null);
        two_0.setText(null);
        two_1.setText(null);
        two_2.setText(null);
    }

    private void reset_game() {
        clear_buttons();
        p1_score.setText(" ");
        p2_score.setText(" ");
        winner.setText(" ");
        p1 = 0;
        p2 = 0;
    }
}