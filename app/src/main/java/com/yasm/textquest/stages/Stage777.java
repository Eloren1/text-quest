package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage777 extends Stage {

    public Stage777() {
        super(false,
                3,
                "Игра окончена.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = null;
    }
}
