package com.zhiang.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.zhiang.ssm3.domain.UserDO;
import com.zhiang.ssm3.domain.UserDOExample;
import com.zhiang.ssm3.mapper.UserDOMapper;
import com.zhiang.util.RestResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mengzhiang on 2017/7/6.
 */
@Controller
public class IndexController {

    @Autowired
    private UserDOMapper userDOMapper;


    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<String, Object>();


        return new ModelAndView("index",map);
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public RestResult list(HttpServletRequest request, @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "curPage", defaultValue = "1") int curPage,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize)
        throws IOException, ServletException {

        UserDOExample example = new UserDOExample();
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andNameLike("%" + name + "%");
        }
        example.setLimit(pageSize);
        int totalCount = userDOMapper.countByExample(example);

        List<UserDO> list = userDOMapper.selectByExample(example);

        return RestResult.success(list);
    }
}
