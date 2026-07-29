package io.reactivex.disposables;

import bj.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements b, ej.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k<b> f32973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f32974b;

    public a() {
    }

    @Override // ej.a
    public boolean a(@e b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // ej.a
    public boolean b(@e b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "disposable is null");
        if (!this.f32974b) {
            synchronized (this) {
                if (!this.f32974b) {
                    k<b> kVar = this.f32973a;
                    if (kVar == null) {
                        kVar = new k<>();
                        this.f32973a = kVar;
                    }
                    kVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // ej.a
    public boolean c(@e b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "disposables is null");
        if (this.f32974b) {
            return false;
        }
        synchronized (this) {
            if (this.f32974b) {
                return false;
            }
            k<b> kVar = this.f32973a;
            if (kVar != null && kVar.e(bVar)) {
                return true;
            }
            return false;
        }
    }

    public boolean d(@e b... bVarArr) {
        io.reactivex.internal.functions.a.g(bVarArr, "disposables is null");
        if (!this.f32974b) {
            synchronized (this) {
                if (!this.f32974b) {
                    k<b> kVar = this.f32973a;
                    if (kVar == null) {
                        kVar = new k<>(bVarArr.length + 1);
                        this.f32973a = kVar;
                    }
                    for (b bVar : bVarArr) {
                        io.reactivex.internal.functions.a.g(bVar, "A Disposable in the disposables array is null");
                        kVar.a(bVar);
                    }
                    return true;
                }
            }
        }
        for (b bVar2 : bVarArr) {
            bVar2.dispose();
        }
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f32974b) {
            return;
        }
        synchronized (this) {
            if (this.f32974b) {
                return;
            }
            this.f32974b = true;
            k<b> kVar = this.f32973a;
            this.f32973a = null;
            f(kVar);
        }
    }

    public void e() {
        if (this.f32974b) {
            return;
        }
        synchronized (this) {
            if (this.f32974b) {
                return;
            }
            k<b> kVar = this.f32973a;
            this.f32973a = null;
            f(kVar);
        }
    }

    public void f(k<b> kVar) {
        if (kVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : kVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.f((Throwable) arrayList.get(0));
        }
    }

    public int g() {
        if (this.f32974b) {
            return 0;
        }
        synchronized (this) {
            if (this.f32974b) {
                return 0;
            }
            k<b> kVar = this.f32973a;
            return kVar != null ? kVar.g() : 0;
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f32974b;
    }

    public a(@e b... bVarArr) {
        io.reactivex.internal.functions.a.g(bVarArr, "disposables is null");
        this.f32973a = new k<>(bVarArr.length + 1);
        for (b bVar : bVarArr) {
            io.reactivex.internal.functions.a.g(bVar, "A Disposable in the disposables array is null");
            this.f32973a.a(bVar);
        }
    }

    public a(@e Iterable<? extends b> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "disposables is null");
        this.f32973a = new k<>();
        for (b bVar : iterable) {
            io.reactivex.internal.functions.a.g(bVar, "A Disposable item in the disposables sequence is null");
            this.f32973a.a(bVar);
        }
    }
}
