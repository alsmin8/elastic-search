package elastic.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import elastic.study.service.TestService;

@Controller
public class TestController {

	@Autowired
	static
	TestService service = new TestService();
	
	public static void main(String[] args) {
		service.testHighLevelClient();
	}
	
	
	public void MainTest() throws Exception{
		
		service.testHighLevelClient();
	}
	
	
}
