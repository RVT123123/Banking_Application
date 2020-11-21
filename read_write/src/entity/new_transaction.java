package entity;

import java.util.*;

public class new_transaction {
	
	private String dt;
	private String amt_type;
	private int ac_num;
	private int amt_st;
	private int bal_avl;
	private String md;
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getAmt_type() {
		return amt_type;
	}
	public void setAmt_type(String amt_type) {
		this.amt_type = amt_type;
	}
	public int getAc_num() {
		return ac_num;
	}
	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
	}
	public int getAmt_st() {
		return amt_st;
	}
	public void setAmt_st(int amt_st) {
		this.amt_st = amt_st;
	}
	public int getBal_avl() {
		return bal_avl;
	}
	public void setBal_avl(int bal_avl) {
		this.bal_avl = bal_avl;
	}
	public String getMd() {
		return md;
	}
	public void setMd(String md) {
		this.md = md;
	}
	public new_transaction(String dt, String amt_type, int ac_num, int amt_st, int bal_avl, String md) {
		super();
		this.dt = dt;
		this.amt_type = amt_type;
		this.ac_num = ac_num;
		this.amt_st = amt_st;
		this.bal_avl = bal_avl;
		this.md = md;
	}
	public new_transaction() {
		super();
	}
	
    
}
