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
package io.github.astrapi69.model.mapper;

import io.github.astrapi69.bean.mapper.GenericMapper;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * The Interface {@link GenericModelMapper} provides the methods for mapping entities to data
 * transfer objects and back.
 *
 * @param <ENTITY>
 *            the element type of the entity object
 * @param <DTO>
 *            the generic type of the data transfer object
 */
public interface GenericModelMapper<ENTITY, DTO> extends GenericMapper<ENTITY, DTO, ModelMapper>
{

	/**
	 * Constructs new instances of destinationClass and performs mapping between from source.
	 *
	 * @param <S>
	 *            the generic type of the source
	 * @param <D>
	 *            the generic type of the destinationClass
	 * @param sources
	 *            the collection of source objects
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 */
	@Override
	default <D, S> List<D> map(final Collection<S> sources, final Class<D> destinationClass)
	{
		Objects.requireNonNull(sources);
		Objects.requireNonNull(destinationClass);
		return ModelMapperExtensions.map(getMapper(), sources, destinationClass);
	}

	/**
	 * Constructs new instance of destinationClass and performs mapping between from source.
	 *
	 * @param <D>
	 *            the generic type of the destinationClass
	 * @param <S>
	 *            the generic type of the source
	 * @param source
	 *            the source
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 */
	@Override
	default <D, S> D map(final S source, final Class<D> destinationClass)
	{
		Objects.requireNonNull(source);
		Objects.requireNonNull(destinationClass);
		return ModelMapperExtensions.map(getMapper(), source, destinationClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	default DTO toDto(final ENTITY entity)
	{
		Objects.requireNonNull(entity);
		return map(entity, getDtoClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	default ENTITY toEntity(final DTO dto)
	{
		Objects.requireNonNull(dto);
		return map(dto, getEntityClass());
	}

}
