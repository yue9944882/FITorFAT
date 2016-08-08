package com.kimmin.ms.controller;

import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Message;
import com.kimmin.ms.misc.Utils;
import com.kimmin.ms.service.DishService;
import com.kimmin.ms.service.FollowService;
import com.kimmin.ms.service.MenuService;
import com.kimmin.ms.service.MessageService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kimmin on 7/29/16.
 */

@Controller
@RequestMapping(name = "/main")
public class MainController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private FollowService followService;

    @Autowired
    private DishService dishService;

    @Autowired
    private MenuService menuService;


    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public String addMessage(@RequestBody Map<String, Object> map){
        String message = (String) map.get("message");
        String user = (String) map.get("user");
        Integer menu = (Integer) map.get("menu");
        if(message != null && user != null && menu != null) {
            messageService.addCommentMessage(user, menu, message);
            return Utils.RESP_SUCCESS;
        } else {
            return Utils.RESP_FAILURE;
        }
    }

    @RequestMapping(value = "/message/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getMessageByUser(@PathVariable("id") String id){
        List<Message> messages = messageService.getMessageByUser(id);
        try{
            return objectMapper.writeValueAsString(messages);
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @RequestMapping(value = "/message/menu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getMessageByMenu(@PathVariable("id") String id){
        Integer mid = Integer.parseInt(id);
        Set<Message> messages = messageService.getMessageByMenu(mid);
        try{
            return objectMapper.writeValueAsString(messages);
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @RequestMapping(value = "/dish/menu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getDishOfMenu(@PathVariable("id") String id){
        Integer mid = Integer.parseInt(id);
        Set<Dish> messages = menuService.getDishOfMenu(mid);
        try{
            return objectMapper.writeValueAsString(messages);
        } catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }
//
//    @RequestMapping(value = "/menu/user/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String getMenuByUser(@PathVariable("id") String id){
//        Set<Dish> messages = menuService.getDishOfMenu();
//        try{
//            return objectMapper.writeValueAsString(messages);
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return Utils.RESP_FAILURE;
//        }
//    }
}
