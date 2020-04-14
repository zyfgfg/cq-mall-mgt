package club.banyuan.cqmall.controller;

import club.banyuan.cqmall.service.OssFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class FileController {

    private Logger logger= LoggerFactory.getLogger(FileController.class);

    @Autowired
    private OssFileService ossFileService;

    @PostMapping("/image/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        String FileName=file.getOriginalFilename();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        String objectName=format.format(new Date())+"/"+FileName;
        try {
            return ossFileService.upload(objectName,file.getInputStream(),file.getContentType());
        } catch (IOException e) {
            logger.error("上传失败：{}",e.getMessage());
        }
        return "fail";
    }

    @PostMapping("/image/delete")
    @ResponseBody
    public String delete(@RequestParam String objectName){
        try {
            ossFileService.delete(objectName);
            return "success";
        } catch (Exception e) {
            logger.error("文件上传失败");
        }
        return "fail";
    }
}
