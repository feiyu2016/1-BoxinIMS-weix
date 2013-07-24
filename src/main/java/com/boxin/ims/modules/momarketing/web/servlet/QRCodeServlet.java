package com.boxin.ims.modules.momarketing.web.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boxin.ims.modules.momarketing.common.ProjectUtils;
import com.boxin.ims.modules.momarketing.entity.QRCode;

public class QRCodeServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		String qrcodeId = req.getParameter("qrcodeId");
		String type = req.getParameter("action");	//v:查看   d:下载
		String fileName = req.getParameter("fn");
		
		QRCode qrCode = 	ProjectUtils.getQRCodeById(Long.parseLong(qrcodeId));
		req.setAttribute("qrCode", qrCode);
		
		String filepath = qrCode.getJpegPath()+".jpeg";
		File file = new File(filepath);
		if("d".equals(type)){	//下载图片
			try {
				String fname = file.getName();
				if(fileName!=null ){
					fname=fileName+".jpg";
				}
				
				 resp.setHeader("Location",file.getName());
				 resp.setHeader("Cache-Control", "max-age=" + 100000);
				 resp.setHeader("Content-Disposition", "attachment; filename=" + fname); //filename应该是编码后的(utf-8)
				 resp.setContentType("image/jpeg");//定义输出类型
				 resp.setContentLength((int)file.length());
				 OutputStream outputStream = resp.getOutputStream();
				 InputStream inputStream = new FileInputStream(file);
				 byte[] buffer = new byte[1024];
				 int i = -1;
				 while ((i = inputStream.read(buffer)) != -1) {
				  outputStream.write(buffer, 0, i);
				 }
				 outputStream.flush();
				 outputStream.close();
				 inputStream.close();
				 outputStream = null;
				 
				 return ;
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}else{//查看
			BufferedImage image = 	ImageIO.read(file);
			OutputStream out = resp.getOutputStream();
			ImageIO.write(image, "JPEG", out);
			out.flush();
			out.close();
				
		}
		
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
