package p4;

import android.content.Context;
import g.n0;
import p4.c;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f46364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.a f46365b;

    public e(@n0 Context context, @n0 c.a aVar) {
        this.f46364a = context.getApplicationContext();
        this.f46365b = aVar;
    }

    @Override // p4.m
    public void a() {
    }

    @Override // p4.m
    public void b() {
        d();
    }

    @Override // p4.m
    public void c() {
        e();
    }

    public final void d() {
        s.a(this.f46364a).d(this.f46365b);
    }

    public final void e() {
        s.a(this.f46364a).f(this.f46365b);
    }
}
