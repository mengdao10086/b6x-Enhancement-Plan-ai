package wo;

import gm.y;
import org.bouncycastle.crypto.r;

/* JADX INFO: loaded from: classes5.dex */
public class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f54757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f54759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f54760d;

    public b(y yVar, int i10, byte[] bArr) {
        this(yVar, i10, bArr, null);
    }

    public b(y yVar, int i10, byte[] bArr, byte[] bArr2) {
        this.f54757a = yVar;
        this.f54758b = i10;
        this.f54759c = bArr;
        this.f54760d = bArr2;
    }

    public y a() {
        return this.f54757a;
    }

    public byte[] b() {
        return this.f54760d;
    }

    public int c() {
        return this.f54758b;
    }

    public byte[] d() {
        return this.f54759c;
    }
}
