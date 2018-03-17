package com.gwf.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试接口
 * @author gaowenfeng
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
