package com.example.nozomi.nozomi_java.util.minio;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Image;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class MinioController {
    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("/minio/exists")
    public void exists() throws Exception {
        System.out.println(minioUtil.bucketExists("image"));
    }

    @ApiOperation("上传图片")
    @PostMapping("/minio/uploadFile")
    public ResponseDTO upload(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String name = file.getOriginalFilename();
        String type = file.getContentType();
        minioUtil.upload(file, "image");
        Image image = new Image();
        image.setUrl("http://149.88.95.15:9000/image/"+name);
        image.setDesc(name);
        return new ResponseDTO(Code.SUCCESS, Msg.UPLOAD_PICTURE_SUCCESS,image);
    }

    @ApiOperation("根据名字删除minio图片")
    @PostMapping("/minio/deleteImage")
    public ResponseDTO delete() {
        String objectName = "";
        String bucketName = "";
        minioUtil.deleteImage(objectName,bucketName);
        return new ResponseDTO(Code.FAILED,Msg.DELETE_SUCCESS_MSG,"删除成功");
    }

    @ApiOperation("下载图片")
    @GetMapping("/minio/download")
    public ResponseDTO download(@RequestParam("fileName") String fileName, HttpServletResponse res) {
        minioUtil.download("image", fileName, res);
        return new ResponseDTO(Code.FAILED, "下载成功", null);
    }

}
