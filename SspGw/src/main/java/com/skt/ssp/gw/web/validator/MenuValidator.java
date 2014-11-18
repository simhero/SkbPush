package com.skt.ssp.gw.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skt.ssp.gw.vo.MenuVO;

/**
 * Menu Validator (MenuValidator)
 *
 * @author <a href="mailto:simhero@in-sprit.com">SimByungChul</a>
 * @version $Id: MenuValidator,v 1.1 2011/08/20 00:00:00 SimByungChul Express $
 */
@Component
public class MenuValidator implements Validator {
//	@Autowired
//	private MenuService menuService;

	public boolean supports(Class<?> clazz) {
		return MenuVO.class.isAssignableFrom(clazz);
	}

	@SuppressWarnings("unused")
	public void validate(Object target, Errors errors) {
		MenuVO formMenu = (MenuVO)target;
//		MenuVO menuVO = this.menuService.findMenu(formMenu.getMenuName());
//		if (menuVO != null && menuVO.getMenuId() != formMenu.getMenuId()) errors.rejectValue("menuName", "duplicateMenuName");
	}

}