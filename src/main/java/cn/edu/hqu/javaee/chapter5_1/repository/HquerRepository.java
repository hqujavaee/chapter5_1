package cn.edu.hqu.javaee.chapter5_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cn.edu.hqu.javaee.chapter5_1.entity.Hquer;

@Repository
public interface HquerRepository extends JpaRepository<Hquer,String>{
	Hquer findByUserName(String userName);
}
