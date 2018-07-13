package mdoe.hobbyproject.services;

import mdoe.hobbyproject.domain.DomainObject;

import java.util.List;

public interface CRUDService<T> {
    List<? extends DomainObject> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}

