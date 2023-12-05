package project.spring.app.zcom.lib.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

    /**
     * 파일업로드
     */
    public static boolean uploadFormFileUuid(MultipartFile formFile, String realPath) {
        InputStream stream;
        
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String tempFileName = uuid;
        
        try {
            stream = formFile.getInputStream();
            
            OutputStream bos = new FileOutputStream(realPath + tempFileName);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.close();
            stream.close();
            
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * 파일업로드2 - 파일명변경안함.
     */
    public static String uploadFormFile(MultipartFile formFile, String realPath) {
        InputStream stream;
        String returnFileNm = null;
        
        String tempFileFullName = formFile.getOriginalFilename();                                    // 풀파일명
        if ( StringUtil.isNull(tempFileFullName) ) {
        	return null;
        }
        
        String tempFileName     = tempFileFullName.substring(0, tempFileFullName.lastIndexOf("."));      // 파일명
        String tempFileExtName  = tempFileFullName.substring(tempFileFullName.lastIndexOf(".") + 1);  // 확장자명
        
        // 업로드 폴더에 동일 파일명 있는지 확인
        File uploadedFile = new File(realPath + tempFileName + "." + tempFileExtName);
        int sufix = 1;
        while(uploadedFile.isFile()) {
            tempFileFullName = tempFileName + "_" + sufix + "." + tempFileExtName;
            uploadedFile = new File(realPath + tempFileFullName);
            sufix++;
        }
        
        try {
            stream = formFile.getInputStream();
            
            OutputStream bos = new FileOutputStream(realPath + tempFileFullName);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.close();
            stream.close();
            
            returnFileNm = tempFileFullName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return returnFileNm;
    }
}
