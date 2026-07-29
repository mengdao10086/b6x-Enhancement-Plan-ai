package t1;

import android.content.Context;
import g.n0;
import g.v0;
import t1.e;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class f extends h {
    public f(Context context) {
        super(context);
        this.f50844a = context;
    }

    @Override // t1.h, t1.e.a
    public boolean a(@n0 e.c cVar) {
        return e(cVar) || super.a(cVar);
    }

    public final boolean e(@n0 e.c cVar) {
        return b().checkPermission(h.f50842f, cVar.b(), cVar.a()) == 0;
    }
}
