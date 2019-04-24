package com.common.base;

public interface ICRUDService<T> {

	  public Boolean validate(T entity);

	  public Boolean validateForInsert(T entity);

	  public Boolean validateForUpdate(T entity);

	  public Boolean validateForDelete(T entity);
}
