package com.example.ossdemo.controller;

import com.example.ossdemo.client.OssClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/10
 */
@Slf4j
@RestController
public class OssController {

    @Autowired
    private OssClient ossClient;

    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        ossClient.uploadPicture(bytes);
        return "上传成功";
    }

}
