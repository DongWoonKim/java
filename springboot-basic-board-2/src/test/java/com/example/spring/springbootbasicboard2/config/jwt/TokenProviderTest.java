package com.example.spring.springbootbasicboard2.config.jwt;

import com.example.spring.springbootbasicboard2.enums.Role;
import com.example.spring.springbootbasicboard2.model.Member;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Base64;

@SpringBootTest
class TokenProviderTest {

    private final TokenProvider tokenProvider;

    @Autowired
    TokenProviderTest(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Test
    void generate_token() {
        // given
        Member member = Member.builder()
                .id(0)
                .userId("test")
                .password("1234")
                .userName("test")
                .role(Role.ROLE_USER)
                .build();

        // when
        String token = tokenProvider.generateToken(member, Duration.ofHours(2));

        // then
        System.out.println(token);
    }

    @Test
    void generate_secret_key() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String encoded = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println(encoded);
    }

}