package com.grumpington.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.provider.MediaStore;

/**
 * Created by Steinar on 17.06.2015.
 */
public class Assets {
    private static SoundPool soundPool;
    public static Bitmap welcome;

    public static void load(){
        welcome = loadBitmap("welcome.png", false);
    }

    private static Bitmap loadBitmap(String filename, boolean transparency){
        InputStream inputStream = null;
        try {
            inputStream = GameMainActivity.assets.open(filename);
        } catch (IOException e){
            e.printStackTrace();
        }
        Options options = new Options();
        if (transparency){
            options.inPreferredConfig = Config.ARGB_8888;
        }else{
            options.inPreferredConfig = Config.RGB_565;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        return bitmap;
    }

    private static int loadSound(String filename){
        int soundID = 0;
        if (soundPool == null){
            soundPool = buildSoundPool();
        }
        try{
            soundID = soundPool.load(GameMainActivity.assets.openFd(filename),1);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return soundID;
    }

    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static SoundPool buildSoundPool(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(25)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        return soundPool;
    }

    public static void playSound(int soundID){
        if (soundPool != null){
            soundPool.play(soundID, 1, 1, 1, 0, 1);
        }
    }
}
