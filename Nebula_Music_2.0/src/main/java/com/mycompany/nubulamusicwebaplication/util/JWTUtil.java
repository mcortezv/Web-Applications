/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nubulamusicwebaplication.util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JWTUtil {
    private static final String SECRET = "mi_super_secreta_firma_jwt";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generarToken(String usuario){
        return Jwts.builders()
                .subject(usuario)
                .issueAt(new Date())
                .expiration(new Date(System.currentTimeMillis + (1000 * 60 * 60)))
                .signWith(KEY)
                .compact();
    }

    public stati String validarToken(String token){
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
