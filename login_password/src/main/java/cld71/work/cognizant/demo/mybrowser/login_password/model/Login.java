package cld71.work.cognizant.demo.mybrowser.login_password.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cld71
 */
@Entity
@Table(name = "LOGIN")
@NamedQueries({
	@NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
	@NamedQuery(name = "Login.findByLoginId", query = "SELECT l FROM Login l WHERE l.loginId = :loginId"),
	@NamedQuery(name = "Login.findByTimeUsed", query = "SELECT l FROM Login l WHERE l.timeUsed = :timeUsed"),
	@NamedQuery(name = "Login.findByCreateDate", query = "SELECT l FROM Login l WHERE l.createDate = :createDate"),
	@NamedQuery(name = "Login.findByUsedDate", query = "SELECT l FROM Login l WHERE l.usedDate = :usedDate"),
	@NamedQuery(name = "Login.findByPasswordChanged", query = "SELECT l FROM Login l WHERE l.passwordChanged = :passwordChanged")})
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "LOGIN_ID")
	private Long loginId;
	@Basic(optional = false)
	@Lob
	@Column(name = "GUID")
	private byte[] guid;
	@Basic(optional = false)
	@Lob
	@Column(name = "USERNAME")
	private String username;
	@Basic(optional = false)
	@Lob
	@Column(name = "PASSWORD")
	private String password;
	@Basic(optional = false)
	@Lob
	@Column(name = "DISPLAY_ORIGIN")
	private String displayOrigin;
	@Basic(optional = false)
	@Lob
	@Column(name = "ORIGIN")
	private String origin;
	@Basic(optional = false)
	@Lob
	@Column(name = "HOSTNAME")
	private String hostname;
	@Basic(optional = false)
	@Lob
	@Column(name = "FORM_ACTION_ORIGIN")
	private String formActionOrigin;
	@Basic(optional = false)
	@Lob
	@Column(name = "FORM_SUBMIT_URL")
	private String formSubmitUrl;
	@Basic(optional = false)
	@Lob
	@Column(name = "HTTP_REALM")
	private String httpRealm;
	@Basic(optional = false)
	@Lob
	@Column(name = "USERNAME_FIELD")
	private String usernameField;
	@Basic(optional = false)
	@Lob
	@Column(name = "PASSWORD_FIELD")
	private String passwordField;
	@Basic(optional = false)
	@Column(name = "TIME_USED")
	private int timeUsed;
	@Basic(optional = false)
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Basic(optional = false)
	@Column(name = "USED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date usedDate;
	@Basic(optional = false)
	@Column(name = "PASSWORD_CHANGED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date passwordChanged;

	public Login(){
	}

	public Login(Long loginId){
		this.loginId = loginId;
	}

	public Login(Long loginId, byte[] guid, String username, String password, String displayOrigin, String origin, String hostname, String formActionOrigin, String formSubmitUrl, String httpRealm, String usernameField, String passwordField, int timeUsed, Date createDate, Date usedDate, Date passwordChanged){
		this.loginId = loginId;
		this.guid = guid;
		this.username = username;
		this.password = password;
		this.displayOrigin = displayOrigin;
		this.origin = origin;
		this.hostname = hostname;
		this.formActionOrigin = formActionOrigin;
		this.formSubmitUrl = formSubmitUrl;
		this.httpRealm = httpRealm;
		this.usernameField = usernameField;
		this.passwordField = passwordField;
		this.timeUsed = timeUsed;
		this.createDate = createDate;
		this.usedDate = usedDate;
		this.passwordChanged = passwordChanged;
	}

	public Long getLoginId(){
		return loginId;
	}

	public void setLoginId(Long loginId){
		this.loginId = loginId;
	}

	public byte[] getGuid(){
		return guid;
	}

	public void setGuid(byte[] guid){
		this.guid = guid;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getDisplayOrigin(){
		return displayOrigin;
	}

	public void setDisplayOrigin(String displayOrigin){
		this.displayOrigin = displayOrigin;
	}

	public String getOrigin(){
		return origin;
	}

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public String getHostname(){
		return hostname;
	}

	public void setHostname(String hostname){
		this.hostname = hostname;
	}

	public String getFormActionOrigin(){
		return formActionOrigin;
	}

	public void setFormActionOrigin(String formActionOrigin){
		this.formActionOrigin = formActionOrigin;
	}

	public String getFormSubmitUrl(){
		return formSubmitUrl;
	}

	public void setFormSubmitUrl(String formSubmitUrl){
		this.formSubmitUrl = formSubmitUrl;
	}

	public String getHttpRealm(){
		return httpRealm;
	}

	public void setHttpRealm(String httpRealm){
		this.httpRealm = httpRealm;
	}

	public String getUsernameField(){
		return usernameField;
	}

	public void setUsernameField(String usernameField){
		this.usernameField = usernameField;
	}

	public String getPasswordField(){
		return passwordField;
	}

	public void setPasswordField(String passwordField){
		this.passwordField = passwordField;
	}

	public int getTimeUsed(){
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed){
		this.timeUsed = timeUsed;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	public Date getUsedDate(){
		return usedDate;
	}

	public void setUsedDate(Date usedDate){
		this.usedDate = usedDate;
	}

	public Date getPasswordChanged(){
		return passwordChanged;
	}

	public void setPasswordChanged(Date passwordChanged){
		this.passwordChanged = passwordChanged;
	}

	@Override
	public int hashCode(){
		int hash = 0;
		hash += (loginId != null ? loginId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object){
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Login)){
			return false;
		}
		Login other = (Login) object;
		if((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))){
			return false;
		}
		return true;
	}

	@Override
	public String toString(){
		return "cld71.demo.bookmarks.database.Login[ loginId=" + loginId + " ]";
	}

}
