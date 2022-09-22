package B4F2.PetStagram.member.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class GetEmail {

    public Object getEmailFromToken(HttpServletRequest request) {

        String email = (String) request.getAttribute("email");

        return email;
    }
}
