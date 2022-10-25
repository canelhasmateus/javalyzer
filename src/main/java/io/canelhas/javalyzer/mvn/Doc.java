// Doc.java

package io.canelhas.javalyzer.mvn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class Doc {
    @JsonProperty( "id" ) private        String         id;
    @JsonProperty( "g" ) private         String         g;
    @JsonProperty( "a" ) private         String         a;
    @JsonProperty( "v" ) private         String         v;
    @JsonProperty( "p" ) private         String         p;
    @JsonProperty( "timestamp" ) private long           timestamp;
    @JsonProperty( "ec" ) private        List< String > ec;
    @JsonProperty( "tags" ) private      List< String > tags;
}

// ResponseHeader.java

