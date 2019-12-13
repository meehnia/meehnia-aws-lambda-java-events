package com.meehnia.amazonaws.services.lambda.runtime.events;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.meehnia.amazonaws.services.lambda.util.PathParseException;
import com.meehnia.amazonaws.services.lambda.util.PathParser;

/**
 * @author Vipul Meehnia <vipulmeehnia@gmail.com>
 *
 */
public class ApplicationLoadBalancerRequestEvent implements Serializable, Cloneable {

	private static final long serialVersionUID = 763261344583521967L;

	private String path;

    private String httpMethod;

    private Map<String, String> headers;

    private Map<String, List<String>> multiValueHeaders;

    private Map<String, String> queryStringParameters;

    private Map<String, List<String>> multiValueQueryStringParameters;

    private Map<String, String> pathParameters;

    private Map<String, String> stageVariables;

    private ALBRequestContext requestContext;

    private String body;

    private Boolean isBase64Encoded;
    
    public static class ElasticLoadBalancer implements Serializable, Cloneable {

		private static final long serialVersionUID = -3001496817616165112L;
		
		private String targetGroupArn;

		/**
		 * @return the targetGroupArn
		 */
		public String getTargetGroupArn() {
			return targetGroupArn;
		}

		/**
		 * @param targetGroupArn the targetGroupArn to set
		 */
		public void setTargetGroupArn(String targetGroupArn) {
			this.targetGroupArn = targetGroupArn;
		}
		
		/**
         * Returns a string representation of this object; useful for testing and debugging.
         *
         * @return A string representation of this object.
         *
         * @see Object#toString()
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            if (getTargetGroupArn() != null)
                sb.append("targetGroupArn: ").append(getTargetGroupArn());
            sb.append("}");
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            if (obj instanceof ElasticLoadBalancer == false)
                return false;
            ElasticLoadBalancer other = (ElasticLoadBalancer) obj;
            if (other.getTargetGroupArn() == null ^ this.getTargetGroupArn() == null)
                return false;
            if (other.getTargetGroupArn() != null && other.getTargetGroupArn().equals(this.getTargetGroupArn()) == false)
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            int hashCode = 7;

            hashCode = 73 * hashCode + ((getTargetGroupArn() == null) ? 0 : getTargetGroupArn().hashCode());
            return hashCode;
        }

        @Override
        public ElasticLoadBalancer clone() {
            try {
                return (ElasticLoadBalancer) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    	
    }
    
    public static class ALBRequestContext implements Serializable, Cloneable {

		private static final long serialVersionUID = -4827729022379089747L;
		
		private ElasticLoadBalancer elb;

		/**
		 * @return the elb
		 */
		public ElasticLoadBalancer getElb() {
			return elb;
		}

		/**
		 * @param elb the elb to set
		 */
		public void setElb(ElasticLoadBalancer elb) {
			this.elb = elb;
		}
		
		/**
         * Returns a string representation of this object; useful for testing and debugging.
         *
         * @return A string representation of this object.
         *
         * @see Object#toString()
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            if (getElb() != null)
                sb.append("elb: ").append(getElb().toString());
            sb.append("}");
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            if (obj instanceof ALBRequestContext == false)
                return false;
            ALBRequestContext other = (ALBRequestContext) obj;
            if (other.getElb() == null ^ this.getElb() == null)
                return false;
            if (other.getElb() != null && other.getElb().equals(this.getElb()) == false)
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            int hashCode = 3;

            hashCode = 73 * hashCode + ((getElb() == null) ? 0 : getElb().hashCode());
            return hashCode;
        }

        @Override
        public ElasticLoadBalancer clone() {
            try {
                return (ElasticLoadBalancer) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
            }
        }
    	
    }
    
	public ApplicationLoadBalancerRequestEvent() {}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the httpMethod
	 */
	public String getHttpMethod() {
		return httpMethod;
	}

	/**
	 * @param httpMethod the httpMethod to set
	 */
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * @return the multiValueHeaders
	 */
	public Map<String, List<String>> getMultiValueHeaders() {
		return multiValueHeaders;
	}

