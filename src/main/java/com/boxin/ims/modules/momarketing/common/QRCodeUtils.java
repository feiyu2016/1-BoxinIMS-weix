package com.boxin.ims.modules.momarketing.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.DateUtils;

/**
 * @author Jakemanse
 * 二维码生成工具类
 */
public class QRCodeUtils {
	
	public   static final String QRCODE_URL_PRIX = "http://www.hdzhx.com/zxims/servlet/qrc?qrcodeId=";
	private static final String  QRCODE_URL_GIFT_PRIX = "http://www.hdzhx.com/zxims/";
	
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
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-1  下午2:47:12
	 * @function <p>  Base Path  即  http://localhost:80/zxims</p>
	 * @param basePath
	 * @param ecardId
	 * @return
	 */
	public static String generateEcardURL(String basePath, Long ecardId){
		return basePath  + Global.MOBILE_ECARD_PATH +"/"+ecardId+Global.URL_SUFFIX;
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-28  上午2:06:29
	 * @function <p> 生成礼物的URL如：http://www.hdzhx.com/zxims/f/gift/5.html </p>
	 * @param giftId
	 * @return
	 */
	public static String generateGiftURL(Long giftId){
		
		return Global.DNS + Global.CONTEXT_PATH + Global.MOBILE_GIFT_PATH +"/"+giftId+Global.URL_SUFFIX;
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-24  上午11:36:57
	 * @function <p> 解析二维码  </p>
	 * @param file
	 * @return
	 */
	public static String decode(File file){
		try {
			String imgPath = "D:\\temp\\QRCode\\1367552294529.png";
//			File file = new File(imgPath);
			BufferedImage image;
			try {
				image = ImageIO.read(file);
				if (image == null) {
					System.out.println("Could not decode image");
				}
				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
						source));
				Result result;
				Hashtable hints = new Hashtable();
				hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
				// 解码设置编码方式为：utf-8，
				result = new MultiFormatReader().decode(bitmap, hints);
				String resultStr = result.getText();
				System.out.println("解析后内容：" + resultStr);
				return resultStr;
			} catch (IOException ioe) {
				System.out.println(ioe.toString());
			} catch (ReaderException re) {
				System.out.println(re.toString());
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
		return null;
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
	
	
	
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-22  上午11:37:26
	 * @function <p> 优惠券 序列号 </p>
	 * @param userId
	 * @return
	 */
	public static String  generateSN(Long userId){
		
		
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int number = random.nextInt(100);
		String strNumber = (number<10) ? "0"+number : ""+number;
		sb.append("ZHX").append(userId).append(System.currentTimeMillis()+strNumber);
		return sb.toString();
		
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-23  下午11:50:16
	 * @function <p> 二维码的下载路径 </p>
	 * @param qrCodeId
	 * @return
	 */
	public static String getQRCodeURL(Long qrCodeId){
		return QRCODE_URL_PRIX+qrCodeId;
	}

}
