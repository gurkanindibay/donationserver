package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.core.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, I> {
    Optional<T> findById(I id);

    List<T> findAll();

    void delete(T entity);

    void delete(I id);

    <S extends T> S save(S entity);
}
