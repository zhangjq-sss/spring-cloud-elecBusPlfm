package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducshopCategory;
import com.product.service.impl.ProducshopCategoryServiceImpl;

@Controller
@RequestMapping("producshopCategory")
public class ProducshopCategoryController extends BaseController<ProducshopCategoryServiceImpl,ProducshopCategory> {

}