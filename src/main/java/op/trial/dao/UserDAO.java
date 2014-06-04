package op.trial.dao;

import java.util.List;
import op.trial.domain.User;

public interface UserDAO {
	void save(User u);
	User find(int id);
	List<User>findAll();
}
