package com.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.base.BaseController;
import com.common.msg.RrcResponse;
import com.domain.product.Producsku;
import com.product.service.ProducskuService;
import com.product.service.impl.ProducskuServiceImpl;

@Controller
@RequestMapping("producsku")
public class ProducskuController extends BaseController<ProducskuServiceImpl,Producsku> {
	
	@Autowired
	private ProducskuService producskuService;
	
	@ResponseBody
	@RequestMapping(value="/updateProdCount", method=RequestMethod.POST)
	public RrcResponse updateProdCount(Integer skuId, int count) {
		return producskuService.updateProdCount(skuId, count);
	}
	
	@ResponseBody
	@RequestMapping(value="/setProCountInRedis", method=RequestMethod.POST)
	public RrcResponse setProCountInRedis(Integer skuId) {
		return producskuService.setProCountInRedis(skuId);
	}

}