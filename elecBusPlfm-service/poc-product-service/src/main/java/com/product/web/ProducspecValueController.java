package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducspecValue;
import com.product.service.impl.ProducspecValueServiceImpl;

@Controller
@RequestMapping("producspecValue")
public class ProducspecValueController extends BaseController<ProducspecValueServiceImpl,ProducspecValue> {

}