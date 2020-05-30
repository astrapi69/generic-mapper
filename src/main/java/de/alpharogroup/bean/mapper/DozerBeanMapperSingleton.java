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

import de.alpharogroup.bean.mapper.factories.MapperFactory;
import lombok.NonNull;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link DozerBeanMapperSingleton} holds a single instance of the class
 * {@linkplain DozerBeanMapper}.
 */
public final class DozerBeanMapperSingleton
{

	/**
	 * The only single one instance.
	 */
	private static DozerBeanMapper instance;

	/**
	 * Instantiates a new {@link DozerBeanMapperSingleton}.
	 */
	private DozerBeanMapperSingleton()
	{
	}

	public static synchronized DozerBeanMapper getInstance(final @NonNull Class<?> entityClass,
		final @NonNull Class<?> dtoClass)
	{
		if (instance == null)
		{
			List<String> mappingFiles = new ArrayList<>();
			mappingFiles.add("uuid-mapping.xml");
			instance = (DozerBeanMapper)MapperFactory
				.newMapper(mappingFiles, entityClass, dtoClass);
		}
		return instance;
	}
}
