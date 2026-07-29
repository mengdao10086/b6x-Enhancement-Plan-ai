package jo;

import cs.o;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class j implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f36539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36540b;

    public j(o oVar) {
        this(oVar, 28);
    }

    public j(o oVar, int i10) {
        this.f36539a = oVar;
        this.f36540b = i10;
    }

    @Override // cs.o
    public zn.b a() {
        return this.f36539a.a();
    }

    @Override // cs.o
    public OutputStream b() {
        return this.f36539a.b();
    }

    @Override // cs.o
    public byte[] c() {
        int i10 = this.f36540b;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f36539a.c(), 0, bArr, 0, i10);
        return bArr;
    }
}
