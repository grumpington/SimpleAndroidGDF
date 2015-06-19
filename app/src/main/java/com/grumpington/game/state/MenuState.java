package com.grumpington.game.state;

import android.view.MotionEvent;

import com.grumpington.framework.util.Painter;
import com.grumpington.simpleandroidgdf.Assets;

/**
 * Created by Steinar on 17.06.2015.
 */
public class MenuState extends State {
    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.welcome, 0, 0);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
