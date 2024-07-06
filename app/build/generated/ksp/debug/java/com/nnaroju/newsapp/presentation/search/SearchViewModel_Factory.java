package com.nnaroju.newsapp.presentation.search;

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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<NewsUseCases> newsUseCasesProvider;

  public SearchViewModel_Factory(Provider<NewsUseCases> newsUseCasesProvider) {
    this.newsUseCasesProvider = newsUseCasesProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(newsUseCasesProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<NewsUseCases> newsUseCasesProvider) {
    return new SearchViewModel_Factory(newsUseCasesProvider);
  }

  public static SearchViewModel newInstance(NewsUseCases newsUseCases) {
    return new SearchViewModel(newsUseCases);
  }
}
