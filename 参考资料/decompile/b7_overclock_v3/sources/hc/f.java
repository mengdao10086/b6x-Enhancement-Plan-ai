package hc;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.k;
import g.p0;
import gc.l;
import hd.w;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static com.google.android.exoplayer2.upstream.b a(ic.i iVar, ic.h hVar, int i10) {
        return new b.C0198b().j(hVar.b(iVar.f32083d)).i(hVar.f32076a).h(hVar.f32077b).g(iVar.k()).c(i10).a();
    }

    @p0
    public static ic.i b(ic.f fVar, int i10) {
        int iA = fVar.a(i10);
        if (iA == -1) {
            return null;
        }
        List<ic.i> list = fVar.f32068c.get(iA).f32028c;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @p0
    public static hb.e c(com.google.android.exoplayer2.upstream.a aVar, int i10, ic.i iVar) throws IOException {
        if (iVar.n() == null) {
            return null;
        }
        gc.f fVarI = i(i10, iVar.f32082c);
        try {
            f(fVarI, aVar, iVar, true);
            fVarI.release();
            return fVarI.e();
        } catch (Throwable th2) {
            fVarI.release();
            throw th2;
        }
    }

    @p0
    public static Format d(com.google.android.exoplayer2.upstream.a aVar, ic.f fVar) throws IOException {
        int i10 = 2;
        ic.i iVarB = b(fVar, 2);
        if (iVarB == null) {
            i10 = 1;
            iVarB = b(fVar, 1);
            if (iVarB == null) {
                return null;
            }
        }
        Format format = iVarB.f32082c;
        Format formatH = h(aVar, i10, iVarB);
        return formatH == null ? format : formatH.m0(format);
    }

    public static void e(com.google.android.exoplayer2.upstream.a aVar, ic.i iVar, gc.f fVar, ic.h hVar) throws IOException {
        new l(aVar, a(iVar, hVar, 0), iVar.f32082c, 0, null, fVar).b();
    }

    public static void f(gc.f fVar, com.google.android.exoplayer2.upstream.a aVar, ic.i iVar, boolean z10) throws IOException {
        ic.h hVar = (ic.h) hd.a.g(iVar.n());
        if (z10) {
            ic.h hVarM = iVar.m();
            if (hVarM == null) {
                return;
            }
            ic.h hVarA = hVar.a(hVarM, iVar.f32083d);
            if (hVarA == null) {
                e(aVar, iVar, fVar, hVar);
                hVar = hVarM;
            } else {
                hVar = hVarA;
            }
        }
        e(aVar, iVar, fVar, hVar);
    }

    public static ic.b g(com.google.android.exoplayer2.upstream.a aVar, Uri uri) throws IOException {
        return (ic.b) k.g(aVar, new ic.c(), uri, 4);
    }

    @p0
    public static Format h(com.google.android.exoplayer2.upstream.a aVar, int i10, ic.i iVar) throws IOException {
        if (iVar.n() == null) {
            return null;
        }
        gc.f fVarI = i(i10, iVar.f32082c);
        try {
            f(fVarI, aVar, iVar, false);
            fVarI.release();
            return ((Format[]) hd.a.k(fVarI.b()))[0];
        } catch (Throwable th2) {
            fVarI.release();
            throw th2;
        }
    }

    public static gc.f i(int i10, Format format) {
        String str = format.f16697k;
        return new gc.d(str != null && (str.startsWith(w.f31186h) || str.startsWith(w.C)) ? new mb.e() : new ob.g(), i10, format);
    }
}
