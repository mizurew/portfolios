package lens.vo;

public class CRS {
	private int cid;
	private String cname;
	private String grade;
	private String loc;
	private String cdate;
	private String addy;
	private String eaddy;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getAddy() {
		return addy;
	}
	public void setAddy(String addy) {
		this.addy = addy;
	}
	public String getEaddy() {
		return eaddy;
	}
	public void setEaddy(String eaddy) {
		this.eaddy = eaddy;
	}
	
	@Override
	public String toString() {
//		return "CRS [cid=" + cid + ", cname=" + cname + ", grade=" + grade + ", loc=" + loc + ", cdate=" + cdate
//				+ ", addy=" + addy + ", eaddy=" + eaddy + "]";
		return cid+","+cname+","+grade;
			
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addy == null) ? 0 : addy.hashCode());
		result = prime * result + ((cdate == null) ? 0 : cdate.hashCode());
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((eaddy == null) ? 0 : eaddy.hashCode());
		
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
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
		CRS other = (CRS) obj;
		if (addy == null) {
			if (other.addy != null)
				return false;
		} else if (!addy.equals(other.addy))
			return false;
		if (cdate == null) {
			if (other.cdate != null)
				return false;
		} else if (!cdate.equals(other.cdate))
			return false;
		if (cid != other.cid)
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (eaddy == null) {
			if (other.eaddy != null)
				return false;
		} else if (!eaddy.equals(other.eaddy))
			return false;
		
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}
	
}
