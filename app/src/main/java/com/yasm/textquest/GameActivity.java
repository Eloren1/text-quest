package com.yasm.textquest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yasm.textquest.stages.Stage001;

public class GameActivity extends FragmentActivity {

    private Stage currentStage;
    private static final int bgCount = 6;
    private ImageView[] backgrounds = new ImageView[bgCount];
    private TypewriterView mainText;
    private Button bt0; // кнопка на весь экран, работает для текста
    private Button bt1; // кнопка выбора в вопросе
    private Button bt2; // кнопка выбора в вопросе
    private Button bt3; // кнопка выбора в вопросе
    private TextView hint;
    private boolean questionStarted = false;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        mainText = findViewById(R.id.mainText);
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        hint = findViewById(R.id.hint);

        backgrounds[0] = findViewById(R.id.bg1);
        backgrounds[1] = findViewById(R.id.bg2);
        backgrounds[2] = findViewById(R.id.bg3);
        backgrounds[3] = findViewById(R.id.bg4);
        backgrounds[4] = findViewById(R.id.bg5);
        backgrounds[5] = findViewById(R.id.bg6);

        bt1.setAlpha(0);
        bt2.setAlpha(0);
        bt3.setAlpha(0);
        hint.setAlpha(0);

        bt0.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (!mainText.isRunning)
                    currentStage.ButtonClicked(0, v.getContext());
            }
        });
        bt1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (!mainText.isRunning)
                    currentStage.ButtonClicked(1, v.getContext());
            }
        });
        bt2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (!mainText.isRunning)
                    currentStage.ButtonClicked(2, v.getContext());
            }
        });
        bt3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (!mainText.isRunning)
                    currentStage.ButtonClicked(3, v.getContext());
            }
        });

        if (!questionStarted) StartQuest();
    }

    private void StartQuest() {
        questionStarted = true;
        // Инициализация первого Stage
        ButtonClicked(-1);
    }

    private void ButtonClicked(int btId) {
        if (currentStage != null) {
            if (currentStage.isQuestion) {
                currentStage.ButtonClicked(btId, this.getApplicationContext());
            } else {
                currentStage.ButtonClicked(0, this.getApplicationContext());
            }
        } else {
            GoNextStage(new Stage001());
        }
    }

    public void GoNextStage(Stage nextStage) {
        currentStage = nextStage;
        hint.setAlpha(0);
        // Скрытие кнопок вопроса
        bt1.setAlpha(0);
        bt2.setAlpha(0);
        bt3.setAlpha(0);
        bt0.setClickable(true);

        // Изменение фона
        for (int c = 0; c < bgCount; c++) {
            backgrounds[c].setImageAlpha(0);
        }
        backgrounds[currentStage.BackgroundId].setImageAlpha(255);

        // Печатание текста
        mainText.setText("");
        mainText.pause(100)
                .type(currentStage.MainText).run(new Runnable() {
            @Override
            public void run() {
                mainText.setText(currentStage.MainText);
                if (!currentStage.isQuestion) {
                    hint.setAlpha(1);
                } else {
                    bt1.setAlpha(1);
                    bt2.setAlpha(1);
                    bt3.setAlpha(1);
                    bt0.setClickable(false);
                }
            }
        });

        // Текст кнопкам вопроса
        if (currentStage.isQuestion) {
            bt1.setText(String.valueOf(currentStage.Bt1Text));
            bt2.setText(String.valueOf(currentStage.Bt2Text));
            bt3.setText(String.valueOf(currentStage.Bt3Text));
        }
    }

    public void MainMenu() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}