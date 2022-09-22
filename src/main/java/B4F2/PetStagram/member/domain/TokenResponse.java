package B4F2.PetStagram.member.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenResponse {

   private String accessToken;
   private String tokenType;

}
