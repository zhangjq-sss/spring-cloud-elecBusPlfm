package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducskuSafeguard;
import com.product.service.impl.ProducskuSafeguardServiceImpl;

@Controller
@RequestMapping("producskuSafeguard")
public class ProducskuSafeguardController extends BaseController<ProducskuSafeguardServiceImpl,ProducskuSafeguard> {

}