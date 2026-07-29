package im;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import java.util.Iterator;
import org.bouncycastle.util.a;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w implements org.bouncycastle.util.k<gm.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.h[] f32521a;

    public g(f0 f0Var) {
        this.f32521a = new gm.h[f0Var.size()];
        int i10 = 0;
        while (true) {
            gm.h[] hVarArr = this.f32521a;
            if (i10 == hVarArr.length) {
                return;
            }
            hVarArr[i10] = f.B(f0Var.K(i10));
            i10++;
        }
    }

    public g(f[] fVarArr) {
        gm.h[] hVarArr = new gm.h[fVarArr.length];
        this.f32521a = hVarArr;
        System.arraycopy(fVarArr, 0, hVarArr, 0, fVarArr.length);
    }

    public static g x(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new j2(this.f32521a);
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<gm.h> iterator() {
        return new a.C0517a(this.f32521a);
    }
}
