package com.company.demographql.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class BookNotFoundException extends RuntimeException implements GraphQLError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7135850745146724662L;
	private Map<String, Object> extensionMap = new HashMap<String, Object>();

	public BookNotFoundException(String msg, Long invalidBookId) {
		super(msg);
		extensionMap.put("invalidBookId", invalidBookId);
	}

	@Override
	public List<SourceLocation> getLocations() {

		return null;
	}
	@Override
    public Map<String, Object> getExtensions() {
        return extensionMap;
    }

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}

}