	/**
	 * @param multiValueHeaders the multiValueHeaders to set
	 */
	public void setMultiValueHeaders(Map<String, List<String>> multiValueHeaders) {
		this.multiValueHeaders = multiValueHeaders;
	}

	/**
	 * @return the queryStringParameters
	 */
	public Map<String, String> getQueryStringParameters() {
		return queryStringParameters;
	}

	/**
	 * @param queryStringParameters the queryStringParameters to set
	 */
	public void setQueryStringParameters(Map<String, String> queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}

	/**
	 * @return the multiValueQueryStringParameters
	 */
	public Map<String, List<String>> getMultiValueQueryStringParameters() {
		return multiValueQueryStringParameters;
	}

	/**
	 * @param multiValueQueryStringParameters the multiValueQueryStringParameters to set
	 */
	public void setMultiValueQueryStringParameters(Map<String, List<String>> multiValueQueryStringParameters) {
		this.multiValueQueryStringParameters = multiValueQueryStringParameters;
	}

	/**
	 * @return the pathParameters
	 */
	public Map<String, String> getPathParameters() {
		return pathParameters;
	}

	/**
	 * @param pathParameters the pathParameters to set
	 */
	public void setPathParameters(Map<String, String> pathParameters) {
		this.pathParameters = pathParameters;
	}

	/**
	 * @return the stageVariables
	 */
	public Map<String, String> getStageVariables() {
		return stageVariables;
	}

	/**
	 * @param stageVariables the stageVariables to set
	 */
	public void setStageVariables(Map<String, String> stageVariables) {
		this.stageVariables = stageVariables;
	}

	/**
	 * @return the requestContext
	 */
	public ALBRequestContext getRequestContext() {
		return requestContext;
	}

