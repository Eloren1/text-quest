package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage011 extends Stage {

    public Stage011() {
        super(false,
                2,
                "А в холодильнике-то пусто...");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage006();
    }
}
