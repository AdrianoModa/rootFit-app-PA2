package com.rootfit.security.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("piaba"));
    }
}
