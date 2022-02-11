package api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//JAX-RS 서버모듈 톰켓에 등록
//JAX-RS 와 관련된 패키지는 javax.ws.rs.* 사용 


@ApplicationPath("/api")
public class ApiConfig  extends Application{
	
	 public Map<String, Object> getProperties() {
	        Map<String, Object> properties = new HashMap<String, Object>();
	        //아래 api 패키지만 restful api로 사용등록 
	        properties.put("jersey.config.server.provider.packages", "api");
	        return properties;
	 }
}
