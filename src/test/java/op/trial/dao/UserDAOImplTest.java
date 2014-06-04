package op.trial.dao;

import op.trial.config.TestConfig;
import op.trial.domain.User;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(classes = { TestConfig.class })
@Transactional
public class UserDAOImplTest {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Test
	public void testSave() {
		String name = "Test001";
		String address = "Address001";
		
		User user = new User();
		user.id = null;
		user.name = name;
		user.address = address;
		
		userDao.save(user);
		sessionFactory.getCurrentSession().flush();
		
		Assert.notNull(user.id);
		Assert.notNull(user.name);
		Assert.notNull(user.address);
		
		User persisted = (User) sessionFactory.getCurrentSession().get(User.class, user.id);
		
		Assert.notNull(persisted);
		
		Assert.isTrue(user.name.equals(persisted.name));	
		Assert.isTrue(user.address.equals(persisted.address));		
	}
	
	
	@Test
	public void testFind() {
		String name = "Test001";
		String address = "Address001";
		
		User persisted = new User();
		persisted.id = null;
		persisted.name = name;
		persisted.address = address;
		
		sessionFactory.getCurrentSession().saveOrUpdate(persisted);
		sessionFactory.getCurrentSession().flush();
		
		User user = userDao.find(persisted.id);
		
		Assert.notNull(user);
		Assert.notNull(user.id);
		Assert.notNull(user.address);
		
		Assert.isTrue(user.name.equals(persisted.name));	
		Assert.isTrue(user.address.equals(persisted.address));	
	}
}
