package com.garen.demo.fallback;

import com.garen.demo.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallbackFactory implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable throwable) {

        return new HelloService() {
            @Override
            public String sayHello(String name) {
                return String.format("ERROR NAME:%s MESSAGE:%s", name, (throwable == null ? "null" : throwable.getMessage()));
            }
        };
    }
}
