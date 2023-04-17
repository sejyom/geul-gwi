package com.posmosalimos.geulgwi.service;

import com.posmosalimos.geulgwi.entity.User;
import com.posmosalimos.geulgwi.form.UserForm;
import com.posmosalimos.geulgwi.repository.JpaUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final JpaUserRepository jpaUserRepository;

    //validateDuplicateUser
    private void validateDuplicateUser(User user) {
        List<User> findUsers = jpaUserRepository.findByUsername(user.getUserName());

        if (!findUsers.isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    //join
    @Transactional
    public Long join(@Valid UserForm form) {
        User user = new User();
        user.setUserId(form.getUserId());
        user.setUserPassword(form.getUserPassword());
        user.setUserName(form.getUserName());
        user.setUserAge(form.getUserAge());
        user.setUserGender(form.getUserGender());
        user.setUserAddress(form.getUserAddress());
        user.setRole(form.getRole());

        validateDuplicateUser(user);
        jpaUserRepository.save(user);

        return user.getUserNumber();
    }
}