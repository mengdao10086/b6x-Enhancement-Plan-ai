package os;

import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46207a = 168;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f46208b = 136;

    public static void a(byte[] bArr, int i10, int i11, short s10, byte[] bArr2, int i12, int i13) {
        zo.e eVar = new zo.e(128, null, new byte[]{(byte) s10, (byte) (s10 >> 8)});
        eVar.update(bArr2, i12, i13);
        eVar.f(bArr, i10, i11);
    }

    public static void b(byte[] bArr, int i10, int i11, short s10, byte[] bArr2, int i12, int i13) {
        zo.e eVar = new zo.e(256, null, new byte[]{(byte) s10, (byte) (s10 >> 8)});
        eVar.update(bArr2, i12, i13);
        eVar.f(bArr, i10, i11);
    }

    public static void c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        j0 j0Var = new j0(128);
        j0Var.update(bArr2, i12, i13);
        j0Var.f(bArr, i10, i11);
    }

    public static void d(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        j0 j0Var = new j0(256);
        j0Var.update(bArr2, i12, i13);
        j0Var.f(bArr, i10, i11);
    }
}
