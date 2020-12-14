package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage103 extends Stage {

    public Stage103() {
        super(false,
                3,
                "*Ты уснул за комьютером, решая задания*");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage777();
    }
}
