package org.xatu.servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.xatu.util.Sample;


/**
 * Servlet implementation class FileServlet
 */
public class FileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        //真正上传照片
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//通过PrintWrite 对象，将分析的结果返回给前台AJAX
		PrintWriter out = response.getWriter();
		//设置表单类型 ； 包括文件类型的字段
		boolean isNultipart = ServletFileUpload.isMultipartContent(request);
		//设置上传的路径
		String uploadFilePath = "d://imgs";
		if(isNultipart){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items;
			String filePath="";
				items = upload.parseRequest(request);
			   Iterator<FileItem> iter = items.iterator();
			   while(iter.hasNext()){
				   //截取每一个照片
				   FileItem item = iter.next();
				   if(!item.isFormField()){
					   //获取文件名
					   String fileName = item.getName();
					   if(fileName != null && !fileName.equals("")){
						   File saveFile = new File(uploadFilePath,fileName);
						   filePath = saveFile.getPath();
						   //保存图片；
						   item.write(saveFile);
						   System.out.println("上传成功");
						   //人脸识别
						   Object result = Sample.faceRecognize(filePath);
						   System.out.println(result);
						   return;
						   
					   }
				   }
			   }
		}
		
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
