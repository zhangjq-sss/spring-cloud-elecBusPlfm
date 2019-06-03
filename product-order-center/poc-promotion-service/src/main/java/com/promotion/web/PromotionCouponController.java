package com.promotion.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.promotion.PromotionCoupon;
import com.promotion.service.impl.PromotionCouponServiceImpl;

@Controller
@RequestMapping("promotionCoupon")
public class PromotionCouponController extends BaseController<PromotionCouponServiceImpl,PromotionCoupon> {

}