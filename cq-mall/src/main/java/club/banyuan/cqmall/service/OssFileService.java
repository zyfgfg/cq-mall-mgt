package club.banyuan.cqmall.service;

import java.io.IOException;
import java.io.InputStream;

public interface OssFileService {
    public String upload(String objectName, InputStream inputStream, String contentType) throws IOException;

    public String delete(String objectName);
}
