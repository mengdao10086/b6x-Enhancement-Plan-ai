package com.flydigi.base.common;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import q1.b;

/* JADX INFO: loaded from: classes2.dex */
public final class RefreshableLiveData<T> extends h0<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public final ik.a<LiveData<T>> f13335n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public LiveData<T> f13336o;

    /* JADX INFO: renamed from: com.flydigi.base.common.RefreshableLiveData$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements ik.l<T, z1> {
        public AnonymousClass1(Object obj) {
            super(1, obj, RefreshableLiveData.class, "observer", "observer(Ljava/lang/Object;)V", 0);
        }

        public final void X0(T t10) {
            ((RefreshableLiveData) this.receiver).y(t10);
        }

        @Override // ik.l
        public /* bridge */ /* synthetic */ z1 i(Object obj) {
            X0(obj);
            return z1.f38230a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RefreshableLiveData(@yt.k ik.a<? extends LiveData<T>> source) {
        f0.p(source, "source");
        this.f13335n = source;
        b.a aVar = (LiveData<T>) ((LiveData) source.o());
        this.f13336o = aVar;
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        s(aVar, new k0() { // from class: com.flydigi.base.common.w
            @Override // androidx.lifecycle.k0
            public final void b(Object obj) {
                RefreshableLiveData.w(anonymousClass1, obj);
            }
        });
    }

    public static final void A(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public final void y(T t10) {
        r(t10);
    }

    public final void z() {
        t(this.f13336o);
        LiveData<T> liveDataO = this.f13335n.o();
        this.f13336o = liveDataO;
        final RefreshableLiveData$refresh$1 refreshableLiveData$refresh$1 = new RefreshableLiveData$refresh$1(this);
        s(liveDataO, new k0() { // from class: com.flydigi.base.common.v
            @Override // androidx.lifecycle.k0
            public final void b(Object obj) {
                RefreshableLiveData.A(refreshableLiveData$refresh$1, obj);
            }
        });
    }
}
