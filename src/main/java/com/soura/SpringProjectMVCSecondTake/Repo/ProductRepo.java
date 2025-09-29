package com.soura.SpringProjectMVCSecondTake.Repo;

import com.soura.SpringProjectMVCSecondTake.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
