package com.grumpington.game.state;

import android.view.MotionEvent;

import com.grumpington.framework.util.Painter;
import com.grumpington.simpleandroidgdf.GameMainActivity;

/**
 * Created by Steinar on 17.06.2015.
 */
public abstract class State {

    public void setCurrentState(State newState){
        GameMainActivity.sGame.setCurrentState(newState);
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Painter g);

    public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);
}
