package com.bebo.bluefolio.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;


@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long portfolioId;

    public Portfolio() {}

    public Portfolio(String firstname, String lastname) {
      super();
      this.firstname = firstname;
      this.lastname = lastname;
    }

	public long getOwnerid() {
		return portfolioId;
	}

	public void setOwnerid(long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	

	// cascade ALL means delete all cars when owner is deleted
	@OneToMany(cascade = CascadeType.ALL, mappedBy="portfolio")
	@JsonIgnore
	private List<Stock> stocks;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	// if using many-to-many relationship, use a Set instead of List
    
	// Many-to-many implementation
//    @ManyToMany(mappedBy = "cars") 
//    private Set<Owner> owners; 
//
//    public Set<Owner> getOwners() {
//      return owners;
//    }
//
//    public void setOwners(Set<Owner> owners) {
//      this.owners = owners;
//    }
	
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "car_owner", joinColumns = { @JoinColumn(name =
//     "ownerid") }, inverseJoinColumns = { @JoinColumn(name = "id") }) 
//    private Set<Car> cars = new HashSet<Car>(0); 
//
//    public Set<Car> getCars() {
//      return cars;
//    }
//
//    public void setCars(Set<Car> cars) {
//      this.cars = cars;
//    }
    
	// Getter and setter
	public List<Stock> getStocks() {
		return stocks;
	}
	
	public void setCars(List<Stock> stocks) {
		this.stocks= stocks;
	}
}
