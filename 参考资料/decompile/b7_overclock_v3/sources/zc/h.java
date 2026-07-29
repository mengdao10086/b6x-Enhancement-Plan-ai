package zc;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import hd.c0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends qc.d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f58418q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f58419r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f58420s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f58421t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f58422u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f58423v = "NOTE";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f58424w = "STYLE";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f58425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f58426p;

    public h() {
        super("WebvttDecoder");
        this.f58425o = new c0();
        this.f58426p = new a();
    }

    public static int B(c0 c0Var) {
        int i10 = -1;
        int iE = 0;
        while (i10 == -1) {
            iE = c0Var.e();
            String strQ = c0Var.q();
            i10 = strQ == null ? 0 : f58424w.equals(strQ) ? 2 : strQ.startsWith(f58423v) ? 1 : 3;
        }
        c0Var.S(iE);
        return i10;
    }

    public static void C(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.q())) {
        }
    }

    @Override // qc.d
    public qc.f A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        e eVarM;
        this.f58425o.Q(bArr, i10);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.f58425o);
            while (!TextUtils.isEmpty(this.f58425o.q())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iB = B(this.f58425o);
                if (iB == 0) {
                    return new k(arrayList2);
                }
                if (iB == 1) {
                    C(this.f58425o);
                } else if (iB == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.f58425o.q();
                    arrayList.addAll(this.f58426p.d(this.f58425o));
                } else if (iB == 3 && (eVarM = f.m(this.f58425o, arrayList)) != null) {
                    arrayList2.add(eVarM);
                }
            }
        } catch (ParserException e10) {
            throw new SubtitleDecoderException(e10);
        }
    }
}
