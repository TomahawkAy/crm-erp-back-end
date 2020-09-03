package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Enums.*;

@Entity
public class Claim implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Enumerated(EnumType.STRING)
	private  ClaimPriority priority ;
	
	@Enumerated(EnumType.STRING)
	private  ClaimStatus status ;
	
	@Enumerated(EnumType.STRING)
	private  ClaimType type ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date openedAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date resolvedAt;
	
	@OneToMany
	private Client createdBy;
	
	@OneToMany
	private Agent resolvedBy;
	
	@OneToMany
	private Agent responsable;
	
	@OneToMany(mappedBy="claim")
	private List<NoteClaim> notes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ClaimPriority getPriority() {
		return priority;
	}
	public void setPriority(ClaimPriority priority) {
		this.priority = priority;
	}
	public ClaimStatus getStatus() {
		return status;
	}
	public void setStatus(ClaimStatus status) {
		this.status = status;
	}
	public ClaimType getType() {
		return type;
	}
	public void setType(ClaimType type) {
		this.type = type;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getOpenedAt() {
		return openedAt;
	}
	public void setOpenedAt(Date openedAt) {
		this.openedAt = openedAt;
	}
	public Date getResolvedAt() {
		return resolvedAt;
	}
	public void setResolvedAt(Date resolvedAt) {
		this.resolvedAt = resolvedAt;
	}
	public Agent getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(Agent resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public Client getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Client createdBy) {
		this.createdBy = createdBy;
	}
	public List<NoteClaim> getNotes() {
		return notes;
	}
	public void setNotes(List<NoteClaim> notes) {
		this.notes = notes;
	}
	public void addNote(NoteClaim note) {
		note.setClaim(this);
		this.notes.add(note);
	}
	public void removeNote(NoteClaim note) {
		this.notes.remove(note.getId());
		note.setClaim(null);
	}
	public Agent getResponsable() {
		return responsable;
	}
	public void setResponsable(Agent responsable) {
		this.responsable = responsable;
	}		
}
