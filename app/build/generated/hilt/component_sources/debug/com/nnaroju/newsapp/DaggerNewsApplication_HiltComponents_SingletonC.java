package com.nnaroju.newsapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.nnaroju.newsapp.data.local.NewsDao;
import com.nnaroju.newsapp.data.local.NewsDatabase;
import com.nnaroju.newsapp.data.remote.NewsApi;
import com.nnaroju.newsapp.di.AppModule_ProvideAppEntryUseCasesFactory;
import com.nnaroju.newsapp.di.AppModule_ProvideLocalUserManagerFactory;
import com.nnaroju.newsapp.di.AppModule_ProvideNewsApiFactory;
import com.nnaroju.newsapp.di.AppModule_ProvideNewsRepositoryFactory;
import com.nnaroju.newsapp.di.AppModule_ProvidesNewsDaoFactory;
import com.nnaroju.newsapp.di.AppModule_ProvidesNewsDatabaseFactory;
import com.nnaroju.newsapp.di.AppModule_ProvidesNewsUsesCasesFactory;
import com.nnaroju.newsapp.domain.manager.LocalUserManager;
import com.nnaroju.newsapp.domain.respository.NewsRepository;
import com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases;
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases;
import com.nnaroju.newsapp.presentation.bookmark.BookmarkViewModel;
import com.nnaroju.newsapp.presentation.bookmark.BookmarkViewModel_HiltModules;
import com.nnaroju.newsapp.presentation.details.components.DetailsViewModel;
import com.nnaroju.newsapp.presentation.details.components.DetailsViewModel_HiltModules;
import com.nnaroju.newsapp.presentation.home.HomeViewModel;
import com.nnaroju.newsapp.presentation.home.HomeViewModel_HiltModules;
import com.nnaroju.newsapp.presentation.onboarding.OnboardingViewModel;
import com.nnaroju.newsapp.presentation.onboarding.OnboardingViewModel_HiltModules;
import com.nnaroju.newsapp.presentation.search.SearchViewModel;
import com.nnaroju.newsapp.presentation.search.SearchViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerNewsApplication_HiltComponents_SingletonC {
  private DaggerNewsApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public NewsApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements NewsApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements NewsApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements NewsApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements NewsApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements NewsApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements NewsApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements NewsApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends NewsApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends NewsApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends NewsApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends NewsApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(6).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_bookmark_BookmarkViewModel, BookmarkViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_details_components_DetailsViewModel, DetailsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_home_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nnaroju_newsapp_MainViewModel, MainViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_onboarding_OnboardingViewModel, OnboardingViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_search_SearchViewModel, SearchViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_nnaroju_newsapp_presentation_details_components_DetailsViewModel = "com.nnaroju.newsapp.presentation.details.components.DetailsViewModel";

      static String com_nnaroju_newsapp_presentation_bookmark_BookmarkViewModel = "com.nnaroju.newsapp.presentation.bookmark.BookmarkViewModel";

      static String com_nnaroju_newsapp_MainViewModel = "com.nnaroju.newsapp.MainViewModel";

      static String com_nnaroju_newsapp_presentation_search_SearchViewModel = "com.nnaroju.newsapp.presentation.search.SearchViewModel";

      static String com_nnaroju_newsapp_presentation_home_HomeViewModel = "com.nnaroju.newsapp.presentation.home.HomeViewModel";

      static String com_nnaroju_newsapp_presentation_onboarding_OnboardingViewModel = "com.nnaroju.newsapp.presentation.onboarding.OnboardingViewModel";

      @KeepFieldType
      DetailsViewModel com_nnaroju_newsapp_presentation_details_components_DetailsViewModel2;

      @KeepFieldType
      BookmarkViewModel com_nnaroju_newsapp_presentation_bookmark_BookmarkViewModel2;

      @KeepFieldType
      MainViewModel com_nnaroju_newsapp_MainViewModel2;

      @KeepFieldType
      SearchViewModel com_nnaroju_newsapp_presentation_search_SearchViewModel2;

      @KeepFieldType
      HomeViewModel com_nnaroju_newsapp_presentation_home_HomeViewModel2;

      @KeepFieldType
      OnboardingViewModel com_nnaroju_newsapp_presentation_onboarding_OnboardingViewModel2;
    }
  }

  private static final class ViewModelCImpl extends NewsApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<BookmarkViewModel> bookmarkViewModelProvider;

    private Provider<DetailsViewModel> detailsViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<MainViewModel> mainViewModelProvider;

    private Provider<OnboardingViewModel> onboardingViewModelProvider;

    private Provider<SearchViewModel> searchViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.bookmarkViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.detailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.onboardingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.searchViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(6).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_bookmark_BookmarkViewModel, ((Provider) bookmarkViewModelProvider)).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_details_components_DetailsViewModel, ((Provider) detailsViewModelProvider)).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_home_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.com_nnaroju_newsapp_MainViewModel, ((Provider) mainViewModelProvider)).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_onboarding_OnboardingViewModel, ((Provider) onboardingViewModelProvider)).put(LazyClassKeyProvider.com_nnaroju_newsapp_presentation_search_SearchViewModel, ((Provider) searchViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_nnaroju_newsapp_presentation_bookmark_BookmarkViewModel = "com.nnaroju.newsapp.presentation.bookmark.BookmarkViewModel";

      static String com_nnaroju_newsapp_presentation_onboarding_OnboardingViewModel = "com.nnaroju.newsapp.presentation.onboarding.OnboardingViewModel";

      static String com_nnaroju_newsapp_presentation_details_components_DetailsViewModel = "com.nnaroju.newsapp.presentation.details.components.DetailsViewModel";

      static String com_nnaroju_newsapp_presentation_search_SearchViewModel = "com.nnaroju.newsapp.presentation.search.SearchViewModel";

      static String com_nnaroju_newsapp_MainViewModel = "com.nnaroju.newsapp.MainViewModel";

      static String com_nnaroju_newsapp_presentation_home_HomeViewModel = "com.nnaroju.newsapp.presentation.home.HomeViewModel";

      @KeepFieldType
      BookmarkViewModel com_nnaroju_newsapp_presentation_bookmark_BookmarkViewModel2;

      @KeepFieldType
      OnboardingViewModel com_nnaroju_newsapp_presentation_onboarding_OnboardingViewModel2;

      @KeepFieldType
      DetailsViewModel com_nnaroju_newsapp_presentation_details_components_DetailsViewModel2;

      @KeepFieldType
      SearchViewModel com_nnaroju_newsapp_presentation_search_SearchViewModel2;

      @KeepFieldType
      MainViewModel com_nnaroju_newsapp_MainViewModel2;

      @KeepFieldType
      HomeViewModel com_nnaroju_newsapp_presentation_home_HomeViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.nnaroju.newsapp.presentation.bookmark.BookmarkViewModel 
          return (T) new BookmarkViewModel(singletonCImpl.providesNewsUsesCasesProvider.get());

          case 1: // com.nnaroju.newsapp.presentation.details.components.DetailsViewModel 
          return (T) new DetailsViewModel(singletonCImpl.providesNewsUsesCasesProvider.get());

          case 2: // com.nnaroju.newsapp.presentation.home.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.providesNewsUsesCasesProvider.get());

          case 3: // com.nnaroju.newsapp.MainViewModel 
          return (T) new MainViewModel(singletonCImpl.provideAppEntryUseCasesProvider.get());

          case 4: // com.nnaroju.newsapp.presentation.onboarding.OnboardingViewModel 
          return (T) new OnboardingViewModel(singletonCImpl.provideAppEntryUseCasesProvider.get());

          case 5: // com.nnaroju.newsapp.presentation.search.SearchViewModel 
          return (T) new SearchViewModel(singletonCImpl.providesNewsUsesCasesProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends NewsApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends NewsApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends NewsApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<NewsApi> provideNewsApiProvider;

    private Provider<NewsRepository> provideNewsRepositoryProvider;

    private Provider<NewsDatabase> providesNewsDatabaseProvider;

    private Provider<NewsDao> providesNewsDaoProvider;

    private Provider<NewsUseCases> providesNewsUsesCasesProvider;

    private Provider<LocalUserManager> provideLocalUserManagerProvider;

    private Provider<AppEntryUseCases> provideAppEntryUseCasesProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideNewsApiProvider = DoubleCheck.provider(new SwitchingProvider<NewsApi>(singletonCImpl, 2));
      this.provideNewsRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<NewsRepository>(singletonCImpl, 1));
      this.providesNewsDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<NewsDatabase>(singletonCImpl, 4));
      this.providesNewsDaoProvider = DoubleCheck.provider(new SwitchingProvider<NewsDao>(singletonCImpl, 3));
      this.providesNewsUsesCasesProvider = DoubleCheck.provider(new SwitchingProvider<NewsUseCases>(singletonCImpl, 0));
      this.provideLocalUserManagerProvider = DoubleCheck.provider(new SwitchingProvider<LocalUserManager>(singletonCImpl, 6));
      this.provideAppEntryUseCasesProvider = DoubleCheck.provider(new SwitchingProvider<AppEntryUseCases>(singletonCImpl, 5));
    }

    @Override
    public void injectNewsApplication(NewsApplication newsApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.nnaroju.newsapp.domain.usecases.news.NewsUseCases 
          return (T) AppModule_ProvidesNewsUsesCasesFactory.providesNewsUsesCases(singletonCImpl.provideNewsRepositoryProvider.get(), singletonCImpl.providesNewsDaoProvider.get());

          case 1: // com.nnaroju.newsapp.domain.respository.NewsRepository 
          return (T) AppModule_ProvideNewsRepositoryFactory.provideNewsRepository(singletonCImpl.provideNewsApiProvider.get());

          case 2: // com.nnaroju.newsapp.data.remote.NewsApi 
          return (T) AppModule_ProvideNewsApiFactory.provideNewsApi();

          case 3: // com.nnaroju.newsapp.data.local.NewsDao 
          return (T) AppModule_ProvidesNewsDaoFactory.providesNewsDao(singletonCImpl.providesNewsDatabaseProvider.get());

          case 4: // com.nnaroju.newsapp.data.local.NewsDatabase 
          return (T) AppModule_ProvidesNewsDatabaseFactory.providesNewsDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 5: // com.nnaroju.newsapp.domain.usecases.app_entry.AppEntryUseCases 
          return (T) AppModule_ProvideAppEntryUseCasesFactory.provideAppEntryUseCases(singletonCImpl.provideLocalUserManagerProvider.get());

          case 6: // com.nnaroju.newsapp.domain.manager.LocalUserManager 
          return (T) AppModule_ProvideLocalUserManagerFactory.provideLocalUserManager(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
