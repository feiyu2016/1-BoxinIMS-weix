package com.boxin.framework.base.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 操作结果
 * 
 */
public class OpResult {

	private static final long serialVersionUID = -6795137118047685842L;

	private boolean success;
	private String explanation;
	private Object value;
	private Exception exception = null;

	/**
	 * 
	 * @param success
	 *            操作是否成功
	 * @param explanation
	 *            说明信息
	 */
	public OpResult(boolean success, String explanation) {
		this.success = success;
		this.explanation = explanation;
	}

	/**
	 * 
	 * @param success
	 *            操作是否成功
	 * @param value
	 *            操作返回
	 * @param exception
	 *            相关异常
	 */
	public OpResult(boolean success, Object value, Exception exception) {
		this.success = success;
		this.value = value;
		this.exception = exception;
		if (exception != null) {
			if (exception instanceof Explainable) {
				this.explanation = exception.getMessage();
			}
			logger.error(exception);
			if (logger.isDebugEnabled())
				exception.printStackTrace();
		}
	}

	/**
	 * 
	 * @param success
	 *            操作是否成功
	 * @param value
	 *            操作返回
	 * @param exception
	 *            相关异常
	 * @param explanation
	 *            说明信息
	 */
	public OpResult(boolean success, Object value, Exception exception,
			String explanation) {
		this.success = success;
		this.value = value;
		this.exception = exception;
		this.explanation = explanation;
		if (exception != null) {
			if (exception instanceof Explainable && explanation == null) {
				this.explanation = exception.getMessage();
			}
			logger.error(exception);
			if (logger.isDebugEnabled())
				exception.printStackTrace();
		}

	}

	public String toString() {
		return "[OpResult:" + success + "," + value + "," + exception + "]";
	}

	/**
	 * 
	 * @return 操作结果相关解释
	 */
	public String getExplanation() {
		if (explanation == null)
			return success ? "操作成功!" : "操作失败!";
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	private static final Log logger = LogFactory.getLog(OpResult.class);

}
