package com.promotion.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.promotion.PromotionCust;
import com.promotion.service.impl.PromotionCustServiceImpl;

@Controller
@RequestMapping("promotionCust")
public class PromotionCustController extends BaseController<PromotionCustServiceImpl,PromotionCust> {

}