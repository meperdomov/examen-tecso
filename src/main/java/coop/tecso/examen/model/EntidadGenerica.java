package coop.tecso.examen.model;

import java.io.Serializable;

public abstract class EntidadGenerica implements Serializable {

	/**
	 * Serialversion
	 */
	private static final long serialVersionUID = 8193992920232946654L;

	public abstract coop.tecso.examen.dto.DTOGenerico getDTO(String... camposIgnorados);

}
