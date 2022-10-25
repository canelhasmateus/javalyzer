package io.canelhas.javalyzer.mvn;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class ResponseStatus {
    @JsonProperty( "exitCode" ) private long   status;
    @JsonProperty( "qTime" ) private    long   qTime;
    @JsonProperty( "params" ) private   Params params;
}

// Params.java

