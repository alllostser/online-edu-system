package com.online.edu.controller;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * @program: phone-contrast
 * @description: 文件上传控制层
 * @created: 2021/03/16 16:27
 */
@RestController
@Slf4j
public class UploadController {
    // 文件上传后的路径
    @Value("${upload.img.path}")
    private String imgPath;
    @Value("${upload.video.path}")
    private String videoPath;
    @Value("${upload.file.path}")
    private String filePath;
    @Value("${server.port}")
    private String serverProt;

    /**
     * 文件上传功能
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public R upload(MultipartFile file) {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            log.error(e.getMessage(),e);
        }
        String ip = localHost.getHostAddress();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);
        String newFileName = UUID.randomUUID().toString() + System.currentTimeMillis() + suffixName;
        log.info("上传后文件名为：" + newFileName);
        String uploadPath = null;
        String filePath2 = "";
        try {
            String contentType = file.getContentType();
            if (contentType.substring(0,contentType.indexOf("/")).equals("image")){
                filePath2=imgPath;
            }else if (contentType.substring(0,contentType.indexOf("/")).equals("video")){
                filePath2=videoPath;
            }else {
                filePath2=filePath;
            }
            uploadPath = ResourceUtils.getURL("classpath:").getPath() + filePath2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File dest = new File(uploadPath, newFileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return R.failed("上传异常");
        }
        return R.ok("//"+ip+":"+serverProt+filePath2.replace("static","")+newFileName);
    }
}
