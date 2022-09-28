package B4F2.PetStagram.configuration.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
public class ETagHeaderFilter {

    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {
        FilterRegistrationBean<ShallowEtagHeaderFilter> filterFilterRegistrationBean
                = new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
        filterFilterRegistrationBean.addUrlPatterns("/file/list");
        filterFilterRegistrationBean.setName("fileListUpFilter");
        return filterFilterRegistrationBean;
    }
}
