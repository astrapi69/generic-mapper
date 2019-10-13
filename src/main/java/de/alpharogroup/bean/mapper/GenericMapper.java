/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.bean.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.MappingException;

import lombok.NonNull;

/**
 * The Interface {@link GenericMapper} provides the methods for mapping entities to domain objects
 * and back.
 *
 * @param <E>
 *            the element type of the entity object
 * @param <DO>
 *            the generic type of the domain object
 */
public interface GenericMapper<E, DO>
{

	/**
	 * Gets the domain object class.
	 *
	 * @return the domain object class
	 */
	Class<DO> getDomainObjectClass();

	/**
	 * Gets the entity class.
	 *
	 * @return the entity class
	 */
	Class<E> getEntityClass();

	/**
	 * Gets the mapper.
	 *
	 * @return the mapper
	 */
	Mapper getMapper();

	/**
	 * Constructs new instances of destinationClass and performs mapping between from source.
	 *
	 * @param <T>
	 *            the generic type of the destinationClass
	 * @param <S>
	 *            the generic type of the source
	 * @param sources
	 *            the collection of source objects
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 * @throws MappingException
	 *             is thrown if something goes wrong with the mapping process.
	 */
	default <T, S> List<T> map(final @NonNull Collection<S> sources,
		final @NonNull Class<T> destinationClass) throws MappingException
	{
		return MapperExtensions.map(getMapper(), sources, destinationClass);
	};

	/**
	 * Constructs new instance of destinationClass and performs mapping between from source.
	 *
	 * @param <T>
	 *            the generic type of the destinationClass
	 * @param <S>
	 *            the generic type of the source
	 * @param source
	 *            the source
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 * @throws MappingException
	 *             is thrown if something goes wrong with the mapping process.
	 */
	default <T, S> T map(final @NonNull S source, final @NonNull Class<T> destinationClass)
		throws MappingException
	{
		return MapperExtensions.map(getMapper(), source, destinationClass);
	};

	/**
	 * Maps the given entity object to a DTO object
	 *
	 * @param entity
	 *            the entity object
	 * @return the DTO object
	 */
	default DO toDto(final @NonNull E entity)
	{
		return getMapper().map(entity, getDomainObjectClass());
	}

	/**
	 * Maps the given collection of entity objects to a list of DTO objects
	 *
	 * @param entities
	 *            the collection of entities objects
	 * @return the list of DTO objects
	 */
	default List<DO> toDtos(final @NonNull Collection<E> entities)
	{
		final List<DO> domainObjects = new ArrayList<>();
		if (!entities.isEmpty())
		{
			for (final E entity : entities)
			{
				domainObjects.add(toDto(entity));
			}
		}
		return domainObjects;
	};

	/**
	 * Maps the given list of domain objects to a list of entity objects.
	 *
	 * @param domainObjects
	 *            the list of domain objects
	 * @return the list of entity objects.
	 */
	default List<E> toEntities(final @NonNull Collection<DO> domainObjects)
	{
		final List<E> entities = new ArrayList<>();
		if (!domainObjects.isEmpty())
		{
			for (final DO domainObject : domainObjects)
			{
				entities.add(toEntity(domainObject));
			}
		}
		return entities;
	};

	/**
	 * Maps the given domain object to a entity object.
	 *
	 * @param domainObject
	 *            the domain object
	 * @return the entity object
	 */
	default E toEntity(final @NonNull DO domainObject)
	{
		return getMapper().map(domainObject, getEntityClass());
	};

}