package com.boxin.ims.modules.qrcode.common;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @author Jakemanse
 * 二维码生成工具类
 */
public class QRCodeUtils {
	
	
	public static boolean generateQRCodePNG(String content,String path,int width,int height){
		try {
			 	String picFormat = "png";
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
		content = "中新网3月27日电 华尔街日报网站昨日晚间援引金砖五国官员的话报道说，金砖五国同意创建一个应急基金，中国拟承担承担大部分出资。"+
"金砖五国包括巴西、俄罗斯、印度、中国和南非五国。"+
"报道说，金砖五国财长当地时间3月26日就创建1000亿美元应急基金方面正式迈出了第一步。该不愿透露姓名的消息人士说，五国央行应会把基金储备作为自己储备的一部分。他同时透露，中国拟出资410亿美元，巴西、俄罗斯和印度各出180亿美元，南非出资50亿美元。"+
"金砖五国在南非召开年度峰会期间，签署了发起应急基金的协议。基金资金将用于紧急情况，作为国际货币基金组织的替代选择。"+
 "报道援引另外一位消息人士的话说，各国可能需要一年左右时间通过相关立法，明年金砖五国在巴西重新聚首时可能会达成最终协议。"+
 "金砖五国官员还商讨成立一家开发银行为成员国项目融资，但有报道称各国对这一机构如何构建存在分歧。";
//		content = "";
//		List<String> lines = FileUtils.readFileByLine(new File("D:\\temp\\temp2.txt"));
//		for(String line : lines){
//			content += line;
//		}
		System.out.println("长度为"+content.length());
		generateQRCodePNG(content, path+"long_text", width, height);
		
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
