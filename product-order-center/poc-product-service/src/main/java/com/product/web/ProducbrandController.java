package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Producbrand;
import com.product.service.impl.ProducbrandServiceImpl;

@Controller
@RequestMapping("producbrand")
public class ProducbrandController extends BaseController<ProducbrandServiceImpl,Producbrand> {

}