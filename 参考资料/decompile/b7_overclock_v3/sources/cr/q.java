package cr;

import gm.d2;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class q extends PBEKeySpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zn.b f25847b = new zn.b(pn.s.f46806g4, d2.f29657b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f25848a;

    public q(char[] cArr, byte[] bArr, int i10, int i11, zn.b bVar) {
        super(cArr, bArr, i10, i11);
        this.f25848a = bVar;
    }

    public zn.b a() {
        return this.f25848a;
    }

    public boolean b() {
        return f25847b.equals(this.f25848a);
    }
}
