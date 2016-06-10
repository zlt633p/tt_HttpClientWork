package httpsample;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import util.HttpUtil;
import util.Json2Codec;

/**
 * @author ztang
 * generated at : Jun 10, 2016 - 9:34:54 AM
 */
public class JsonTestSample {	
	private static final Logger logger = Logger.getLogger(HttpUtil.class);
	CloseableHttpClient httpClient;
	
	public JsonTestSample() {
		super();
		init();
	}
	
	public void init(){
		httpClient = HttpClients.createDefault();		
	}
	
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
	
	public void destroy(){
		HttpUtil.close(httpClient);
	}
	
	public static void main(String[] args) throws Exception {
		
		JsonTestSample agent = new JsonTestSample();
		
		//agent.run_Date();
		agent.run_MD5();
		
		agent.destroy();
		System.exit(0);
	}

}
