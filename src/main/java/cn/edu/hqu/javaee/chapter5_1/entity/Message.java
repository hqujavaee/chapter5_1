package cn.edu.hqu.javaee.chapter5_1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="message")
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//注意@Column中的name如果采用驼峰写法会映射到数据库列时会自动转换成下划线写法
	//比如postedTime会被映射到数据库的posted_Time，如果不小心就会发生数据库列找不到的问题
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Getter
	@Setter
	@Column(name="message",length=2000)
	private String message;
	
	@Getter
	@Setter
	@Column(name="postedtime")
	@Temporal(value=TemporalType.DATE)
	@NotEmpty
	private Date postedTime;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="username",  nullable = false) 
	private Hquer hquer;
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"id","postedTime");
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","postedTime");
	}

}
