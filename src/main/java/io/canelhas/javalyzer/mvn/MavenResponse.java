// TopLevel.java

package io.canelhas.javalyzer.mvn;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class MavenResponse {
    @JsonProperty( "responseHeader" ) private ResponseStatus responseHeader;
    @JsonProperty( "response" ) private       Response       response;
}
