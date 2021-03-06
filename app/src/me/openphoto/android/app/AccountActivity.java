
package me.openphoto.android.app;

import me.openphoto.android.app.util.LoginUtils;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class AccountActivity extends Activity {

    private static final String TAG = AccountActivity.class.getSimpleName();

	BroadcastReceiver loginBroadcastReceiver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
		loginBroadcastReceiver = LoginUtils
				.getAndRegisterDestroyOnLoginActionBroadcastReceiver(TAG, this);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		unregisterReceiver(loginBroadcastReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_account, menu);
        return true;
    }

    public void accountSignupButtonAction(View view) {
        Log.d(TAG, "Start account signup button action");
        Intent intent = new Intent(this, AccountSignup.class);
        startActivity(intent);
    }

    public void accountLoginButtonAction(View view) {
        Log.d(TAG, "Start account login button action");
        Intent intent = new Intent(this, AccountLogin.class);
        startActivity(intent);
    }

	public void accountOwnServerButtonAction(View view)
	{
		Log.d(TAG, "Start own server button action");
		Intent intent = new Intent(this, SetupActivity.class);
		startActivity(intent);
	}

}
