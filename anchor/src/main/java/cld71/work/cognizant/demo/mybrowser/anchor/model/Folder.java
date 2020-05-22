/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cld71.work.cognizant.demo.mybrowser.anchor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cld71
 */
@Entity
@Table(name = "FOLDER")
@NamedQueries({
	@NamedQuery(name = "Folder.findAll", query = "SELECT f FROM Folder f"),
	@NamedQuery(name = "Folder.findByFolderId", query = "SELECT f FROM Folder f WHERE f.folderId = :folderId"),
	@NamedQuery(name = "Folder.findByToolbarFolder", query = "SELECT f FROM Folder f WHERE f.toolbarFolder = :toolbarFolder"),
	@NamedQuery(name = "Folder.findByCreateDate", query = "SELECT f FROM Folder f WHERE f.createDate = :createDate"),
	@NamedQuery(name = "Folder.findByModifiedDate", query = "SELECT f FROM Folder f WHERE f.modifiedDate = :modifiedDate")})
public class Folder implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "FOLDER_ID")
	private Long folderId;
	@Basic(optional = false)
	@Lob
	@Column(name = "FOLDER_NAME")
	private String folderName;
	@Column(name = "TOOLBAR_FOLDER")
	private Boolean toolbarFolder;
	@Basic(optional = false)
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Basic(optional = false)
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@OneToMany(mappedBy = "parentFolder")
	private Collection<Anchor> anchorCollection;
	@OneToMany(mappedBy = "parent")
	private Collection<Folder> folderCollection;
	@JoinColumn(name = "PARENT", referencedColumnName = "FOLDER_ID")
	@ManyToOne
	private Folder parent;

	public Folder(){
	}

	public Folder(Long folderId){
		this.folderId = folderId;
	}

	public Folder(Long folderId, String folderName, Date createDate, Date modifiedDate){
		this.folderId = folderId;
		this.folderName = folderName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

	public Long getFolderId(){
		return folderId;
	}

	public void setFolderId(Long folderId){
		this.folderId = folderId;
	}

	public String getFolderName(){
		return folderName;
	}

	public void setFolderName(String folderName){
		this.folderName = folderName;
	}

	public Boolean getToolbarFolder(){
		return toolbarFolder;
	}

	public void setToolbarFolder(Boolean toolbarFolder){
		this.toolbarFolder = toolbarFolder;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getModifiedDate(){
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate){
		this.modifiedDate = modifiedDate;
	}

	public Collection<Anchor> getAnchorCollection(){
		return anchorCollection;
	}

	public void setAnchorCollection(Collection<Anchor> anchorCollection){
		this.anchorCollection = anchorCollection;
	}

	public Collection<Folder> getFolderCollection(){
		return folderCollection;
	}

	public void setFolderCollection(Collection<Folder> folderCollection){
		this.folderCollection = folderCollection;
	}

	public Folder getParent(){
		return parent;
	}

	public void setParent(Folder parent){
		this.parent = parent;
	}

	@Override
	public int hashCode(){
		int hash = 0;
		hash += (folderId != null ? folderId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object){
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Folder)){
			return false;
		}
		Folder other = (Folder) object;
		if((this.folderId == null && other.folderId != null) || (this.folderId != null && !this.folderId.equals(other.folderId))){
			return false;
		}
		return true;
	}

	@Override
	public String toString(){
		return "cld71.demo.bookmarks.database.Folder[ folderId=" + folderId + " ]";
	}

}
