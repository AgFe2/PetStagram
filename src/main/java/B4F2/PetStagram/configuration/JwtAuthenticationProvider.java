package B4F2.PetStagram.configuration;

import B4F2.PetStagram.member.util.Aes256Util;
import B4F2.PetStagram.member.domain.MemberVo;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Objects;

public class JwtAuthenticationProvider {

    @Value("{spring.jwt.secret}")
    private String secretKey;

    private long tokenValidTime = 1000L * 60 * 60 * 24; //1일


    //todo=========
//    public String getUserEmail(String token){
//        Claims c = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//        return new String(Objects.requireNonNull(Aes256Util.decrypt(c.getId())));
//    }

    public String createToken(String userPk, Long id){
        Claims claims = Jwts.claims().setSubject(Aes256Util.encrypt(userPk)).setId(Aes256Util.encrypt(id.toString()));
        Date now = new Date();
        claims.put("email",userPk);

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
    // 아이디와 이메일 두개를 저장해서 이걸 기반으로 동작
    public MemberVo getMemberVo(String token){
        Claims c = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return new MemberVo(Long.valueOf(Objects.requireNonNull(Aes256Util.decrypt(c.getId()))) ,Aes256Util.decrypt(c.getSubject()));
    }
}

