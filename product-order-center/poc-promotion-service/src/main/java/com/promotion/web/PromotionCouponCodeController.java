package com.promotion.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.promotion.PromotionCouponCode;
import com.promotion.service.impl.PromotionCouponCodeServiceImpl;

@Controller
@RequestMapping("promotionCouponCode")
public class PromotionCouponCodeController extends BaseController<PromotionCouponCodeServiceImpl,PromotionCouponCode> {

}