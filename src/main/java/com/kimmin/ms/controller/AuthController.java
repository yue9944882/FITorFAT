package com.kimmin.ms.controller;

import com.kimmin.ms.misc.Utils;
import com.kimmin.ms.service.AuthService;
import javassist.compiler.ast.StringL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by t-mijin on 8/6/2016.
 */


@Controller
@RequestMapping(value = "/auth", method = {
        RequestMethod.POST
}, produces = "application/json;charset=UTF-8")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String userLoginRoute(@RequestBody Map<String, Object> map,
                               HttpServletRequest request,
                               HttpServletResponse response){
        String uid = (String) map.get("id");
        String password = (String) map.get("password");
        boolean success = authService.checkUser(uid, password);
        if(success) return Utils.RESP_SUCCESS;
        else return Utils.RESP_FAILURE;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String userRegisterRoute(@RequestBody Map<String, Object> map,
                                    HttpServletResponse response){
        String uid = (String) map.get("id");
        String password = (String) map.get("password");
        String name = (String) map.get("name");
        String gender = (String) map.get("gender");
        int upper = (Integer) map.get("upper");
        boolean success = authService.registerUser(uid, password, gender, name, upper);
        if(success) return Utils.RESP_SUCCESS;
        else return Utils.RESP_FAILURE;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public String userModifyRoute(@RequestBody Map<String, Object> map,
                                  HttpServletResponse response){
        String uid = (String) map.get("id");
        String password = (String) map.get("password");
        String name = (String) map.get("name");
        String gender = (String) map.get("gender");
        int upper = (Integer) map.get("upper");
        boolean success = authService.modifyUser(uid, password, gender, name, upper);
        if(success) return Utils.RESP_SUCCESS;
        else return Utils.RESP_FAILURE;
    }

}
