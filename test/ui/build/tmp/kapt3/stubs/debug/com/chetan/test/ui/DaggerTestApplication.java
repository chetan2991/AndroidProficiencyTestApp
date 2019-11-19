package com.chetan.test.ui;

import java.lang.System;

/**
 * Base application class for instrumented tests.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\u0016R\u001a\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/chetan/test/ui/DaggerTestApplication;", "Ldagger/android/support/DaggerApplication;", "()V", "component", "Ldagger/android/AndroidInjector;", "getComponent", "()Ldagger/android/AndroidInjector;", "applicationInjector", "ui_debug"})
public abstract class DaggerTestApplication extends dagger.android.support.DaggerApplication {
    
    @org.jetbrains.annotations.NotNull()
    public abstract dagger.android.AndroidInjector<? extends dagger.android.support.DaggerApplication> getComponent();
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public dagger.android.AndroidInjector<? extends dagger.android.support.DaggerApplication> applicationInjector() {
        return null;
    }
    
    public DaggerTestApplication() {
        super();
    }
}