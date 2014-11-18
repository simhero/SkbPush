package com.skt.ssp.gw.vo.order;

import com.skt.ssp.gw.vo.BaseVO;

/**
 * IfOr002ComBodyJengSanResVO (IfOr002ComBodyJengSanResVO)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: IfOr002ComBodyJengSanResVO.java,v 1.0 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public class IfOr002ComBodyJengSanResVO extends BaseVO {
	private String jsDate	= "";
	private String jsPamt	= "";
	private String jsSamt	= "";
	private String jsJamt	= "";
	
	public IfOr002ComBodyJengSanResVO() {
		super();
	}

	public String getJsDate() {
		return jsDate;
	}

	public String getJsPamt() {
		return jsPamt;
	}

	public String getJsSamt() {
		return jsSamt;
	}

	public String getJsJamt() {
		return jsJamt;
	}

	public void setJsDate(String jsDate) {
		this.jsDate = jsDate;
	}

	public void setJsPamt(String jsPamt) {
		this.jsPamt = jsPamt;
	}

	public void setJsSamt(String jsSamt) {
		this.jsSamt = jsSamt;
	}

	public void setJsJamt(String jsJamt) {
		this.jsJamt = jsJamt;
	}

}