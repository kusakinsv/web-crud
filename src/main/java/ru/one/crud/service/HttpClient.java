package ru.one.crud.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ru.one.crud.entity.Book;

import javax.xml.crypto.OctetStreamData;
import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

@Component
public class HttpClient {

    @Value("${service.tlv-converter-url}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> requestOrder(MultipartFile file) throws IOException {
        System.out.println("Файл принят");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
//        byte[] bytes = file.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
        InputStreamSource s = new InputStreamResource(inputStream);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byteArrayOutputStream.writeBytes(file.getBytes());
        File outputFile = File.createTempFile(UUID.randomUUID().toString(), ".bin");
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            outputStream.write(file.getBytes());
        }

//        File file1 = outputFile;
//        FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file1.toPath()), false, file.getName(), (int) file1.length(), file1.getParentFile());
//        try {
//
//             IOUtils.copy(new FileInputStream(file1), fileItem.getOutputStream());
//        } catch (IOException ex) {
//            // do something.
//        }
//        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//        OctetStreamData octetStreamData = new OctetStreamData(inputStream);

//        File tempfile = File.createTempFile(UUID.randomUUID().toString(), ".tmp");
        FileSystemResource resource = new FileSystemResource(outputFile);

        MultiValueMap<String, Object> multiPartRequest = new LinkedMultiValueMap<>() {{
            add("file", resource);
        }};
//        HttpEntity<MultipartFile> requestEntity = new HttpEntity<>(file, httpHeaders);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multiPartRequest, httpHeaders);

        url = "http://localhost:8280/api/convert";
        System.out.println(url);
//        ResponseEntity<?> responseOutput = restTemplate.exchange(url + "/api/convert", HttpMethod.POST, requestEntity, JsonNode.class);
        ResponseEntity<?> responseOutput = restTemplate.postForEntity(url, requestEntity, String.class);
        System.out.println(responseOutput);
        System.out.println("Отправлено");
        return responseOutput;

    }
}
