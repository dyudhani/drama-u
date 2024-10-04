package menu.utama;

import java.util.HashMap;

public class romance extends HashMap<Object, Object>{
	private static final long seriaalversionUID = 128724731;
	
	public String id_drama;
	public String nama;
	
	public static String KEYid_drama="strid";
	public static String KEYnama="strnama";
	
	public romance(String strid,String strnama){
		this.id_drama=strid;
		
		this.nama=strnama;
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		
		if(KEYid_drama.equals(key)){
			return id_drama;
		}
		
		else if(KEYnama.equals(key)){
			return nama;
		}
		
		return null;
	}
}
