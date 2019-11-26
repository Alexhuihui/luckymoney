package top.alexmmd.luckymoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.alexmmd.luckymoney.config.LimitConfig;

/**
 * @author 汪永晖
 */
@RestController
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/hello")
    public String say() {
        return "description:" + limitConfig.getDescription();
    }

    @GetMapping("/test/jrebel")
    public String jrebel() {
        return "jrebel 真香";
    }
}
