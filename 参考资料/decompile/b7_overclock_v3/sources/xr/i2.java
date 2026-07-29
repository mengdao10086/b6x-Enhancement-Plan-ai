package xr;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static class a<T> implements PrivilegedAction<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gm.f0 f55931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f55932b;

        public a(gm.f0 f0Var, Class cls) {
            this.f55931a = f0Var;
            this.f55932b = cls;
        }

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> run() {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<gm.h> it2 = this.f55931a.iterator();
                while (it2.hasNext()) {
                    arrayList.add(this.f55932b.cast(this.f55932b.getMethod("getInstance", Object.class).invoke(null, it2.next())));
                }
                return arrayList;
            } catch (Exception e10) {
                throw new IllegalStateException("could not invoke getInstance on type " + e10.getMessage(), e10);
            }
        }
    }

    public static <T> List<T> a(Class<T> cls, gm.f0 f0Var) {
        return (List) AccessController.doPrivileged(new a(f0Var, cls));
    }

    public static byte[] b(byte[] bArr) {
        if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("octet string out of range");
        }
        return org.bouncycastle.util.a.p(bArr);
    }

    public static byte[] c(byte[] bArr, int i10) {
        if (bArr.length == i10) {
            return bArr;
        }
        throw new IllegalArgumentException("octet string out of range");
    }

    public static gm.f0 d(List list) {
        return new gm.j2((gm.h[]) list.toArray(new gm.h[0]));
    }

    public static gm.f0 e(gm.h... hVarArr) {
        return new gm.j2(hVarArr);
    }
}
