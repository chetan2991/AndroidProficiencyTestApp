package umon.ui.test.binding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a@\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\u0002\b\rH\u0086\b\u001a*\u0010\u000e\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0086\b\u00a2\u0006\u0002\u0010\u0010\u001aE\u0010\u000e\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0011*\u0002H\u00022\b\u0010\u0012\u001a\u0004\u0018\u0001H\u00112\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\u0002\b\rH\u0086\b\u00a2\u0006\u0002\u0010\u0013\" \u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0014"}, d2 = {"parent", "Landroid/view/View;", "T", "Landroidx/databinding/ViewDataBinding;", "getParent", "(Landroidx/databinding/ViewDataBinding;)Landroid/view/View;", "inflate", "", "layout", "", "style", "init", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "bind", "Lkotlin/Function0;", "(Landroidx/databinding/ViewDataBinding;Lkotlin/jvm/functions/Function0;)V", "S", "state", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ui_release"})
public final class DataBindingTestUtilKt {
    
    /**
     * Inflates a binding layout and calls [init] on newly-created binding for that layout.
     */
    public static final <T extends androidx.databinding.ViewDataBinding>void inflate(@androidx.annotation.LayoutRes()
    int layout, @androidx.annotation.StyleRes()
    int style, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> init) {
    }
    
    /**
     * Executes pending binding right away.
     */
    public static final <T extends androidx.databinding.ViewDataBinding>void bind(@org.jetbrains.annotations.NotNull()
    T $this$bind, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> init) {
    }
    
    /**
     * Executes pending binding right away.
     */
    public static final <T extends androidx.databinding.ViewDataBinding, S extends java.lang.Object>void bind(@org.jetbrains.annotations.NotNull()
    T $this$bind, @org.jetbrains.annotations.Nullable()
    S state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super S, kotlin.Unit> init) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends androidx.databinding.ViewDataBinding>android.view.View getParent(@org.jetbrains.annotations.NotNull()
    T $this$parent) {
        return null;
    }
}