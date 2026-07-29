package et;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class j implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[][] f27166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short[][] f27167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[] f27168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f27169d;

    public j(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f27169d = i10;
        this.f27166a = sArr;
        this.f27167b = sArr2;
        this.f27168c = sArr3;
    }

    public short[][] a() {
        return this.f27166a;
    }

    public short[] b() {
        return this.f27168c;
    }

    public short[][] c() {
        return this.f27167b;
    }

    public int d() {
        return this.f27169d;
    }
}
