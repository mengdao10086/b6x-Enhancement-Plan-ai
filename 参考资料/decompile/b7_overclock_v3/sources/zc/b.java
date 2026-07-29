package zc;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import hd.c0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import qc.b;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends qc.d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f58336p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f58337q = 1885436268;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f58338r = 1937011815;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f58339s = 1987343459;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f58340o;

    public b() {
        super("Mp4WebvttDecoder");
        this.f58340o = new c0();
    }

    public static qc.b B(c0 c0Var, int i10) throws SubtitleDecoderException {
        CharSequence charSequenceQ = null;
        b.c cVarO = null;
        while (i10 > 0) {
            if (i10 < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int iO = c0Var.o();
            int iO2 = c0Var.o();
            int i11 = iO - 8;
            String strK = u0.K(c0Var.d(), c0Var.e(), i11);
            c0Var.T(i11);
            i10 = (i10 - 8) - i11;
            if (iO2 == 1937011815) {
                cVarO = f.o(strK);
            } else if (iO2 == 1885436268) {
                charSequenceQ = f.q(null, strK.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return cVarO != null ? cVarO.z(charSequenceQ).a() : f.l(charSequenceQ);
    }

    @Override // qc.d
    public qc.f A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        this.f58340o.Q(bArr, i10);
        ArrayList arrayList = new ArrayList();
        while (this.f58340o.a() > 0) {
            if (this.f58340o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iO = this.f58340o.o();
            if (this.f58340o.o() == 1987343459) {
                arrayList.add(B(this.f58340o, iO - 8));
            } else {
                this.f58340o.T(iO - 8);
            }
        }
        return new c(arrayList);
    }
}
