package be.vdab.dao;

import be.vdab.entities.Docent;

public class DocentDAO extends AbstractDAO{

	public Docent read(long id) {
		return getEntityManager().find(Docent.class, id);
	}

	public void create(Docent docent) {
		getEntityManager().persist(docent);
	}

	public void delete(long id) {
		Docent docent = getEntityManager().find(Docent.class, id);
		if (docent != null) {
			getEntityManager().remove(docent);
		}
	}
}
