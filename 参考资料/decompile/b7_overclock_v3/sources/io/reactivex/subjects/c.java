package io.reactivex.subjects;

import bj.e;
import bj.f;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> extends z<T> implements g0<T> {
    @f
    public abstract Throwable i8();

    public abstract boolean j8();

    public abstract boolean k8();

    public abstract boolean l8();

    @e
    public final c<T> m8() {
        return this instanceof b ? this : new b(this);
    }
}
