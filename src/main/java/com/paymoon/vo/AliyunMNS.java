package com.paymoon.vo;

public class AliyunMNS {
	private	String mnsAccountEndpoint;
	private	String mnsAccesskeyId;
	private	String mnsAccesskeySecret;
	private	String appkey;
	private	String queue;
	private	String timestamp;
	private	String status;
	private	String deleted;
	private	String remark;

    public AliyunMNS() {
    }


	public String getMnsAccountEndpoint() {
		return mnsAccountEndpoint;
	}


	public void setMnsAccountEndpoint(String mnsAccountEndpoint) {
		this.mnsAccountEndpoint = mnsAccountEndpoint;
	}




	public String getMnsAccesskeyId() {
		return mnsAccesskeyId;
	}

	public void setMnsAccesskeyId(String mnsAccesskeyId) {
		this.mnsAccesskeyId = mnsAccesskeyId;
	}

	public String getMnsAccesskeySecret() {
		return mnsAccesskeySecret;
	}

	public void setMnsAccesskeySecret(String mnsAccesskeySecret) {
		this.mnsAccesskeySecret = mnsAccesskeySecret;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}



	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appkey == null) ? 0 : appkey.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object a) {
		if (a == null)
			return false;
		AliyunMNS other = (AliyunMNS) a;
		
		if (appkey == null) {
			if (other.appkey != null)
				return false;
		} else if (!appkey.equals(other.appkey))
			return false;
		
		if (mnsAccesskeyId == null) {
			if (other.mnsAccesskeyId != null)
				return false;
		} else if (!mnsAccesskeyId.equals(other.mnsAccesskeyId))
			return false;
		
		if (mnsAccesskeySecret == null) {
			if (other.mnsAccesskeySecret != null)
				return false;
		} else if (!mnsAccesskeySecret.equals(other.mnsAccesskeySecret))
			return false;
		
		if (mnsAccountEndpoint == null) {
			if (other.mnsAccountEndpoint != null)
				return false;
		} else if (!mnsAccountEndpoint.equals(other.mnsAccountEndpoint))
			return false;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AliyunMNS [accountendpoint=" + mnsAccountEndpoint + ", mnsAccesskeyId=" + mnsAccesskeyId
				+ ", mnsAccesskeySecret=" + mnsAccesskeySecret + ", appkey=" + appkey + ", queue=" + queue
				+ ", Timestamp=" + timestamp + ", status=" + status + ", deleted=" + deleted + ", remark=" + remark
				+ "]";
	}
	

}