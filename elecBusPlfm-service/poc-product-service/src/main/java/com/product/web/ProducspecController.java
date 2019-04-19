package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Producspec;
import com.product.service.impl.ProducspecServiceImpl;

@Controller
@RequestMapping("producspec")
public class ProducspecController extends BaseController<ProducspecServiceImpl,Producspec> {

}