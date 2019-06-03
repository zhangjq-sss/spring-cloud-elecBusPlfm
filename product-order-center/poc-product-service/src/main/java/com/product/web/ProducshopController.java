package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Producshop;
import com.product.service.impl.ProducshopServiceImpl;

@Controller
@RequestMapping("producshop")
public class ProducshopController extends BaseController<ProducshopServiceImpl,Producshop> {

}