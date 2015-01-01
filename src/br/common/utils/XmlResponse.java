package br.common.utils;

import java.io.OutputStream;

public class XmlResponse<T> {

	public String xmlToString(T obj) {
		OutputStream os = new XmlWriter<T>(obj).writeToXml();
        String responseXml = StreamUtil.convertStreamToString(os);
        
        return responseXml;
	}
}
