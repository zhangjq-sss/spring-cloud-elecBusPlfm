package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Producspu;
import com.product.service.impl.ProducspuServiceImpl;

@Controller
@RequestMapping("producspu")
public class ProducspuController extends BaseController<ProducspuServiceImpl,Producspu> {

}