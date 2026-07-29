package vm;

import gm.c0;
import gm.f2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f53232a;

    public b(z zVar) {
        this.f53232a = zVar;
    }

    public b(byte[] bArr) {
        this(new f2(bArr));
    }

    public static b x(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(z.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f53232a;
    }

    public z y() {
        return this.f53232a;
    }
}
