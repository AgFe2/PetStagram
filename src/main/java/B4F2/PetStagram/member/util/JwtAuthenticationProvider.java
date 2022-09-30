package B4F2.PetStagram.member.util;

import B4F2.PetStagram.member.util.Aes256Util;
import B4F2.PetStagram.member.domain.MemberVo;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Configuration
public class JwtAuthenticationProvider {

    @Value("{spring.jwt.secret}")
    private String secretKey;

    private long tokenValidTime = 1000L * 60 * 60 * 24; //1일

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String email){
        Claims claims = Jwts.claims().setSubject(email);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+tokenValidTime))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    //=====토큰에 대한 validation 체크=====
    public boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    //토큰에서 값 추출
    public String getSubject(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 이메일 저장해서 이걸 기반으로 동작
    public MemberVo getMemberVo(String token){
        Claims c = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return new MemberVo(c.getSubject());
    }
}

