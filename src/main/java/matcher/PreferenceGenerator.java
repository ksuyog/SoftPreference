package matcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import reader.Record;
import reader.StandardFields;

public class PreferenceGenerator {

	public String catName;
	public Map<String,Record> recordMap;
	
	public PreferenceGenerator() {
	
	}
	
	public String GeneratePref(String patron, Record rec) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append(rec.getRecordNumber());
		//sb.append(",");
		boolean[] preference = null;
		if(preference == null) {
			preference = new boolean[27];
			for(int i=0;i<preference.length;i++) {
				preference[i] = false;
			}
		}
		//StandardFields f = new StandardFields();
		Map<String, Integer> categoryMap = rec.getCategoryCountMap();
		for(Entry<String,Integer> ent:categoryMap.entrySet()) {
		
			switch(ent.getKey()) {
			
			case "Fiction":
				if(ent.getValue()>25)
					preference[0] = true;
				
				break;
			case "Nonfiction":
				if(ent.getValue()>20)
					preference[1] = true;
				
				break;
			case "MYSTERY":
				if(ent.getValue()>5)
					preference[2] = true;
				
				break;
			case "ROMANCE":
				if(ent.getValue()>5)
					preference[3] = true;
				
				break;
			case "SCIENCE FICTION":
				if(ent.getValue()>5)
					preference[4] = true;
				
				break;
			case "AUDIOBOOKS: FICTION":
				if(ent.getValue()>17)
					preference[5] = true;
				
				break;
			case "AUDIOBOOKS: NONFICTION":
				if(ent.getValue()>15)
					preference[6] = true;
				
				break;
			case "LARGE_TYPE":
				if(ent.getValue()>16)
					preference[7] = true;
				
				break;
			case "GRAPHIC NOVELS":
				if(ent.getValue()>18)
					preference[8] = true;
				
				break;
			case "TEEN GRAPHIC NOVELS AND MANGA":
				if(ent.getValue()>18)
					preference[9] = true;
				
				break;
			case "CDs":
				if(ent.getValue()>22)
					preference[10] = true;
				
				break;
			case "MOVIES (BLU-RAY)":
				if(ent.getValue()>23)
					preference[11] = true;
				
				break;
			case "MOVIES (DVD)":
				if(ent.getValue()>40)
					preference[12] = true;
				
				break;
			case "NONFICTION FILMS (DVD)":
				if(ent.getValue()>12)
					preference[13] = true;
				
				break;
			case "TV SHOWS (DVD)":
				if(ent.getValue()>20)
					preference[14] = true;
				
				break;
			case "TV SHOWS (BLUE-RAY)":
				if(ent.getValue()>5)
					preference[15] = true;
				
				break;
			case "PICTURE BOOKS":
				if(ent.getValue()>31)
					preference[16] = true;
				
				break;
			case "EASY READERS":
				if(ent.getValue()>27)
					preference[17] = true;
				
				break;
			case "YOUTH FICTION":
				if(ent.getValue()>17)
					preference[18] = true;
				
				break;
			case "YOUTH NONFICTION":
				if(ent.getValue()>16)
					preference[19] = true;
				
				break;
			case "YOUTH BIOGRAPHIES":
				if(ent.getValue()>5)
					preference[20] = true;
				
				break;
			case "TEEN FICTION":
				if(ent.getValue()>5)
					preference[21] = true;
				
				break;
			case "JUNIOR HIGH FICTION":
				if(ent.getValue()>15)
					preference[22] = true;
				
				break;
			case "KIDS VIDEO GAMES":
				if(ent.getValue()>14)
					preference[23] = true;
				
				break;
			case "TEEN VIDEO GAMES":
				if(ent.getValue()>10)
					preference[24] = true;
				
				break;
			case "YOUTH MOVIES (BLUE-RAY)":
				if(ent.getValue()>10)
					preference[25] = true;
				
				break;
			case "YOUTH MOVIES (DVD)":
				if(ent.getValue()>5)
					preference[26] = true;
				
				break;
				
			default:
				break;
			
			}
			
		}
		
		for(int j=0;j<preference.length;j++) {
			sb.append(",");
			if(preference[j]==true)
				sb.append("1");
			else
				sb.append("0");
		}
		
		return sb.toString();
		
	}
	
	/*public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }*/
	
}
