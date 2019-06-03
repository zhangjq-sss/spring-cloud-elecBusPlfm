package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducskuSpecValue;
import com.product.service.impl.ProducskuSpecValueServiceImpl;

@Controller
@RequestMapping("producskuSpecValue")
public class ProducskuSpecValueController extends BaseController<ProducskuSpecValueServiceImpl,ProducskuSpecValue> {

}