package com.cc.shop.base.aspect;

import com.cc.shop.base.controller.BaseAdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cc.shop.framework.common.page.PagingResult;
import com.cc.shop.framework.common.search.Search;

/**
 * Controller中方法拦截
 */
@Component
@Aspect
public class ControllerAspect {

	@Around(value = "execution(public * com.cc.shop..controller.*Controller.*(..))")
	public Object aroundControllerMethod(final ProceedingJoinPoint pjp) {
		try {
			Object returnVal = pjp.proceed();
//			MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
//			methodSignature.getMethod();
			for (Object obj : pjp.getArgs()) {
				if (obj instanceof Search && returnVal instanceof PagingResult &&
						((Search)obj).containsRouterCall()) {
					((BaseAdminController)pjp.getTarget()).generateRouterCallButtons(
							(PagingResult)returnVal, (Search)obj);
				}
			}
			return returnVal;
		} catch (Throwable throwable) {

			throwable.printStackTrace();
		}
		return null;
	}

}
