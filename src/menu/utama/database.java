package menu.utama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

	public database(Context context) {
		super(context, "drama", null, 1);
		// TODO Auto-generated constructor stub
	}
	
	public void create_table_ip(SQLiteDatabase db){
		db.execSQL(" CREATE TABLE if not exists ip ("+
				"_id integer primary key autoincrement,"+
				"ip text"+
				" )");
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
