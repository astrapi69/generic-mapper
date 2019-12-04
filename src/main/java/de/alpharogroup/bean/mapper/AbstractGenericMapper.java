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

import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import de.alpharogroup.lang.TypeArgumentsExtensions;
import lombok.Getter;
import lombok.NonNull;

/**
 * The abstract class {@link AbstractGenericMapper} provides an base implementation for mapping
 * entities to data transfer objects and back.
 *
 * @param <E>
 *            the element type
 * @param <DO>
 *            the generic type
 */
public abstract class AbstractGenericMapper<E, DO> implements DozerGenericMapper<E, DO>
{

	/** The data transfer object class. */
	@SuppressWarnings("unchecked")
	@Getter
	private final Class<DO> dtoClass = (Class<DO>)TypeArgumentsExtensions
		.getTypeArgument(AbstractGenericMapper.class, this.getClass(), 1);

	/** The entity class. */
	@SuppressWarnings("unchecked")
	@Getter
	private final Class<E> entityClass = (Class<E>)TypeArgumentsExtensions
		.getTypeArgument(AbstractGenericMapper.class, this.getClass(), 0);

	/**
	 * The mapper instance.
	 */
	@Getter
	private final Mapper mapper;

	/**
	 * Instantiates a new {@link AbstractGenericMapper} object
	 */
	public AbstractGenericMapper()
	{
		this(Collections.singletonList("uuid-mapping.xml"));
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

	private BeanMappingBuilder beanMappingBuilder()
	{
		return new BeanMappingBuilder()
		{
			@Override
			protected void configure()
			{
				mapping(getEntityClass(), getDtoClass(), TypeMappingOptions.mapNull(false),
					TypeMappingOptions.mapEmptyString(false));
			}

		};
	}

	/**
	 * Factory method for creating the new {@link Mapper} for the mapping process with the given
	 * mapping files list. This method is invoked in the constructor and can be overridden so users
	 * can provide their own mapping process.
	 *
	 * @param mappingFiles
	 *            the mapping files
	 *
	 * @return the new {@link Mapper} for the mapping process.
	 */
	public Mapper newMapper(final @NonNull List<String> mappingFiles)
	{
		final DozerBeanMapper mapper = DozerBeanMapperSingleton.get();
		if (!mappingFiles.isEmpty())
		{
			mapper.setMappingFiles(mappingFiles);
		}
		mapper.addMapping(beanMappingBuilder());
		mapper.setCustomFieldMapper((source, destination, sourceFieldValue, classMap,
			fieldMapping) -> sourceFieldValue == null);
		return mapper;
	}

}