package com.cxaou.thetestsystem.controller;

import com.cxaou.thetestsystem.common.R;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Api(tags = "共用的接口")
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path: F:\\temp}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "要上传的文件", required = true)

    })
    @ApiOperation("文件上传用的接口")
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String name = UUID.randomUUID().toString() + suffix;
        //创建一个目录对象，防止目录不存在
        File dir = new File(basePath);
        // 判断当前目录是否存在,不存在创建目录
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(new File(basePath + File.separator + name));

        return R.success(name);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "要下载的文件名", required = true)

    })
    @ApiOperation("文件下载用的接口")
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        response.setContentType("image/jpeg");
        try {
            // 输入流 ，通过输入流读取文件内容
            fileInputStream = new FileInputStream(new File(basePath + File.separator + name));
            // 输出流，通过输出流来将我们文件写回浏览器，在浏览器展示图片
            outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
