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

import org.modelmapper.ModelMapper;

import io.github.astrapi69.lang.TypeArgumentsExtensions;
import io.github.astrapi69.model.mapper.factory.ModelMapperFactory;

/**
 * The abstract class {@link AbstractGenericMapper} provides an base implementation for mapping
 * entities to data transfer objects and back.
 *
 * @param <E>
 *            the element type
 * @param <DO>
 *            the generic type
 */
public abstract class AbstractGenericMapper<E, DO> implements GenericModelMapper<E, DO>
{

	/**
	 * The data transfer object class.
	 */
	@SuppressWarnings("unchecked")
	private final Class<DO> dtoClass = (Class<DO>)TypeArgumentsExtensions
		.getTypeArgument(AbstractGenericMapper.class, this.getClass(), 1);

	/**
	 * The entity class.
	 */
	@SuppressWarnings("unchecked")
	private final Class<E> entityClass = (Class<E>)TypeArgumentsExtensions
		.getTypeArgument(AbstractGenericMapper.class, this.getClass(), 0);

	/**
	 * The mapper instance.
	 */
	private final ModelMapper mapper;

	/**
	 * Instantiates a new {@link AbstractGenericMapper} object
	 */
	public AbstractGenericMapper()
	{
		mapper = newMapper();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapper newMapper()
	{
		return newModelMapper();
	}

	/**
	 * Factory method for creating the new {@link ModelMapper} for the mapping process. This method
	 * is invoked in the constructor and can be overridden so users can provide their own mapping
	 * process
	 *
	 * @return the new {@link ModelMapper} for the mapping process
	 */
	protected ModelMapper newModelMapper()
	{
		return ModelMapperFactory.newModelMapper();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<DO> getDtoClass()
	{
		return dtoClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<E> getEntityClass()
	{
		return entityClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapper getMapper()
	{
		return mapper;
	}
}
