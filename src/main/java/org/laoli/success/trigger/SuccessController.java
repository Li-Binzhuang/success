package org.laoli.success.trigger;

import org.laoli.success.trigger.VO.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuccessController {
    @PostMapping("/success")
    public Result<String> success(){
        return Result.success("SuccessController");
    }
    @PostMapping("/fail")
    public Result<String> fail(){
        return Result.fail("fail");
    }
    @GetMapping("/test")
    public Result<String> test(){
        return Result.success("test");
    }
    @GetMapping("/test2")
    public Result<String> test2(){
        return Result.success("dd");
    }
}
