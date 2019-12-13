package com.meehnia.amazonaws.services.lambda.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Vipul Meehnia <vipulmeehnia@gmail.com>
 *
 */
public final class PathResourceInfo implements Serializable {

	private static final long serialVersionUID = -3382847345411916614L;

	private List<String> variables;
	
	private List<String> wildcards;

	private Pattern pattern;

	private PathResourceInfo(List<String> variables, List<String> wildcards, Pattern pattern) {
		this.variables = variables;
		this.wildcards = wildcards;
		this.pattern = pattern;
	}

	/**
	 * @return the variables
	 */
	public List<String> getVariables() {
		return variables;
	}

	/**
	 * @return the pattern
	 */
	public Pattern getPattern() {
		return pattern;
	}
	
	/**
	 * @return the wildcards
	 */
	public List<String> getWildcards() {
		return wildcards;
	}

	/**
	 * This is the function to parse a path and find out variables and creates a patterns to match it.
	 * @param path
	 * @return {@link PathResourceInfo}
	 * @throws IllegalArgumentException
	 */
	public static PathResourceInfo parse(String path) throws PathParseException {
		int start = 0;
		List<String> vars = new ArrayList<String>();
		List<String> wild = new ArrayList<String>();
		StringBuilder pattern = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		path = manageWildcards(path);
		//System.out.println("Managed Path = "+ path);
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == '{') {
				start++;
				if (start == 1) {
					// start of URI variable
					pattern.append(quote(builder));
					builder = new StringBuilder();
					continue;
				}
			} else if (c == '}') {
				start--;
				if (start == 0) {
					// end of URI variable
					String var = builder.toString();
					int idx = var.indexOf(':');
					if (idx == -1) {
						pattern.append("([^/]*)");
						vars.add(var);
					} else {
						if (idx + 1 == var.length()) {
							throw new PathParseException(
									"No custom regular expression specified after ':' in \"" + var + "\"");
						}
						String regex = var.substring(idx + 1, var.length());
						pattern.append('(');
						pattern.append(regex);
						pattern.append(')');
						vars.add(var.substring(0, idx));
						if (var.startsWith("star")) {
							wild.add(var.substring(0, idx));
						}
					}
					builder = new StringBuilder();
					continue;
				}
			}
			builder.append(c);
		}
		if (builder.length() > 0) {
			pattern.append(quote(builder));
		}
		return new PathResourceInfo(vars, wild, Pattern.compile(pattern.toString()));
	}

	/**
	 * Refer {@link Pattern.quote} for more information.
	 * @param builder - {@link StringBuilder}
	 * @return {@link String}
	 */
	private static String quote(StringBuilder builder) {
		return (builder.length() > 0 ? Pattern.quote(builder.toString()) : "");
	}
	
	/**
	 * Function to manage wildcards. Currently, only <code>star('*')</code> is supported.
	 * @param path {@link String}
	 * @return {@link String}
	 */
	private static String manageWildcards(String path) {
		StringBuilder result = new StringBuilder();
		int wIndex = 1;
		String star = "star";
		//String question = "question";
		char p[] = path.toCharArray();
		for (int i = 0; i < p.length; i++) {
			char c = p[i];
			if(c == '*') {
				result.append("{");
				result.append(star);
				result.append(wIndex++);
				result.append(":");
				result.append("[^/]+");
				result.append("}");
			} 
			else 
				result.append(c);
		}
		return result.toString();
	}

}
