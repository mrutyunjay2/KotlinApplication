package mtj.example.dagger2.Scopes

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Retention(RetentionPolicy.RUNTIME)
@Documented
annotation class ActivityScope()
