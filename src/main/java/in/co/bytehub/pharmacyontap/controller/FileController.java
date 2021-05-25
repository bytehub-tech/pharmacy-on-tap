package in.co.bytehub.pharmacyontap.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("fileop")
public class FileController {

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)

    public ResponseEntity<Resource> download() throws IOException {

        String fileName = "download.txt";
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        fw.write("Hello India");
        fw.flush();
        fw.close();
        Resource resource = new FileSystemResource(file);
        System.out.println("resource.getURL() = " + resource.getURL());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
