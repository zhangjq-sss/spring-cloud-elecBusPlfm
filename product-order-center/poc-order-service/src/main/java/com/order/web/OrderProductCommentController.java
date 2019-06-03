package com.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.base.BaseController;
import com.domain.order.OrderProductComment;
import com.order.service.impl.OrderProductCommentServiceImpl;

@Controller
@RequestMapping("orderProduccomment")
public class OrderProductCommentController extends BaseController<OrderProductCommentServiceImpl,OrderProductComment> {

}