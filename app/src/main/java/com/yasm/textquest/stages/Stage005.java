package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage005 extends Stage {

    public Stage005() {
        super(false,
                5,
                "...опять одни крипы в команде...");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage006();
    }
}
