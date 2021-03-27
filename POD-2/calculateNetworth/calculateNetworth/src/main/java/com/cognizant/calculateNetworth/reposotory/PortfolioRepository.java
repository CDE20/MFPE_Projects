package com.cognizant.calculateNetworth.reposotory;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.calculateNetworth.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{

}
