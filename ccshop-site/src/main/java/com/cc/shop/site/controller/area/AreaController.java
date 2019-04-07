package com.cc.shop.site.controller.area;

import com.cc.shop.site.controller.BaseSiteController;
import com.cc.shop.support.area.entity.Area;
import com.cc.shop.support.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 地区选择
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseSiteController {

    @Autowired private AreaService areaService;

    @RequestMapping("/index")
    public String index(Model model) {
        Map<String, List<Area>> group = areaService.getAreaGroup();
        model.addAttribute("areas", group);
        return "/src/main/webapp/WEB-INF/views/area/area.ftl";
    }

}
