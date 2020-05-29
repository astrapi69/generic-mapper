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

import de.alpharogroup.lang.TypeArgumentsExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.dozer.Mapper;

import java.util.Collections;
import java.util.List;

import static de.alpharogroup.bean.mapper.factories.MapperFactory.newMapper;

/**
 * The abstract class {@link AbstractGenericMapper} provides an base implementation for mapping
 * entities to data transfer objects and back.
 *
 * @param <E>  the element type
 * @param <DO> the generic type
 */
@Getter @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) public abstract class AbstractGenericMapper<E, DO>
	implements DozerGenericMapper<E, DO>
{

	/**
	 * The data transfer object class.
	 */
	@SuppressWarnings("unchecked") Class<DO> dtoClass = (Class<DO>)TypeArgumentsExtensions
		.getTypeArgument(AbstractGenericMapper.class, this.getClass(), 1);

	/**
	 * The entity class.
	 */
	@SuppressWarnings("unchecked") Class<E> entityClass = (Class<E>)TypeArgumentsExtensions
		.getTypeArgument(AbstractGenericMapper.class, this.getClass(), 0);

	/**
	 * The mapper instance.
	 */
	Mapper mapper;

	/**
	 * Instantiates a new {@link AbstractGenericMapper} object
	 */
	public AbstractGenericMapper()
	{
		this(Collections.emptyList());
	}

	/**
	 * Instantiates a new {@link AbstractGenericMapper} object
	 *
	 * @param mappingFiles
	 *            the mapping files
	 */
	public AbstractGenericMapper(final @NonNull List<String> mappingFiles)
	{
		mapper = newMapper(mappingFiles);
	}

}