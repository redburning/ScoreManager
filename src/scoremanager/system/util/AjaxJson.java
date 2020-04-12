package scoremanager.system.util;


import org.json.JSONObject;

public class AjaxJson {

	/**
	 * 是否成功
	 */
	private boolean success = true;
	
	/**
	 * 提示信息
	 */
	private String msg = "操作成功";
	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		JSONObject obj = new JSONObject();
		obj.put("success", this.isSuccess());
		obj.put("msg", this.getMsg());
		return obj.toString();
	}
	
}
