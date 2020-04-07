package com.dlszy.entity;
import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class Role implements Serializable{
	private Integer rid;
	private String rname;
	private List<Limit> limits;
	public Role() {
		this.rid=0;
	}
	public Role(String rname, List<Limit> limits) {
		super();
		this.rname = rname;
		this.limits = limits;
	}
	public Role(Integer rid, String rname, List<Limit> limits) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.limits = limits;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public List<Limit> getLimits() {
		return limits;
	}
	public void setLimits(List<Limit> limits) {
		this.limits = limits;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", limits=" + limits
				+ "]";
	}
}
