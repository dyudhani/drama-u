package menu.utama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class sidebar extends Activity {

	LinearLayout back,to_main,to_romance,to_comedy,to_fantasy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sidebar);
		
		back = (LinearLayout)findViewById(R.id.back);
		to_main = (LinearLayout) findViewById(R.id.to_main);
		to_romance = (LinearLayout) findViewById(R.id.to_romance);
		to_comedy = (LinearLayout) findViewById(R.id.to_comedy);
		to_fantasy = (LinearLayout) findViewById(R.id.to_fantasy);
		
		back.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						finish();
						overridePendingTransition(R.anim.masukkiri, R.anim.keluarkiri);
					}
				});
		
		to_main.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(sidebar.this, menuutama.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);
					}
				});
		
		to_romance.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(sidebar.this, list_romance.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);
					}
				});
		
		to_comedy.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(sidebar.this, list_comedy.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);
					}
				});
		
		to_fantasy.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(sidebar.this, list_fantasy.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);
					}
				});
	}

}
