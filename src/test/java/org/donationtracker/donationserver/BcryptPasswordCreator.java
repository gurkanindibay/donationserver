package org.donationtracker.donationserver;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordCreator {


    public static void main(String[] args){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
        System.out.println(bCryptPasswordEncoder.encode("password"));
    }
}
