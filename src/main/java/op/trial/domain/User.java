package op.trial.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 201303111143L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	@Column
	public String name;
	
	@Column
	public String address;

	public User() {
	}

	public User(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}	
	
	@Override
	public String toString() {
		return "User [address=" + address + ", id=" + id + ", name=" + name + "]";
	}
}
