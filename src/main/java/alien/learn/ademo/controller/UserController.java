package alien.learn.ademo.controller;

import org.springframework.web.bind.annotation.RestController;

import alien.learn.ademo.entity.USER;
import alien.learn.ademo.mapper.UserMapper;
import alien.learn.ademo.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import alien.learn.ademo.utils.Result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "用户管理")
@RestController
@CrossOrigin
public class UserController {
    // 注入userMapper
    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "获取所有用户")
    @GetMapping("/user")
    public List<USER> query() {
        List<USER> List = userMapper.show_all();
        System.out.println(List);
        return List;
    }

    @Operation(summary = "获取用户")
    @GetMapping("/user/{id}")
    public USER getUserid(@PathVariable int id) {
        USER user = userMapper.find(id);
        System.out.println(user);
        return user;
    }

    @Operation(summary = "添加用户")
    @PostMapping("/user")
    public String adduser(USER user) {
        int i = userMapper.insert(user);
        System.out.println(i);
        if (i > 0)
            return "插入成功";
        else
            return "插入失败";
    }

    @Operation(summary = "更新用户")
    @PutMapping("/user")
    public String updateuser(USER user) {
        return "更新用户";
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/user/{id}")
    public String deletebyid(@PathVariable int id) {
        return "根据id删除用户";
    }

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result Login(@RequestBody USER user) {
        String token = JwtUtils.generateToken(user.getUsername());
        USER flag = userMapper.exist(user.getUsername());
        if (flag != null) {
            if (flag.getPassword().equals(user.getPassword())) {
                return Result.ok().data("token", token);
            }
        }
        return Result.error();
    }

    @GetMapping("/info")
    public Result info(String token) {
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String url = "https://img2.baidu.com/it/u=1325995315,4158780794&fm=26&fmt=auto&gp=0.jpg";
        return Result.ok().data("name", username).data("avatar", url);
    }

    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }

    // @GetMapping("/findAll")
    // public List<USER> findall() {
    // return userMapper.selectAllUserAndActive();
    // }

}
