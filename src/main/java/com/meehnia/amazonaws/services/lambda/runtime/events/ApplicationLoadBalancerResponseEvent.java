package com.meehnia.amazonaws.services.lambda.runtime.events;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Class that represents an ApplicationLoadBalancerResponseEvent object
 * 
 * @author Vipul Meehnia <vipulmeehnia@gmail.com>
 *
 */
public class ApplicationLoadBalancerResponseEvent implements Serializable, Cloneable {

	private static final long serialVersionUID = -3466191444064332499L;

	private Integer statusCode;

	private Map<String, String> headers;
	
	private Map<String, List<String>> multiValueHeaders;

	private String body;

	private Boolean isBase64Encoded;

	/**
	 * default constructor
	 */
	public ApplicationLoadBalancerResponseEvent() {
	}

	/**
	 * @return The HTTP status code for the request
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode The HTTP status code for the request
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return The HTTP headers return in the response
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers The HTTP headers return in the response
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
	 * @return The response body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body The response body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return whether the body String is base64 encoded.
	 */
	public Boolean getIsBase64Encoded() {
		return this.isBase64Encoded;
	}

	/**
	 * @param isBase64Encoded Whether the body String is base64 encoded
	 */
	public void setIsBase64Encoded(Boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}

	/**
	 * Returns a string representation of this object; useful for testing and
	 * debugging.
	 *
	 * @return A string representation of this object.
	 *
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if (getStatusCode() != null)
			sb.append("statusCode: ").append(getStatusCode()).append(",");
		if (getHeaders() != null)
			sb.append("headers: ").append(getHeaders().toString()).append(",");
		if (getMultiValueHeaders() != null)
            sb.append("multiValueHeaders: ").append(getMultiValueHeaders().toString()).append(",");
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

		if (obj instanceof ApplicationLoadBalancerResponseEvent == false)
			return false;
		ApplicationLoadBalancerResponseEvent other = (ApplicationLoadBalancerResponseEvent) obj;
		if (other.getStatusCode() == null ^ this.getStatusCode() == null)
			return false;
		if (other.getStatusCode() != null && other.getStatusCode().equals(this.getStatusCode()) == false)
			return false;
		if (other.getHeaders() == null ^ this.getHeaders() == null)
			return false;
		if (other.getHeaders() != null && other.getHeaders().equals(this.getHeaders()) == false)
			return false;
		if (other.getMultiValueHeaders() == null ^ this.getMultiValueHeaders() == null)
            return false;
        if (other.getMultiValueHeaders() != null && other.getMultiValueHeaders().equals(this.getMultiValueHeaders()) == false)
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
		int hashCode = 1;

		hashCode = 73 * hashCode + ((getStatusCode() == null) ? 0 : getStatusCode().hashCode());
		hashCode = 73 * hashCode + ((getHeaders() == null) ? 0 : getHeaders().hashCode());
		hashCode = 73 * hashCode + ((getMultiValueHeaders() == null) ? 0 : getMultiValueHeaders().hashCode());
		hashCode = 73 * hashCode + ((getBody() == null) ? 0 : getBody().hashCode());
		hashCode = 73 * hashCode + ((getIsBase64Encoded() == null) ? 0 : getIsBase64Encoded().hashCode());
		return hashCode;
	}

	@Override
	public ApplicationLoadBalancerResponseEvent clone() {
		try {
			return (ApplicationLoadBalancerResponseEvent) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone()", e);
		}
	}

}
