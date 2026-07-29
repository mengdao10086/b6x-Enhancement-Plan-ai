package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11798f = "UiMessageUtils";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f11799g = l1.q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f11801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<List<d>> f11802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f11803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f11804e;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h1 f11805a = new h1();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f11806a;

        public int b() {
            return this.f11806a.what;
        }

        public Object c() {
            return this.f11806a.obj;
        }

        public final void d(Message message) {
            this.f11806a = message;
        }

        public String toString() {
            return "{ id=" + b() + ", obj=" + c() + " }";
        }

        public c(Message message) {
            this.f11806a = message;
        }
    }

    public interface d {
        void a(@g.n0 c cVar);
    }

    public static h1 c() {
        return b.f11805a;
    }

    public void a(int i10, @g.n0 d dVar) {
        Objects.requireNonNull(dVar, "Argument 'listener' of type UiMessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.f11802c) {
            List<d> arrayList = this.f11802c.get(i10);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f11802c.put(i10, arrayList);
            }
            if (!arrayList.contains(dVar)) {
                arrayList.add(dVar);
            }
        }
    }

    public void b(@g.n0 d dVar) {
        Objects.requireNonNull(dVar, "Argument 'listener' of type UiMessageCallback (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.f11803d) {
            if (!this.f11803d.contains(dVar)) {
                this.f11803d.add(dVar);
            } else if (f11799g) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Listener is already added. ");
                sb2.append(dVar.toString());
            }
        }
    }

    public final void d(@g.n0 c cVar) {
        Objects.requireNonNull(cVar, "Argument 'msg' of type UiMessage (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<d> list = this.f11802c.get(cVar.b());
        if ((list == null || list.size() == 0) && this.f11803d.size() == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Delivering FAILED for message ID ");
            sb2.append(cVar.b());
            sb2.append(". No listeners. ");
            sb2.append(cVar.toString());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Delivering message ID ");
        sb3.append(cVar.b());
        sb3.append(", Specific listeners: ");
        if (list == null || list.size() == 0) {
            sb3.append(0);
        } else {
            sb3.append(list.size());
            sb3.append(" [");
            for (int i10 = 0; i10 < list.size(); i10++) {
                sb3.append(list.get(i10).getClass().getSimpleName());
                if (i10 < list.size() - 1) {
                    sb3.append(ag.c.f654g);
                }
            }
            sb3.append("]");
        }
        sb3.append(", Universal listeners: ");
        synchronized (this.f11803d) {
            if (this.f11803d.size() == 0) {
                sb3.append(0);
            } else {
                sb3.append(this.f11803d.size());
                sb3.append(" [");
                for (int i11 = 0; i11 < this.f11803d.size(); i11++) {
                    sb3.append(this.f11803d.get(i11).getClass().getSimpleName());
                    if (i11 < this.f11803d.size() - 1) {
                        sb3.append(ag.c.f654g);
                    }
                }
                sb3.append("], Message: ");
            }
        }
        sb3.append(cVar.toString());
    }

    public void e(int i10, @g.n0 d dVar) {
        Objects.requireNonNull(dVar, "Argument 'listener' of type UiMessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.f11802c) {
            List<d> list = this.f11802c.get(i10);
            if (list == null || list.isEmpty()) {
                if (f11799g) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Trying to remove specific listener that is not registered. ID ");
                    sb2.append(i10);
                    sb2.append(", ");
                    sb2.append(dVar);
                }
            } else {
                if (f11799g && !list.contains(dVar)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Trying to remove specific listener that is not registered. ID ");
                    sb3.append(i10);
                    sb3.append(", ");
                    sb3.append(dVar);
                    return;
                }
                list.remove(dVar);
            }
        }
    }

    public void f(@g.n0 d dVar) {
        Objects.requireNonNull(dVar, "Argument 'listener' of type UiMessageCallback (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        synchronized (this.f11803d) {
            if (f11799g && !this.f11803d.contains(dVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Trying to remove a listener that is not registered. ");
                sb2.append(dVar.toString());
            }
            this.f11803d.remove(dVar);
        }
    }

    public void g(int i10) {
        List<d> list;
        if (f11799g && ((list = this.f11802c.get(i10)) == null || list.size() == 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to remove specific listeners that are not registered. ID ");
            sb2.append(i10);
        }
        synchronized (this.f11802c) {
            this.f11802c.delete(i10);
        }
    }

    public final void h(int i10) {
        this.f11800a.sendEmptyMessage(i10);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.f11801b.d(message);
        if (f11799g) {
            d(this.f11801b);
        }
        synchronized (this.f11802c) {
            List<d> list = this.f11802c.get(message.what);
            if (list != null) {
                if (list.size() == 0) {
                    this.f11802c.remove(message.what);
                } else {
                    this.f11804e.addAll(list);
                    Iterator<d> it2 = this.f11804e.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(this.f11801b);
                    }
                    this.f11804e.clear();
                }
            }
        }
        synchronized (this.f11803d) {
            if (this.f11803d.size() > 0) {
                this.f11804e.addAll(this.f11803d);
                Iterator<d> it3 = this.f11804e.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this.f11801b);
                }
                this.f11804e.clear();
            }
        }
        this.f11801b.d(null);
        return true;
    }

    public final void i(int i10, @g.n0 Object obj) {
        Objects.requireNonNull(obj, "Argument 'obj' of type Object (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Handler handler = this.f11800a;
        handler.sendMessage(handler.obtainMessage(i10, obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h1() {
        this.f11800a = new Handler(Looper.getMainLooper(), this);
        this.f11801b = new c(null);
        this.f11802c = new SparseArray<>();
        this.f11803d = new ArrayList();
        this.f11804e = new ArrayList();
    }
}
