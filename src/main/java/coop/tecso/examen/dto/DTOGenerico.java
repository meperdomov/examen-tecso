package coop.tecso.examen.dto;

import java.io.Serializable;

public abstract interface DTOGenerico extends Serializable {
	
	public abstract Serializable getId();

	public abstract void setId(Serializable paramSerializable);
	
}