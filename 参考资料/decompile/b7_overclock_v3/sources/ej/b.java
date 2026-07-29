package ej;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements io.reactivex.disposables.b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<io.reactivex.disposables.b> f26999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f27000b;

    public b() {
    }

    @Override // ej.a
    public boolean a(io.reactivex.disposables.b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // ej.a
    public boolean b(io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "d is null");
        if (!this.f27000b) {
            synchronized (this) {
                if (!this.f27000b) {
                    List linkedList = this.f26999a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f26999a = linkedList;
                    }
                    linkedList.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // ej.a
    public boolean c(io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.g(bVar, "Disposable item is null");
        if (this.f27000b) {
            return false;
        }
        synchronized (this) {
            if (this.f27000b) {
                return false;
            }
            List<io.reactivex.disposables.b> list = this.f26999a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    public boolean d(io.reactivex.disposables.b... bVarArr) {
        io.reactivex.internal.functions.a.g(bVarArr, "ds is null");
        if (!this.f27000b) {
            synchronized (this) {
                if (!this.f27000b) {
                    List linkedList = this.f26999a;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f26999a = linkedList;
                    }
                    for (io.reactivex.disposables.b bVar : bVarArr) {
                        io.reactivex.internal.functions.a.g(bVar, "d is null");
                        linkedList.add(bVar);
                    }
                    return true;
                }
            }
        }
        for (io.reactivex.disposables.b bVar2 : bVarArr) {
            bVar2.dispose();
        }
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f27000b) {
            return;
        }
        synchronized (this) {
            if (this.f27000b) {
                return;
            }
            this.f27000b = true;
            List<io.reactivex.disposables.b> list = this.f26999a;
            this.f26999a = null;
            f(list);
        }
    }

    public void e() {
        if (this.f27000b) {
            return;
        }
        synchronized (this) {
            if (this.f27000b) {
                return;
            }
            List<io.reactivex.disposables.b> list = this.f26999a;
            this.f26999a = null;
            f(list);
        }
    }

    public void f(List<io.reactivex.disposables.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<io.reactivex.disposables.b> it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().dispose();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.f((Throwable) arrayList.get(0));
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f27000b;
    }

    public b(io.reactivex.disposables.b... bVarArr) {
        io.reactivex.internal.functions.a.g(bVarArr, "resources is null");
        this.f26999a = new LinkedList();
        for (io.reactivex.disposables.b bVar : bVarArr) {
            io.reactivex.internal.functions.a.g(bVar, "Disposable item is null");
            this.f26999a.add(bVar);
        }
    }

    public b(Iterable<? extends io.reactivex.disposables.b> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "resources is null");
        this.f26999a = new LinkedList();
        for (io.reactivex.disposables.b bVar : iterable) {
            io.reactivex.internal.functions.a.g(bVar, "Disposable item is null");
            this.f26999a.add(bVar);
        }
    }
}
