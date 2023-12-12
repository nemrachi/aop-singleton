package sk.fiit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {

    private final Logger logger = Logger.getInstance();

    @Pointcut("@annotation(log)")
    public void logPointcut(LOG log) {}

    @Before(value = "logPointcut(log)", argNames = "pjp,log")
    public void before(ProceedingJoinPoint pjp, LOG log) {
        logger.logAOP(log.level(), "Method '" + pjp.getSignature().getName() + "' will be called with input: " + Arrays.toString(pjp.getArgs()));
    }

    @Around(value = "logPointcut(log)", argNames = "pjp,log")
    public Object around(ProceedingJoinPoint pjp, LOG log) throws Throwable {
        logger.logAOP(log.level(), "Method '" + pjp.getSignature().getName() + "' is called with input: " + Arrays.toString(pjp.getArgs()));
        return pjp.proceed(pjp.getArgs());
    }

    @After(value = "logPointcut(log)", argNames = "pjp,log")
    public void after(ProceedingJoinPoint pjp, LOG log) throws IllegalAccessException, NoSuchFieldException {
        logger.logAOP(log.level(), "Method '" + pjp.getSignature().getName()  + "' was called");
    }
}