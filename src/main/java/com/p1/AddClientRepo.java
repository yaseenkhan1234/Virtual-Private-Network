package com.p1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AddClientRepo extends JpaRepository<NewClientAdd, String>{
	
	List<NewClientAdd> findBymail(String mail);

}
