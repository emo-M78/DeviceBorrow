package com.ruoyi.device.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 */
@RestController
@Anonymous//匿名访问不鉴权注解
@RequestMapping("/device/test")//访问路径
public class TController {
    @GetMapping("/list")
    public AjaxResult list() {
        return AjaxResult.success("测试接口success");
    }
}
