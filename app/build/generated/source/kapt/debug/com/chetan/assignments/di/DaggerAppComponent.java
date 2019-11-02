// Generated by Dagger (https://dagger.dev).
package com.chetan.assignments.di;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.chetan.assignments.App;
import com.chetan.splash.ui.SplashFragment;
import com.chetan.splash.ui.SplashFragment_MembersInjector;
import com.chetan.splash.ui.SplashViewModel;
import com.chetan.splash.ui.SplashViewModel_Factory;
import com.chetan.splash.ui.di.SplashUiModule_SplashFragment;
import com.chetan.ui.ViewModelFactory;
import com.chetan.ui.ViewModelFactory_Factory;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private Provider<SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory> splashFragmentSubcomponentFactoryProvider;

  private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;

  private Provider<ViewModelFactory> viewModelFactoryProvider;

  private DaggerAppComponent(Application application) {

    initialize(application);
  }

  public static AppComponent.Factory factory() {
    return new Factory();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
      ) {
    return Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>singletonMap(SplashFragment.class, (Provider) splashFragmentSubcomponentFactoryProvider);}

  private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
    return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

  @SuppressWarnings("unchecked")
  private void initialize(final Application application) {
    this.splashFragmentSubcomponentFactoryProvider = new Provider<SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory>() {
      @Override
      public SplashUiModule_SplashFragment.SplashFragmentSubcomponent.Factory get() {
        return new SplashFragmentSubcomponentFactory();}
    };
    this.mapOfClassOfAndProviderOfViewModelProvider = MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(1).put(SplashViewModel.class, (Provider) SplashViewModel_Factory.create()).build();
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
    public AppComponent create(Application application) {
      Preconditions.checkNotNull(application);
      return new DaggerAppComponent(application);
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
}
