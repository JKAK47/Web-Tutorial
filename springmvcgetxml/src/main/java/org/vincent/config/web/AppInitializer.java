package org.vincent.config.web;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName AppInitializer.java
 * @date 2019/6/15 - 15:51
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return  null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    /**
     * 增加 过滤器映射到 DispatcherServlet，
     * 这种方式对于jar 包实现的 filter 有很好的兼容性，可以通过手动注册上去。
     * */
    @Override
    protected Filter[] getServletFilters() {
        List<Filter> filters =new ArrayList<>();
        /** 设置字符集 编码 UTF-8 */
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8",true);
        filters.add(filter);
        return filters.toArray(new Filter[0]);
    }
}
