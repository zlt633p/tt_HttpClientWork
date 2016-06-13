package httpsample;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.HttpUtil;
import util.Json2Codec;

/**
 * @author ztang
 * generated at : Jun 10, 2016 - 9:34:54 AM
 * 
 * Refer to: http://www.jsontest.com/#headers
 * Cross-Origin Resource Sharing: https://www.w3.org/TR/cors/
 * HTTP access control (CORS): https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS
 * json Media Type for JavaScript Object Notation: http://www.ietf.org/rfc/rfc4627.txt
 */
public class JsonTestSample {	
	private static final Logger logger = Logger.getLogger(HttpUtil.class);
	CloseableHttpClient httpClient;
	
	public JsonTestSample() {
		super();
		init();
	}
	
	@Before
	public void init(){
		httpClient = HttpClients.createDefault();		
	}
	
	@Test
	public void run_IpAddress(){
		String urltext = "http://ip.jsontest.com/";
		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			//logger.info(resContent);
			
			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
			logger.info(convertedMap);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}		
	
	@Test
	public void run_Date(){
		String urltext = "http://date.jsontest.com";		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			logger.info(resContent);
			
			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
			logger.info(convertedMap);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}
	
	@Test
	public void run_EchoJSON(){
		String urltext = "http://echo.jsontest.com/key/value/one/two/xx/yy";		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			logger.info(resContent);
			
			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
			logger.info(convertedMap);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}
	
	
	@Test
	public void run_HttpHeader(){
		String urltext = "http://headers.jsontest.com/";		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			logger.info(resContent);
			
			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
			logger.info(convertedMap);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}
	
	@Test
	public void run_Cookie(){
		String urltext = "http://cookie.jsontest.com/";
		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			//logger.info(resContent);
			
			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
			logger.info(convertedMap);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}
	
	@Test
	public void run_MD5(){
		String urltext = "http://md5.jsontest.com/?text=whatever-forboo";
		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			logger.info(resContent);
			
			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
			logger.info(convertedMap);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}
	
	@Test
	public void run_CallBack(){
		String urltext = "http://ip.jsontest.com/?callback=showIP";
		
		HttpGet httpGet = new HttpGet(urltext);		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpGet);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			logger.info(resContent);

		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} finally {
			HttpUtil.close(httpRes);
		} 
	}
	
	
	@After
	public void destroy(){
		HttpUtil.close(httpClient);
	}
	
	public static void main(String[] args) throws Exception {
		
		JsonTestSample agent = new JsonTestSample();
		
		//agent.run_Date();
		agent.run_HttpHeader();
		
		agent.destroy();
		System.exit(0);
	}

}
