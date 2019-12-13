package com.meehnia.amazonaws.services.lambda.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A singleton utility class to enable parsing of URL path parameter.
 * 
 * @author Vipul Meehnia <vipulmeehnia@gmail.com>
 *
 */
public class PathParser implements Serializable {

	private static final long serialVersionUID = 1302818873496019798L;
	
	private static class PathParserHelper {
        private static final PathParser _instance = new PathParser();
    }
	
	private static List<String> variableNames;
	
	private static List<String> wildcards;

	private static Pattern matchPattern;
	
	private static Matcher matcher;
	
	private PathParser() {}
	
	public static PathParser getInstance() {
		return PathParserHelper._instance;
	}
	
	/**
	 * This method checks is the given <code>resource</code> and <code>path</code>
	 *  is a match or not.
	 * 
	 * @param resource - {@link String}
	 * @param path - {@link String}
	 * @return {@link Boolean}
	 * @throws PathParseException
	 */
	public boolean match(String resource, String path) throws PathParseException {
		return PathResourceInfo.parse(resource).getPattern().matcher(path).matches();
	}
	
	/**
	 * This method enables the matching and extracting of path parameters from the
	 *  given <code>resource</code> and <code>path</code>
	 * 
	 * @param resource - {@link String}
	 * @param path - {@link String}
	 * @return {@link Map}
	 * @throws PathParseException
	 */
	public Map<String, String> matchAndExtract(String resource, String path) throws PathParseException {
		Map<String, String> result = new HashMap<String, String>();
		PathResourceInfo pathInfo = PathResourceInfo.parse(resource);
		variableNames = pathInfo.getVariables();
		wildcards = pathInfo.getWildcards();
		matchPattern = pathInfo.getPattern();
		matcher = matchPattern.matcher(path);
		
		boolean matches = matcher.matches();
		int mCount = matcher.groupCount();
		
		if(matches) {
        	int idx=1;
        	for (String var : variableNames) {
        		if(! wildcards.contains(var) && idx <= mCount)
        			result.put(var, matcher.group(idx));
        		idx++;
        	}
        } else {
        	throw new PathParseException("Cannot match the 'path' on the given 'resource'.");
        }
		
		return result;
	}

}
