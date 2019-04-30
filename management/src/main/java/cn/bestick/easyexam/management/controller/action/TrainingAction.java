package cn.bestick.easyexam.management.controller.action;

import cn.bestick.easyexam.common.util.file.FileUploadUtil;
import cn.bestick.easyexam.management.security.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 5/5/16
 * Time: 22:35
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 Bestick All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
@Controller
public class TrainingAction {

    @RequestMapping(value = "/secure/upload-uploadify-file", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFile(HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> filePathList = new ArrayList<>();
        try {
            filePathList = FileUploadUtil.uploadFile(request, response, userInfo.getUsername());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (filePathList.size() == 0) {
            return "系统错误";
        }
        return filePathList.get(0);
    }
}