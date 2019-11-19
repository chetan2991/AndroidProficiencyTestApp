package com.chetan.test.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u001a1\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b\u001aA\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u001a\u001a\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\"\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a\"\u0010\u000f\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\"\u0010\u000f\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013\u00a8\u0006\u0014"}, d2 = {"launchFragment", "Landroidx/fragment/app/testing/FragmentScenario;", "F", "Landroidx/fragment/app/Fragment;", "navController", "Landroidx/navigation/NavController;", "args", "Landroid/os/Bundle;", "factory", "Lkotlin/Function0;", "launchFragmentInContainer", "assertNavigatedBack", "", "backTo", "Lcom/chetan/base/ui/NavigateTo$BackTo;", "assertNavigatedTo", "direction", "Landroidx/navigation/NavDirections;", "deepLink", "Lcom/chetan/base/ui/NavigateTo$DeepLink;", "ui_debug"})
public final class FragmentScenarioExtKt {
    
    /**
     * To assert the fragment of [FragmentScenario] is navigated to given [NavDirections].
     */
    public static final <F extends androidx.fragment.app.Fragment>void assertNavigatedTo(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.testing.FragmentScenario<F> $this$assertNavigatedTo, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavDirections direction) {
    }
    
    /**
     * To assert the fragment of [FragmentScenario] is navigated to given [DeepLink].
     */
    public static final <F extends androidx.fragment.app.Fragment>void assertNavigatedTo(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.testing.FragmentScenario<F> $this$assertNavigatedTo, @org.jetbrains.annotations.NotNull()
    com.chetan.base.ui.NavigateTo.DeepLink deepLink) {
    }
    
    /**
     * To assert the fragment of [FragmentScenario] is navigated to back.
     */
    public static final <F extends androidx.fragment.app.Fragment>void assertNavigatedBack(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.testing.FragmentScenario<F> $this$assertNavigatedBack) {
    }
    
    /**
     * To assert the fragment of [FragmentScenario] is navigated to back to specific destination.
     */
    public static final <F extends androidx.fragment.app.Fragment>void assertNavigatedBack(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.testing.FragmentScenario<F> $this$assertNavigatedBack, @org.jetbrains.annotations.NotNull()
    com.chetan.base.ui.NavigateTo.BackTo backTo) {
    }
    
    /**
     * To assert the [NavController] is navigated to given [NavDirections].
     */
    public static final void assertNavigatedTo(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController $this$assertNavigatedTo, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavDirections direction) {
    }
    
    /**
     * To assert the [NavController] is navigated to given [DeepLink].
     */
    public static final void assertNavigatedTo(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController $this$assertNavigatedTo, @org.jetbrains.annotations.NotNull()
    com.chetan.base.ui.NavigateTo.DeepLink deepLink) {
    }
    
    /**
     * To assert the [NavController] is navigated to back.
     */
    public static final void assertNavigatedBack(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController $this$assertNavigatedBack) {
    }
    
    /**
     * To assert the [NavController] is navigated to back to specific destination.
     */
    public static final void assertNavigatedBack(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController $this$assertNavigatedBack, @org.jetbrains.annotations.NotNull()
    com.chetan.base.ui.NavigateTo.BackTo backTo) {
    }
}