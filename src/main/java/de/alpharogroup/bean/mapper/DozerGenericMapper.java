/**
 * The MIT License
 * <p>
 * Copyright (C) 2015 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.bean.mapper;

import lombok.NonNull;
import org.dozer.Mapper;
import org.dozer.MappingException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Interface {@link DozerGenericMapper} provides the methods for mapping entities to data
 * transfer objects and back.
 *
 * @param <ENTITY> the element type of the entity object
 * @param <DTO>    the generic type of the data transfer object
 */
public interface DozerGenericMapper<ENTITY, DTO> extends GenericMapper<ENTITY, DTO>
{

	/**
	 * Gets the data transfer object class.
	 *
	 * @return the data transfer object class
	 */
	Class<DTO> getDtoClass();

	/**
	 * Gets the entity class.
	 *
	 * @return the entity class
	 */
	Class<ENTITY> getEntityClass();

	/**
	 * Gets the mapper.
	 *
	 * @return the mapper
	 */
	Mapper getMapper();

	/**
	 * Constructs new instances of destinationClass and performs mapping between from source.
	 *
	 * @param <S>              the generic type of the source
	 * @param <D>              the generic type of the destinationClass
	 * @param sources          the collection of source objects
	 * @param destinationClass the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 * @throws MappingException is thrown if something goes wrong with the mapping process.
	 */
	default <D, S> List<D> map(final @NonNull Collection<S> sources,
		final @NonNull Class<D> destinationClass) throws MappingException
	{
		return MapperExtensions.map(getMapper(), sources, destinationClass);
	}

	/**
	 * Constructs new instance of destinationClass and performs mapping between from source.
	 *
	 * @param <D>              the generic type of the destinationClass
	 * @param <S>              the generic type of the source
	 * @param source           the source
	 * @param destinationClass the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 * @throws MappingException is thrown if something goes wrong with the mapping process.
	 */
	default <D, S> D map(final @NonNull S source, final @NonNull Class<D> destinationClass)
		throws MappingException
	{
		return MapperExtensions.map(getMapper(), source, destinationClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override default DTO toDto(final @NonNull ENTITY entity)
	{
		return getMapper().map(entity, getDtoClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override default List<DTO> toDtos(final @NonNull Collection<ENTITY> entities)
	{
		final List<DTO> domainObjects = new ArrayList<>();
		if (!entities.isEmpty())
		{
			for (final ENTITY entity : entities)
			{
				domainObjects.add(toDto(entity));
			}
		}
		return domainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override default List<ENTITY> toEntities(final @NonNull Collection<DTO> dtos)
	{
		final List<ENTITY> entities = new ArrayList<>();
		if (!dtos.isEmpty())
		{
			for (final DTO dto : dtos)
			{
				entities.add(toEntity(dto));
			}
		}
		return entities;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override default ENTITY toEntity(final @NonNull DTO dto)
	{
		return getMapper().map(dto, getEntityClass());
	}

}