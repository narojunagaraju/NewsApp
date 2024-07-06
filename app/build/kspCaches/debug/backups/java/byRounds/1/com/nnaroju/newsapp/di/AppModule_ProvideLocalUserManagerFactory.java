package com.nnaroju.newsapp.di;

import android.app.Application;
import com.nnaroju.newsapp.domain.manager.LocalUserManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AppModule_ProvideLocalUserManagerFactory implements Factory<LocalUserManager> {
  private final Provider<Application> applicationProvider;

  public AppModule_ProvideLocalUserManagerFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public LocalUserManager get() {
    return provideLocalUserManager(applicationProvider.get());
  }

  public static AppModule_ProvideLocalUserManagerFactory create(
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideLocalUserManagerFactory(applicationProvider);
  }

  public static LocalUserManager provideLocalUserManager(Application application) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLocalUserManager(application));
  }
}
