package sb;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import g.p0;
import hb.l;
import hd.c0;
import hd.t;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f49579a = "WavHeaderReader";

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f49580c = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f49582b;

        public a(int i10, long j10) {
            this.f49581a = i10;
            this.f49582b = j10;
        }

        public static a a(l lVar, c0 c0Var) throws IOException {
            lVar.t(c0Var.d(), 0, 8);
            c0Var.S(0);
            return new a(c0Var.o(), c0Var.v());
        }
    }

    @p0
    public static c a(l lVar) throws IOException {
        byte[] bArr;
        hd.a.g(lVar);
        c0 c0Var = new c0(16);
        if (a.a(lVar, c0Var).f49581a != 1380533830) {
            return null;
        }
        lVar.t(c0Var.d(), 0, 4);
        c0Var.S(0);
        int iO = c0Var.o();
        if (iO != 1463899717) {
            t.d(f49579a, "Unsupported RIFF format: " + iO);
            return null;
        }
        a aVarA = a.a(lVar, c0Var);
        while (aVarA.f49581a != 1718449184) {
            lVar.j((int) aVarA.f49582b);
            aVarA = a.a(lVar, c0Var);
        }
        hd.a.i(aVarA.f49582b >= 16);
        lVar.t(c0Var.d(), 0, 16);
        c0Var.S(0);
        int iY = c0Var.y();
        int iY2 = c0Var.y();
        int iX = c0Var.x();
        int iX2 = c0Var.x();
        int iY3 = c0Var.y();
        int iY4 = c0Var.y();
        int i10 = ((int) aVarA.f49582b) - 16;
        if (i10 > 0) {
            byte[] bArr2 = new byte[i10];
            lVar.t(bArr2, 0, i10);
            bArr = bArr2;
        } else {
            bArr = u0.f31159f;
        }
        return new c(iY, iY2, iX, iX2, iY3, iY4, bArr);
    }

    public static Pair<Long, Long> b(l lVar) throws IOException {
        hd.a.g(lVar);
        lVar.n();
        c0 c0Var = new c0(8);
        a aVarA = a.a(lVar, c0Var);
        while (true) {
            int i10 = aVarA.f49581a;
            if (i10 == 1684108385) {
                lVar.o(8);
                long position = lVar.getPosition();
                long j10 = aVarA.f49582b + position;
                long length = lVar.getLength();
                if (length != -1 && j10 > length) {
                    t.n(f49579a, "Data exceeds input length: " + j10 + ", " + length);
                    j10 = length;
                }
                return Pair.create(Long.valueOf(position), Long.valueOf(j10));
            }
            if (i10 != 1380533830 && i10 != 1718449184) {
                t.n(f49579a, "Ignoring unknown WAV chunk: " + aVarA.f49581a);
            }
            long j11 = aVarA.f49582b + 8;
            if (aVarA.f49581a == 1380533830) {
                j11 = 12;
            }
            if (j11 > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + aVarA.f49581a);
            }
            lVar.o((int) j11);
            aVarA = a.a(lVar, c0Var);
        }
    }
}
