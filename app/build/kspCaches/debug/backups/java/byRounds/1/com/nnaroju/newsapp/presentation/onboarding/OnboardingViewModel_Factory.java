package com.nnaroju.newsapp.presentation.onboarding;

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
public final class OnboardingViewModel_Factory implements Factory<OnboardingViewModel> {
  private final Provider<AppEntryUseCases> appEntryUseCasesProvider;

  public OnboardingViewModel_Factory(Provider<AppEntryUseCases> appEntryUseCasesProvider) {
    this.appEntryUseCasesProvider = appEntryUseCasesProvider;
  }

  @Override
  public OnboardingViewModel get() {
    return newInstance(appEntryUseCasesProvider.get());
  }

  public static OnboardingViewModel_Factory create(
      Provider<AppEntryUseCases> appEntryUseCasesProvider) {
    return new OnboardingViewModel_Factory(appEntryUseCasesProvider);
  }

  public static OnboardingViewModel newInstance(AppEntryUseCases appEntryUseCases) {
    return new OnboardingViewModel(appEntryUseCases);
  }
}
