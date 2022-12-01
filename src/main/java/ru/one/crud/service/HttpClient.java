package ru.one.crud.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Component
public class HttpClient {

    @Value("${service.tlv-converter-url}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<JsonNode> requestOrder(MultipartFile file) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        File outputFile = File.createTempFile(UUID.randomUUID().toString(), ".tmp");
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            outputStream.write(file.getBytes());
        }
        FileSystemResource resource = new FileSystemResource(outputFile);
        MultiValueMap<String, Object> multiPartRequest = new LinkedMultiValueMap<>() {{
            add("file", resource);
        }};
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multiPartRequest, httpHeaders);
        ResponseEntity<JsonNode> responseOutput = restTemplate.postForEntity(url + "/api/convert", requestEntity, JsonNode.class);
        outputFile.delete();
        return responseOutput;

    }
}
