package io.rushi.SpringWebProject.Repository;

import io.rushi.SpringWebProject.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Repository -> Uses Jpa and hibernate to connect to our reqd
// database and tables
public interface UserRepository extends JpaRepository<UserTable, Integer> {

    //Custom Query
    //join queries

 boolean existsByUsernameAndPassword(String un,String pwd);
}
