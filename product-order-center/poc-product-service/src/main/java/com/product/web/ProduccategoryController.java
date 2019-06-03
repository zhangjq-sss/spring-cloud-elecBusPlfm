package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.Produccategory;
import com.product.service.impl.ProduccategoryServiceImpl;

@Controller
@RequestMapping("produccategory")
public class ProduccategoryController extends BaseController<ProduccategoryServiceImpl,Produccategory> {

}