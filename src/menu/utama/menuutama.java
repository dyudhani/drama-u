package menu.utama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class menuutama extends Activity {
    /** Called when the activity is first created. */
	LinearLayout to_romance,to_comedy,to_fantasy;
	TextView menu;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        to_romance = (LinearLayout) findViewById(R.id.to_romance);
        to_comedy = (LinearLayout) findViewById(R.id.to_comedy);
        to_fantasy = (LinearLayout) findViewById(R.id.to_fantasy);
        
        menu = (TextView)findViewById(R.id.menu);
        
        menu.setOnClickListener(
        		new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(menuutama.this, sidebar.class);
						startActivity(i);
						overridePendingTransition(R.anim.keluarkanan, R.anim.keluarkiri);
					}
				});
        
        to_romance.setOnClickListener(
        		new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(menuutama.this, list_romance.class);
						startActivity(i);
					}
				}
        );
        
        to_comedy.setOnClickListener(
        		new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(menuutama.this, list_comedy.class);
						startActivity(i);
					}
				}
        );
        
        to_fantasy.setOnClickListener(
        		new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(menuutama.this, list_fantasy.class);
						startActivity(i);
					}
				}
        );
    }
}