package project.spring.app.zcom.lib.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {
    
    public FileDownloadView() {
        
        super.setContentType("application/octet-stream");
        
    }
    
    @Override
    @SuppressWarnings({"rawtypes"})
    protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map map           = (Map)   model.get("downloadFile");
        File    filePath  = (File)    map.get("filePath");
        String  lgcFileNm = (String)  map.get("lgcFileNm");
        
        // 파일 존재 여부 확인.
        if (!filePath.exists() || !filePath.canRead()) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">alert('File Not Found'); history.back();</script>");
            return;
        }
        
        String userAgent = request.getHeader("User-Agent");
		if (userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
			lgcFileNm = URLEncoder.encode(lgcFileNm, "UTF-8").replaceAll("\\+", "\\ ");
		} else if (userAgent.indexOf("Trident") > -1) { // MS IE 11
			lgcFileNm = URLEncoder.encode(lgcFileNm, "UTF-8").replaceAll("\\+", "\\ ");
		} else { // 모질라나 오페라
			lgcFileNm = new String(lgcFileNm.getBytes("UTF-8"), "ISO-8859-1").replaceAll("\\+", "\\ ");
		}
        
        response.setHeader("Content-Disposition", "attachment; filename=\"" + lgcFileNm + "\";"); 
        response.setHeader("Content-Transfer-Encoding", "binary"); 
        response.setContentLength((int) filePath.length()); 
        response.setContentType(super.getContentType()); 
        response.setHeader("Connection", "close");

        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            FileCopyUtils.copy(fis, out);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                }
            }
            out.flush();
        }
        
    }
    
}
