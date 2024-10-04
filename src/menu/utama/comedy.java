package menu.utama;

import java.util.HashMap;

public class comedy extends HashMap<Object, Object>{
	private static final long seriaalversionUID = 128724731;
	
	public String idcomedy;
	public String nama;
	
	public static String KEYcomedy="strid";
	public static String KEYnama="strnama";
	
	public comedy(String strid,String strnama){
		this.idcomedy=strid;
		
		this.nama=strnama;
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		
		if(KEYcomedy.equals(key)){
			return idcomedy;
		}
		
		else if(KEYnama.equals(key)){
			return nama;
		}
		
		return null;
	}
}
