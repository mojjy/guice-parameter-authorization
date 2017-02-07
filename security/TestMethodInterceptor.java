package security;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestMethodInterceptor {

   public static void main(String[] args) {
      Injector injector = Guice.createInjector(new SecurityModule());
      TestMethodInterceptor testClass = injector.getInstance(TestMethodInterceptor.class);
      testClass.doSomething("clothing", "jones");
      testClass.doSomethingElse("spare parts", "monday");
   }

   @Secure
   public void doSomething(@AuthParam("department") String department, String surname) {
   }

   @Secure
   public void doSomethingElse(@AuthParam("department") String department, @AuthParam("day") String day) {
   }
}
