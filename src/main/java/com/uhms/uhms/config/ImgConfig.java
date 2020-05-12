package com.uhms.uhms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/*
* 引入外部图片静态资源
* */
@Configuration
class ImgConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:D:/file/");
        super.addResourceHandlers(registry);
    }

}
