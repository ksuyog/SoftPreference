package reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import matcher.PatternMatcher;

public class TransactionReader {

	public String transactionLine;
	public Transaction transaction;
	public Map<String,Record> recordMap;
	
	public TransactionReader() {
		this.transactionLine = null;
		this.transaction = null;
		this.recordMap = null;
	}
	
	public void readTransaction(String transaction) {
		this.transactionLine = transaction;
		if(!this.transactionLine.equals("") && !this.transactionLine.equals("")) {
			this.transaction = new Transaction();
		}
		
		String[] transactionValues = this.transactionLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",-1); 
		if(transactionValues.length==7) {
			this.transaction.setRecordNumber(transactionValues[0]);
			this.transaction.setOutDate(transactionValues[1]);
			this.transaction.setLocation(transactionValues[2]);
			this.transaction.setMateType(transactionValues[3]);
			this.transaction.setOutLoc(transactionValues[4]);
			this.transaction.setCallNumber(transactionValues[5]);
			this.transaction.setLang(transactionValues[6]);
		}else {
			System.out.println("This transaction does not have required values: ");
			System.out.println(transactionLine);
			return;
		}
		
		updateRecordValues();
		
	}

	public void updateRecordValues() {
		if(this.recordMap==null) {
			this.recordMap = new HashMap<String, Record>();
		}
		
		PatternMatcher matcher = new PatternMatcher();
		String matchedCategory = matcher.match(this.transaction);
		Record rec = null;
		if(this.recordMap.containsKey(this.transaction.getRecordNumber())) {
			rec = this.recordMap.get(this.transaction.getRecordNumber());
			
		}else {
			rec = new Record();
		}
			
		rec.setRecordNumber(this.transaction.getRecordNumber());
		if(matchedCategory!=null && !matchedCategory.equals("NO_MATCH")) {
			Map<String,Integer> categoryCountMap = rec.getCategoryCountMap(); 
			int currCount = categoryCountMap.get(matchedCategory);
			categoryCountMap.put(matchedCategory, currCount+1);
			rec.setCategoryCountMap(categoryCountMap);			
		}
		this.recordMap.put(this.transaction.getRecordNumber(), rec);
	}
}
