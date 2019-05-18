package neau.cekong.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Deprecated
public class UserRoleFuncAspect {

    @AfterThrowing(value = "neau.cekong.aop.pointcut.UserRoleFuncServicePointCut.find()", throwing = "ex")
    public Object findNoPointer(JoinPoint point, NullPointerException ex) throws Throwable {

        return null;
    }

    @AfterThrowing(value = "@annotation(neau.cekong.aop.annotation.NullPointerReturnNull)", throwing = "ex")
    public Object noPointer(JoinPoint point, NullPointerException ex) throws Throwable {

        System.out.println("NullPointer");

        return null;
    }

    @Before("@annotation(neau.cekong.aop.annotation.NullPointerReturnNull)")
    public void permissionCheck(JoinPoint point) {
        System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
    }

}
