/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.login_password.repository;

import cld71.work.cognizant.demo.mybrowser.login_password.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cld71
 */
public interface LoginRepository extends JpaRepository<Login, Long>{

}
