package io.yeahx4.myspring.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class TimeTraceAop {
    @Around("execution(* io.yeahx4.myspring..*(..))")
    fun execute(joinPoint: ProceedingJoinPoint): Any {
        val start = System.currentTimeMillis()
        println("START: $joinPoint")
        try {
            return joinPoint.proceed()
        } finally {
            val finish = System.currentTimeMillis()
            val timeMs = finish - start
            println("END: $joinPoint ${timeMs}ms")
        }
    }
}
