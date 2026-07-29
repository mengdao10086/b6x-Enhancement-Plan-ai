package si;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public e f49841a;

    public final void a() {
        e eVar = this.f49841a;
        if (eVar != null) {
            eVar.P1();
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        this.f49841a = null;
        b();
    }

    public void e(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("Sync client must not be null");
        }
        this.f49841a = eVar;
        c();
    }
}
