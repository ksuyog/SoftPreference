package matcher;

import reader.StandardFields;
import reader.Transaction;

public class PatternMatcher {

	public StandardFields fields;
	public String match(Transaction transaction) {
		/* start with material types */
	String matchedCat = "NO_MATCH";
		if(!transaction.getMateType().equals("") && !transaction.getMateType().equals(" ")) {
			
			String mType = transaction.getMateType();
			/* All categories containing mat type as "f" */
			if(mType.equals("f")) {
				matchedCat = FmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("n")) {
				matchedCat = NmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("i")) {
				matchedCat = ImatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("o")) {
				matchedCat = OmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("j")) {
				return fields.CD;
			}else if(mType.equals("g")) {
				matchedCat = GmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("d")) {
				matchedCat = DmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("p")) {
				return fields.PICT_BOOKS;
			}else if(mType.equals("s")) {
				return fields.EASY_READER;
			}else if(mType.equals("b")) {
				matchedCat = BmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("m")) {
				matchedCat = MmatchLoc(transaction.getLocation(),transaction.getCallNumber());
			}else if(mType.equals("l")) {
				return fields.LARGE_TYPE;
			}
			
			
		}
	return matchedCat;
}
	private String MmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
		else {
			if(location.equals(fields.jvg))
				return fields.KID_VIDEO_GAME;
			else
				return fields.TEEN_VIDEO_GAME;
		}
	}
	private String BmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
			
		if(location.equals(fields.jbio) || location.equals(fields.bjbio)) {
			return fields.YOUTH_BIO;
		}
		
		return matchCat;
	}

	private String DmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
		else {
			if(location.equals(fields.advv)) {
				return fields.TV_SHOWS_DVD;
			}
			if(location.equals(fields.advdn) || location.equals(fields.badvn) || location.equals(fields.jdvdn) || location.equals(fields.bjdvn)) {
				return fields.NONFICTION_FILMS_DVD;
			}
			if(!location.equals(fields.advdn) && !location.equals(fields.badvn) && !location.equals(fields.jdvdn) && !location.equals(fields.bjdvn) && !location.equals(fields.advv)) {
				return fields.MOVIES_DVD;
			}
			return fields.YOUTH_MOVIES_DVD;
		}
	}
	
	private String GmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
		else {
			if(location.equals(fields.abdv)) {
				return fields.TV_SHOWS_BLUERAY;
			}
			if(location.startsWith("bjb") || location.startsWith("jb")) {
				return fields.YOUTH_MOVIES_BLUERAY;
			}
			return fields.MOVIES_BLUERAY;
		}
	}

	private String OmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
		else {
			if(location.equals(fields.aucg) || location.equals(fields.baucg)) {
				return fields.TEEN_GRAPH_NOVEL;
			}
			return fields.GRAPHIC_NOVEL;
		}
	}
	
	private String ImatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
		else {
			if(location.equals(fields.acdf) || location.equals(fields.jcdf)) {
				return fields.AUDIOBOOK_FIC;
			}
			return fields.AUDIOBOOK_NONFIC;
		}
	}
	
	private String NmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
			return matchCat;
		}
		else {
			if(location.equals(fields.bjnf) || location.equals(fields.jnf)) {
				return fields.YOUTH_NON_FICTION;
			}
			return fields.NONFICTION;
		}
	}
	
	private String FmatchLoc(String location, String callNumber) {
		// TODO Auto-generated method stub
		String matchCat = "NO_MATCH";
		if(location.equals("") || location.equals(" " )) {
				return matchCat;
		}	
		else {
			if(location.equals(fields.amys) || location.equals(fields.bamys)) {
				if(callNumber.startsWith("mystery"))
					return fields.MYSTERY;
			}
			if(location.equals(fields.apbr) || location.equals(fields.bapbr) || location.equals(fields.arom) || location.equals(fields.brom)) {
				if(callNumber.startsWith("romance"))
					return fields.ROMANCE;
			}
			if(location.equals(fields.bapbs) || location.equals(fields.apbs) || location.equals(fields.bascf) || location.equals(fields.ascf)) {
				if(callNumber.startsWith("science"))
					return fields.SCI_FICTION;
			}
			if(location.equals(fields.jfic) || location.equals(fields.bjfic)) {
					return fields.YOUTH_FICTION;
			}
			if(location.equals(fields.jfjh)) {
					return fields.JUNIOR_HIGH_FICTION;
			}
			if(location.equals(fields.baucf)) {
					return fields.TEEN_FICTION;
			}
			return fields.FICTION;
		}
	}		
	
 
	
	
	
	
}
