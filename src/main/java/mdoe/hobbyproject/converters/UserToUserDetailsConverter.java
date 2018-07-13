package mdoe.hobbyproject.converters;

import mdoe.hobbyproject.domain.User;
import mdoe.hobbyproject.domain.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Component
public class UserToUserDetailsConverter implements Converter<User, UserDetails> {

    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getEncryptedPassword());
        userDetails.setEnabled(user.getEnabled());
        userDetails.setAuthorities(this.getUserAuthorities(user));

        return userDetails;
    }

    private Collection<SimpleGrantedAuthority> getUserAuthorities(User user) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return authorities;
    }
}