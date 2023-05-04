package in.ajayit.serviceImpl;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajayit.binding.Login;
import in.ajayit.binding.Register;
import in.ajayit.entity.User;
import in.ajayit.repo.UserRepo;
import in.ajayit.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public Boolean register(Register register) {
		
		User findUser = userRepo.findByEmail(register.getEmail());
		
		Optional<User> optional = Optional.ofNullable(findUser);
		
		if (optional.isEmpty()) {
			
			User user=new User();
			
			BeanUtils.copyProperties(register, user);
			
			userRepo.save(user);
			
			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public String login(Login login) {
		
		User user = userRepo.findByEmail(login.getEmail());
		
		Optional<User> optional = Optional.ofNullable(user);
		
		if (optional.isPresent() ) {
			
			if (login.getPwd().equals(user.getPwd())) {
				
				session.setAttribute("userId", user.getUserId());
				
				return "success";
			}
			else {
				return "Invalid Password";
			}
		}else {
			return "User not available";
		}
		
		
	}

}