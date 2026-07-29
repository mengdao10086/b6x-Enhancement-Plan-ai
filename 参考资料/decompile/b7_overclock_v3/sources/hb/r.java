package hb;

import com.google.android.exoplayer2.ParserException;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30895a;
    }

    public static boolean a(hd.c0 c0Var, u uVar, int i10) {
        int iJ = j(c0Var, i10);
        return iJ != -1 && iJ <= uVar.f30906b;
    }

    public static boolean b(hd.c0 c0Var, int i10) {
        return c0Var.G() == u0.x(c0Var.d(), i10, c0Var.e() - 1, 0);
    }

    public static boolean c(hd.c0 c0Var, u uVar, boolean z10, a aVar) {
        try {
            long jN = c0Var.N();
            if (!z10) {
                jN *= (long) uVar.f30906b;
            }
            aVar.f30895a = jN;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(hd.c0 c0Var, u uVar, int i10, a aVar) {
        int iE = c0Var.e();
        long jI = c0Var.I();
        long j10 = jI >>> 16;
        if (j10 != i10) {
            return false;
        }
        return g((int) (15 & (jI >> 4)), uVar) && f((int) ((jI >> 1) & 7), uVar) && !(((jI & 1) > 1L ? 1 : ((jI & 1) == 1L ? 0 : -1)) == 0) && c(c0Var, uVar, ((j10 & 1) > 1L ? 1 : ((j10 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(c0Var, uVar, (int) ((jI >> 12) & 15)) && e(c0Var, uVar, (int) ((jI >> 8) & 15)) && b(c0Var, iE);
    }

    public static boolean e(hd.c0 c0Var, u uVar, int i10) {
        int i11 = uVar.f30909e;
        if (i10 == 0) {
            return true;
        }
        if (i10 <= 11) {
            return i10 == uVar.f30910f;
        }
        if (i10 == 12) {
            return c0Var.G() * 1000 == i11;
        }
        if (i10 > 14) {
            return false;
        }
        int iM = c0Var.M();
        if (i10 == 14) {
            iM *= 10;
        }
        return iM == i11;
    }

    public static boolean f(int i10, u uVar) {
        return i10 == 0 || i10 == uVar.f30913i;
    }

    public static boolean g(int i10, u uVar) {
        return i10 <= 7 ? i10 == uVar.f30911g - 1 : i10 <= 10 && uVar.f30911g == 2;
    }

    public static boolean h(l lVar, u uVar, int i10, a aVar) throws IOException {
        long jI = lVar.i();
        byte[] bArr = new byte[2];
        lVar.t(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
            lVar.n();
            lVar.j((int) (jI - lVar.getPosition()));
            return false;
        }
        hd.c0 c0Var = new hd.c0(16);
        System.arraycopy(bArr, 0, c0Var.d(), 0, 2);
        c0Var.R(n.a(lVar, c0Var.d(), 2, 14));
        lVar.n();
        lVar.j((int) (jI - lVar.getPosition()));
        return d(c0Var, uVar, i10, aVar);
    }

    public static long i(l lVar, u uVar) throws IOException {
        lVar.n();
        lVar.j(1);
        byte[] bArr = new byte[1];
        lVar.t(bArr, 0, 1);
        boolean z10 = (bArr[0] & 1) == 1;
        lVar.j(2);
        int i10 = z10 ? 7 : 6;
        hd.c0 c0Var = new hd.c0(i10);
        c0Var.R(n.a(lVar, c0Var.d(), 0, i10));
        lVar.n();
        a aVar = new a();
        if (c(c0Var, uVar, z10, aVar)) {
            return aVar.f30895a;
        }
        throw new ParserException();
    }

    public static int j(hd.c0 c0Var, int i10) {
        switch (i10) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i10 - 2);
            case 6:
                return c0Var.G() + 1;
            case 7:
                return c0Var.M() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i10 - 8);
            default:
                return -1;
        }
    }
}
