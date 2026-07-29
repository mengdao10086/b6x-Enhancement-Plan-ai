package fs;

import cs.y;
import gm.d2;
import java.security.SecureRandom;
import org.bouncycastle.crypto.v;
import pn.r;
import zo.c0;

/* JADX INFO: loaded from: classes6.dex */
public class c implements es.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f28721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f28722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f28723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28725e;

    public c() {
        this(new c0(), new zn.b(on.b.f44365i, d2.f29657b));
    }

    public c(v vVar, zn.b bVar) {
        this.f28725e = 1024;
        this.f28721a = vVar;
        this.f28722b = bVar;
        this.f28724d = vVar.h();
    }

    @Override // es.d
    public zn.b a() {
        return this.f28722b;
    }

    @Override // es.d
    public y b(char[] cArr) {
        if (this.f28723c == null) {
            this.f28723c = new SecureRandom();
        }
        byte[] bArr = new byte[this.f28724d];
        this.f28723c.nextBytes(bArr);
        return g.b(this.f28722b.x(), this.f28721a, new r(bArr, this.f28725e), cArr);
    }

    public c c(int i10) {
        this.f28725e = i10;
        return this;
    }
}
