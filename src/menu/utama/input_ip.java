package menu.utama;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class input_ip extends Activity {
	EditText input_ip;
	Button	kirim_ip;
	SQLiteDatabase db;
	database drama;
	Cursor cursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_ip);
		
		drama = new database(this);
		db = drama.getWritableDatabase();
		drama.create_table_ip(db);
		cursor = db.rawQuery("select * from ip", null);
		
		kirim_ip = (Button) findViewById(R.id.kirim_ip);
		input_ip = (EditText) findViewById(R.id.input_ip);
		
		
		kirim_ip.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						db.execSQL("INSERT INTO ip VALUES(null, '"+input_ip.getText().toString()+"')");
						Intent i = new Intent(getApplicationContext(),splash.class);
						startActivity(i);
					}
				}
		);
		
	}
}
