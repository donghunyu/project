package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

import project.spring.app.zcom.lib.util.FileUtil;
import project.spring.app.zcom.lib.util.StringUtil;



public class WordList {

	public String inDir     = "C:/IO/IN/DB/";
	public String outDir    = "C:/IO/OUT/DB/";
	public String writeFile = outDir + "wordList.txt";
	public HashMap<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		WordList wordList = new WordList();
		wordList.searchDir(wordList.inDir);
	}
	
	
	public WordList() {
		FileUtil.mkdir(outDir);
	}
	
	public void searchDir(String dirPath) {
		File dir = new File(dirPath);
		
		if ( !dir.exists() ) return;
		if ( !dir.isDirectory() ) return;
		
		File[] fileList = dir.listFiles();
		for ( int i = 0; i < fileList.length; i++ ) {
			System.out.println(fileList[i].getPath());
			if ( fileList[i].isDirectory() ) {
				searchDir(fileList[i].getPath());
			}
			
			workFile(fileList[i]);
		}
	}
	
	
	public void workFile(File file) {
		try {
			System.out.println(file.getName());
			
			if ( file.isDirectory() ) return;
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = "";
			int cnt = 0;
			String[] temp;
			
			while ( (line = bufferedReader.readLine()) != null ) {
				line = line.trim();
				if ( line.length() < 5 ) continue;
				if ( line.indexOf("DROP") > -1 ) continue;
				if ( line.indexOf("CREATE") > -1 ) continue;
				line = line.substring(0, line.indexOf(" "));
				
				temp = line.split("_");
				
				for ( int j = 0; j < temp.length; j++ ) {
					System.out.println(temp[j]);
					map.put(temp[j], temp[j]);
				}
			}
			
			Iterator<String> iterator = map.keySet().iterator(); 
			String key;
			while ( iterator.hasNext() ) {
				key = iterator.next();
				cnt++;
				FileUtil.writeFileContinue(writeFile, key + "\n");
			}
			
			bufferedReader.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
}
