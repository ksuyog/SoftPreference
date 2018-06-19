package reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
	private String recordNumber;
	private String preference;
	private Map<String,Integer> categoryCountMap;
	private List<Transaction> transactions;
	
	public Record() {
		this.recordNumber = "";
		this.preference = null;
		this.categoryCountMap = null;
		this.transactions = null;
	}
	
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public Map<String, Integer> getCategoryCountMap() {
		if(categoryCountMap==null) {
			categoryCountMap = new HashMap<String, Integer>();
			StandardFields f = new StandardFields();
			categoryCountMap.put(f.FICTION, 0);
			categoryCountMap.put(f.NONFICTION, 0);
			categoryCountMap.put(f.MYSTERY, 0);
			categoryCountMap.put(f.ROMANCE, 0);
			categoryCountMap.put(f.SCI_FICTION, 0);
			categoryCountMap.put(f.AUDIOBOOK_FIC, 0);
			categoryCountMap.put(f.AUDIOBOOK_NONFIC, 0);
			categoryCountMap.put(f.LARGE_TYPE, 0);
			categoryCountMap.put(f.GRAPHIC_NOVEL, 0);
			categoryCountMap.put(f.TEEN_GRAPH_NOVEL, 0);
			categoryCountMap.put(f.CD, 0);
			categoryCountMap.put(f.MOVIES_BLUERAY, 0);
			categoryCountMap.put(f.MOVIES_DVD, 0);
			categoryCountMap.put(f.NONFICTION_FILMS_DVD, 0);
			categoryCountMap.put(f.TV_SHOWS_DVD, 0);
			categoryCountMap.put(f.TV_SHOWS_BLUERAY, 0);
			categoryCountMap.put(f.PICT_BOOKS, 0);
			categoryCountMap.put(f.EASY_READER, 0);
			categoryCountMap.put(f.YOUTH_FICTION, 0);
			categoryCountMap.put(f.YOUTH_NON_FICTION, 0);
			categoryCountMap.put(f.YOUTH_BIO, 0);
			categoryCountMap.put(f.TEEN_FICTION,0);
			categoryCountMap.put(f.JUNIOR_HIGH_FICTION, 0);
			categoryCountMap.put(f.KID_VIDEO_GAME, 0);
			categoryCountMap.put(f.TEEN_VIDEO_GAME, 0);
			categoryCountMap.put(f.YOUTH_MOVIES_BLUERAY, 0);
			categoryCountMap.put(f.YOUTH_MOVIES_DVD, 0);
		}
		
		
		return categoryCountMap;
	}
	public void setCategoryCountMap(Map<String, Integer> categoryCountMap) {
		this.categoryCountMap = categoryCountMap;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
