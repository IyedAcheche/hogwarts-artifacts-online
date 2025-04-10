package edu.tcu.cs.hogwartsartifactsonline.hogwartsuser;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<HogwartsUser> findAll() {
        return this.userRepository.findAll();
    }

    public HogwartsUser findById(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public HogwartsUser save(HogwartsUser newUser) {
        return this.userRepository.save(newUser);
    }

    public HogwartsUser update(Integer id, HogwartsUser update) {
        return this.userRepository.findById(id)
                .map(oldUser -> {
                    oldUser.setUsername(update.getUsername());
                    oldUser.setEnabled(update.isEnabled());
                    oldUser.setRoles(update.getRoles());
                    return this.userRepository.save(oldUser);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Integer id) {
        this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        this.userRepository.deleteById(id);
    }
} 