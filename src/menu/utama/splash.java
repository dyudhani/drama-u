package menu.utama;

import menu.utama.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		new CountDownTimer(3000, 100) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				menuUtama();
				finish();
			}
		}.start();
	}
	void menuUtama(){
		Intent i = new Intent(this, menuutama.class);
		startActivity(i);
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		TextView loading=(TextView) findViewById(R.id.load5);
		AnimationDrawable anim = (AnimationDrawable) loading.getBackground();
		anim.start();
		super.onWindowFocusChanged(hasFocus);
	}

}
