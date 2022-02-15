package api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath; //Rest API 서비스 진입
import javax.ws.rs.core.Application;

//JAX-RS 서버모듈 톰켓에 등록 
//JAX-RS 와 관련된 패키지는 javax.ws.rs.* 사용 


@ApplicationPath("/api") // 어노테이션을 이용등록 진행 
public class ApiConfig  extends Application{
	
	 public Map<String, Object> getProperties() {
	        Map<String, Object> properties = new HashMap<String, Object>();
	        //아래 api 패키지만 restful api로 사용등록 
	        properties.put("jersey.config.server.provider.packages", "api");
	        return properties;
	 }
}

/*
 @ApplicationPath("/api") (어노테이션 사용하지 않으면 web.xml 등록해야함 )
 
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_3_0.xsd" 
		version="3.0">
		
	<servlet>
		<servlet-name>com.example.MyApplication</servlet-name>
	</servlet>
	<servlet-mapping>
	<servlet-name>com.example.MyApplication</servlet-name>
		<url-pattern>/api/*</url-pattern>
	</servlet-mapping>
</web-app>
*/


