package hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
        
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity download() throws IOException {
        String filePath = "http://www.isai.online/4256s5f46ht4he4r6/2016/Bairavaa/Azhagiya Soodana Poovey.mp3";
        InputStream inputStream = new FileInputStream(new File(filePath));
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(Files.size(Paths.get(filePath)));
        return new ResponseEntity(inputStreamResource, headers, HttpStatus.OK);
    }
    
    
    
}
