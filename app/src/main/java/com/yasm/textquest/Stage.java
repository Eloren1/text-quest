package com.yasm.textquest;

import android.app.Activity;
import android.content.Context;

public class Stage {
    protected Stage nextStage1;
    protected Stage nextStage2;
    protected Stage nextStage3;
    protected boolean isQuestion;
    public int BackgroundId;
    public String MainText;
    public String Bt1Text;
    public String Bt2Text;
    public String Bt3Text;

    public Stage(boolean isQuestion, int BackgroundId, String MainText) {
        // Для Stage с isQuestion = false (т.е. для текста)
        this.isQuestion = isQuestion;
        this.BackgroundId = BackgroundId;
        this.MainText = MainText;
    }

    public Stage(boolean isQuestion, int BackgroundId, String MainText,
                 String Bt1Text, String Bt2Text, String Bt3Text) {
        // Для Stage с isQuestion = true (т.е. вопроса)
        this.isQuestion = isQuestion;
        this.BackgroundId = BackgroundId;
        this.MainText = MainText;
        this.Bt1Text = Bt1Text;
        this.Bt2Text = Bt2Text;
        this.Bt3Text = Bt3Text;
    }

    public void ButtonClicked(int btId, Context context) {
        GameActivity activity = (GameActivity) context;
        SetNext();
        if (nextStage1 == null) { activity.MainMenu(); }
        if (isQuestion) {
            if (btId == 1) activity.GoNextStage(nextStage1);
            if (btId == 2) activity.GoNextStage(nextStage2);
            if (btId == 3) activity.GoNextStage(nextStage3);
        } else {
            activity.GoNextStage(nextStage1);
        }
    }

    public void SetNext() {}
}
