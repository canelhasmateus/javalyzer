package io.canelhas.javalyzer.mvn;

import io.canelhas.javalyzer.Dependencies;
import io.canelhas.javalyzer.utils.FileUtils;
import io.canelhas.javalyzer.utils.StringUtils;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.canelhas.javalyzer.utils.FileUtils.walk;

@RequiredArgsConstructor
public class MavenClient {


    private static final HttpClient         client = HttpClient.newBuilder().build();
    private final        Path               cachePath;
    private final        Map< String, Doc > cache;

    public static MavenClient of( Path mvnPath ) {


        Map< String, Doc > cache = walk( mvnPath ).filter( FileUtils::isJson )
                                                  .collect( Collectors.toMap( FileUtils.getName( ".json" )
                                                                                       .andThen( StringUtils::decodeBase64 ),
                                                                              FileUtils.deserializeAs( Doc.class ) ) );


        return new MavenClient( mvnPath, cache );
    }

    public Optional< Doc > search( Dependencies.JarInfo jar ) {
//
//        String[] keys = { jar.getSha() };
//        for ( String key : keys ) {
//            String s   = StringUtils.encodeBase64( key );
//            Doc    doc = cache.get( s );
//            if ( doc != null ) {
//                return Optional.of( doc );
//            }
//        }
//
//        Doc    result = null;
//        String key;
//        {
//            // check by checksum
//            key = jar.getSha();
//            URI mvnUrl = URI.create( "https://search.maven.org/solrsearch/select?q=1:" + key + "&rows=20&wt=json" );
//            result = search( mvnUrl ).stream()
//                                     .findFirst()
//                                     .orElse( null );
////
//
//        }
//        {
//            // check by classes?
//        }
//        if ( result != null ) {
//
//            String encodedKey = StringUtils.encodeBase64( key );
//            Path   resolve    = cachePath.resolve( encodedKey + ".json" );
//            byte[] content    = StringUtils.asJson( result );
//            cache.put( encodedKey, result );
//            FileUtils.write( resolve, content );
//
//        }
//        return Optional.ofNullable( result );

        return null;

    }

    private List< Doc > search( URI mvnUrl ) {
        try {
            HttpResponse< String > response = client.send( HttpRequest.newBuilder()
                                                                      .GET()
                                                                      .uri( mvnUrl )
                                                                      .build(), HttpResponse.BodyHandlers.ofString() );

            MavenResponse mavenResponse = StringUtils.fromJson( response.body(), MavenResponse.class );
            return mavenResponse.getResponse()
                                .getDocs();


        }
        catch ( IOException | InterruptedException e ) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
