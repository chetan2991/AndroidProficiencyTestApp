package com.chetan.assignments.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/chetan/assignments/di/AppComponent;", "Ldagger/android/AndroidInjector;", "Lcom/chetan/assignments/App;", "Factory", "app_debug"})
@dagger.Component(modules = {dagger.android.support.AndroidSupportInjectionModule.class, com.chetan.base.ui.di.BaseUiModule.class, com.chetan.base.domain.di.BaseDomainModule.class, com.chetan.base.data.di.BaseDataModule.class, com.chetan.home.ui.di.HomeUiModule.class, com.chetan.home.domain.di.HomeDomainModule.class, com.chetan.home.data.di.HomeDataModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent extends dagger.android.AndroidInjector<com.chetan.assignments.App> {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/chetan/assignments/di/AppComponent$Factory;", "", "create", "Lcom/chetan/assignments/di/AppComponent;", "app", "Landroid/app/Application;", "app_debug"})
    @dagger.Component.Factory()
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.chetan.assignments.di.AppComponent create(@org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        android.app.Application app);
    }
}