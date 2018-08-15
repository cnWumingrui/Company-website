package com.yc.bean;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 1	id	int
		2	Product_class	nnvarchar
		3	Product_name	nnvarchar
		4	Product_in	nvarchar
		5	Product_gain	nvarchar
		6	Product_spec	nnvarchar
		7	Product_unit	nnvarchar
		8	Product_remark	ntext
		9	Product_explain	ntext
		10	Product_picture	nnvarchar
		11	Product_auditing	bit
		12	index_show	bit
		13	join_date	smalldatetime
		14	change_date	smalldatetime

	 */
	private static final long serialVersionUID = -197123173441739350L;
	
	private Integer id;
	private String Product_class;
	private String Product_name;
	private String Product_in;
	private String Product_gain;
	private String Product_spec;
	private String Product_unit;
	private String Product_remark;
	private String Product_explain;
	private String Product_picture;
	private Integer Product_auditing;
	private Integer index_show;
	private String join_date;
	private String change_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct_class() {
		return Product_class;
	}
	public void setProduct_class(String product_class) {
		Product_class = product_class;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_in() {
		return Product_in;
	}
	public void setProduct_in(String product_in) {
		Product_in = product_in;
	}
	public String getProduct_gain() {
		return Product_gain;
	}
	public void setProduct_gain(String product_gain) {
		Product_gain = product_gain;
	}
	public String getProduct_spec() {
		return Product_spec;
	}
	public void setProduct_spec(String product_spec) {
		Product_spec = product_spec;
	}
	public String getProduct_unit() {
		return Product_unit;
	}
	public void setProduct_unit(String product_unit) {
		Product_unit = product_unit;
	}
	public String getProduct_remark() {
		return Product_remark;
	}
	public void setProduct_remark(String product_remark) {
		Product_remark = product_remark;
	}
	public String getProduct_explain() {
		return Product_explain;
	}
	public void setProduct_explain(String product_explain) {
		Product_explain = product_explain;
	}
	public String getProduct_picture() {
		return Product_picture;
	}
	public void setProduct_picture(String product_picture) {
		Product_picture = product_picture;
	}
	public Integer getProduct_auditing() {
		return Product_auditing;
	}
	public void setProduct_auditing(Integer product_auditing) {
		Product_auditing = product_auditing;
	}
	public Integer getIndex_show() {
		return index_show;
	}
	public void setIndex_show(Integer index_show) {
		this.index_show = index_show;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getChange_date() {
		return change_date;
	}
	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", Product_class=" + Product_class
				+ ", Product_name=" + Product_name + ", Product_in="
				+ Product_in + ", Product_gain=" + Product_gain
				+ ", Product_spec=" + Product_spec + ", Product_unit="
				+ Product_unit + ", Product_remark=" + Product_remark
				+ ", Product_explain=" + Product_explain + ", Product_picture="
				+ Product_picture + ", Product_auditing=" + Product_auditing
				+ ", index_show=" + index_show + ", join_date=" + join_date
				+ ", change_date=" + change_date + "]";
	}
	
	
	
}
