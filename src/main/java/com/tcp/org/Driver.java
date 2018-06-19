package com.tcp.org;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Map.Entry;

import matcher.PreferenceGenerator;
import reader.Record;
import reader.TransactionReader;

public class Driver {

	
	
	
	
	public static void main(String[] args) {
		File inputFile = null;
		File outFile = null;
		System.out.println("Enter input file:");
		Scanner sc = new Scanner(System.in);
		
		
		inputFile = new File(sc.nextLine());
		outFile = new File("Out_" + inputFile.getName());
		/*if(args.length==1) {
			inputFile = new File(args[0]);
			outFile = new File("Out_" + args[0]);
			
		}else{
			System.err.println("Invalid arguments count:" + args.length);
			System.exit(0);
		}*/
		
		if(!inputFile.exists()) {
			System.out.println("Input file does not exist..");
			System.exit(0);
		}
		
		BufferedReader readBuffer = null;
		BufferedWriter writeBuffer = null;
		FileOutputStream fos = null;
		
		String headerLine = "";
		String transaction = "";
		try {
			fos = new FileOutputStream(outFile);
			writeBuffer = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
			readBuffer = new BufferedReader(new FileReader(inputFile));
			// First line should contain headers
			headerLine = readBuffer.readLine();
			
			TransactionReader reader = new TransactionReader();
			while((transaction = readBuffer.readLine())!=null) {
				reader.readTransaction(transaction);
			}
			
			PreferenceGenerator prefGenerator = new PreferenceGenerator();
			int i = 0;
			
			StringBuilder sb = new StringBuilder();
			sb.append("ID,Fiction,Nonfiction,MYSTERY,ROMANCE,SCIENCE FICTION,AUDIOBOOKS: FICTION,AUDIOBOOKS: NONFICTION,LARGE_TYPE,GRAPHIC NOVELS,TEEN GRAPHIC NOVELS AND MANGA,CDs,MOVIES (BLU-RAY),MOVIES (DVD),");
			sb.append("NONFICTION FILMS (DVD),TV SHOWS (DVD),TV SHOWS (BLUE-RAY),PICTURE BOOKS,EASY READERS,YOUTH FICTION,YOUTH NONFICTION,YOUTH BIOGRAPHIES,TEEN FICTION,JUNIOR HIGH FICTION,KIDS VIDEO GAMES,");
			sb.append("TEEN VIDEO GAMES,YOUTH MOVIES (BLUE-RAY),YOUTH MOVIES (DVD)");
			writeBuffer.write(sb.toString());
			writeBuffer.newLine();
			
			for(Entry<String, Record> entry:reader.recordMap.entrySet()) {	
				String patron = entry.getKey();
				Record rec = entry.getValue();
				String outLine = prefGenerator.GeneratePref(patron,rec);
				if(outLine!=null) {
					writeBuffer.write(outLine);
					writeBuffer.newLine();
				}
			}

				
		}catch(IOException e) {
			System.out.println("IOException in reading TempFile..");	
			e.printStackTrace();
		}finally {
			try {
				readBuffer.close();
				writeBuffer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
}
