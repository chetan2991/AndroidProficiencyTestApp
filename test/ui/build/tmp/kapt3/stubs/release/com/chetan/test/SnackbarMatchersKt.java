package com.chetan.test;

import java.lang.System;

@java.lang.SuppressWarnings(value = {"MatchingDeclarationName"})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0005\"\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\t\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\t\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"hasNoSnackbar", "Lorg/hamcrest/Matcher;", "Landroid/view/View;", "hasSnackbar", "matchers", "", "([Lorg/hamcrest/Matcher;)Lorg/hamcrest/Matcher;", "withAction", "resId", "", "withMessage", "message", "", "ui_release"})
public final class SnackbarMatchersKt {
    
    /**
     * Creates matcher that verifies that view doesn't have Snackbar.
     */
    @org.jetbrains.annotations.NotNull()
    public static final org.hamcrest.Matcher<android.view.View> hasNoSnackbar() {
        return null;
    }
    
    /**
     * Creates matcher that verifies that view has Snackbar.
     */
    @org.jetbrains.annotations.NotNull()
    public static final org.hamcrest.Matcher<android.view.View> hasSnackbar(@org.jetbrains.annotations.NotNull()
    org.hamcrest.Matcher<android.view.View>... matchers) {
        return null;
    }
    
    /**
     * Creates matcher that matches snackbar message text with given string resource id.
     */
    @org.jetbrains.annotations.NotNull()
    public static final org.hamcrest.Matcher<android.view.View> withMessage(@androidx.annotation.StringRes()
    int resId) {
        return null;
    }
    
    /**
     * Creates matcher that matches snackbar message text with given string resource id.
     */
    @org.jetbrains.annotations.NotNull()
    public static final org.hamcrest.Matcher<android.view.View> withMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return null;
    }
    
    /**
     * Creates matcher that matches snackbar action button text with given string resource id.
     */
    @org.jetbrains.annotations.NotNull()
    public static final org.hamcrest.Matcher<android.view.View> withAction(@androidx.annotation.StringRes()
    int resId) {
        return null;
    }
}