package com.boxin.ims.modules.momarketing.common;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.thinkgem.jeesite.common.config.Global;

/**
 * @author Jakemanse
 * 二维码生成工具类
 */
public class QRCodeUtils {
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-5-28  下午2:08:18
	 * @function <p> 生成png 图片 </p>
	 * @param content
	 * @param path
	 * @param width
	 * @param height
	 * @return
	 */
	public static boolean generateQRCodePNG(String content,String path,int width,int height){
		return generateQRCode("png",content,path,width,height);
	}
	
	public static boolean generateQRCodeJPEG(String content,String path,int width,int height){
		return generateQRCode("jpeg",content,path,width,height);
	}
	
	
	
	
	private  static boolean   generateQRCode(String picType,String content,String path,int width,int height){
		try {
		 	String picFormat = picType;
            File file = new File(path + "." + picFormat);
           // String str = new String(content.getBytes("GBK"), "ISO-8859-1");
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToFile(bitMatrix, picFormat, file);
            
            return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return false;
	}
	
	
	public static void main(String[] args) {
		String content = "Content ";
		String path = "D:\\temp\\QRCode\\";
		int width = 200;
		int height = 200;
//		for(int i=0;i<10;i++){
//			String str = content +i;
//			String filepath = path + "testqrcode-"+i+".png";
//			generateQRCodePNG(str, filepath, width+(i*10), height+i);
//		}
		content = "http://192.168.1.102:8080/jeesite/f/mobsite/mom/pro/1.html";
//		content = "";
//		List<String> lines = FileUtils.readFileByLine(new File("D:\\temp\\temp2.txt"));
//		for(String line : lines){
//			content += line;
//		}
		System.out.println("长度为"+content.length());
		generateQRCodePNG(content, path+"long_text", width, height);
		
	}
	
	
	
	public static String generateURL(Long projectId){
		return Global.DNS_TEMP + Global.MOBILE_SITE_PATH+"/mom/pro/"+projectId+".html";
	}
	
	
	public void encode(String contents, String imgPath, int width, int height) {  
        Hashtable  hints = new Hashtable<Object, Object>();  
        // 指定纠错等级  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
        // 指定编码格式  
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");  
        try { 
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);  
            MatrixToImageWriter  
                    .writeToFile(bitMatrix, "png", new File(imgPath));  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

}
