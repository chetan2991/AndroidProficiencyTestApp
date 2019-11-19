// Generated by Dagger (https://dagger.dev).
package com.chetan.test.ui.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okreplay.OkReplayInterceptor;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OkReplayInterceptorModule_Companion_OkReplayInterceptorFactory implements Factory<OkReplayInterceptor> {
  private final OkReplayInterceptorModule.Companion module;

  public OkReplayInterceptorModule_Companion_OkReplayInterceptorFactory(
      OkReplayInterceptorModule.Companion module) {
    this.module = module;
  }

  @Override
  public OkReplayInterceptor get() {
    return okReplayInterceptor(module);
  }

  public static OkReplayInterceptorModule_Companion_OkReplayInterceptorFactory create(
      OkReplayInterceptorModule.Companion module) {
    return new OkReplayInterceptorModule_Companion_OkReplayInterceptorFactory(module);
  }

  public static OkReplayInterceptor okReplayInterceptor(
      OkReplayInterceptorModule.Companion instance) {
    return Preconditions.checkNotNull(instance.okReplayInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}