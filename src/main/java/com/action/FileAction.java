package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Namespace("/FileAction")
@ParentPackage("struts-default")
public class FileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<File> file;// 上传文件对象
	private List<String> fileFileName;// 上传文件名
	private List<String> fileContentType;// 上传文件内容类型

	/**
	 * 处理文件上传的Action
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action(value = "fileUpload", results = { @Result(name = "success", location = "/queryAllFile",type="redirectAction") })
	public String fileUpload() throws IOException {
		String realPath = ServletActionContext.getServletContext().getRealPath("/file");
		if (file.size() > 0) {
			File destFile = new File(realPath);
			if (!destFile.exists()) {
				destFile.mkdir();
			}
			for (int i = 0; i < file.size(); i++) {
				FileUtils.copyFile(file.get(i), new File(destFile, fileFileName.get(i)));
			}
		}
		return SUCCESS;
	}

	/**
	 * 处理文件下载的Action
	 * 
	 * @return
	 */
	private String[] downloadFileNameList;//file文件夹下的所有文件的名称
	private String filename;//下载文件的名称
	private String Path;//指定下载文件的路径
	private String contentType;//指定下载文件的类型
	private long contentLength;//指定下载文件的长度
	private String contentDisposition;//下载文件的方式，并指定保存文件的文件名
	private InputStream inputStream;//指定文件读数据流
	@Action(value = "queryAllFile", results = { @Result(name = "success", location = "/pages/file.jsp") })
	public String queryAllFile() throws IOException {

		File file = new File(ServletActionContext.getServletContext().getRealPath("/file"));
		downloadFileNameList = file.list();
		ActionContext.getContext().getValueStack().set("downloadFileNameList", downloadFileNameList);
		return SUCCESS;
	}
	
	@Action(value = "fileDownload"
			, results = { @Result(name="success",type="stream",
			params= {
					"contentType","application/octet-stream",
//					"contentDisposition","attachment;filename=\"${filename}\"",
//					"filename","${filename}",
//					"inputPath","${inputPath}",
//					"inputStream","${stream}",
					}
	) })
	public String fileDownload() throws IOException {
//		contentType = "application/octet-stream";//不能在这里直接设置，只能在reuslt的参数中设置，不然不会下载文件而是直接显示文件
		String name = URLEncoder.encode(filename, "UTF-8"); 
		contentDisposition = "attachment;filename=" + name;
		Path = ServletActionContext.getServletContext().getRealPath("/file") + "\\" + filename;
		inputStream = new FileInputStream(Path);
		return SUCCESS;
	}

	
	
	
	
	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getDownloadFileNameList() {
		return downloadFileNameList;
	}

	public void setDownloadFileNameList(String[] downloadFileNameList) {
		this.downloadFileNameList = downloadFileNameList;
	}

	

	public String getContentType() {
		return contentType;
	}

	

	public long getContentLength() {
		return contentLength;
	}

	

	public String getContentDisposition() {
		return contentDisposition;
	}


	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}


	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return Path;
	}

	public void setInputPath(String Path) {
		this.Path = Path;
	}

	

	



	
}
