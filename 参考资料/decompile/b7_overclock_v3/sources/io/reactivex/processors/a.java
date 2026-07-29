package io.reactivex.processors;

import bj.c;
import bj.e;
import bj.f;
import xi.j;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> extends j<T> implements bu.b<T, T>, o<T> {
    @f
    public abstract Throwable M8();

    public abstract boolean N8();

    public abstract boolean O8();

    public abstract boolean P8();

    @c
    @e
    public final a<T> Q8() {
        return this instanceof b ? this : new b(this);
    }
}
