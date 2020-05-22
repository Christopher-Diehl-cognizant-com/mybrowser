/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.anchor.controller;

import cld71.work.cognizant.demo.mybrowser.anchor.model.Anchor;
import cld71.work.cognizant.demo.mybrowser.anchor.repository.AnchorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cld71
 */
@RestController
@RequestMapping(path = "/anchor", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AnchorController{

	@Autowired
	private AnchorRepository anchorRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Anchor> getAnchors(){
		return this.anchorRepository.findAll();
	}

	@RequestMapping(path = "/{anchorId}", method = RequestMethod.GET)
	public Anchor getAnchor(@PathVariable Long anchorId){
		return this.anchorRepository.findById(anchorId).get();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Anchor newAnchor(@RequestBody Anchor anchor){
		return this.anchorRepository.save(anchor);
	}

	@RequestMapping(path = "/{anchorId}", method = RequestMethod.PUT)
	public Anchor replaceAnchor(@RequestBody Anchor newAnchor, @PathVariable Long anchorId){
		return this.anchorRepository.findById(anchorId).map(anchor -> {
			anchor.setHref(newAnchor.getHref());
			anchor.setIcon(newAnchor.getIcon());
			anchor.setIconUrl(newAnchor.getIconUrl());
			anchor.setParent(newAnchor.getParent());
			anchor.setParentFolder(newAnchor.getParentFolder());
			anchor.setTitle(newAnchor.getTitle());
			return this.anchorRepository.save(anchor);
		}).orElseGet(() -> {
			newAnchor.setAnchorId(anchorId);
			return this.anchorRepository.save(newAnchor);
		});
	}

	@RequestMapping(path = "/{anchorId}", method = RequestMethod.PATCH)
	public Anchor patchAnchor(@RequestBody Anchor newAnchor, @PathVariable Long anchorId){
		return this.anchorRepository.findById(anchorId).map(anchor -> {
			if(newAnchor.getHref() != null){
				anchor.setHref(newAnchor.getHref());
			}
			if(newAnchor.getIcon() != null){
				anchor.setIcon(newAnchor.getIcon());
			}
			if(newAnchor.getIconUrl() != null){
				anchor.setIconUrl(newAnchor.getIconUrl());
			}
			if(newAnchor.getParent() != null){
				anchor.setParent(newAnchor.getParent());
			}
			if(newAnchor.getParentFolder() != null){
				anchor.setParentFolder(newAnchor.getParentFolder());
			}
			if(newAnchor.getTitle() != null){
				anchor.setTitle(newAnchor.getTitle());
			}
			return this.anchorRepository.save(anchor);
		}).orElseGet(() -> {
			newAnchor.setAnchorId(anchorId);
			return this.anchorRepository.save(newAnchor);
		});
	}

	@RequestMapping(path = "/{anchorId}", method = RequestMethod.DELETE)
	public void deleteAnchor(@PathVariable Long anchorId){
		this.anchorRepository.deleteById(anchorId);
	}

}
