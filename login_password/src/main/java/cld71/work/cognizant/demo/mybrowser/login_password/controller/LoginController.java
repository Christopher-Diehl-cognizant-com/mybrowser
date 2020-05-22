/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.login_password.controller;

import cld71.work.cognizant.demo.mybrowser.login_password.model.Login;
import cld71.work.cognizant.demo.mybrowser.login_password.repository.LoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cld71
 */
public class LoginController{

	@Autowired
	private LoginRepository loginRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Login> getLogins(){
		return this.loginRepository.findAll();
	}

	@RequestMapping(path = "/{loginId}", method = RequestMethod.GET)
	public Login getLogin(@PathVariable Long loginId){
		return this.loginRepository.findById(loginId).get();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Login newLogin(@RequestBody Login login){
		return this.loginRepository.save(login);
	}

	@RequestMapping(path = "/{loginId}", method = RequestMethod.PUT)
	public Login replaceLogin(@RequestBody Login newLogin, @PathVariable Long loginId){
		return this.loginRepository.findById(loginId).map(login -> {
			login.setDisplayOrigin(newLogin.getDisplayOrigin());
			login.setGuid(newLogin.getGuid());
			login.setHostname(newLogin.getHostname());
			login.setOrigin(newLogin.getOrigin());
			login.setPassword(newLogin.getPassword());
			login.setPasswordField(newLogin.getPasswordField());
			login.setUsername(newLogin.getUsername());
			login.setUsernameField(newLogin.getUsernameField());
			return this.loginRepository.save(login);
		}).orElseGet(() -> {
			newLogin.setLoginId(loginId);
			return this.loginRepository.save(newLogin);
		});
	}

	@RequestMapping(path = "/{loginId}", method = RequestMethod.PATCH)
	public Login patchLogin(@RequestBody Login newLogin, @PathVariable Long loginId){
		return this.loginRepository.findById(loginId).map(login -> {
			if(newLogin.getDisplayOrigin() != null){
				login.setDisplayOrigin(newLogin.getDisplayOrigin());
			}
			if(newLogin.getGuid() != null){
				login.setGuid(newLogin.getGuid());
			}
			if(newLogin.getHostname() != null){
				login.setHostname(newLogin.getHostname());
			}
			if(newLogin.getOrigin() != null){
				login.setOrigin(newLogin.getOrigin());
			}
			if(newLogin.getPassword() != null){
				login.setPassword(newLogin.getPassword());
			}
			if(newLogin.getPasswordField() != null){
				login.setPasswordField(newLogin.getPasswordField());
			}
			if(newLogin.getUsername() != null){
				login.setUsername(newLogin.getUsername());
			}
			if(newLogin.getUsernameField() != null){
				login.setUsernameField(newLogin.getUsernameField());
			}
			return this.loginRepository.save(login);
		}).orElseGet(() -> {
			newLogin.setLoginId(loginId);
			return this.loginRepository.save(newLogin);
		});
	}

	@RequestMapping(path = "/{loginId}", method = RequestMethod.DELETE)
	public void deleteLogin(@PathVariable Long loginId){
		this.loginRepository.deleteById(loginId);
	}
}
