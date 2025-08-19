package org.atgalway.lease.web.admin.custom.config;

import org.atgalway.lease.model.enums.ItemType;
import org.atgalway.lease.web.admin.custom.converter.StringToBaseEnumConverterFactory;
import org.atgalway.lease.web.admin.custom.converter.StringToItemTypeConverter;
import org.atgalway.lease.web.admin.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private StringToBaseEnumConverterFactory converter;

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authenticationInterceptor).
                addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
    }

}
