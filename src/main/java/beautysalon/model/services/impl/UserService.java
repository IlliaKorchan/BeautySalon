package beautysalon.model.services.impl;

import beautysalon.model.entities.User;
import beautysalon.model.entities.WorkingDay;
import beautysalon.model.repositories.UserRepository;
import beautysalon.model.repositories.WorkingDayRepository;
import beautysalon.model.services.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService, UserProcessor {
    private UserRepository userRepository;
    @Autowired
    private WorkingDayRepository workingDayRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByLogin(s);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<WorkingDay> getAvailableMasterWorkingDays(String surnameEn) {
        return workingDayRepository.findAllByMasterId(userRepository.findBySurnameEn(surnameEn));
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}
