package com.boot.test.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.boot.test.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	private ObjectMapper mapper;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.alwaysDo(print())
				.build();

		 this.mapper = new ObjectMapper();
	}

	@Test
	public void contextLoads() {
		User u = new User();
//		u.setUsername("admin");
		u.setPassword("123456");
		try {
//			mockMvc.perform(post("/login")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(u)))
//					.andExpect(status().isOk())
//					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
//			mockMvc.perform(get("/login")
//					.contentType(MediaType.APPLICATION_JSON_UTF8)
//					.content(mapper.writeValueAsString(u)))
//					.andExpect(status().isOk())
//					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//					.andDo(print());
			MvcResult result = mockMvc.perform(get("/login"))
					.andExpect(status().isOk())
					.andExpect(view().name("backend/login"))
					.andExpect(forwardedUrl("/views/backend/login.html"))
					.andExpect(model().hasNoErrors())
					.andDo(print())
					.andReturn();
			Assert.assertNotNull(result.getModelAndView().getView().equals("backend/login"));
//
//			byte[] bytes = new byte[] {1, 2};
//			mockMvc.perform(fileUpload("/user/{id}/icon", 1L).file("icon", bytes)) //执行文件上传
//					.andExpect(model().attribute("icon", bytes)) //验证属性相等性
//					.andExpect(view().name("success")); //验证视图
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void blogControllerTest(){
		String content = "this is my blog";
		try {
//			mockMvc.perform(post("/backend/blog/saveBlog")
//                .content(content))
//					.andExpect(status().isOk())
//					.andDo(print());

			mockMvc.perform(get("/backend/blog/getBlog/{id}",576))
					.andExpect(status().isOk())
					.andDo(print());
//					.andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJson(){
		User u = new User();
//		u.setUsername("Vivien");
		u.setPassword("1234");
		try {
			mockMvc.perform(post("/backend/blog/testJson")
                .content(mapper.writeValueAsString(u))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.data.username").value("Vivien"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void timeUnitTest() throws Exception {
		mockMvc.perform(get("/backend/blog/test"))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
