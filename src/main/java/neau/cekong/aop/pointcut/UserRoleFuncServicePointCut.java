package neau.cekong.aop.pointcut;


import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Deprecated
public class UserRoleFuncServicePointCut {

    @Pointcut("execution(* neau.cekong.service..Sys*.find*(..))")
    public void find(){} //这是Pointcut签名(id)

}
