package com.jintu.govern.zuul.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * author 王金海
 * Title: DocumentationConfig
 * ProjectName ipcdp
 * Description: TODO
 * date 2019/4/2623:30
 */
@Slf4j
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    private static final String SERVER="server";

    public DocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        routes.forEach(route->{
            if (route.getId().contains(SERVER)) {
                String location = route.getFullPath().replace("**", "v2/api-docs");
                swaggerResources.add(swaggerResource(route.getId(), location,"2.0"));
            }
        });
        return swaggerResources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        log.warn("name:{},location:{}",name,location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
