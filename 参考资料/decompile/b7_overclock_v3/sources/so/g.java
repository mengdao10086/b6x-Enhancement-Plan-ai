package so;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class g extends a0 {
    public mm.g0 B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f50174y = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f50175z = null;
    public d A = null;

    @Override // so.a0
    public void a(w1 w1Var) {
        this.f50174y.add(w1Var);
    }

    @Override // so.a0
    public void b(n1 n1Var) {
        this.B = n1Var.c();
    }

    public void d(d dVar) {
        this.f50175z = dVar;
    }

    public void e(d dVar) {
        this.A = dVar;
    }
}
