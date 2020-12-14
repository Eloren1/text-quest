package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage008 extends Stage {

    public Stage008() {
        super(false,
                3,
                "Начну с понедельника, а сейчас — спать.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage777();
    }
}
