package B4F2.PetStagram.member.service;

import javax.servlet.http.HttpServletRequest;

public class GetEmail {

    public Object getEmailFromToken(HttpServletRequest request) {

        String email = (String) request.getAttribute("email");

        return email;
    }
}
