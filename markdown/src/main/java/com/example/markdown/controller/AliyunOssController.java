package com.example.markdown.controller;

import com.example.markdown.dto.ResponseResult;
import com.example.markdown.utils.AliyunOssUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LB
 * @create 2019-07-09 10:30
 */
@Controller
@RequestMapping("/mark")
public class AliyunOssController {
    private final Logger logger = LoggerFactory.getLogger(AliyunOssController.class);

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

//    @RequestMapping("/save")
//    public ModelAndView save(String text){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("markdown",text );
//        modelAndView.setViewName("preview");
//        System.out.println(text);
//        return modelAndView;
//    }

    /**
     * 保存markdown源码
     * @param text
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(String text){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("markdown",text );
        modelAndView.setViewName("preview");
        System.out.println(text);
        return modelAndView;
    }

    /**
     * 上传本地图片
     * @param file
     * @param model
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ResponseResult testUpload(@RequestParam("editormd-image-file")MultipartFile file, Model model){
        logger.info("文件上传");
        ResponseResult responseResult = new ResponseResult();
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        try {
            if(file != null){
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream outputStream = new FileOutputStream(newFile);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    file.transferTo(newFile);
                    String url = aliyunOssUtil.upLoad(newFile);
                    responseResult.setSuccess(1);
                    responseResult.setUrl(url);
                    responseResult.setMessage("上传成功");
                }
            }
        } catch (FileNotFoundException e) {
            responseResult.setSuccess(0);
            responseResult.setMessage("上传失败");
            e.printStackTrace();
        } catch (IOException e) {
            responseResult.setSuccess(0);
            responseResult.setMessage("上传失败");
            e.printStackTrace();
        }
        return responseResult;
    }
}
