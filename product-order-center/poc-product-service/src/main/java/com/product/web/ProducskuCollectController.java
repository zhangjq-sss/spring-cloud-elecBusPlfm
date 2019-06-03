package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducskuCollect;
import com.product.service.impl.ProducskuCollectServiceImpl;

@Controller
@RequestMapping("producskuCollect")
public class ProducskuCollectController extends BaseController<ProducskuCollectServiceImpl,ProducskuCollect> {

}