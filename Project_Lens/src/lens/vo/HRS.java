package lens.vo;

public class HRS {
	private int hid;
	private String hname;
	private String pst;
	private String dep;
	private int sal;
	private String hdate;
	private String tel;
	private String eml;
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getPst() {
		return pst;
	}
	public void setPst(String pst) {
		this.pst = pst;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHdate() {
		return hdate;
	}
	public void setHdate(String hdate) {
		this.hdate = hdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEml() {
		return eml;
	}
	public void setEml(String eml) {
		this.eml = eml;
	}
	
	@Override
	public String toString() {
		return hname+","+dep;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
		result = prime * result + ((eml == null) ? 0 : eml.hashCode());
		
		result = prime * result + ((hdate == null) ? 0 : hdate.hashCode());
		result = prime * result + hid;
		result = prime * result + ((hname == null) ? 0 : hname.hashCode());
		result = prime * result + ((pst == null) ? 0 : pst.hashCode());
		result = prime * result + sal;
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		HRS other = (HRS) obj;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		if (eml == null) {
			if (other.eml != null)
				return false;
		} else if (!eml.equals(other.eml))
			return false;
		
		if (hdate == null) {
			if (other.hdate != null)
				return false;
		} else if (!hdate.equals(other.hdate))
			return false;
		if (hid != other.hid)
			return false;
		if (hname == null) {
			if (other.hname != null)
				return false;
		} else if (!hname.equals(other.hname))
			return false;
		if (pst == null) {
			if (other.pst != null)
				return false;
		} else if (!pst.equals(other.pst))
			return false;
		if (sal != other.sal)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
}
