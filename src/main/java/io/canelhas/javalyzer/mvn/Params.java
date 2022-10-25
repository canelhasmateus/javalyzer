package io.canelhas.javalyzer.mvn;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Params {
    @JsonProperty( "q" ) private       String q;
    @JsonProperty( "core" ) private    String core;
    @JsonProperty( "indent" ) private  String indent;
    @JsonProperty( "fl" ) private      String fl;
    @JsonProperty( "start" ) private   String start;
    @JsonProperty( "sort" ) private    String sort;
    @JsonProperty( "rows" ) private    String rows;
    @JsonProperty( "wt" ) private      String wt;
    @JsonProperty( "version" ) private String version;
}
