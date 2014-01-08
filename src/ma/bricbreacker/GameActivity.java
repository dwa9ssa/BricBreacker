package ma.bricbreacker;

import ma.bricbreacker.game.BarreBalle;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class GameActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        
        Bundle extras = getIntent().getExtras();
        
        initialize(new BarreBalle(extras.getInt("margeBarre"), extras.getInt("margeBrique"), extras.getInt("nbrBrique"), extras.getInt("initialSpeed")), cfg);
    }
}