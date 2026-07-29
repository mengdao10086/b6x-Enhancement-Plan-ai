package androidx.room;

import c2.e;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class b3 implements e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.p0
    public final String f7343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public final File f7344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public final Callable<InputStream> f7345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final e.c f7346d;

    public b3(@g.p0 String str, @g.p0 File file, @g.p0 Callable<InputStream> callable, @g.n0 e.c cVar) {
        this.f7343a = str;
        this.f7344b = file;
        this.f7345c = callable;
        this.f7346d = cVar;
    }

    @Override // c2.e.c
    @g.n0
    public c2.e a(e.b bVar) {
        return new a3(bVar.f9700a, this.f7343a, this.f7344b, this.f7345c, bVar.f9702c.f9699a, this.f7346d.a(bVar));
    }
}
