package a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<p> f7163a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2489a;

    public q(boolean z) {
        this.f2489a = z;
    }

    public void a(p pVar) {
        this.f7163a.add(pVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f2489a;
    }

    public final void d() {
        Iterator<p> it = this.f7163a.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public void e(p pVar) {
        this.f7163a.remove(pVar);
    }

    public final void f(boolean z) {
        this.f2489a = z;
    }
}
