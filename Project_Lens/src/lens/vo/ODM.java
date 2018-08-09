package lens.vo;

public class ODM {
	private int oid;
	private int cid;
	private int sid;
	private String dep;
	private int pri;
	private String odate;
	private int qty;
	private String etc;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	@Override
	public String toString() {
		return "ODM [oid=" + oid + ", cid=" + cid + ", sid=" + sid + ", dep=" + dep + ", pri=" + pri + ", odate="
				+ odate + ", qty=" + qty + ", etc=" + etc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
		result = prime * result + ((etc == null) ? 0 : etc.hashCode());
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + oid;
		result = prime * result + pri;
		result = prime * result + qty;
		result = prime * result + sid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ODM other = (ODM) obj;
		if (cid != other.cid)
			return false;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		if (etc == null) {
			if (other.etc != null)
				return false;
		} else if (!etc.equals(other.etc))
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (oid != other.oid)
			return false;
		if (pri != other.pri)
			return false;
		if (qty != other.qty)
			return false;
		if (sid != other.sid)
			return false;
		return true;
	}
	
}
