//package B4F2.PetStagram.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.CacheControl;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class WebCachingConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        CacheControl cacheControl = CacheControl
//                .maxAge(60, TimeUnit.SECONDS)
//                .mustRevalidate();
//
//        registry.addResourceHandler("/file/list")
//                .addResourceLocations("classpath:/static/")
//                .setCacheControl(cacheControl);
//    }
//}
