package menu.utama;

import java.util.HashMap;

public class fantasy extends HashMap<Object, Object>{
	private static final long seriaalversionUID = 128724731;
	
	public String idfantasy;
	public String nama;
	
	public static String KEYfantasy="strid";
	public static String KEYnama="strnama";
	
	public fantasy(String strid,String strnama){
		this.idfantasy=strid;
		
		this.nama=strnama;
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		
		if(KEYfantasy.equals(key)){
			return idfantasy;
		}
		
		else if(KEYnama.equals(key)){
			return nama;
		}
		
		return null;
	}
}
