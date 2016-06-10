package httpsample;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import util.HttpUtil;

/**
 * @author ztang
 * generated at : Jun 10, 2016 - 9:34:54 AM
 */
public class GoogleSample {	
	private static final Logger logger = Logger.getLogger(HttpUtil.class);
	CloseableHttpClient httpClient;
	
	public GoogleSample() {
		super();
		init();
	}
	
	public void init(){
		httpClient = HttpClients.createDefault();		
	}
	
	public void run(){
		String urltext = "https://www.google.com";
		
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
	
	public void destroy(){
		HttpUtil.close(httpClient);
	}
	
	public static void main(String[] args) throws Exception {
		
		GoogleSample agent = new GoogleSample();		
		agent.run();
		agent.destroy();
		System.exit(0);
	}

}
