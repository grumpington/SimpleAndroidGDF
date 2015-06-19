package com.grumpington.simpleandroidgdf;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.AssetManager;

/**
 * Created by Steinar on 17.06.2015.
 */
public class GameMainActivity extends Activity {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 450;
    public static GameView sGame;
    public static AssetManager assets;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        assets = getAssets();
        sGame = new GameView(this, GAME_WIDTH, GAME_HEIGHT);
        setContentView(sGame);
    }
}
