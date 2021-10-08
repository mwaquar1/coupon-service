package com.waquar.springcould.couponservice.controller;

import com.waquar.springcould.couponservice.models.Coupon;
import com.waquar.springcould.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

    @Autowired
    CouponRepository couponRepo;

    @PostMapping("/add-coupon")
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon){
        return ResponseEntity.ok(couponRepo.save(coupon));
    }

    @GetMapping("get-coupon/{code}")
    public ResponseEntity<Coupon> getCoupon(@PathVariable("code") String code){
        return ResponseEntity.ok(couponRepo.findByCouponCode(code));
    }

}
