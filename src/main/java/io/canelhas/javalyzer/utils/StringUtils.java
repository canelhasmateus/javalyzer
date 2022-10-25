package io.canelhas.javalyzer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class StringUtils {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public static String asXml(JAXBElement<?> o) {
        try {
            final ByteArrayOutputStream xml = new ByteArrayOutputStream();
            final Class<?> aClass = o.getDeclaredType();
            final Marshaller marshaller = JAXBContext.newInstance(aClass).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(o, xml);
            return xml.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromXml(byte[] s, Class<T> kind) {
        try {
            return (T) JAXBContext.newInstance(kind)
                .createUnmarshaller()
                .unmarshal(new ByteArrayInputStream(s));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String body, Class<T> docClass) {

        try {
            return JSON_MAPPER.readValue(body, docClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T coalesce(T left, T right) {
        return left != null ? left : right;
    }

    public static byte[] asJson(Object o) {

        try {
            return JSON_MAPPER.writeValueAsBytes(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decodeBase64(String s) {
        final byte[] decode = Base64.getDecoder().decode(s);
        return new String(decode);
    }

    public static String encodeBase64(String s) {
        final byte[] decode = Base64.getEncoder().encode(s.getBytes());
        return new String(decode);
    }
}
