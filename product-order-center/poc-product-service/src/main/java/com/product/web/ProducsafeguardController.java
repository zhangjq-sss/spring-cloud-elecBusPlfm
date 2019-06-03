package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Producsafeguard;
import com.product.service.impl.ProducsafeguardServiceImpl;

@Controller
@RequestMapping("producsafeguard")
public class ProducsafeguardController extends BaseController<ProducsafeguardServiceImpl,Producsafeguard> {

}