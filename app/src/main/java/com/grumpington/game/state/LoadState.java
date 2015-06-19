package com.grumpington.game.state;

import android.view.MotionEvent;

import com.grumpington.framework.util.Painter;
import com.grumpington.simpleandroidgdf.Assets;

/**
 * Created by Steinar on 17.06.2015.
 */
public class LoadState extends State {
    @Override
    public void init() {
        Assets.load();
    }

    @Override
    public void update(float delta) {
        setCurrentState(new MenuState());
    }

    @Override
    public void render(Painter g) {

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
