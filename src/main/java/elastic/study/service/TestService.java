package elastic.study.service;

import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import elastic.study.model.TestTo;

@Service
public class TestService {

	
	public void testHighLevelClient(){
		RestHighLevelClient client = new 
				RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		
		try {
			
			GetRequest getRequest = new GetRequest("customer", "list", "1"); //인덱스, 타입, document id
			
			GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
			

			if (getResponse.isExists()) {
			    String sourceAsString = getResponse.getSourceAsString();        
			    Map<String, Object> sourceAsMap = getResponse.getSourceAsMap(); 
			    //byte[] sourceAsBytes = getResponse.getSourceAsBytes();   
			    
			    Gson gson = new Gson();
			    
			    TestTo testTo = gson.fromJson(sourceAsString, TestTo.class);
			    
			    System.out.println("[확인]"+sourceAsString);
			    System.out.println("[확인2]"+testTo.getName()); 
			} else {
			    
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
	
	}
	
}
