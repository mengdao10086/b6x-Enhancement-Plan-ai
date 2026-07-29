package yc;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.common.base.Charsets;
import hd.c0;
import hd.t;
import hd.u0;
import java.util.List;
import qc.b;
import qc.d;
import qc.f;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    public static final String A = "Serif";
    public static final int B = 8;
    public static final int C = 2;
    public static final int D = 2;
    public static final int E = 12;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 4;
    public static final int I = 16711680;
    public static final int J = 0;
    public static final int K = 0;
    public static final int L = -1;
    public static final String M = "sans-serif";
    public static final float N = 0.85f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f57287v = "Tx3gDecoder";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final char f57288w = 65279;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final char f57289x = 65534;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f57290y = 1937013100;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f57291z = 1952608120;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f57292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f57293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f57294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f57295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f57296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f57297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f57298u;

    public a(List<byte[]> list) {
        super(f57287v);
        this.f57292o = new c0();
        if (list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f57294q = 0;
            this.f57295r = -1;
            this.f57296s = "sans-serif";
            this.f57293p = false;
            this.f57297t = 0.85f;
            this.f57298u = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f57294q = bArr[24];
        this.f57295r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f57296s = A.equals(u0.K(bArr, 43, bArr.length - 43)) ? g.f56727r : "sans-serif";
        int i10 = bArr[25] * 20;
        this.f57298u = i10;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f57293p = z10;
        if (z10) {
            this.f57297t = u0.s(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i10, 0.0f, 0.95f);
        } else {
            this.f57297t = 0.85f;
        }
    }

    public static void C(boolean z10) throws SubtitleDecoderException {
        if (!z10) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void D(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i10 >>> 8) | ((i10 & 255) << 24)), i12, i13, i14 | 33);
        }
    }

    public static void E(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            int i15 = i14 | 33;
            boolean z10 = (i10 & 1) != 0;
            boolean z11 = (i10 & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i12, i13, i15);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i12, i13, i15);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, i13, i15);
            }
            boolean z12 = (i10 & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i13, i15);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i12, i13, i15);
        }
    }

    public static void F(SpannableStringBuilder spannableStringBuilder, String str, int i10, int i11) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i10, i11, 16711713);
        }
    }

    public static String G(c0 c0Var) throws SubtitleDecoderException {
        char cG;
        C(c0Var.a() >= 2);
        int iM = c0Var.M();
        return iM == 0 ? "" : (c0Var.a() < 2 || !((cG = c0Var.g()) == 65279 || cG == 65534)) ? c0Var.E(iM, Charsets.UTF_8) : c0Var.E(iM, Charsets.UTF_16);
    }

    @Override // qc.d
    public f A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        this.f57292o.Q(bArr, i10);
        String strG = G(this.f57292o);
        if (strG.isEmpty()) {
            return b.f57299b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strG);
        E(spannableStringBuilder, this.f57294q, 0, 0, spannableStringBuilder.length(), 16711680);
        D(spannableStringBuilder, this.f57295r, -1, 0, spannableStringBuilder.length(), 16711680);
        F(spannableStringBuilder, this.f57296s, 0, spannableStringBuilder.length());
        float fS = this.f57297t;
        while (this.f57292o.a() >= 8) {
            int iE = this.f57292o.e();
            int iO = this.f57292o.o();
            int iO2 = this.f57292o.o();
            if (iO2 == 1937013100) {
                C(this.f57292o.a() >= 2);
                int iM = this.f57292o.M();
                for (int i11 = 0; i11 < iM; i11++) {
                    B(this.f57292o, spannableStringBuilder);
                }
            } else if (iO2 == 1952608120 && this.f57293p) {
                C(this.f57292o.a() >= 2);
                fS = u0.s(this.f57292o.M() / this.f57298u, 0.0f, 0.95f);
            }
            this.f57292o.S(iE + iO);
        }
        return new b(new b.c().z(spannableStringBuilder).t(fS, 0).u(0).a());
    }

    public final void B(c0 c0Var, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        int length;
        C(c0Var.a() >= 12);
        int iM = c0Var.M();
        int iM2 = c0Var.M();
        c0Var.T(2);
        int iG = c0Var.G();
        c0Var.T(1);
        int iO = c0Var.o();
        if (iM2 > spannableStringBuilder.length()) {
            t.n(f57287v, "Truncating styl end (" + iM2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            length = spannableStringBuilder.length();
        } else {
            length = iM2;
        }
        if (iM < length) {
            int i10 = length;
            E(spannableStringBuilder, iG, this.f57294q, iM, i10, 0);
            D(spannableStringBuilder, iO, this.f57295r, iM, i10, 0);
            return;
        }
        t.n(f57287v, "Ignoring styl with start (" + iM + ") >= end (" + length + ").");
    }
}
