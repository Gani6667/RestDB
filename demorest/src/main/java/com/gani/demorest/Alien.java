package com.gani.demorest;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien
{
	private String name;
	private int points;
	private int id;
	
	
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int setId) {
		this.id = setId;
	}
	public String getName() {
		return name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, points);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alien other = (Alien) obj;
		return id == other.id && Objects.equals(name, other.name) && points == other.points;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	

}
