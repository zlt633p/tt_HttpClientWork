package util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;

/**
 * @author ztang
 * generated at : Jun 10, 2016 - 9:36:08 AM
 */
public class HttpUtil {
	
	private static final Logger logger = Logger.getLogger(HttpUtil.class);

    public static String getHttpResponseContent(HttpResponse response ) {
    	if( response == null ){
    		throw new IllegalArgumentException("HttpResponse instance must not be null");
    	}
        HttpEntity resEntity = response.getEntity();

        if (resEntity != null) {
        	logger.debug("Response content length: " + resEntity.getContentLength());
        	logger.debug("Chunked?: " + resEntity.isChunked());
        }
        try{
        	InputStream is = resEntity.getContent();
            String resContent = IOUtils.toString( is );            
            is.close();
            return resContent;
        } catch (IOException e){
        	e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }
    
	public static void close(Closeable closeableObj){
		if( closeableObj != null){
			try {
				closeableObj.close();
			} catch (IOException e) {
				logger.warn(e.getMessage(), e);
			}
		}
	}
    
}
