package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v<T> {
    @SuppressLint({"MissingNullability"})
    public static w a(final w wVar, @SuppressLint({"MissingNullability"}) final w wVar2) {
        Objects.requireNonNull(wVar2);
        return new w() { // from class: androidx.core.util.r
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return v.d(wVar, wVar2, obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w b(w wVar3) {
                return v.a(this, wVar3);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w c() {
                return v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w d(w wVar3) {
                return v.c(this, wVar3);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static w b(final w wVar) {
        return new w() { // from class: androidx.core.util.q
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return v.e(wVar, obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w b(w wVar2) {
                return v.a(this, wVar2);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w c() {
                return v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w d(w wVar2) {
                return v.c(this, wVar2);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static w c(final w wVar, @SuppressLint({"MissingNullability"}) final w wVar2) {
        Objects.requireNonNull(wVar2);
        return new w() { // from class: androidx.core.util.s
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return v.f(wVar, wVar2, obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w b(w wVar3) {
                return v.a(this, wVar3);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w c() {
                return v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ w d(w wVar3) {
                return v.c(this, wVar3);
            }
        };
    }

    public static /* synthetic */ boolean d(w wVar, w wVar2, Object obj) {
        return wVar.a(obj) && wVar2.a(obj);
    }

    public static /* synthetic */ boolean e(w wVar, Object obj) {
        return !wVar.a(obj);
    }

    public static /* synthetic */ boolean f(w wVar, w wVar2, Object obj) {
        return wVar.a(obj) || wVar2.a(obj);
    }

    @SuppressLint({"MissingNullability"})
    public static <T> w<T> g(@SuppressLint({"MissingNullability"}) final Object obj) {
        return obj == null ? new w() { // from class: androidx.core.util.u
            public /* synthetic */ w a(w wVar) {
                return v.a(this, wVar);
            }

            public /* synthetic */ w b() {
                return v.b(this);
            }

            public /* synthetic */ w c(w wVar) {
                return v.c(this, wVar);
            }

            public final boolean d(Object obj2) {
                return p.a(obj2);
            }
        } : new w() { // from class: androidx.core.util.t
            public /* synthetic */ w a(w wVar) {
                return v.a(this, wVar);
            }

            public /* synthetic */ w b() {
                return v.b(this);
            }

            public /* synthetic */ w c(w wVar) {
                return v.c(this, wVar);
            }

            public final boolean d(Object obj2) {
                return obj.equals(obj2);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static <T> w<T> j(@SuppressLint({"MissingNullability"}) w<? super T> wVar) {
        Objects.requireNonNull(wVar);
        return wVar.c();
    }
}
