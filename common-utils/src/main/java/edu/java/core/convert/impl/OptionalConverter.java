package edu.java.core.convert.impl;

import java.util.Optional;

import cn.hutool.core.convert.AbstractConverter;

/**
 * 
 * {@link Optional}对象转换器
 * 
 * @author Looly
 * @since 5.0.0
 */
public class OptionalConverter extends AbstractConverter<Optional<?>> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Optional<?> convertInternal(Object value) {
		return Optional.ofNullable(value);
	}

}
