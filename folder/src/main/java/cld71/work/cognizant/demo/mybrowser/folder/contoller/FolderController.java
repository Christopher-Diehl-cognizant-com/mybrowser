/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.folder.contoller;

import cld71.work.cognizant.demo.mybrowser.folder.model.Folder;
import cld71.work.cognizant.demo.mybrowser.folder.repository.FolderRepository;
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
public class FolderController{

	@Autowired
	private FolderRepository folderRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Folder> getFolders(){
		return this.folderRepository.findAll();
	}

	@RequestMapping(path = "/{folderId}", method = RequestMethod.GET)
	public Folder getFolder(@PathVariable Long folderId){
		return this.folderRepository.findById(folderId).get();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Folder newFolder(@RequestBody Folder folder){
		return this.folderRepository.save(folder);
	}

	@RequestMapping(path = "/{folderId}", method = RequestMethod.PUT)
	public Folder replaceFolder(@RequestBody Folder newFolder, @PathVariable Long folderId){
		return this.folderRepository.findById(folderId).map(folder -> {
			folder.setFolderName(newFolder.getFolderName());
			folder.setParent(newFolder.getParent());
			return this.folderRepository.save(folder);
		}).orElseGet(() -> {
			newFolder.setFolderId(folderId);
			return this.folderRepository.save(newFolder);
		});
	}

	@RequestMapping(path = "/{folderId}", method = RequestMethod.PATCH)
	public Folder patchFolder(@RequestBody Folder newFolder, @PathVariable Long folderId){
		return this.folderRepository.findById(folderId).map(folder -> {
			if(newFolder.getFolderName() != null){
				folder.setFolderName(newFolder.getFolderName());
			}
			if(newFolder.getParent() != null){
				folder.setParent(newFolder.getParent());
			}
			return this.folderRepository.save(folder);
		}).orElseGet(() -> {
			newFolder.setFolderId(folderId);
			return this.folderRepository.save(newFolder);
		});
	}

	@RequestMapping(path = "/{folderId}", method = RequestMethod.DELETE)
	public void deleteFolder(@PathVariable Long folderId){
		this.folderRepository.deleteById(folderId);
	}
}
