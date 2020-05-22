/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.folder.repository;

import cld71.work.cognizant.demo.mybrowser.folder.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cld71
 */
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long>{

}
