package Snacks.jsoupWebCrawling.User;

import Snacks.jsoupWebCrawling.Repository.UserRepository;
import Snacks.jsoupWebCrawling.User.Dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

   public void signUp(UserSignUpDto userSignUpDto) throws Exception{
       User user = userSignUpDto.toEntity();
       user.addUserAuthority();
       user.encodePassword(passwordEncoder);
       System.out.println(userRepository.findByUserId(user.getUserId()));

       if(!userRepository.findByUserId(user.getUserId()).isEmpty()){
           throw new Exception("이미 존재하는 이이디입니다.");
       }
        userRepository.save(user);
   }

}
/*TODO:
*  1) User 2) UserDTO 3) UserService 4) UserServiceImpl 5) UserResponseDto */