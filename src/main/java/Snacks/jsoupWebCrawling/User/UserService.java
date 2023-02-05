package Snacks.jsoupWebCrawling.User;

import Snacks.jsoupWebCrawling.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional //로직을 처리하다가 에러가 발생하면, 변경된 데이터를 로직을 수행하기 이전 상태로 콜백
@Service
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        validateDuplicateMember(user);
        return userRepository.save(user);
    }
    private void validateDuplicateMember(User user) {
        User findMember = userRepository.findByUserId(user.getUserId());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}