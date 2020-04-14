package club.banyuan.cqmall.service.serviceImpl;

import club.banyuan.cqmall.service.OssFileService;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class MinioOssFileServiceImpl implements OssFileService {

    private Logger logger=LoggerFactory.getLogger(MinioOssFileServiceImpl.class);

    @Value("${minio.endpoint}")
    private String endPoint;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    public String upload(String objectName, InputStream inputStream,String contentType) throws IOException {
        try {
            MinioClient minioClient=new MinioClient(endPoint,accessKey,secretKey);
            Boolean flag=minioClient.bucketExists(bucketName);
            if(flag){
                logger.info("桶已存在");
            }else {
                minioClient.makeBucket(bucketName);
                minioClient.setBucketPolicy(bucketName,".", PolicyType.READ_WRITE);
            }
            minioClient.putObject(bucketName,objectName,inputStream,contentType);
            logger.info("文件上传成功");
            return endPoint+"/"+bucketName+"/"+objectName;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public String delete(String objectName) {
        try {
            MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);
            minioClient.removeObject(bucketName, objectName);
            return "success";
        } catch (Exception e) {
            logger.error("文件上传失败");
        }
        return "fail";
    }
}
