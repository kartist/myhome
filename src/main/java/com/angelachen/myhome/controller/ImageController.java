package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.model.JsonResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import com.angelachen.myhome.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Kartist 2018/10/4 8:05
 */
@RestController
@RequestMapping("/img/")
@Slf4j
public class ImageController {


    @Resource
    private ImageService imageService;

    @PostMapping("upload")
    public JsonResult upload(MultipartFile file, HttpServletRequest request) {
        User user = UserUtil.getGoodUser(request);
        if (file.isEmpty()) {
            return new JsonResult(0, "文件是空的");
        }
        imageService.saveUploadImage(file, user);
        return new JsonResult();
    }

    @PostMapping("download")
    public JsonResult download(String imgId, HttpServletRequest request) {

        return new JsonResult();
    }


    /**
     * 获取图片的展示列表
     *
     * @param type 类别 0,轮播图列表  1,展示列表
     * @return {@link com.angelachen.myhome.common.model.PageResult<com.angelachen.myhome.common.dto.ImageListDto>}
     */
    @PostMapping("list")
    public JsonResult imgList(Integer type) {
        return new JsonResult();
    }


}
