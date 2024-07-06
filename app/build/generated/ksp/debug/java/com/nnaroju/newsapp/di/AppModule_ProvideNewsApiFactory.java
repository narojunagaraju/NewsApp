package com.nnaroju.newsapp.di;

import com.nnaroju.newsapp.data.remote.NewsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideNewsApiFactory implements Factory<NewsApi> {
  @Override
  public NewsApi get() {
    return provideNewsApi();
  }

  public static AppModule_ProvideNewsApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NewsApi provideNewsApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNewsApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideNewsApiFactory INSTANCE = new AppModule_ProvideNewsApiFactory();
  }
}
