package com.yc.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class FileUploadFiles {

	private String allowedFilesList = "gif,jpg,png,bmp";
	private String deniedFilesList = "jsp,asp,php,aspx,html,htm,exe,bat,js,py,sh";
	private long singleFileSize = 20 * 1024 * 1024;
	private long totalMaxFileSize = 5 * singleFileSize;
	// 将来在页面上 <img src="" />访问 路径，是一个相对路径
	private String dirName = "../upload/"; // upload\1.png
	
	private DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public FileUploadFiles() {
	}

	public Map<String, String> uploadFiles(PageContext pageContext) throws ServletException, IOException, SQLException, SmartUploadException {
		Map<String, String> result = new HashMap<String, String>();
		SmartUpload su = new SmartUpload();
		su.setCharset("utf-8");
		su.initialize(pageContext); // 页面初始化

		// 定义允许上传文件类型
		su.setAllowedFilesList(allowedFilesList);
		// 不允许上传文件类型
		su.setDeniedFilesList(deniedFilesList);
		// 单个文件最大限制
		su.setMaxFileSize(singleFileSize);
		// 所有上传文件的总容量限制
		su.setTotalMaxFileSize(totalMaxFileSize);
		su.upload();

		// 取出jspsmartupload中的request对象，以取出 uname, message
		com.jspsmart.upload.Request req = su.getRequest();
		Enumeration<String> enu = req.getParameterNames();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			result.put(key, req.getParameter(key));
		}

		String relativepath = "";
		if (su.getFiles().getCount() > 0) {
			Files files = su.getFiles();
			int count = files.getCount();

			for (int i = 0; i < count; i++) {
				// 获取单个上传文件
				com.jspsmart.upload.File file = files.getFile(i);
				
				
				String oldname=file.getFileName();
				String newname=df.format(new Date())+"."+ file.getFileExt();

				relativepath = dirName + newname; // ...webapp/upload/xxx.jpg

				// 设置文件在服务器的保存位置
				// 取出绝对路径:
				// 取tomcat下的webapp下的upload的绝对路径，以用于存图片
				String rootpath = pageContext.getRequest().getRealPath("/"); // webapp/talkroom/
				String filepath = rootpath + dirName; // webapp/talkroom/../upload/xxx.jpg
				java.io.File f = new java.io.File(filepath);
				if (f.exists() == false) {
					f.mkdirs();
				}
				String absolutepath = filepath +newname;
				// 文件另存为
				file.saveAs(absolutepath, SmartUpload.SAVE_PHYSICAL);

				// 将这个文件的信息存到 result中 键的规则是: 域名_relativepath
				// 域名_absolutepath
				result.put(file.getFieldName() + "_relativepath", relativepath);
				result.put(file.getFieldName() + "_absolutepath", absolutepath);
				result.put( file.getFieldName()+"_oldname" , oldname);
				result.put( file.getFieldName()+"_newname" , newname);
				
				
			}
		}

		return result;
	}

	public long getSingleFileSize() {
		return singleFileSize;
	}

	public void setSingleFileSize(long singleFileSize) {
		this.singleFileSize = singleFileSize;
	}

	public long getTotalMaxFileSize() {
		return totalMaxFileSize;
	}

	public void setTotalMaxFileSize(long totalMaxFileSize) {
		this.totalMaxFileSize = totalMaxFileSize;
	}

	public String getAllowedFilesList() {
		return allowedFilesList;
	}

	public void setAllowedFilesList(String allowedFilesList) {
		this.allowedFilesList = allowedFilesList;
	}

	public String getDeniedFilesList() {
		return deniedFilesList;
	}

	public void setDeniedFilesList(String deniedFilesList) {
		this.deniedFilesList = deniedFilesList;
	}

}
