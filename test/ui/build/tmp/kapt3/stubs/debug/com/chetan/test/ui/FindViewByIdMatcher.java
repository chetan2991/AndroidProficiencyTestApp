package com.chetan.test.ui;

import java.lang.System;

/**
 * Wraps matcher and apply it on a view with given resource id.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0004H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/chetan/test/ui/FindViewByIdMatcher;", "Lorg/hamcrest/TypeSafeMatcher;", "Landroid/view/View;", "viewResId", "", "viewMatcher", "Lorg/hamcrest/Matcher;", "(ILorg/hamcrest/Matcher;)V", "describeMismatchSafely", "", "item", "mismatchDescription", "Lorg/hamcrest/Description;", "describeTo", "description", "matchesSafely", "", "resourceName", "", "resources", "Landroid/content/res/Resources;", "resId", "ui_debug"})
public final class FindViewByIdMatcher extends org.hamcrest.TypeSafeMatcher<android.view.View> {
    private final int viewResId = 0;
    private final org.hamcrest.Matcher<android.view.View> viewMatcher = null;
    
    @java.lang.Override()
    protected boolean matchesSafely(@org.jetbrains.annotations.NotNull()
    android.view.View item) {
        return false;
    }
    
    @java.lang.Override()
    public void describeTo(@org.jetbrains.annotations.NotNull()
    org.hamcrest.Description description) {
    }
    
    @java.lang.Override()
    protected void describeMismatchSafely(@org.jetbrains.annotations.NotNull()
    android.view.View item, @org.jetbrains.annotations.NotNull()
    org.hamcrest.Description mismatchDescription) {
    }
    
    private final java.lang.String resourceName(android.content.res.Resources resources, @androidx.annotation.IdRes()
    int resId) {
        return null;
    }
    
    public FindViewByIdMatcher(@androidx.annotation.IdRes()
    int viewResId, @org.jetbrains.annotations.NotNull()
    org.hamcrest.Matcher<android.view.View> viewMatcher) {
        super();
    }
}