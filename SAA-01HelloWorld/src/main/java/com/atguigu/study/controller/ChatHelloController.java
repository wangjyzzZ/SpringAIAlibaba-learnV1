package com.atguigu.study.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatHelloController {

    @Resource
    private ChatModel chatModel;

    /**
     * 通用调用
     * @param msg
     * @return
     */
    @GetMapping("/hello/doChat")
    public String doChat(@RequestParam(name = "msg", defaultValue = "你是谁") String msg) {
        return chatModel.call(msg);
    }

    /**
     * 流式返回调用
     * @param msg
     * @return
     */
    @GetMapping("/hello/streamChat")
    public Flux<String> stream(@RequestParam(name = "msg", defaultValue = "你是谁") String msg) {
        return chatModel.stream(msg);
    }
}
