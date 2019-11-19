package com.chetan.test.ui.di;

import java.lang.System;

/**
 * Dagger module for [OkReplayInterceptor].
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/chetan/test/ui/di/OkReplayInterceptorModule;", "", "()V", "bindOkReplayInterceptor", "Lokhttp3/Interceptor;", "interceptor", "Lokreplay/OkReplayInterceptor;", "Companion", "ui_debug"})
@dagger.Module()
public abstract class OkReplayInterceptorModule {
    public static final com.chetan.test.ui.di.OkReplayInterceptorModule.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.multibindings.IntoSet()
    @dagger.Binds()
    public abstract okhttp3.Interceptor bindOkReplayInterceptor(@org.jetbrains.annotations.NotNull()
    okreplay.OkReplayInterceptor interceptor);
    
    public OkReplayInterceptorModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public static final okreplay.OkReplayInterceptor okReplayInterceptor() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/chetan/test/ui/di/OkReplayInterceptorModule$Companion;", "", "()V", "okReplayInterceptor", "Lokreplay/OkReplayInterceptor;", "ui_debug"})
    @dagger.Module()
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        @javax.inject.Singleton()
        @dagger.Provides()
        public final okreplay.OkReplayInterceptor okReplayInterceptor() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}