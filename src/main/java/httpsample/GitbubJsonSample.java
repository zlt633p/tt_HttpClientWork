package httpsample;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import util.HttpUtil;

/**
 * @author ztang
 * generated at : Jun 10, 2016 - 9:34:54 AM
 */
public class GitbubJsonSample {	
	private static final Logger logger = Logger.getLogger(HttpUtil.class);
	CloseableHttpClient httpClient;
	
	public GitbubJsonSample() {
		super();
		init();
	}
	
	public void init(){
		httpClient = HttpClients.createDefault();		
	}
	
	public void run(){
		//String urltext = "https://api.github.com/users/mralexgray/repos";
		String urltext = "https://api.github.com/users/zlt633p/repos";
		
		
		
		HttpPost httpMethod = new HttpPost(urltext);
		
		CloseableHttpResponse httpRes = null;
		try {
			httpRes = httpClient.execute(httpMethod);
			String resContent = HttpUtil.getHttpResponseContent(httpRes);			
			logger.info(resContent);
			
//			Map<String, Object> convertedMap = Json2Codec.unmarshalToMap(resContent);
//			logger.info(convertedMap);
			
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
		
		GitbubJsonSample agent = new GitbubJsonSample();		
		agent.run();
		agent.destroy();
		System.exit(0);
	}

}
