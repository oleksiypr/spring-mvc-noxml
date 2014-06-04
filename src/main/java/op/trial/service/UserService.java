package op.trial.service;

import java.util.List;

import op.trial.domain.User;

public interface UserService {
	void save(User u);
	User find(int id);
	List<User>findAll();
}
