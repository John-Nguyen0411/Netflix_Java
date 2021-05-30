package model;
// default package
// Generated Apr 27, 2021, 3:04:25 PM by Hibernate Tools 5.4.27.Final

import java.util.Date;

/**
 * ActorMovie generated by hbm2java
 */
public class ActorMovie implements java.io.Serializable {

	private int stt;
	private Actor actor;
	private Movie movie;
	private int movie_id;
	
	private String firstName;
	private String LastName;

	private int actor_id;
	private Date lastUpDate;
	private String last_update;
	
	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

	public ActorMovie() {
	}

	public ActorMovie(int stt, Actor actor, Movie movie) {
		this.stt = stt;
		this.actor = actor;
		this.movie = movie;
	}

	public ActorMovie(int stt, Actor actor, Movie movie, Date lastUpDate) {
		this.stt = stt;
		this.actor = actor;
		this.movie = movie;
		this.lastUpDate = lastUpDate;
	}
	public ActorMovie(int stt, int movie_id, int actor_id) {
		this.stt = stt;
		this.movie_id = movie_id;
		this.actor_id = actor_id;
	}
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public int getStt() {
		return this.stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getLastUpDate() {
		return this.lastUpDate;
	}

	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}


}