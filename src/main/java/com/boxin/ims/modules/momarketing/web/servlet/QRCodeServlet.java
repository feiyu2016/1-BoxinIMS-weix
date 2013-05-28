package com.boxin.ims.modules.momarketing.web.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

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
		
		QRCode qrCode = 	ProjectUtils.getQRCodeById(Long.parseLong(qrcodeId));
		String filepath = qrCode.getJpegPath()+".jpeg";
		File file = new File(filepath);
		BufferedImage image = 	ImageIO.read(file);
		OutputStream out = resp.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
