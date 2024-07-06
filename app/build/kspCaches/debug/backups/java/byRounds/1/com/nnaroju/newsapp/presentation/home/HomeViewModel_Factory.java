package com.nnaroju.newsapp.presentation.home;

import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<NewsUseCases> newsUseCasesProvider;

  public HomeViewModel_Factory(Provider<NewsUseCases> newsUseCasesProvider) {
    this.newsUseCasesProvider = newsUseCasesProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(newsUseCasesProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<NewsUseCases> newsUseCasesProvider) {
    return new HomeViewModel_Factory(newsUseCasesProvider);
  }

  public static HomeViewModel newInstance(NewsUseCases newsUseCases) {
    return new HomeViewModel(newsUseCases);
  }
}
