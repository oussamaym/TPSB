package com.emsi.tpsb;

import com.emsi.tpsb.dao.EtudiantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TpsbApplication {

    public static void main(String[] args) {

        ApplicationContext ctx=	SpringApplication.run(TpsbApplication.class, args);
        EtudiantRepository etu= ctx.getBean(EtudiantRepository.class);
    }

}
