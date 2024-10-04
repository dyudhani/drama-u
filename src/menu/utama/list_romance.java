package menu.utama;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class list_romance extends ListActivity {

	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb = null;
	SimpleAdapter daftarromance;
	
	SQLiteDatabase db;
	database drama;
	Cursor cursor;
	
	String ip_web;
	TextView menur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_romance);
		
		menur = (TextView)findViewById(R.id.menur);
		menur.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(list_romance.this, sidebar.class);
						startActivity(i);
						overridePendingTransition(R.anim.keluarkanan, R.anim.keluarkiri);
					}
				});
		
		drama = new database(this);
		db = drama.getWritableDatabase();
		drama.create_table_ip(db);
		cursor = db.rawQuery("SELECT * FROM ip", null);
		
		while (cursor.moveToNext()) {
			ip_web = cursor.getString(1);
		}
		
		ArrayList<NameValuePair> nameValuePairs = 
			new ArrayList<NameValuePair>();
		
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost =
				new HttpPost("http://"+ip_web+ "/rpl1_02/list_romance.php");
			httppost.setEntity
			(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("log_log","Error http connection"+e.toString());
		}
		
		try {
			BufferedReader reader = new BufferedReader
			(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine()+ "\n");
			String line="0";
			while ((line = reader.readLine()) != null)
			{
				sb.append(line+"\n");
			}
			is.close();
			result=sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("log_log", "Error convert result" + e.toString());
		}
		filldata();
		registerForContextMenu(getListView());
	}
	
	private void filldata(){
		List<romance> dataromance = getData();
		daftarromance = new SimpleAdapter(this, (List<? extends Map<String, ?>>) dataromance, 
				R.layout.datalistromance, new String[] {
				romance.KEYid_drama,romance.KEYnama},
				new int[] { R.id.tidromance, R.id.tnamaromance});
		setListAdapter(daftarromance);
	}
	
	private List<romance> getData()
	{
		List<romance> lromance = new ArrayList<romance>();
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i=0;i<jArray.length();i++)
			{
				json_data = jArray.getJSONObject(i);
				lromance.add(new romance
						(json_data.getString("id_drama"), 
						json_data.getString("nama")));
				

			}
		}
		catch(JSONException el)
		{
			Log.e("log_log", "Error JSONException"+el.toString());
		}
		catch (ParseException e2)
		{
			Log.e("log_tag", "Error ParseException"+e2.toString());
		}
		return lromance;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		HashMap<String, Object> obj = (HashMap<String, Object>) daftarromance.getItem(position);
		String result= (String) obj.get("strnama");
		Toast.makeText(getApplicationContext(), result,
				Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this, detailromance.class);
		i.putExtra("nama", result);
		startActivity(i);
	}
}
