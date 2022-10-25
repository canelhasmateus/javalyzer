// Response.java

package io.canelhas.javalyzer.mvn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class Response {
    @JsonProperty( "numFound" ) private long        numFound;
    @JsonProperty( "start" ) private    long        start;
    @JsonProperty( "docs" ) private     List< Doc > docs;
}

