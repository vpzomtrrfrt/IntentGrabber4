package xyz.dogeon.intentgrabber4;

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class IntentGrabber4Activity extends UnityPlayerActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        handleIntent();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        if(intent != null && intent.getDataString() != null) {
            UnityPlayer.UnitySendMessage("IntentReceiver", "ReceiveIntent", intent.getDataString());
        }
    }
}
