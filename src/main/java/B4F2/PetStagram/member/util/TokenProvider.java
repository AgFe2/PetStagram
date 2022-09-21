package B4F2.PetStagram.member.util;

import B4F2.PetStagram.member.domain.MemberVo;
import B4F2.PetStagram.member.service.MemberService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class TokenProvider {

    private final MemberService memberService;

    @Value("{spring.jwt.secret}")
    private String secretKey;

    private long tokenValidTime = 1000L * 60 * 60 * 24; //1일


    public String createToken(String email, Long id){
//        Claims claims = Jwts.claims().setSubject(Aes256Util.encrypt(email)).setId(Aes256Util.encrypt(id.toString()));
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("email",email);

        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, this.secretKey)
                .compact();
    }

    public Authentication authentication(String token){
        UserDetails userDetails = memberService.loadUserByUsername(getUserEmail(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserEmail(String token){
        return this.parseClaims(token).getSubject();
    }

    //=====토큰에 대한 validation 체크=====
    public boolean validateToken(String token){
        if (!StringUtils.hasText(token)) return false;

        var claims = this.parseClaims(token);
        return !claims.getExpiration().before(new Date());
    }

    // 아이디와 이메일 두개를 저장해서 이걸 기반으로 동작
//    public MemberVo getMemberVo(String token){
//        Claims c = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//        return new MemberVo(Long.valueOf(Objects.requireNonNull(Aes256Util.decrypt(c.getId()))) ,Aes256Util.decrypt(c.getSubject()));
//    }

    private Claims parseClaims(String token){
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}

