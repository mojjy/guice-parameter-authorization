package security;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;

public class AuthorizationInterceptor  implements MethodInterceptor {

   @Override
   public Object invoke(MethodInvocation methodInvocation) throws Throwable {
      Method method = methodInvocation.getMethod();
      Objects.requireNonNull(method.getAnnotation(Secure.class));

      System.out.println("method = " + method.getName());
      int i = 0;
      for (Parameter parameter : method.getParameters()) {
         AuthParam annotation = parameter.getAnnotation(AuthParam.class);
         if (annotation != null) {
            //validate
            Object o = methodInvocation.getArguments()[i];
            System.out.println("annotation.value => " + annotation.value() + " parameter value: " + o);
         }
         i++;
      }
      System.out.println("");
      return methodInvocation.proceed();
   }
}
