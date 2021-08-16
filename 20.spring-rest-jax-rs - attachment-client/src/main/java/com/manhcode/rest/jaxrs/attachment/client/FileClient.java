package com.manhcode.rest.jaxrs.attachment.client;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileClient {
    public static void main(String[] args) throws FileNotFoundException {
        upload();
    }

    public static void upload() throws FileNotFoundException {
        WebClient client = WebClient.create("http://localhost:8080/services/fileService/upload");
        client.type("multipart/form-data");

        ContentDisposition cd = new ContentDisposition("attachment;filename=hi.JPG");

        Attachment attachment = new Attachment("root",
                new FileInputStream(new File("E:\\hi.JPG")), cd);

        client.post(attachment);
    }

}
