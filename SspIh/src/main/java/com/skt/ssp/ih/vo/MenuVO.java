package com.skt.ssp.ih.vo;

import java.util.Date;

/**
 * Menu VO (MenuVO)
 *
 * @author SimByungChul
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MenuVO.java,v 1.0 2011/10/31 00:00:00 SimByungChul Express $
 */
public class MenuVO extends BaseVO {
	private String menuId;
	private String menuName;
	private Integer menuPrice;
	private String pizzaId;
	private String drinkId;
	private Date registerDate;
	private int listNum;

	public MenuVO() {
	}

	public MenuVO(String menuId, String menuName, int menuPrice, String pizzaId, String drinkId) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.pizzaId = pizzaId;
		this.drinkId = drinkId;
	}

	public String getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public Integer getMenuPrice() {
		return menuPrice;
	}

	public String getPizzaId() {
		return pizzaId;
	}

	public String getDrinkId() {
		return drinkId;
	}

	public Date getRegisterDate() {
		return registerDate;
	}
	
	public int getListNum() {
		return listNum;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}

	public void setPizzaId(String pizzaId) {
		this.pizzaId = pizzaId;
	}

	public void setDrinkId(String drinkId) {
		this.drinkId = drinkId;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
}