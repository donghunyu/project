package project.spring.app.zcom.lib.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtil {
    
    /*****************************************************************************
    *  파일삭제
    *****************************************************************************/
    public static void deleteFile(String realPath) {
        try {
            File file = new File(realPath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteFile(File file) {
        try {
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*****************************************************************************
    *  디렉토리 생성
    *****************************************************************************/
    public static void mkdir(String realPath) {
        try {
            File createDir = new File(realPath);
            if (!createDir.exists()) {
                createDir.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*****************************************************************************
    *  디렉토리 삭제
    *****************************************************************************/
    public static void deleteDir(String realPath) {
        try {
            File file = new File(realPath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*****************************************************************************
    *  디렉토리 파일 검색
    *****************************************************************************/
    public static enum CompareType {
    	NAME,
    	DATE
    }
    public static enum SortType {
    	ASC,
    	DESC
    }
    public static File[] searchDirFile(String path, final CompareType compareType, final SortType sortType) {
        
        File dir = new File(path);
        File[] fileList = dir.listFiles();
        if (fileList != null) {
            Arrays.sort(fileList, new Comparator<Object>() {

				@Override
				public int compare(Object o1, Object o2) {
					String s1 = "";
					String s2 = "";
					
					switch (compareType) {
					case NAME:
						
						switch (sortType) {
						case ASC:
							s1 = ((File) o1).getName();
							s2 = ((File) o2).getName();
							
							break;
							
						case DESC:
							s1 = ((File) o2).getName();
							s2 = ((File) o1).getName();
							
							break;

						default:
							break;
						}
						
						break;
						
					case DATE:
						
						switch (sortType) {
						case ASC:
							s1 = ((File) o1).lastModified() + "";
							s2 = ((File) o2).lastModified() + "";
							
							break;
							
						case DESC:
							s1 = ((File) o2).lastModified() + "";
							s2 = ((File) o1).lastModified() + "";
							
							break;

						default:
							break;
						}
						
						break;

					default:
						break;
					}
					
					return s1.compareTo(s2);
				}
            	
            });
        }
        
        return fileList;
    }
    
    
    public static File[] searchDirFullFile(String path, final CompareType compareType, final SortType sortType) {
    	
    	File dir = new File(path);
		File[] fileList = dir.listFiles();
      	File[] totalFileList = fileList;
		
		if ( fileList == null ) {
			return null;
		}
    	
		File[] tempFile;
		for ( int i = 0; i < fileList.length; i++ ) {
			if ( fileList[i].isDirectory() == true ) {
				tempFile = searchDirFile(fileList[i].getPath(), compareType, sortType);
				if ( tempFile == null ) {
					continue;
				}
				
				totalFileList = addArray(totalFileList, tempFile);
			}
		}
		
		return totalFileList;
    }
        
    /*****************************************************************************
    *  List 합치기
    *****************************************************************************/
    public static File[] addArray(File[] arrayTarger, File[] arrayAttact) {
      	if ( arrayTarger == null ) {
      		return arrayAttact;
      	}
      	if ( arrayAttact == null ) {
      		return arrayTarger;
      	}
      	 
      	File[] fileList = new File[arrayTarger.length + arrayAttact.length];
      	
      	for ( int i = 0; i < arrayTarger.length; i++ ) {
      		fileList[i] = arrayTarger[i];
      	}
      	
      	for ( int i = 0; i < arrayAttact.length; i++ ) {
      		fileList[arrayTarger.length + i] = arrayAttact[i];
      	}
      	
      	return fileList;
    }
    
    public static File getSerNumFile(String absoluteFileNm, String extension) {
    	int serNum = 0;
    	String s_serNum = "";
    	
    	File file = new File(absoluteFileNm + "." + extension);
    	if ( !file.exists() ) {
    		return file;
    	}
    	
    	do {
    		serNum++;
    		s_serNum = StringUtil.getLpad(Integer.toString(serNum), "0", 3);
    		file = new File(absoluteFileNm + "_" + s_serNum + "." + extension);
    	} while (file.exists());
    	
    	return file;
    }
    

    public static void writeFile(String fileName, String ctt) {
    	try {
    		writeFile(fileName, ctt, "UTF-8");
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    }

    public static void writeFile(String fileName, String ctt, String charSet) {
    	try {
//    		File file = new File(fileName);
//    		file.delete();
//    		
    		FileOutputStream fw = new FileOutputStream(fileName, false);
    		OutputStreamWriter writer = new OutputStreamWriter(fw, charSet);
    		BufferedWriter bw = new BufferedWriter(writer);
    		
    		bw.write(ctt);
    		bw.close();
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    }
    
    public static void writeFileContinue(String fileName, String ctt) {
    	try {
    		writeFileContinue(fileName, ctt, "UTF-8");
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    }

    public static void writeFileContinue(String fileName, String ctt, String charSet) {
    	try {
    		FileOutputStream fw = new FileOutputStream(fileName, true);
    		OutputStreamWriter writer = new OutputStreamWriter(fw, charSet);
    		BufferedWriter bw = new BufferedWriter(writer);
    		
    		bw.write(ctt);
    		bw.close();
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    }
    
    
    
    
    
    /**
     * 파일생성
     */
    public static void createNewFile(String dirPath, String fileName) {
        mkdir(dirPath);
        
        File file = new File(dirPath + fileName);
        createNewFile(file);

    }
    
    public static void createNewFile(File file) {
        if(! file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static File getFile(String dirPath, String fileName) {
        File file = new File(dirPath + fileName);
        mkdir(dirPath);
        createNewFile(file);
        return file;
    }
}
