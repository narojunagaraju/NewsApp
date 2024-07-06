package com.nnaroju.newsapp.presentation.bookmark;

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
public final class BookmarkViewModel_Factory implements Factory<BookmarkViewModel> {
  private final Provider<NewsUseCases> newsUseCasesProvider;

  public BookmarkViewModel_Factory(Provider<NewsUseCases> newsUseCasesProvider) {
    this.newsUseCasesProvider = newsUseCasesProvider;
  }

  @Override
  public BookmarkViewModel get() {
    return newInstance(newsUseCasesProvider.get());
  }

  public static BookmarkViewModel_Factory create(Provider<NewsUseCases> newsUseCasesProvider) {
    return new BookmarkViewModel_Factory(newsUseCasesProvider);
  }

  public static BookmarkViewModel newInstance(NewsUseCases newsUseCases) {
    return new BookmarkViewModel(newsUseCases);
  }
}
