package io.github.xiaoxuetu.debughelper;

import androidx.appcompat.app.AppCompatActivity;
import io.github.xiaoxuetu.debughelper.util.DeveloperModeHelper;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DebugHelper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DeveloperModeHelper.DeveloperMode developerMode = DeveloperModeHelper.getDeveloperMode();
        Log.i(TAG, "developer mode is " + developerMode);
    }
}