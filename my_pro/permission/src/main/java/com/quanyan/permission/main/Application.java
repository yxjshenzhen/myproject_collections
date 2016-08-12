package com.quanyan.permission.main;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
/**
 * Created by youxiaojia on 2016/8/9.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.quanyan.permission.service",
        "com.quanyan.permission.web",
})
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.quanyan.*.mapper"})
@ImportResource({"classpath:spring/application-profile.xml"})
@EnableScheduling
@EnableAsync
public class Application extends WebMvcConfigurerAdapter {

    /**
     * 启动器
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
        
    }


    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource", locations = "classpath:application.properties")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/quanyan/*/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }


    @Bean
    public RequestContextFilter requestContextFilter(ServletContext servletContext) {
        RequestContextFilter requestContextFilter =new RequestContextFilter();
        requestContextFilter.setServletContext(servletContext);
        requestContextFilter.setThreadContextInheritable(false);
        return requestContextFilter;
    }


    /**
     * 添加需要拦截的url，进行cookie检验
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new xxxInterceptor()).addPathPatterns("/xxx/xxx");
    }
}
