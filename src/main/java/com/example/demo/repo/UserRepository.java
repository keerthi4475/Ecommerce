package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username);
	@Query(value="select * from User where username =?1 and password=?2", nativeQuery = true)
	User getUserPwd(String username,String password);
}
