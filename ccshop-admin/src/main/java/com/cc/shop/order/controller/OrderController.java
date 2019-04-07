package com.cc.shop.order.controller;

import com.cc.shop.base.controller.BaseAdminController;
import com.cc.shop.groupon.order.entity.Order;
import com.cc.shop.groupon.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.shop.framework.common.page.PagingResult;
import com.cc.shop.framework.common.search.Search;

/**
 * OrderController
 */
@RequestMapping(value = "/order/management")
@Controller
public class OrderController extends BaseAdminController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * 显示订单列表
	 * @param model
	 * @param search	查询条件
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String orderList(Model model, Search search) {
		return "/order/order_list";
	}
	
	@RequestMapping(value = "/listOrder", method = RequestMethod.POST)
	@ResponseBody
	public PagingResult<Order> listOrder(Model model, Search search) {
		return orderService.findOrderForPage(search);
	}
	
}