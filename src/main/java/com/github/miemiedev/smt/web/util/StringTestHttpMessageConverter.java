package com.github.miemiedev.smt.web.util;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class StringTestHttpMessageConverter extends StringHttpMessageConverter {
    public StringTestHttpMessageConverter() {
    }

    public StringTestHttpMessageConverter(Charset defaultCharset) {
        super(defaultCharset);
    }

    protected void writeInternal(String s, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        s = "fdasfdsafdsafdsa";
        //FIXME  编码问题
        byte[] array = s.getBytes();
        StreamUtils.copy(array, httpOutputMessage.getBody());
        httpOutputMessage.getHeaders().setContentLength(array.length);
    }
}