package np;

/* JADX INFO: loaded from: classes5.dex */
public class a2 extends n1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42330b;

    public a2(byte[] bArr) {
        this(bArr, bArr.length > 128 ? 1024 : bArr.length * 8);
    }

    public a2(byte[] bArr, int i10) {
        super(bArr);
        this.f42330b = i10;
    }

    public int b() {
        return this.f42330b;
    }
}
