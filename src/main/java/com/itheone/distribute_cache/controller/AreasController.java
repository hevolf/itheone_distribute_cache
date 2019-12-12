package com.itheone.distribute_cache.controller;

import com.itheone.distribute_cache.entity.Areas;
import com.itheone.distribute_cache.entity.Provinces;
import com.itheone.distribute_cache.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author caohaifengx@163.com 2019-12-12 21:38
 */

@RequestMapping(value = "areas")
@RestController
public class AreasController {

    @Autowired
    private AreasService provincesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Areas> query(HttpServletRequest request){
        try {
            return provincesService.list();
        } catch (Exception e) {
            return null;
        }
    }
}
