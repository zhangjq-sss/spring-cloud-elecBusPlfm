package com.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.product.ProducshopFollow;
import com.product.service.impl.ProducshopFollowServiceImpl;

@Controller
@RequestMapping("producshopFollow")
public class ProducshopFollowController extends BaseController<ProducshopFollowServiceImpl,ProducshopFollow> {

}