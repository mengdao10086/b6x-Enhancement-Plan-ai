package fs;

import cs.d0;
import cs.q;
import gm.y;
import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.h;
import org.bouncycastle.crypto.v;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f28735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f28736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f28737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f28738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28739e;

    public class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f28740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f28741b;

        public a(r rVar, char[] cArr) {
            this.f28740a = rVar;
            this.f28741b = cArr;
        }

        @Override // cs.d0
        public zn.b a() {
            return new zn.b(f.this.f28737c, this.f28740a);
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return new gp.b(outputStream, f.this.f28736b);
        }

        @Override // cs.d0
        public q getKey() {
            return new q(new zn.b(f.this.f28737c, this.f28740a), c0.a(this.f28741b));
        }
    }

    public f(y yVar, org.bouncycastle.crypto.f fVar) {
        this(yVar, fVar, new zo.c0());
    }

    public f(y yVar, org.bouncycastle.crypto.f fVar, v vVar) {
        this.f28739e = 1024;
        this.f28737c = yVar;
        this.f28736b = new mp.e(fVar, new mp.d());
        this.f28735a = vVar;
    }

    public d0 c(char[] cArr) {
        if (this.f28738d == null) {
            this.f28738d = new SecureRandom();
        }
        byte[] bArr = new byte[20];
        this.f28738d.nextBytes(bArr);
        r rVar = new r(bArr, this.f28739e);
        this.f28736b.f(true, g.a(this.f28737c, this.f28735a, this.f28736b.b(), rVar, cArr));
        return new a(rVar, cArr);
    }

    public f d(int i10) {
        this.f28739e = i10;
        return this;
    }
}
