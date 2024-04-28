package alien.learn.ademo.controller;

import org.springframework.web.bind.annotation.RestController;

import alien.learn.ademo.entity.USER;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class testcontroller {
    // http://localhost::8080/hello
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestBody USER user) {
        System.out.println(user);
        return "POST请求";
    }
}
