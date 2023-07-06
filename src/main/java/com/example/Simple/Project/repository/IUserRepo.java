package com.example.Simple.Project.repository;

import com.example.Simple.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {

}
