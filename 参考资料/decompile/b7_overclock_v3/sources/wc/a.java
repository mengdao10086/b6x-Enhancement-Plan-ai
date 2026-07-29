package wc;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import hd.c0;
import hd.t;
import hd.u;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qc.d;
import qc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    public static final String A = "{\\an3}";
    public static final String B = "{\\an4}";
    public static final String C = "{\\an5}";
    public static final String D = "{\\an6}";
    public static final String E = "{\\an7}";
    public static final String F = "{\\an8}";
    public static final String G = "{\\an9}";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f54623q = 0.08f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f54624r = 0.92f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f54625s = 0.5f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f54626t = "SubripDecoder";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f54627u = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f54628v = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f54629w = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f54630x = "\\{\\\\an[1-9]\\}";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f54631y = "{\\an1}";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f54632z = "{\\an2}";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final StringBuilder f54633o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<String> f54634p;

    public a() {
        super(f54626t);
        this.f54633o = new StringBuilder();
        this.f54634p = new ArrayList<>();
    }

    public static float C(int i10) {
        if (i10 == 0) {
            return 0.08f;
        }
        if (i10 == 1) {
            return 0.5f;
        }
        if (i10 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long D(Matcher matcher, int i10) {
        String strGroup = matcher.group(i10 + 1);
        long j10 = (strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) hd.a.g(matcher.group(i10 + 2))) * 60 * 1000) + (Long.parseLong((String) hd.a.g(matcher.group(i10 + 3))) * 1000);
        String strGroup2 = matcher.group(i10 + 4);
        if (strGroup2 != null) {
            j10 += Long.parseLong(strGroup2);
        }
        return j10 * 1000;
    }

    @Override // qc.d
    public f A(byte[] bArr, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        u uVar = new u();
        c0 c0Var = new c0(bArr, i10);
        while (true) {
            String strQ = c0Var.q();
            int i11 = 0;
            if (strQ == null) {
                break;
            }
            if (strQ.length() != 0) {
                try {
                    Integer.parseInt(strQ);
                    String strQ2 = c0Var.q();
                    if (strQ2 == null) {
                        t.n(f54626t, "Unexpected end");
                        break;
                    }
                    Matcher matcher = f54628v.matcher(strQ2);
                    if (matcher.matches()) {
                        uVar.a(D(matcher, 1));
                        uVar.a(D(matcher, 6));
                        this.f54633o.setLength(0);
                        this.f54634p.clear();
                        for (String strQ3 = c0Var.q(); !TextUtils.isEmpty(strQ3); strQ3 = c0Var.q()) {
                            if (this.f54633o.length() > 0) {
                                this.f54633o.append("<br>");
                            }
                            this.f54633o.append(E(strQ3, this.f54634p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f54633o.toString());
                        String str = null;
                        while (true) {
                            if (i11 >= this.f54634p.size()) {
                                break;
                            }
                            String str2 = this.f54634p.get(i11);
                            if (str2.matches(f54630x)) {
                                str = str2;
                                break;
                            }
                            i11++;
                        }
                        arrayList.add(B(spannedFromHtml, str));
                        arrayList.add(qc.b.f47222q);
                    } else {
                        t.n(f54626t, "Skipping invalid timing: " + strQ2);
                    }
                } catch (NumberFormatException unused) {
                    t.n(f54626t, "Skipping invalid index: " + strQ);
                }
            }
        }
        return new b((qc.b[]) arrayList.toArray(new qc.b[0]), uVar.d());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final qc.b B(android.text.Spanned r17, @g.p0 java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wc.a.B(android.text.Spanned, java.lang.String):qc.b");
    }

    public final String E(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb2 = new StringBuilder(strTrim);
        Matcher matcher = f54629w.matcher(strTrim);
        int i10 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i10;
            int length = strGroup.length();
            sb2.replace(iStart, iStart + length, "");
            i10 += length;
        }
        return sb2.toString();
    }
}
