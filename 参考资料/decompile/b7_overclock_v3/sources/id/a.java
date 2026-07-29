package id;

import com.google.android.exoplayer2.ParserException;
import g.p0;
import hd.c0;
import hd.y;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f32132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f32136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final String f32137f;

    public a(List<byte[]> list, int i10, int i11, int i12, float f10, @p0 String str) {
        this.f32132a = list;
        this.f32133b = i10;
        this.f32134c = i11;
        this.f32135d = i12;
        this.f32136e = f10;
        this.f32137f = str;
    }

    public static byte[] a(c0 c0Var) {
        int iM = c0Var.M();
        int iE = c0Var.e();
        c0Var.T(iM);
        return hd.d.d(c0Var.d(), iE, iM);
    }

    public static a b(c0 c0Var) throws ParserException {
        String strA;
        int i10;
        float f10;
        try {
            c0Var.T(4);
            int iG = (c0Var.G() & 3) + 1;
            if (iG == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iG2 = c0Var.G() & 31;
            for (int i11 = 0; i11 < iG2; i11++) {
                arrayList.add(a(c0Var));
            }
            int iG3 = c0Var.G();
            for (int i12 = 0; i12 < iG3; i12++) {
                arrayList.add(a(c0Var));
            }
            int i13 = -1;
            if (iG2 > 0) {
                y.b bVarI = hd.y.i((byte[]) arrayList.get(0), iG, ((byte[]) arrayList.get(0)).length);
                int i14 = bVarI.f31246e;
                int i15 = bVarI.f31247f;
                float f11 = bVarI.f31248g;
                strA = hd.d.a(bVarI.f31242a, bVarI.f31243b, bVarI.f31244c);
                i13 = i14;
                i10 = i15;
                f10 = f11;
            } else {
                strA = null;
                i10 = -1;
                f10 = 1.0f;
            }
            return new a(arrayList, iG, i13, i10, f10, strA);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw new ParserException("Error parsing AVC config", e10);
        }
    }
}
