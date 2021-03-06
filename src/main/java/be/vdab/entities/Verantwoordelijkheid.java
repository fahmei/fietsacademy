package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "verantwoordelijkheden")
public class Verantwoordelijkheid implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id; // je maakt zelf een getter
	private String naam; // je maakt zelf een getter

	@ManyToMany(mappedBy="verantwoordelijkheden")
	private Set<Docent> docenten;

	// GETTERS
	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Set<Docent> getDocenten() {
		return Collections.unmodifiableSet(docenten);
	}

	// SETTERS
	public void addDocent(Docent docent) {
		docenten.add(docent);
		if (!docent.getVerantwoordelijkheden().contains(this)) {
			docent.addVerantwoordelijkheid(this);
		}
	}

	public void removeDocent(Docent docent) {
		docenten.remove(docent);
		if (docent.getVerantwoordelijkheden().contains(this)) {
			docent.removeVerantwoordelijkheid(this);
		}
	}

	// OVERRIDES
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Verantwoordelijkheid)) {
			return false;
		}
		return ((Verantwoordelijkheid) obj).naam.equalsIgnoreCase(this.naam);
	}

	@Override
	public int hashCode() {
		return naam.toUpperCase().hashCode();
	}

}
