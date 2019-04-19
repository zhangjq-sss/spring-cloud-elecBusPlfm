package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Producsku;
import com.product.service.impl.ProducskuServiceImpl;

@Controller
@RequestMapping("producsku")
public class ProducskuController extends BaseController<ProducskuServiceImpl,Producsku> {

}