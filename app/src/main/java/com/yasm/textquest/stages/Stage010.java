package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage010 extends Stage {

    public Stage010() {
        super(false,
                2,
                "Надо подкрепиться.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage011();
    }
}
