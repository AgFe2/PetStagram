package B4F2.PetStagram.member.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class JwtAuthenticationProviderTest {

    Aes256Util aes256Util;

    @Test
    void getSubject() {
        //given
        String email = "test@test.com";

        String secretKey = "keykeykey";

        long tokenValidTime = 1000L * 60 * 60 * 24;

        Claims claims = Jwts.claims().setSubject(Aes256Util.encrypt(email));
        Date now = new Date();
        claims.put("email",email);

        String token =  Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+tokenValidTime))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();

        //when
        String userEmail = Aes256Util.decrypt(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());

        //then
        Assertions.assertThat(userEmail).isEqualTo("test@test.com");
    }
}