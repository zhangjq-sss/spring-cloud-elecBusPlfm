package com.promotion.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.promotion.PromotionCouponScope;
import com.promotion.service.impl.PromotionCouponScopeServiceImpl;

@Controller
@RequestMapping("promotionCouponScope")
public class PromotionCouponScopeController extends BaseController<PromotionCouponScopeServiceImpl,PromotionCouponScope> {

}