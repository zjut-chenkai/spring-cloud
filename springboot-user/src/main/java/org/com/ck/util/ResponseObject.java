package org.com.ck.util;

public class ResponseObject {
	private String code;
	private String msg;
	private Object data;

	public ResponseObject() {

	}

	public ResponseObject(CommonCodeMsg commonCodeMsg) {
		this.code = commonCodeMsg.getCode();
		this.msg = commonCodeMsg.getMsg();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResponseObject getResponseObject(CommonCodeMsg commonCodeMsg) {
		return new ResponseObject(commonCodeMsg);
	}

	public static ResponseObject getResponseObject(CommonCodeMsg commonCodeMsg, Object data) {
		ResponseObject rs = new ResponseObject(commonCodeMsg);
		rs.setData(data);
		return rs;
	}

	public static ResponseObject successful() {
		return getResponseObject(BaseCode.SUCCESS);
	}

	public static ResponseObject error() {
		return getResponseObject(BaseCode.ERROR);
	}

	public static ResponseObject paramsError() {
		return getResponseObject(BaseCode.PARAMS_ERROR);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
