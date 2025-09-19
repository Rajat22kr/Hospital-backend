package in.rajat.main.service;

import java.util.List;

import in.rajat.main.dto.LoginDTO;
import in.rajat.main.dto.UserDTO;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
    String login(LoginDTO dto);

}
