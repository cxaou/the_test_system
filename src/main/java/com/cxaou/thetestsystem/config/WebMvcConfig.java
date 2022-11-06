package com.cxaou.thetestsystem.config;

import com.cxaou.thetestsystem.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {




    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        // 设置对象转换器，底层使用Jackson 将java对象转换成 json 对象
        JacksonObjectMapper objectMapper = new JacksonObjectMapper();
        messageConverter.setObjectMapper(objectMapper);
        // 追加到mvc转换器的容器中
        converters.add(0,messageConverter);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 表示对哪种格式的请求路径进行跨域处理。
                .allowedHeaders("*") // 表示允许的请求头，默认允许所有的请求头信息。
                .allowedMethods("*") // 表示允许的请求方法，默认是 GET、POST 和 HEAD。这里配置为 * 表示支持所有的请求方法。
                .maxAge(1800) // 表示探测请求的有效期
                .allowedOrigins("*"); //  表示支持的域
    }

}
