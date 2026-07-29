package wo;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.r;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.t;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class f implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f54773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f54774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f54776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f54777e;

    public f(s sVar) {
        this.f54773a = sVar;
        this.f54777e = new byte[sVar.h()];
    }

    @Override // org.bouncycastle.crypto.q
    public void a(r rVar) {
        if (!(rVar instanceof e)) {
            throw new IllegalArgumentException("unkown parameters type");
        }
        e eVar = (e) rVar;
        this.f54774b = eVar.c();
        this.f54775c = eVar.b();
        this.f54776d = eVar.a();
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("output buffer too small");
        }
        s sVar = this.f54773a;
        byte[] bArr2 = this.f54774b;
        sVar.update(bArr2, 0, bArr2.length);
        int i12 = this.f54775c;
        this.f54775c = i12 + 1;
        byte[] bArrK = o.k(i12);
        this.f54773a.update(bArrK, 0, bArrK.length);
        byte[] bArr3 = this.f54776d;
        if (bArr3 != null) {
            this.f54773a.update(bArr3, 0, bArr3.length);
        }
        this.f54773a.c(this.f54777e, 0);
        System.arraycopy(this.f54777e, 0, bArr, i10, i11);
        org.bouncycastle.util.a.n(this.f54777e);
        return i11;
    }

    @Override // org.bouncycastle.crypto.t
    public s c() {
        return this.f54773a;
    }
}
