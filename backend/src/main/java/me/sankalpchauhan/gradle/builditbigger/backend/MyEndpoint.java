package me.sankalpchauhan.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import me.sankalpchauhan.joketellinglibrary.JokeTeller;
/**
 * This class was included with the udacity provided starter code for this project
 * I have modified it for creating jokeApi
 */

/** An endpoint class we are exposing */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.sankalpchauhan.me",
                ownerName = "backend.builditbigger.gradle.sankalpchauhan.me",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJokeResponse")
    public MyBean getJokeResponse() {
        MyBean response = new MyBean();
        response.setData(JokeTeller.getJoke());
        return response;
    }

}