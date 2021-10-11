package com.waquar.springcloud.couponservice.controller;

import com.waquar.springcloud.couponservice.models.Coupon;
import com.waquar.springcloud.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CouponWebController {

    @Autowired
    CouponRepository couponRepo;

    @GetMapping("/")
    public String homepage(){
        return "index";
    }

    @GetMapping("/create-coupon")
    public String createCouponPage(){
        return "createCoupon";
    }

    @PostMapping("/save-coupon")
    public String save(Coupon coupon){
        couponRepo.save(coupon);
        return "saveResponse";
    }
}
