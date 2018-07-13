package mdoe.hobbyproject.services;


import mdoe.hobbyproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    private Converter<User, UserDetails> userConverter;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    @Qualifier(value = "userToUserDetailsConverter")
    public void setUserConverter(Converter<User, UserDetails> userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userConverter.convert(this.userService.findByUsername(s));
    }
}
