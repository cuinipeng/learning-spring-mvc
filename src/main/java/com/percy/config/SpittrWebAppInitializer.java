package com.percy.config;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;

/* 配置 DispatcherServlet 和 Spring 应用上下文.
 * 在Servlet 3.0环境中,容器会在类路径中查找实现
 * javax.servlet.ServletContainerInitializer接口的类,
 * 如果能发现的话,就会用它来配置Servlet容器.
 * Spring提供了这个接口的实现，名为 SpringServletContainerInitializer,
 * 这个类反过来又会查找实现 WebApplicationInitializer 的类并将配置的任务
 * 交给它们来完成. Spring 3.2引入了一个便利的 WebApplicationInitializer
 * 基础实现,也就是 AbstractAnnotationConfigDispatcherServletInitializer
 */
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    /* 配置 ContextLoaderListener 上下文 */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /* 配置 DispatcherServlet 上下文 */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /**
     * 在 DispatcherServlet 初始化中配置 Multipart 请求:
     *  1. StandardServletMultipartResolver
     *  2. 配置 Jakarta Commons FileUpload Multipart 解析器
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setMultipartConfig(new MultipartConfigElement(
            "/", 20 * 1024 * 1024, 40 * 1024 * 1024, 0)
        );
    }
}

