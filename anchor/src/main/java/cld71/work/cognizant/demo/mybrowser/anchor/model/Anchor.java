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
@Table(name = "ANCHOR")
@NamedQueries({
	@NamedQuery(name = "Anchor.findAll", query = "SELECT a FROM Anchor a"),
	@NamedQuery(name = "Anchor.findByAnchorId", query = "SELECT a FROM Anchor a WHERE a.anchorId = :anchorId"),
	@NamedQuery(name = "Anchor.findByCreateDate", query = "SELECT a FROM Anchor a WHERE a.createDate = :createDate"),
	@NamedQuery(name = "Anchor.findByModifiedDate", query = "SELECT a FROM Anchor a WHERE a.modifiedDate = :modifiedDate")})
public class Anchor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ANCHOR_ID")
	private Long anchorId;
	@Basic(optional = false)
	@Lob
	@Column(name = "TITLE")
	private String title;
	@Basic(optional = false)
	@Lob
	@Column(name = "HREF")
	private String href;
	@Lob
	@Column(name = "ICON_URL")
	private String iconUrl;
	@Lob
	@Column(name = "ICON")
	private String icon;
	@Basic(optional = false)
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Basic(optional = false)
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@OneToMany(mappedBy = "parent")
	private Collection<Anchor> anchorCollection;
	@JoinColumn(name = "PARENT", referencedColumnName = "ANCHOR_ID")
	@ManyToOne
	private Anchor parent;
	@JoinColumn(name = "PARENT_FOLDER", referencedColumnName = "FOLDER_ID")
	@ManyToOne
	private Folder parentFolder;

	public Anchor(){
	}

	public Anchor(Long anchorId){
		this.anchorId = anchorId;
	}

	public Anchor(Long anchorId, String title, String href, Date createDate, Date modifiedDate){
		this.anchorId = anchorId;
		this.title = title;
		this.href = href;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

	public Long getAnchorId(){
		return anchorId;
	}

	public void setAnchorId(Long anchorId){
		this.anchorId = anchorId;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getHref(){
		return href;
	}

	public void setHref(String href){
		this.href = href;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIcon(){
		return icon;
	}

	public void setIcon(String icon){
		this.icon = icon;
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

	public Anchor getParent(){
		return parent;
	}

	public void setParent(Anchor parent){
		this.parent = parent;
	}

	public Folder getParentFolder(){
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder){
		this.parentFolder = parentFolder;
	}

	@Override
	public int hashCode(){
		int hash = 0;
		hash += (anchorId != null ? anchorId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object){
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Anchor)){
			return false;
		}
		Anchor other = (Anchor) object;
		if((this.anchorId == null && other.anchorId != null) || (this.anchorId != null && !this.anchorId.equals(other.anchorId))){
			return false;
		}
		return true;
	}

	@Override
	public String toString(){
		return "cld71.demo.bookmarks.database.Anchor[ anchorId=" + anchorId + " ]";
	}

}
