package br.ufsc.inf.lapesd.dblppublication.dataservice.config;

import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.ufsc.inf.lapesd.dblppublication.dataservice")
public class PublicationsApiApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(PublicationsApiApplication.class, args);
    }
}