package in.rajat.main.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import in.rajat.main.entities.User;
import in.rajat.main.repositories.UserRepository;
import in.rajat.main.dto.LoginDTO;
import in.rajat.main.dto.UserDTO;
import in.rajat.main.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .contact(user.getContact())
                .role(user.getRole())
                .gender(user.getGender())
                .address(user.getAddress())
                .build();
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User user = User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .contact(dto.getContact())
                .role(dto.getRole())
                .gender(dto.getGender())
                .address(dto.getAddress())
                .build();
        return convertToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    
    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.getName() != null) user.setName(dto.getName());
        if (dto.getPassword() != null) user.setPassword(dto.getPassword());
        if (dto.getContact() != null) user.setContact(dto.getContact());
        if (dto.getRole() != null) user.setRole(dto.getRole());
        if (dto.getGender() != null) user.setGender(dto.getGender());
        if (dto.getAddress() != null) user.setAddress(dto.getAddress());

        return convertToDTO(userRepository.save(user));
    }

    
    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id))
            throw new RuntimeException("User not found");
        userRepository.deleteById(id);
    }
    
    
    @Override
    public String login(LoginDTO dto) {
        User user = userRepository.findByName(dto.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPassword() != null && user.getPassword().equals(dto.getPassword())) {
            return "Login successful for role: " + user.getRole();
        } else {
            throw new RuntimeException("Invalid password");
        }
    }

}
