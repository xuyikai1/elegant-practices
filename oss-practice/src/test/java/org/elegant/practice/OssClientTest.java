package org.elegant.practice;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuyk
 * @description 单元测试
 * @date 2021-05-07
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class OssClientTest {

    @Autowired
    private OssClient ossClient;

    @Test
    public void uploadPicture(){
        byte[] bytes = FileUtil.readBytes("/Users/xuyikai/Downloads/头像.jpg");
        ossClient.uploadPicture(bytes);
    }

}