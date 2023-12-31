package com.example.lazyloading.controller;

import com.example.lazyloading.model.shop.dto.CreateShopRequest;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import com.example.lazyloading.model.shop.service.ShopService;
import com.example.lazyloading.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("{id}")
  public ShopEntity getShop(@PathVariable Long id) throws NotFoundException {
    ShopEntity rs = shopService.findById(id);
    return rs;
  }

  @ExceptionHandler(NotFoundException.class)
  public String handleException(Exception e){
    log.error("Exception is found", e);
    return e.getMessage();
  }
}
