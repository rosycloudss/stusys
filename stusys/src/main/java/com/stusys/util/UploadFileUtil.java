package com.stusys.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileUtil {

	/**
	 * 保存文件
	 * 
	 * @param path
	 * @param fileByte
	 * @return
	 */
	public boolean saveFile(String path, HttpServletRequest request) {
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()) {
			// 创建目录
			file.mkdir();
		}
		try {
			// 创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload();
			// 设置编码
			upload.setHeaderEncoding("UTF-8");
			// 判断提交上来的数据是否上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				return false;
			}

			List<FileItem> fileItemList;
			fileItemList = upload.parseRequest(request);
			for (FileItem fileItem : fileItemList) {
				//如果fileItem中封装的是普通输入项的数据
				if(!fileItem.isFormField()) {
					InputStream in = fileItem.getInputStream();
					FileOutputStream out = new FileOutputStream(path);
					byte[] buffer = new byte[1024];
					int len = 0;
					while((len = in.read(buffer)) > 0) {
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					fileItem.delete();
					return true;
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
