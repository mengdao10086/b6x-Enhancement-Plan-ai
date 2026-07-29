package ns;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f42639a;

    public byte[] a(org.bouncycastle.crypto.k kVar) {
        byte[] bArr = new byte[32];
        k.h(bArr, this.f42639a.f42647b, ((h) kVar).f42648b);
        return bArr;
    }

    public void b(org.bouncycastle.crypto.k kVar) {
        this.f42639a = (g) kVar;
    }
}
