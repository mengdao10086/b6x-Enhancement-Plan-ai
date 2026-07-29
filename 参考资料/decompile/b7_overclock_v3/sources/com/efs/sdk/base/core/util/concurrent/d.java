package com.efs.sdk.base.core.util.concurrent;

import com.efs.sdk.base.core.util.Log;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b<T>> f12947a = new ArrayList(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<T> f12948b;

    public d(@n0 c<T> cVar) {
        this.f12948b = cVar;
    }

    public final void a(@n0 List<b<T>> list) {
        this.f12947a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public final T a() {
        T tA = null;
        try {
            Iterator<b<T>> it2 = this.f12947a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
            tA = this.f12948b.a();
            Iterator<b<T>> it3 = this.f12947a.iterator();
            while (it3.hasNext()) {
                it3.next().a(this.f12948b, tA);
            }
            Iterator<b<T>> it4 = this.f12947a.iterator();
            while (it4.hasNext()) {
                it4.next().result(tA);
            }
        } catch (Throwable th2) {
            Log.w("efs.util.concurrent", th2);
            Iterator<b<T>> it5 = this.f12947a.iterator();
            while (it5.hasNext()) {
                it5.next();
            }
        }
        return tA;
    }
}
