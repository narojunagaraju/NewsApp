package com.nnaroju.newsapp;

import com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases;
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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<AppEntryUseCases> appEntryUseCasesProvider;

  public MainViewModel_Factory(Provider<AppEntryUseCases> appEntryUseCasesProvider) {
    this.appEntryUseCasesProvider = appEntryUseCasesProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(appEntryUseCasesProvider.get());
  }

  public static MainViewModel_Factory create(Provider<AppEntryUseCases> appEntryUseCasesProvider) {
    return new MainViewModel_Factory(appEntryUseCasesProvider);
  }

  public static MainViewModel newInstance(AppEntryUseCases appEntryUseCases) {
    return new MainViewModel(appEntryUseCases);
  }
}
