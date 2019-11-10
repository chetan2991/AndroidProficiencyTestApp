// Generated by Dagger (https://dagger.dev).
package com.chetan.assignments.di;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.chetan.assignments.App;
import com.chetan.base.data.di.LoggingInterceptorModule_LoggingInterceptorFactory;
import com.chetan.base.data.di.NetworkModule_LoggerFactory;
import com.chetan.base.data.di.NetworkModule_OkHttpClientFactory;
import com.chetan.base.data.di.NetworkModule_RetrofitFactory;
import com.chetan.base.data.network.NetworkClient;
import com.chetan.base.data.network.NetworkClient_Factory;
import com.chetan.base.ui.ViewModelFactory;
import com.chetan.base.ui.ViewModelFactory_Factory;
import com.chetan.home.data.HomeRepositoryImpl;
import com.chetan.home.data.HomeRepositoryImpl_Factory;
import com.chetan.home.data.db.FactDao;
import com.chetan.home.data.db.FactDatabase;
import com.chetan.home.data.db.FactLocalCacheImpl;
import com.chetan.home.data.db.FactLocalCahe;
import com.chetan.home.data.di.FactDbModule;
import com.chetan.home.data.di.FactDbModule_ProvideFactDaoFactory;
import com.chetan.home.data.di.FactDbModule_ProvideFactLocalCacheImplFactory;
import com.chetan.home.data.di.FactDbModule_ProvideIoCoroutineScopeFactory;
import com.chetan.home.data.di.FactDbModule_ProvidesRoomFactDatabaseFactory;
import com.chetan.home.data.di.HomeDataModule_HomeCacheFactory;
import com.chetan.home.data.di.HomeDataModule_HomeServiceFactory;
import com.chetan.home.data.di.HomeDataModule_ProvideRemoteDataSourceFactory;
import com.chetan.home.data.network.HomeNetworkService;
import com.chetan.home.data.network.HomeRemoteDataSource;
import com.chetan.home.domain.GetFactsImpl;
import com.chetan.home.domain.GetFactsImpl_Factory;
import com.chetan.home.ui.HomeColorPalettesImpl;
import com.chetan.home.ui.HomeColorPalettesImpl_Factory;
import com.chetan.home.ui.HomeFragment;
import com.chetan.home.ui.HomeFragment_MembersInjector;
import com.chetan.home.ui.HomeViewModel;
import com.chetan.home.ui.HomeViewModel_Factory;
import com.chetan.home.ui.di.HomeUiModule_HomeFragment;
import com.chetan.splash.ui.SplashFragment;
import com.chetan.splash.ui.SplashFragment_MembersInjector;
import com.chetan.splash.ui.SplashViewModel;
import com.chetan.splash.ui.SplashViewModel_Factory;
import com.chetan.splash.ui.di.SplashUiModule_SplashFragment;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private Provider<SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory> splashFragmentSubcomponentFactoryProvider;

  private Provider<HomeUiModule_HomeFragment.HomeFragmentSubcomponent.Factory> homeFragmentSubcomponentFactoryProvider;

  private Provider<Set<Interceptor>> setOfInterceptorProvider;

  private Provider<OkHttpClient> okHttpClientProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<NetworkClient> networkClientProvider;

  private Provider<HomeNetworkService> homeServiceProvider;

  private Provider<HomeRemoteDataSource> provideRemoteDataSourceProvider;

  private Provider<Application> appProvider;

  private Provider<FactDatabase> providesRoomFactDatabaseProvider;

  private Provider<FactDao> provideFactDaoProvider;

  private Provider<CoroutineScope> provideIoCoroutineScopeProvider;

  private Provider<FactLocalCacheImpl> provideFactLocalCacheImplProvider;

  private Provider<FactLocalCahe> homeCacheProvider;

  private Provider<HomeRepositoryImpl> homeRepositoryImplProvider;

  private Provider<GetFactsImpl> getFactsImplProvider;

  private Provider<HomeColorPalettesImpl> homeColorPalettesImplProvider;

  private Provider<HomeViewModel> homeViewModelProvider;

  private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;

  private Provider<ViewModelFactory> viewModelFactoryProvider;

  private DaggerAppComponent(FactDbModule factDbModuleParam, Application appParam) {

    initialize(factDbModuleParam, appParam);
  }

  public static AppComponent.Factory factory() {
    return new Factory();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
      ) {
    return MapBuilder.<Class<?>, Provider<AndroidInjector.Factory<?>>>newMapBuilder(2).put(SplashFragment.class, (Provider) splashFragmentSubcomponentFactoryProvider).put(HomeFragment.class, (Provider) homeFragmentSubcomponentFactoryProvider).build();}

  private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
    return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

  @SuppressWarnings("unchecked")
  private void initialize(final FactDbModule factDbModuleParam, final Application appParam) {
    this.splashFragmentSubcomponentFactoryProvider = new Provider<SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory>() {
      @Override
      public SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory get() {
        return new SplashFragmentSubcomponentFactory();}
    };
    this.homeFragmentSubcomponentFactoryProvider = new Provider<HomeUiModule_HomeFragment.HomeFragmentSubcomponent.Factory>() {
      @Override
      public HomeUiModule_HomeFragment.HomeFragmentSubcomponent.Factory get() {
        return new HomeFragmentSubcomponentFactory();}
    };
    this.setOfInterceptorProvider = SetFactory.<Interceptor>builder(1, 0).addProvider(LoggingInterceptorModule_LoggingInterceptorFactory.create()).build();
    this.okHttpClientProvider = NetworkModule_OkHttpClientFactory.create(setOfInterceptorProvider, NetworkModule_LoggerFactory.create());
    this.retrofitProvider = NetworkModule_RetrofitFactory.create(okHttpClientProvider);
    this.networkClientProvider = DoubleCheck.provider(NetworkClient_Factory.create(retrofitProvider));
    this.homeServiceProvider = HomeDataModule_HomeServiceFactory.create(networkClientProvider);
    this.provideRemoteDataSourceProvider = HomeDataModule_ProvideRemoteDataSourceFactory.create(homeServiceProvider);
    this.appProvider = InstanceFactory.create(appParam);
    this.providesRoomFactDatabaseProvider = DoubleCheck.provider(FactDbModule_ProvidesRoomFactDatabaseFactory.create(factDbModuleParam, appProvider));
    this.provideFactDaoProvider = DoubleCheck.provider(FactDbModule_ProvideFactDaoFactory.create(factDbModuleParam, providesRoomFactDatabaseProvider));
    this.provideIoCoroutineScopeProvider = FactDbModule_ProvideIoCoroutineScopeFactory.create(factDbModuleParam);
    this.provideFactLocalCacheImplProvider = DoubleCheck.provider(FactDbModule_ProvideFactLocalCacheImplFactory.create(factDbModuleParam, provideFactDaoProvider, provideIoCoroutineScopeProvider));
    this.homeCacheProvider = HomeDataModule_HomeCacheFactory.create(provideFactLocalCacheImplProvider);
    this.homeRepositoryImplProvider = HomeRepositoryImpl_Factory.create(provideRemoteDataSourceProvider, homeCacheProvider, provideIoCoroutineScopeProvider);
    this.getFactsImplProvider = GetFactsImpl_Factory.create((Provider) homeRepositoryImplProvider);
    this.homeColorPalettesImplProvider = HomeColorPalettesImpl_Factory.create(appProvider);
    this.homeViewModelProvider = HomeViewModel_Factory.create((Provider) getFactsImplProvider, (Provider) homeColorPalettesImplProvider);
    this.mapOfClassOfAndProviderOfViewModelProvider = MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(2).put(SplashViewModel.class, (Provider) SplashViewModel_Factory.create()).put(HomeViewModel.class, (Provider) homeViewModelProvider).build();
    this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(mapOfClassOfAndProviderOfViewModelProvider));
  }

  @Override
  public void inject(App arg0) {
    injectApp(arg0);}

  private App injectApp(App instance) {
    DaggerApplication_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
    return instance;
  }

  private static final class Factory implements AppComponent.Factory {
    @Override
    public AppComponent create(Application app) {
      Preconditions.checkNotNull(app);
      return new DaggerAppComponent(new FactDbModule(), app);
    }
  }

  private final class SplashFragmentSubcomponentFactory implements SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory {
    @Override
    public SplashUiModule_SplashFragment.SplashFragmentSubcomponent create(SplashFragment arg0) {
      Preconditions.checkNotNull(arg0);
      return new SplashFragmentSubcomponentImpl(arg0);
    }
  }

  private final class SplashFragmentSubcomponentImpl implements SplashUiModule_SplashFragment.SplashFragmentSubcomponent {
    private SplashFragmentSubcomponentImpl(SplashFragment arg0) {

    }

    @Override
    public void inject(SplashFragment arg0) {
      injectSplashFragment(arg0);}

    private SplashFragment injectSplashFragment(SplashFragment instance) {
      DaggerFragment_MembersInjector.injectAndroidInjector(instance, DaggerAppComponent.this.getDispatchingAndroidInjectorOfObject());
      SplashFragment_MembersInjector.injectFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }

  private final class HomeFragmentSubcomponentFactory implements HomeUiModule_HomeFragment.HomeFragmentSubcomponent.Factory {
    @Override
    public HomeUiModule_HomeFragment.HomeFragmentSubcomponent create(HomeFragment arg0) {
      Preconditions.checkNotNull(arg0);
      return new HomeFragmentSubcomponentImpl(arg0);
    }
  }

  private final class HomeFragmentSubcomponentImpl implements HomeUiModule_HomeFragment.HomeFragmentSubcomponent {
    private HomeFragmentSubcomponentImpl(HomeFragment arg0) {

    }

    @Override
    public void inject(HomeFragment arg0) {
      injectHomeFragment(arg0);}

    private HomeFragment injectHomeFragment(HomeFragment instance) {
      DaggerFragment_MembersInjector.injectAndroidInjector(instance, DaggerAppComponent.this.getDispatchingAndroidInjectorOfObject());
      HomeFragment_MembersInjector.injectFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
      return instance;
    }
  }
}