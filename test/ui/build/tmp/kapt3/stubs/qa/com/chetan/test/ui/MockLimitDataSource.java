package com.chetan.test.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/chetan/test/ui/MockLimitDataSource;", "T", "Landroidx/room/paging/LimitOffsetDataSource;", "itemList", "", "(Ljava/util/List;)V", "convertRows", "", "cursor", "Landroid/database/Cursor;", "countItems", "", "isInvalid", "", "loadInitial", "", "params", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "callback", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "loadRange", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "startPosition", "loadCount", "ui_qa"})
public final class MockLimitDataSource<T extends java.lang.Object> extends androidx.room.paging.LimitOffsetDataSource<T> {
    private final java.util.List<T> itemList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.util.List<T> convertRows(@org.jetbrains.annotations.Nullable()
    android.database.Cursor cursor) {
        return null;
    }
    
    @java.lang.Override()
    public int countItems() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isInvalid() {
        return false;
    }
    
    @java.lang.Override()
    public void loadRange(@org.jetbrains.annotations.NotNull()
    androidx.paging.PositionalDataSource.LoadRangeParams params, @org.jetbrains.annotations.NotNull()
    androidx.paging.PositionalDataSource.LoadRangeCallback<T> callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<T> loadRange(int startPosition, int loadCount) {
        return null;
    }
    
    @java.lang.Override()
    public void loadInitial(@org.jetbrains.annotations.NotNull()
    androidx.paging.PositionalDataSource.LoadInitialParams params, @org.jetbrains.annotations.NotNull()
    androidx.paging.PositionalDataSource.LoadInitialCallback<T> callback) {
    }
    
    public MockLimitDataSource(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> itemList) {
        super(null, null, false, null);
    }
}