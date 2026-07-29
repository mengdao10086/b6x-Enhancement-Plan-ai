package q2;

import android.content.Context;
import androidx.work.l;
import g.i1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;
import r2.c;
import r2.f;
import r2.g;
import r2.h;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f47109d = l.f("WorkConstraintsTracker");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final c f47110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r2.c<?>[] f47111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f47112c;

    public d(@n0 Context context, @n0 w2.a taskExecutor, @p0 c callback) {
        Context applicationContext = context.getApplicationContext();
        this.f47110a = callback;
        this.f47111b = new r2.c[]{new r2.a(applicationContext, taskExecutor), new r2.b(applicationContext, taskExecutor), new h(applicationContext, taskExecutor), new r2.d(applicationContext, taskExecutor), new g(applicationContext, taskExecutor), new f(applicationContext, taskExecutor), new r2.e(applicationContext, taskExecutor)};
        this.f47112c = new Object();
    }

    @Override // r2.c.a
    public void a(@n0 List<String> workSpecIds) {
        synchronized (this.f47112c) {
            ArrayList arrayList = new ArrayList();
            for (String str : workSpecIds) {
                if (c(str)) {
                    l.c().a(f47109d, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            c cVar = this.f47110a;
            if (cVar != null) {
                cVar.f(arrayList);
            }
        }
    }

    @Override // r2.c.a
    public void b(@n0 List<String> workSpecIds) {
        synchronized (this.f47112c) {
            c cVar = this.f47110a;
            if (cVar != null) {
                cVar.b(workSpecIds);
            }
        }
    }

    public boolean c(@n0 String workSpecId) {
        synchronized (this.f47112c) {
            for (r2.c<?> cVar : this.f47111b) {
                if (cVar.d(workSpecId)) {
                    l.c().a(f47109d, String.format("Work %s constrained by %s", workSpecId, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(@n0 Iterable<r> workSpecs) {
        synchronized (this.f47112c) {
            for (r2.c<?> cVar : this.f47111b) {
                cVar.g(null);
            }
            for (r2.c<?> cVar2 : this.f47111b) {
                cVar2.e(workSpecs);
            }
            for (r2.c<?> cVar3 : this.f47111b) {
                cVar3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f47112c) {
            for (r2.c<?> cVar : this.f47111b) {
                cVar.f();
            }
        }
    }

    @i1
    public d(@p0 c callback, r2.c<?>[] controllers) {
        this.f47110a = callback;
        this.f47111b = controllers;
        this.f47112c = new Object();
    }
}
