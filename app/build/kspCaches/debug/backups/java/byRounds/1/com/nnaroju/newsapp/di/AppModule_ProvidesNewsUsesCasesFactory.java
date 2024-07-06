package com.nnaroju.newsapp.di;

import com.nnaroju.newsapp.data.local.NewsDao;
import com.nnaroju.newsapp.domain.respository.NewsRepository;
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases;
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
public final class AppModule_ProvidesNewsUsesCasesFactory implements Factory<NewsUseCases> {
  private final Provider<NewsRepository> newsRepositoryProvider;

  private final Provider<NewsDao> newsDaoProvider;

  public AppModule_ProvidesNewsUsesCasesFactory(Provider<NewsRepository> newsRepositoryProvider,
      Provider<NewsDao> newsDaoProvider) {
    this.newsRepositoryProvider = newsRepositoryProvider;
    this.newsDaoProvider = newsDaoProvider;
  }

  @Override
  public NewsUseCases get() {
    return providesNewsUsesCases(newsRepositoryProvider.get(), newsDaoProvider.get());
  }

  public static AppModule_ProvidesNewsUsesCasesFactory create(
      Provider<NewsRepository> newsRepositoryProvider, Provider<NewsDao> newsDaoProvider) {
    return new AppModule_ProvidesNewsUsesCasesFactory(newsRepositoryProvider, newsDaoProvider);
  }

  public static NewsUseCases providesNewsUsesCases(NewsRepository newsRepository, NewsDao newsDao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesNewsUsesCases(newsRepository, newsDao));
  }
}
