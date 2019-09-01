package com.master.spring.university.database.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class ExtendedRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements ExtendedRepository<T, ID> {

	EntityManager entityManager;

	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findByAttributes(Parameters parameters) {
		TypedQuery<T> findByAttributes = entityManager.createNamedQuery("findByAttributes", this.getDomainClass());
		parameters.getParametersMap().forEach((key, value) -> findByAttributes.setParameter(key, value));
		return findByAttributes.getResultList();
	}

}
