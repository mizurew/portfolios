package lens.vo;

import lens.dao.IDao;

public class SCM {
	private int sid;
	private String sname;
	private String dep;
	private int hid;
	private String sdate;
	private int pqty;
	private String oqty;
	private int rqty;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public String getOqty() {
		return oqty;
	}
	public void setOqty(String oqty) {
		this.oqty = oqty;
	}
	public int getRqty() {
		return rqty;
	}
	public void setRqty(int rqty) {
		this.rqty = rqty;
	}
	@Override
	public String toString() {
//		return "SCM [sid=" + sid + ", sname=" + sname + ", dep=" + dep + ", hid=" + hid + ", sdate=" + sdate + ", pqty="
//				+ pqty + ", oqty=" + oqty + ", rqty=" + rqty + "]";
		return sid+","+sname+","+pqty;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
		result = prime * result + hid;
		result = prime * result + ((oqty == null) ? 0 : oqty.hashCode());
		result = prime * result + pqty;
		result = prime * result + rqty;
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
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
		SCM other = (SCM) obj;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		if (hid != other.hid)
			return false;
		if (oqty == null) {
			if (other.oqty != null)
				return false;
		} else if (!oqty.equals(other.oqty))
			return false;
		if (pqty != other.pqty)
			return false;
		if (rqty != other.rqty)
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		return true;
	}
	
}
