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

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The class {@link ModelMapperExtensions}.
 */
public final class ModelMapperExtensions
{

	/**
	 * Constructs new instances of destinationClass and performs mapping between from source.
	 *
	 * @param <T>              the generic type of the destinationClass
	 * @param <S>              the generic type of the source
	 * @param mapper           the dozer mapper object
	 * @param sources          the collection of source objects
	 * @param destinationClass the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 */
	public static <T, S> List<T> map(final ModelMapper mapper, final Collection<S> sources,
		final Class<T> destinationClass)
	{
		final List<T> destination = new ArrayList<>();
		if ((sources != null) && !sources.isEmpty())
		{
			for (final S source : sources)
			{
				destination.add(ModelMapperExtensions.map(mapper, source, destinationClass));
			}
		}
		return destination;
	}

	/**
	 * Constructs new instance of destinationClass and performs mapping between from source.
	 *
	 * @param <T>
	 *            the generic type of the destinationClass
	 * @param <S>
	 *            the generic type of the source
	 * @param mapper
	 *            the dozer mapper object
	 * @param source
	 *            the source
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 */
	public static <T, S> T map(final ModelMapper mapper, final S source,
		final Class<T> destinationClass)

	{
		return mapper.map(source, destinationClass);
	}

}
