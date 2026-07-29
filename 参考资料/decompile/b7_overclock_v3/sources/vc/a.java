package vc;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import g.p0;
import hd.c0;
import hd.t;
import hd.u0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qc.b;
import qc.f;
import vc.c;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends qc.d {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f52922t = "SsaDecoder";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f52923u = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f52924v = "Format:";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f52925w = "Style:";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f52926x = "Dialogue:";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f52927y = 0.05f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f52928o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public final b f52929p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, c> f52930q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f52931r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f52932s;

    public a() {
        this(null);
    }

    public static int B(long j10, List<Long> list, List<List<qc.b>> list2) {
        int i10;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i10 = 0;
                break;
            }
            if (list.get(size).longValue() == j10) {
                return size;
            }
            if (list.get(size).longValue() < j10) {
                i10 = size + 1;
                break;
            }
            size--;
        }
        list.add(i10, Long.valueOf(j10));
        list2.add(i10, i10 == 0 ? new ArrayList() : new ArrayList(list2.get(i10 - 1)));
        return i10;
    }

    public static float C(int i10) {
        if (i10 == 0) {
            return 0.05f;
        }
        if (i10 != 1) {
            return i10 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static qc.b D(String str, @p0 c cVar, c.b bVar, float f10, float f11) {
        SpannableString spannableString = new SpannableString(str);
        b.c cVarZ = new b.c().z(spannableString);
        if (cVar != null) {
            if (cVar.f52951c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f52951c.intValue()), 0, spannableString.length(), 33);
            }
            float f12 = cVar.f52952d;
            if (f12 != -3.4028235E38f && f11 != -3.4028235E38f) {
                cVarZ.B(f12 / f11, 1);
            }
            boolean z10 = cVar.f52953e;
            if (z10 && cVar.f52954f) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z10) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f52954f) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
        }
        int i10 = bVar.f52968a;
        if (i10 == -1) {
            i10 = cVar != null ? cVar.f52950b : -1;
        }
        cVarZ.A(M(i10)).w(L(i10)).u(K(i10));
        PointF pointF = bVar.f52969b;
        if (pointF == null || f11 == -3.4028235E38f || f10 == -3.4028235E38f) {
            cVarZ.v(C(cVarZ.i()));
            cVarZ.t(C(cVarZ.f()), 0);
        } else {
            cVarZ.v(pointF.x / f10);
            cVarZ.t(bVar.f52969b.y / f11, 0);
        }
        return cVarZ.a();
    }

    public static Map<String, c> I(c0 c0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVarA = null;
        while (true) {
            String strQ = c0Var.q();
            if (strQ == null || (c0Var.a() != 0 && c0Var.h() == 91)) {
                break;
            }
            if (strQ.startsWith(f52924v)) {
                aVarA = c.a.a(strQ);
            } else if (strQ.startsWith(f52925w)) {
                if (aVarA == null) {
                    t.n(f52922t, "Skipping 'Style:' line before 'Format:' line: " + strQ);
                } else {
                    c cVarB = c.b(strQ, aVarA);
                    if (cVarB != null) {
                        linkedHashMap.put(cVarB.f52949a, cVarB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long J(String str) {
        Matcher matcher = f52923u.matcher(str.trim());
        return !matcher.matches() ? g.f56663b : (Long.parseLong((String) u0.k(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) u0.k(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) u0.k(matcher.group(3))) * 1000000) + (Long.parseLong((String) u0.k(matcher.group(4))) * 10000);
    }

    public static int K(int i10) {
        switch (i10) {
            case -1:
                break;
            case 0:
            default:
                t.n(f52922t, "Unknown alignment: " + i10);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    public static int L(int i10) {
        switch (i10) {
            case -1:
                break;
            case 0:
            default:
                t.n(f52922t, "Unknown alignment: " + i10);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    @p0
    public static Layout.Alignment M(int i10) {
        switch (i10) {
            case -1:
                return null;
            case 0:
            default:
                t.n(f52922t, "Unknown alignment: " + i10);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // qc.d
    public f A(byte[] bArr, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c0 c0Var = new c0(bArr, i10);
        if (!this.f52928o) {
            G(c0Var);
        }
        F(c0Var, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }

    public final void E(String str, b bVar, List<List<qc.b>> list, List<Long> list2) {
        int i10;
        hd.a.a(str.startsWith(f52926x));
        String[] strArrSplit = str.substring(9).split(ag.c.f654g, bVar.f52937e);
        if (strArrSplit.length != bVar.f52937e) {
            t.n(f52922t, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long J = J(strArrSplit[bVar.f52933a]);
        if (J == g.f56663b) {
            t.n(f52922t, "Skipping invalid timing: " + str);
            return;
        }
        long J2 = J(strArrSplit[bVar.f52934b]);
        if (J2 == g.f56663b) {
            t.n(f52922t, "Skipping invalid timing: " + str);
            return;
        }
        Map<String, c> map = this.f52930q;
        c cVar = (map == null || (i10 = bVar.f52935c) == -1) ? null : map.get(strArrSplit[i10].trim());
        String str2 = strArrSplit[bVar.f52936d];
        qc.b bVarD = D(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f52931r, this.f52932s);
        int iB = B(J2, list2, list);
        for (int iB2 = B(J, list2, list); iB2 < iB; iB2++) {
            list.get(iB2).add(bVarD);
        }
    }

    public final void F(c0 c0Var, List<List<qc.b>> list, List<Long> list2) {
        b bVarA = this.f52928o ? this.f52929p : null;
        while (true) {
            String strQ = c0Var.q();
            if (strQ == null) {
                return;
            }
            if (strQ.startsWith(f52924v)) {
                bVarA = b.a(strQ);
            } else if (strQ.startsWith(f52926x)) {
                if (bVarA == null) {
                    t.n(f52922t, "Skipping dialogue line before complete format: " + strQ);
                } else {
                    E(strQ, bVarA, list, list2);
                }
            }
        }
    }

    public final void G(c0 c0Var) {
        while (true) {
            String strQ = c0Var.q();
            if (strQ == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strQ)) {
                H(c0Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strQ)) {
                this.f52930q = I(c0Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(strQ)) {
                t.i(f52922t, "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strQ)) {
                return;
            }
        }
    }

    public final void H(c0 c0Var) {
        while (true) {
            String strQ = c0Var.q();
            if (strQ == null) {
                return;
            }
            if (c0Var.a() != 0 && c0Var.h() == 91) {
                return;
            }
            String[] strArrSplit = strQ.split(":");
            if (strArrSplit.length == 2) {
                String strW1 = u0.w1(strArrSplit[0].trim());
                strW1.hashCode();
                if (strW1.equals("playresx")) {
                    this.f52931r = Float.parseFloat(strArrSplit[1].trim());
                } else if (strW1.equals("playresy")) {
                    try {
                        this.f52932s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    public a(@p0 List<byte[]> list) {
        super(f52922t);
        this.f52931r = -3.4028235E38f;
        this.f52932s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f52928o = false;
            this.f52929p = null;
            return;
        }
        this.f52928o = true;
        String strJ = u0.J(list.get(0));
        hd.a.a(strJ.startsWith(f52924v));
        this.f52929p = (b) hd.a.g(b.a(strJ));
        G(new c0(list.get(1)));
    }
}
