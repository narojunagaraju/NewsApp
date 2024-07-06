package com.nnaroju.newsapp.di;

import com.nnaroju.newsapp.data.local.NewsDao;
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
public final class AppModule_ProvidesNewsDaoFactory implements Factory<NewsDao> {
  private final Provider<NewsDatabase> newsDatabaseProvider;

  public AppModule_ProvidesNewsDaoFactory(Provider<NewsDatabase> newsDatabaseProvider) {
    this.newsDatabaseProvider = newsDatabaseProvider;
  }

  @Override
  public NewsDao get() {
    return providesNewsDao(newsDatabaseProvider.get());
  }

  public static AppModule_ProvidesNewsDaoFactory create(
      Provider<NewsDatabase> newsDatabaseProvider) {
    return new AppModule_ProvidesNewsDaoFactory(newsDatabaseProvider);
  }

  public static NewsDao providesNewsDao(NewsDatabase newsDatabase) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesNewsDao(newsDatabase));
  }
}
