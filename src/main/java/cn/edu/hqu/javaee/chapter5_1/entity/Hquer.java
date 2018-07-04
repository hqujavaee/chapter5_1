package cn.edu.hqu.javaee.chapter5_1.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hquer")
public class Hquer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@NotEmpty
	@Id
	@Column(name="username")
	private String userName;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="firstname")
	private String firstName;
	@Getter
	@Setter
	@NotEmpty
	@Column(name="lastname")
	private String lastName;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="password")
	private String password;
	
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="email")
	private String email;
	
	@Getter
	@Setter
	@OneToMany(mappedBy="hquer",cascade=CascadeType.REMOVE)
	private List<Message> messageList;
	
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "userName");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "userName");
	}
}
