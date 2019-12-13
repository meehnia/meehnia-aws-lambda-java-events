package test.com.meehnia.amazonaws.services.lambda.util;

import java.util.Map;

import com.meehnia.amazonaws.services.lambda.util.PathParseException;
import com.meehnia.amazonaws.services.lambda.util.PathParser;

public class Test {
	
	public static void main(String[] args) {
		String resourceUriTemplate = "/*/episodes/{episodeId}/comments";
		String path = "/stage/episodes/2030898/comments";
		Map<String, String> res = null;
		
		PathParser pp = PathParser.getInstance();
		try {
			res = pp.matchAndExtract(resourceUriTemplate, path);
		} catch (PathParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(res.toString());
	}

}
