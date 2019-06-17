package beautysalon.model.services;

import beautysalon.model.entities.User;
import beautysalon.model.entities.WorkingDay;
import beautysalon.model.repositories.UserRepository;
import beautysalon.model.repositories.WorkingDayRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private WorkingDayRepository workingDayRepository;

    public UserService(UserRepository userRepository,
                       WorkingDayRepository workingDayRepository) {
        this.userRepository = userRepository;
        this.workingDayRepository = workingDayRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByLogin(s);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    public List<WorkingDay> getAvailableMasterWorkingDays(String surnameEn) {
        return workingDayRepository.findAllByMasterId(userRepository.findBySurnameEn(surnameEn));
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void updatePassword(User user, String newPassword) {
        userRepository.updatePassword(newPassword, user.getId());
    }
}
