package com.kimmin.ms.controller;

import com.kimmin.ms.entity.Dish;
import com.kimmin.ms.entity.Menu;
import com.kimmin.ms.entity.User;
import com.kimmin.ms.misc.Utils;
import com.kimmin.ms.service.AuthService;
import com.kimmin.ms.service.MenuService;
import com.kimmin.ms.service.QueryService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by t-mijin on 8/6/2016.
 */

@Controller
@RequestMapping(value = "/query", method = {
        RequestMethod.GET
})
public class QueryController {

    @Autowired
    private AuthService authService;

    @Autowired
    private QueryService queryService;

    @Autowired
    private MenuService menuService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET )
    public String queryUserInfo(@PathVariable("id") String id){
        User user = authService.getUserById(id);
        user.setPassword("***********".getBytes());
        try{
            return objectMapper.writeValueAsString(user);
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/dish/{id}", method = RequestMethod.GET )
    public String queryDishInfo(@PathVariable("id") String id){
        try{
            int did = Integer.parseInt(id);
            Dish dish = queryService.queryDish(did);
            return objectMapper.writeValueAsString(dish);
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/dishes/low", method = RequestMethod.GET )
    @ResponseBody
    public String queryLowDishes(){
        try{
            return objectMapper.writeValueAsString(queryService.queryLowDishes());
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/dishes/medium", method = RequestMethod.GET)
    @ResponseBody
    public String queryMediumDishes(){
        try{
            return objectMapper.writeValueAsString(queryService.queryMediumDishes());
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/dishes/high", method = RequestMethod.GET )
    @ResponseBody
    public String queryHighDishes(){
        try{
            return objectMapper.writeValueAsString(queryService.queryHighDishes());
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/dishes/latest", method = RequestMethod.GET )
    @ResponseBody
    public String queryLatestDishes(){
        try{
            return objectMapper.writeValueAsString(queryService.queryLatestDishes());
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/today/{id}", method = RequestMethod.GET)
    public String queryUserToday(@PathVariable("id") String id){
        try{
            User user = authService.getUserById(id);
            Map<String, Object> resp = new HashMap<String, Object>();
            resp.put("upper", user.getUpper());
            Set<Menu> menus = menuService.getMenuByUser(id);
            Date today = new Date();
            today.setHours(0);
            today.setMinutes(0);
            today.setSeconds(0);
            boolean put = false;
            for(Menu menu : menus){
                if(menu.getDate().after(today)){
                    resp.put("menu", menu);
                    put = true;
                }
            }
            return objectMapper.writeValueAsString(resp);
        }catch (Throwable e){
            e.printStackTrace();
            return Utils.RESP_FAILURE;
        }
    }




}
