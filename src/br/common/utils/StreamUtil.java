package br.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

public class StreamUtil {
	
	private static Logger logger = Logger.getLogger(StreamUtil.class);

    public static String convertStreamToString(OutputStream outputStream) {
        String outputStreamAsString = null;
        try {
            outputStreamAsString = new String(((ByteArrayOutputStream) outputStream).toByteArray(), "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            logger.info("UnsupportedEncodingException exception occured " + exception.getMessage());
        }

        return outputStreamAsString;
    }
}
