package com.kimmin.ms.controller;

import com.kimmin.ms.entity.*;
import com.kimmin.ms.misc.Utils;
import com.kimmin.ms.service.*;
import com.kimmin.ms.storage.StorageManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.Date;
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

    @Autowired
    private AuthService authService;



    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/add/message", method = RequestMethod.POST)
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

    @RequestMapping(value = "/menu/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getMenuByUser(@PathVariable("id") String id){
        Set<Menu> menus = menuService.getMenuByUser(id);
        try{
            return objectMapper.writeValueAsString(menus);
        } catch (Throwable e) {
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @RequestMapping(value = "/ingredient/dish/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getIngredientByDish(@PathVariable("id") String id){
        Integer did = Integer.parseInt(id);
        Set<Ingredient> ingredients = dishService.getIngredientByDish(did);
        try{
            return objectMapper.writeValueAsString(ingredients);
        } catch (Throwable e) {
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }


    @RequestMapping(value = "/upload/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@PathVariable("id") String id,
                              @RequestParam("file") MultipartFile file){
        try{
            byte[] bytes = file.getBytes();
            long length = bytes.length;
            StorageManager.getInstance().saveImageToCloud(new ByteArrayInputStream(bytes), length, id);
            return Utils.RESP_SUCCESS;
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }

    }

    @RequestMapping(value = "/add/ingredient", method = RequestMethod.POST)
    @ResponseBody
    public String addIngredient(@RequestBody Map<String, Object> map){
        Ingredient ingredient = new Ingredient();
        String name = (String) map.get("name");
        Integer caloric = (Integer) map.get("caloric");
        ingredient.setName(name);
        ingredient.setCaloric(caloric);
        dishService.addIngredient(ingredient);
        return Utils.RESP_SUCCESS;
    }

    @RequestMapping(value = "/add/dish", method = RequestMethod.POST)
    @ResponseBody
    public String addDish(@RequestBody Map<String, Object> map){
        String name = (String) map.get("name");
        int weight = (Integer) map.get("weight");
        int location = (Integer) map.get("location");
        int energy = (Integer) map.get("energy");
        int type = (Integer) map.get("type");
        List<Integer> iids = (List<Integer>) map.get("iids");
        dishService.addDish(name, location, weight, energy, type, iids);
        return Utils.RESP_SUCCESS;
    }

    @RequestMapping(value = "/add/menu", method = RequestMethod.POST)
    @ResponseBody
    public String addMenu(@RequestBody Map<String, Object> map){
        String uid = (String) map.get("uid");
        List<Integer> dids = (List<Integer>) map.get("dids");
        menuService.addMenu(uid, dids);
        return Utils.RESP_SUCCESS;
    }

}
