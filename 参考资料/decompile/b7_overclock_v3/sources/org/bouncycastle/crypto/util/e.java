package org.bouncycastle.crypto.util;

import gm.j2;
import gm.n0;
import gm.n2;
import gm.z;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f44730a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zn.b f44731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f44732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z f44733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public n0 f44734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public n0 f44735e;

        public b(zn.b bVar, byte[] bArr, byte[] bArr2) {
            this.f44731a = bVar;
            this.f44732b = DerUtil.a(bArr);
            this.f44733c = DerUtil.a(bArr2);
        }

        public e a() {
            gm.i iVar = new gm.i();
            iVar.a(this.f44731a);
            iVar.a(this.f44732b);
            iVar.a(this.f44733c);
            n0 n0Var = this.f44734d;
            if (n0Var != null) {
                iVar.a(n0Var);
            }
            n0 n0Var2 = this.f44735e;
            if (n0Var2 != null) {
                iVar.a(n0Var2);
            }
            return new e(new j2(iVar));
        }

        public b b(byte[] bArr) {
            this.f44735e = new n2(false, 1, (gm.h) DerUtil.a(bArr));
            return this;
        }

        public b c(byte[] bArr) {
            this.f44734d = new n2(false, 0, (gm.h) DerUtil.a(bArr));
            return this;
        }
    }

    public e(j2 j2Var) {
        this.f44730a = j2Var;
    }

    public byte[] a() throws IOException {
        return this.f44730a.getEncoded();
    }
}
