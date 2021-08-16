package com.manhcode.rest.jaxrs.attachment;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;

@Path("/fileService")
@Service
public class FileService {


	private static final String FILE_PATH = "E:\\IntelliJ Project\\20.spring-rest-jax-rs - attachment\\upload\\1.jpg";

	@POST
	@Path("/upload")
	public void upload(List<Attachment> attachments) {
		for (Attachment attachment: attachments) {
			try {
				copyFile(attachment.getDataHandler().getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@GET
	@Path("/dowload")  // http://localhost:8080/services/fileService/dowload can dowload by this URI
	public Response dowload() {
		File file = new File(FILE_PATH);
		Response.ResponseBuilder builder = Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=dowloaded.jpg");
		return builder.build();
	}

	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();	
	}

}