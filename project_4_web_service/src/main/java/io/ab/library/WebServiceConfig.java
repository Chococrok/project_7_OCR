package io.ab.library;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soap/*");
	}

	@Bean(name = "library")
	public DefaultWsdl11Definition defaultWsdl11Definition(CommonsXsdSchemaCollection librarySchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("LibraryPort");
		wsdl11Definition.setLocationUri("/soap");
		wsdl11Definition.setTargetNamespace("http://ab.io/library");
		wsdl11Definition.setSchemaCollection(librarySchema);
		return wsdl11Definition;
	}

	//	found help about that here:
	//	https://docs.spring.io/spring-ws/sites/1.5/reference/html/server.html#server-automatic-wsdl-exposure
	@Bean
	public CommonsXsdSchemaCollection librarySchema() {
		CommonsXsdSchemaCollection librarySchema = new CommonsXsdSchemaCollection();
		Resource[] xsdResources = {
				new ClassPathResource("model.xsd"),
				new ClassPathResource("request.xsd"),
				new ClassPathResource("response.xsd")
				};
		librarySchema.setXsds(xsdResources);
		librarySchema.setInline(true);
		return librarySchema;
	}
}
