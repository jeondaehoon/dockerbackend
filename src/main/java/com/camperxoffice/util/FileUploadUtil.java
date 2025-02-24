package com.camperxoffice.util;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.tika.Tika;
//import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.vo.common.FileVO;

public class FileUploadUtil {
	
	/** logger **/
	private static Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

	public static void uploadFormFile(FileVO vo) {
		//MultipartFile formFile, String realPath, String resizePath, String filename, int width, int height
		File dirFile = new File(vo.getOriginPath());
		
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		File file = new File(vo.getOriginPath(), vo.getFileNm());
		
		
		//vo.setFileNm(fileNm);
		//file = createUniqueFile(file);
		
		try {
			
			// 파일 용량 구하기(byte)
	        long fileSize = vo.getFile().getSize();
			/** [정수] byte, short, int, long    [실수] double, float **/
			double bytes = fileSize; //file.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			double gigabytes = (megabytes / 1024);
			double terabytes = (gigabytes / 1024);
			double petabytes = (terabytes / 1024);
			double exabytes = (petabytes / 1024);
			double zettabytes = (exabytes / 1024);
			@SuppressWarnings("unused")
			double yottabytes = (zettabytes / 1024);
			
			//if ( bytes > 1 ) { // for test
			if ( megabytes > Constant.UPLOAD_FILE_MAX_SIZE ) {
				throw new IOException(Constant.UPLOAD_FILE_MAX_OVER );
				//return Constant.UPLOAD_FILE_MAX_OVER ;
			}
			 
			vo.getFile().transferTo(file);
			
			//이미지일 경우 resize
			if(isImageFile(file.getAbsolutePath())) {
				vo.setOriginPath(file.getAbsolutePath());
				vo.setFileNm(file.getName());
				//resizeFile(vo);
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if ( logger.isDebugEnabled() ) {
			logger.debug("#### file.getName (" + file.getName() + ") ...");
		}
		
    } 
	
	private static File createUniqueFile(File f) {
		if ( logger.isDebugEnabled() ) {
			logger.debug("#### FileUploadUtil.createUniqueFile ...");
			logger.debug("#### f.exists (" + f.exists() + ") ...");
		}
		
		if (!f.exists()) {
			return f;
		}
		String filename = f.getName();
		int dot = filename.lastIndexOf('.');
		
		System.out.println("FILE PATH : "+f.getParent());
		
		if (dot == -1) { //확장자가 없으면
			filename = appendNumber(filename);
			return createUniqueFile(new File(f.getParent(), filename));
		} else {
			String name = filename.substring(0, dot);
			String ext = filename.substring(dot);
			name = appendNumber(name);
			return createUniqueFile(new File(f.getParent(), name + ext));
		}
	}
	
	/**
	 * 이름 뒤에 숫자를 붙인다. 숫자가 존재하는 경우 1증가 시킨다.
	 * 예) temp => temp1
	 * temp1 => temp2  
	 * 
	 * @param name 이름
	 * @return
	 */
	private static String appendNumber(String name) {
		int i;
		for (i = name.length()-1; i >= 0; i--) {
			char c = name.charAt(i);
			if (c < '0' || c > '9') {
				break;
			}
		}
		i += 1;
		if (i == name.length()) { //뒤에 숫자가 없으면
			name = name + 1;
		} else {
			String txtPart = name.substring(0,i);
			String numPart = name.substring(i);
			try {
				name = txtPart + (Integer.parseInt(numPart) + 1);
			} catch (NumberFormatException nfe) {
				name = txtPart + numPart + "_1";
			}
		}
		return name;
	}
	
	/**
	 * 파일 이름에 부모 디렉토리 경로가 포함되었는지 검사.
	 * 파일이름이 '/'로 시작하거나, '../' 나 '..\'이 포함되어 있는지 검사한다.
	 * 
	 * @param filename
	 * @return 부모디렉토리 경로가 포함되어 있으면 true, 경로가 포함 안 되어 있으면 false.
	 */
	public static boolean isIncludeParentDirectory(String filename) {
		if (filename == null) {
			return false;
		}
		if (filename.startsWith("/") ||
			filename.indexOf("../") != -1 ||
			filename.indexOf("..\\") != -1) {
			return true;
		} else {
			return false;
		}	
	}
	
	
	// File 크기 조정하여 menu 폴더에 등록.
	public static void resizeFile(FileVO vo) {
        
		if(vo.getFormat()==null || "".equals(vo.getFormat())) {
			vo.setFormat("jpg");	// 새 이미지 포맷. jpg, gif 등
		}
		if(vo.getWidth()==0) {
			vo.setWidth(600);	// 변경 할 넓이
		}
		if(vo.getHeight()==0) {
			vo.setHeight(600); // 변경 할 높이
		}
		
		if(vo.getPosition()==null || "".contentEquals(vo.getPosition())) {
			vo.setPosition("H");	// W:넓이중심, H:높이중심, X:설정한 수치로(비율무시)
		}
        
        Image image;
        int imageWidth;
        int imageHeight;
        double ratio;
        int w;
        int h;
 
        try{
        	//폴더 생성
        	File dirFile = new File(vo.getApplyPath());
    		
    		if (!dirFile.exists()) {
    			dirFile.mkdirs();
    		}
    		
    		vo.setApplyPath(vo.getApplyPath()+"/"+vo.getFileNm());
    		
            // 원본 이미지 가져오기
            image = ImageIO.read(new File(vo.getOriginPath()));
 
            // 원본 이미지 사이즈 가져오기
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);
 
            if(vo.getPosition().equals("W")){    // 넓이기준
 
                ratio = (double)vo.getWidth()/(double)imageWidth;
                w = (int)(imageWidth * ratio);
                h = (int)(imageHeight * ratio);
 
            }else if(vo.getPosition().equals("H")){ // 높이기준
 
                ratio = (double)vo.getHeight()/(double)imageHeight;
                w = (int)(imageWidth * ratio);
                h = (int)(imageHeight * ratio);
 
            }else{ //설정값 (비율무시)
 
                w = vo.getWidth();
                h = vo.getHeight();
            }
 
            // 이미지 리사이즈
            // Image.SCALE_DEFAULT : 기본 이미지 스케일링 알고리즘 사용
            // Image.SCALE_FAST    : 이미지 부드러움보다 속도 우선
            // Image.SCALE_REPLICATE : ReplicateScaleFilter 클래스로 구체화 된 이미지 크기 조절 알고리즘
            // Image.SCALE_SMOOTH  : 속도보다 이미지 부드러움을 우선
            // Image.SCALE_AREA_AVERAGING  : 평균 알고리즘 사용
            Image resizeImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
 
            // 새 이미지  저장하기
            BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = newImage.getGraphics();
            g.drawImage(resizeImage, 0, 0, null);
            g.dispose();
            ImageIO.write(newImage, vo.getFormat(), new File(vo.getApplyPath()));
 
        }catch (Exception e){
 
            e.printStackTrace();
 
        }
	}
	
	
	private static boolean isImageFile( String filePath ) throws Exception {
		
		final String[] PERMISSION_FILE_MIME_TYPE = {"image/gif", "image/jpeg", "image/png", "image/bmp"};
		
		if( !StringUtils.hasText(filePath) ) {
			return false;
		}
		
		File file = new File(filePath);
		
		if( !file.isFile() ) {
			return false;
		}
		
		String mimeType = new Tika().detect(file);
		boolean isPermisionFileMimeType = false;
		
		for( int i = 0; i < PERMISSION_FILE_MIME_TYPE.length; i++ ) {
			if( PERMISSION_FILE_MIME_TYPE[i].equals(mimeType) ) {
				isPermisionFileMimeType = true;
				break;
			}
		}
		
		return isPermisionFileMimeType;
		
	}
	
}
