package com.example.lazyloading.controller;

import com.example.lazyloading.model.shop.dto.CreateShopRequest;
import com.example.lazyloading.model.shop.dto.ShopInfo;
import com.example.lazyloading.model.shop.service.ShopService;
import com.example.lazyloading.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@Log4j2
@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {
  private final ShopService shopService;

  @PostMapping
  public void create(@RequestBody CreateShopRequest request){
    log.info("Received create shop request: {}", StringUtils.toJson(request));
    shopService.create(request);
  }

  @GetMapping("{id}/name")
  public String getShopName(@PathVariable Long id) throws EntityNotFoundException {
    return shopService.findById(id).getName();
  }

  @GetMapping("{id}/info")
  public ShopInfo getShopInfoV2(@PathVariable Long id) throws EntityNotFoundException {
    return shopService.findInfoById(id);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public String handleException(Exception e){
    log.error("Exception is found", e);
    return e.getMessage();
  }
}
