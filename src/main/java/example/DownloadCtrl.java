package example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

@RestController
public class DownloadCtrl {
    @RequestMapping("/dl")
    public ResponseEntity<StreamingResponseBody> dl2 () {
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("Content-Disposition", "attachment; filename=whatever.txt");         respHeaders.add("Content-Type", "text/plain");
        StreamingResponseBody responseBody = new StreamingResponseBody() {
            @Override
            public void writeTo (OutputStream out) throws IOException {
                for (int i = 0; i < 10000; i++) {
                    out.write((Integer.toString(i) + " - ")
                            .getBytes());
                    out.flush();
//                    try {
//                        Thread.sleep(5);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }
            }
        };
        return ResponseEntity.ok().headers(respHeaders).body(responseBody);
    }
}
