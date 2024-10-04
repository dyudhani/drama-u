package menu.utama;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;

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

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class detailromance extends Activity {

	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb = null;
	
	SQLiteDatabase db;
	database drama;
	Cursor cursor;
	
	String ip_web,nama="0";
	TextView detailnama,detailtahun,detailjenis,deskripsi,rating,genre,cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detaildrama);
		
		cancel = (TextView)	findViewById(R.id.cancel);
		detailnama = (TextView) findViewById(R.id.detailnama);
		detailtahun = (TextView) findViewById(R.id.detailtahun);
		detailjenis = (TextView) findViewById(R.id.detailjenis);
		deskripsi = (TextView) findViewById(R.id.deskripsi);
		genre = (TextView) findViewById(R.id.genre);
		rating = (TextView) findViewById(R.id.rating);
		
		cancel.setOnClickListener(
				new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						finish();
					}
				});
		
		ArrayList<NameValuePair> nameValuePairs=
			new ArrayList<NameValuePair>();
		
		Bundle extras = getIntent().getExtras();
		if (extras!=null)
		{
			nama=extras.getString("nama");
		}
		Toast.makeText(getApplicationContext(), nama, Toast.LENGTH_SHORT).show();
		
		try
		{
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost =
				new HttpPost("http://10.0.2.2/rpl1_02/list_romance.php?nama="+URLEncoder.encode(nama,"UTF-8"));
			httppost.setEntity
			(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response=httpclient.execute(httppost);
			HttpEntity entity=response.getEntity();
			is=entity.getContent();
		}
		catch(Exception e){
			Log.e("log_tag", "Error http connection"+e.toString());
		}
		
		try
		{
			BufferedReader reader=new BufferedReader
			(new InputStreamReader(is,"iso-8859-1"));
			sb=new StringBuilder();
			sb.append(reader.readLine()+"\n");
			String line="0";
			
			while((line=reader.readLine())!=null){
				sb.append(line+"\n");
			}
			is.close();
			result=sb.toString();
			
		}
		catch(Exception e){
			Log.e("log_tag","Error convert result "+e.toString());
			
		}
		fillData();
	}
	
	public void fillData(){
		try{
			jArray=new JSONArray(result);
			JSONObject json_data=null;
			for(int i=0;i<jArray.length();i++){
				json_data=jArray.getJSONObject(i);
				detailnama.setText(json_data.getString("nama"));
				detailtahun.setText(json_data.getString("tahun"));
				detailjenis.setText(json_data.getString("jenis"));
				deskripsi.setText(json_data.getString("Deskripsi"));
				genre.setText(json_data.getString("genre"));
				rating.setText(json_data.getString("rating"));
			}
		}
		catch(JSONException e1){
			Log.e("log_tag","Error JSONException"+e1.toString());
		}
		catch(ParseException e2){
			Log.e("log_tag","Error JSONException"+e2.toString());
		}
	}	
}
