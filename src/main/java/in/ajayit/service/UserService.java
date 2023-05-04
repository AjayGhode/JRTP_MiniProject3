package in.ajayit.service;

import in.ajayit.binding.Login;
import in.ajayit.binding.Register;

public interface UserService {

	
	public Boolean register(Register register);
	
	public String login(Login login);
}