package project.spring.app.zcom.lib.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Thumbnail {
	String sourceImage = "C:/Users/sjh/Downloads/family_1280.jpg";
	String thumbImage  = "C:/Users/sjh/Downloads/thumbnail_family_1280.jpg";
	
	public static void main(String[] agrs) {
		Thumbnail thumbnail = new Thumbnail();
		thumbnail.makeThumbnail();
	}
	
	
	public Thumbnail() {
		
	}
	
	public void makeThumbnail() {
		try {
			// 저장된 원본파일로부터 BufferedImage 객체를 생성합니다. 
			BufferedImage sourceImageFile = ImageIO.read(new File(sourceImage)); 
			
			// 썸네일의 너비와 높이 입니다. 
			int thumbWidth  = 250;
			int thumbHeight = 150; 
			
			// 원본 이미지의 너비와 높이 입니다. 
			int sourceWidth  = sourceImageFile.getWidth(); 
			int sourceHeight = sourceImageFile.getHeight(); 
			
			// 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다. 
			
			// 
			BufferedImage thumbImageFile = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_3BYTE_BGR); 
			Graphics2D graphic = thumbImageFile.createGraphics();
			
			Image image = sourceImageFile.getScaledInstance(thumbWidth, thumbHeight, Image.SCALE_SMOOTH);
			graphic.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
			graphic.dispose();
		
			ImageIO.write(thumbImageFile, "jpg", new File(thumbImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
