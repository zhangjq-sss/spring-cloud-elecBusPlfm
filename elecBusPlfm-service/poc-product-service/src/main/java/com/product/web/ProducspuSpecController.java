package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducspuSpec;
import com.product.service.impl.ProducspuSpecServiceImpl;

@Controller
@RequestMapping("producspuSpec")
public class ProducspuSpecController extends BaseController<ProducspuSpecServiceImpl,ProducspuSpec> {

}