package security;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;

public class SecurityModule implements Module {

   @Override
   public void configure(Binder binder) {
      binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Secure.class), new AuthorizationInterceptor());
   }
}
