package co.grandcircus.lab25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import co.grandcircus.lab25.Card;
//import co.grandcircus.lab25.ForecastResponse;

@Service
public class ApiService {
	private RestTemplate rt = new RestTemplate();
	
	String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring!");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	public ForecastResponse setLocation(Double latitude, Double longitude) {

		

		String url = "https://forecast.weather.gov/MapClick.php?lat={latitude}&lon={longitude}&FcstType=json";

		

		
		ForecastResponse response = rt.getForObject(url, ForecastResponse.class, latitude, longitude);

		return response;

	}

	public ForecastResponse setLocationXML(Double latitude, Double longitude) {

		

		String url = "https://forecast.weather.gov/MapClick.php?lat={latitude}&lon={longitude}&FcstType=xml";



		   List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		   converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		   messageConverters.add(converter);
		   rt.setMessageConverters(messageConverters);
		  
		

		HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<ForecastResponse> response = rt.exchange(url, HttpMethod.GET, entity, ForecastResponse.class,
				latitude, longitude);
		
		
		return response.getBody();

	}

}
