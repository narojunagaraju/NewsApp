package com.nnaroju.newsapp.di;

import android.app.Application;
import com.nnaroju.newsapp.data.local.NewsDatabase;
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
public final class AppModule_ProvidesNewsDatabaseFactory implements Factory<NewsDatabase> {
  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesNewsDatabaseFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public NewsDatabase get() {
    return providesNewsDatabase(applicationProvider.get());
  }

  public static AppModule_ProvidesNewsDatabaseFactory create(
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesNewsDatabaseFactory(applicationProvider);
  }

  public static NewsDatabase providesNewsDatabase(Application application) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesNewsDatabase(application));
  }
}
