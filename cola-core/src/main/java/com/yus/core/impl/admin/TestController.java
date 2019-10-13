package com.yus.core.impl.admin;

import com.yus.admin.TestApi;
import com.yus.result.ResultWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController implements TestApi {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    /**
     * 测试
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Map<String, Object> receive(@RequestParam String msg) {
        LOGGER.info(msg);
        return ResultWrapper.success("领取成功，请及时完成报价");
    }

}