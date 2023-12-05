package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import project.spring.app.zcom.lib.util.FileUtil;



public class ErdAttList {

	public String inDir     = "C:/IO/IN/ERD/";
	public String outDir    = "C:/IO/OUT/ERD/";
	public String writeFile = outDir + "attList.txt";
	public TreeMap<String, String> map = new TreeMap<String, String>();
	
	public static void main(String[] args) {
		ErdAttList wordList = new ErdAttList();
		wordList.searchDir(wordList.inDir);
	}
	
	
	public ErdAttList() {
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
			String[] temp;
			int cnt = 0;
			
			while ( (line = bufferedReader.readLine()) != null ) {
				line = line.trim();
				
				temp = line.split(" ");
				
				for ( int j = 0; j < temp.length; j++ ) {
					System.out.println(temp[j]);
					map.put(temp[j], temp[j]);
					cnt++;
				}
			}
			
			Object[] mapkey = map.keySet().toArray();
			Arrays.sort(mapkey);
			
			for ( String key : map.keySet() ) {
				FileUtil.writeFileContinue(writeFile, map.get(key) + "\n");
			}
			
			bufferedReader.close();
			System.out.println(map.size());
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
}
