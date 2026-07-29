package com.flydigi.base.common;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class RefreshableLiveData$refresh$1<T> extends FunctionReferenceImpl implements ik.l<T, z1> {
    public RefreshableLiveData$refresh$1(Object obj) {
        super(1, obj, RefreshableLiveData.class, "observer", "observer(Ljava/lang/Object;)V", 0);
    }

    public final void X0(T t10) {
        ((RefreshableLiveData) this.receiver).y(t10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(Object obj) {
        X0(obj);
        return z1.f38230a;
    }
}