	/**
	 * @param requestContext the requestContext to set
	 */
	public void setRequestContext(ALBRequestContext requestContext) {
		this.requestContext = requestContext;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the isBase64Encoded
	 */
	public Boolean getIsBase64Encoded() {
		return isBase64Encoded;
	}

	/**
	 * @param isBase64Encoded the isBase64Encoded to set
	 */
	public void setIsBase64Encoded(Boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}
	
	/**
	 * Will parse the given resource template against the requested path and update the pathParameters.
	 * 
	 * @param resourceUriTemplate
	 * @throws Exception
	 */
	public void parsePathParameters(String resourceUriTemplate) throws PathParseException {
		PathParser pp = PathParser.getInstance();
		setPathParameters(pp.matchAndExtract(resourceUriTemplate, path));
	}
	
	/**
	 * Will parse the first matched resource template against the requested path and update the pathParameters.
	 * 
	 * @param resourceUriTemplates
	 * @throws Exception
	 */
	public void parsePathParameters(List<String> resourceUriTemplates) throws PathParseException {
		PathParser pp = PathParser.getInstance();
		for (String template : resourceUriTemplates) {
			if (pp.match(template, path)) {
				setPathParameters(pp.matchAndExtract(template, path));
				break;
			}
		}
	}
	
	/**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPath() != null)
            sb.append("path: ").append(getPath()).append(",");
        if (getHttpMethod() != null)
            sb.append("httpMethod: ").append(getHttpMethod()).append(",");
        if (getHeaders() != null)
            sb.append("headers: ").append(getHeaders().toString()).append(",");
        if (getMultiValueHeaders() != null)
            sb.append("multiValueHeaders: ").append(getMultiValueHeaders().toString()).append(",");
        if (getQueryStringParameters() != null)
            sb.append("queryStringParameters: ").append(getQueryStringParameters().toString()).append(",");
        if (getMultiValueQueryStringParameters() != null)
            sb.append("multiValueQueryStringParameters: ").append(getMultiValueQueryStringParameters().toString()).append(",");
        if (getPathParameters() != null)
            sb.append("pathParameters: ").append(getPathParameters().toString()).append(",");
        if (getStageVariables() != null)
            sb.append("stageVariables: ").append(getStageVariables().toString()).append(",");
        if (getRequestContext() != null)
            sb.append("requestContext: ").append(getRequestContext().toString()).append(",");
        if (getBody() != null)
            sb.append("body: ").append(getBody()).append(",");
        if (getIsBase64Encoded() != null)
            sb.append("isBase64Encoded: ").append(getIsBase64Encoded());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ApplicationLoadBalancerRequestEvent == false)
            return false;
        ApplicationLoadBalancerRequestEvent other = (ApplicationLoadBalancerRequestEvent) obj;
        if (other.getPath() == null ^ this.getPath() == null)
            return false;
        if (other.getPath() != null && other.getPath().equals(this.getPath()) == false)
            return false;
        if (other.getHttpMethod() == null ^ this.getHttpMethod() == null)
            return false;
        if (other.getHttpMethod() != null && other.getHttpMethod().equals(this.getHttpMethod()) == false)
            return false;
        if (other.getHeaders() == null ^ this.getHeaders() == null)
            return false;
        if (other.getHeaders() != null && other.getHeaders().equals(this.getHeaders()) == false)
            return false;
        if (other.getMultiValueHeaders() == null ^ this.getMultiValueHeaders() == null)
            return false;
        if (other.getMultiValueHeaders() != null && other.getMultiValueHeaders().equals(this.getMultiValueHeaders()) == false)
            return false;
        if (other.getQueryStringParameters() == null ^ this.getQueryStringParameters() == null)
            return false;
        if (other.getQueryStringParameters() != null && other.getQueryStringParameters().equals(this.getQueryStringParameters()) == false)
            return false;
        if (other.getMultiValueQueryStringParameters() == null ^ this.getMultiValueQueryStringParameters() == null)
            return false;
        if (other.getMultiValueQueryStringParameters() != null && other.getMultiValueQueryStringParameters().equals(this.getMultiValueQueryStringParameters()) == false)
            return false;
        if (other.getPathParameters() == null ^ this.getPathParameters() == null)
            return false;
        if (other.getPathParameters() != null && other.getPathParameters().equals(this.getPathParameters()) == false)
            return false;
        if (other.getStageVariables() == null ^ this.getStageVariables() == null)
            return false;
        if (other.getStageVariables() != null && other.getStageVariables().equals(this.getStageVariables()) == false)
            return false;
        if (other.getRequestContext() == null ^ this.getRequestContext() == null)
            return false;
        if (other.getRequestContext() != null && other.getRequestContext().equals(this.getRequestContext()) == false)
            return false;
        if (other.getBody() == null ^ this.getBody() == null)
            return false;
        if (other.getBody() != null && other.getBody().equals(this.getBody()) == false)
            return false;
        if (other.getIsBase64Encoded() == null ^ this.getIsBase64Encoded() == null)
            return false;
        if (other.getIsBase64Encoded() != null && other.getIsBase64Encoded().equals(this.getIsBase64Encoded()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 11;

        hashCode = 73 * hashCode + ((getPath() == null) ? 0 : getPath().hashCode());
        hashCode = 73 * hashCode + ((getHttpMethod() == null) ? 0 : getHttpMethod().hashCode());
        hashCode = 73 * hashCode + ((getHeaders() == null) ? 0 : getHeaders().hashCode());
        hashCode = 73 * hashCode + ((getMultiValueHeaders() == null) ? 0 : getMultiValueHeaders().hashCode());
        hashCode = 73 * hashCode + ((getQueryStringParameters() == null) ? 0 : getQueryStringParameters().hashCode());
        hashCode = 73 * hashCode + ((getMultiValueQueryStringParameters() == null) ? 0 : getMultiValueQueryStringParameters().hashCode());
        hashCode = 73 * hashCode + ((getPathParameters() == null) ? 0 : getPathParameters().hashCode());
        hashCode = 73 * hashCode + ((getStageVariables() == null) ? 0 : getStageVariables().hashCode());
        hashCode = 73 * hashCode + ((getRequestContext() == null) ? 0 : getRequestContext().hashCode());
        hashCode = 73 * hashCode + ((getBody() == null) ? 0 : getBody().hashCode());
        hashCode = 73 * hashCode + ((getIsBase64Encoded() == null) ? 0 : getIsBase64Encoded().hashCode());
        return hashCode;
    }

    @Override
    public ApplicationLoadBalancerRequestEvent clone() {
        try {
            return (ApplicationLoadBalancerRequestEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
        }
    }

}
