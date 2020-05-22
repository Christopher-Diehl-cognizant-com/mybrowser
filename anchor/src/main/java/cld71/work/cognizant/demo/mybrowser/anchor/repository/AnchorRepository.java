/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.anchor.repository;

import cld71.work.cognizant.demo.mybrowser.anchor.model.Anchor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cld71
 */
@Repository
public interface AnchorRepository extends JpaRepository<Anchor, Long>{

}
