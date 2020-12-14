package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage006 extends Stage {

    public Stage006() {
        super(false,
                4,
                "Мда.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage007();
    }
}
