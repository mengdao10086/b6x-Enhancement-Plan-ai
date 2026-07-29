package zc;

import android.text.TextUtils;
import g.p0;
import hd.c0;
import hd.u0;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f58315c = "CssParser";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f58316d = "{";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f58317e = "}";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f58318f = "color";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f58319g = "background-color";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f58320h = "font-family";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f58321i = "font-weight";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f58322j = "ruby-position";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f58323k = "over";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f58324l = "under";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f58325m = "text-combine-upright";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f58326n = "all";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f58327o = "digits";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f58328p = "text-decoration";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f58329q = "bold";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f58330r = "underline";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f58331s = "font-style";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f58332t = "italic";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f58333u = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f58334a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f58335b = new StringBuilder();

    public static boolean b(c0 c0Var) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        if (iE + 2 > iF) {
            return false;
        }
        int i10 = iE + 1;
        if (bArrD[iE] != 47) {
            return false;
        }
        int i11 = i10 + 1;
        if (bArrD[i10] != 42) {
            return false;
        }
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= iF) {
                c0Var.T(iF - c0Var.e());
                return true;
            }
            if (((char) bArrD[i11]) == '*' && ((char) bArrD[i12]) == '/') {
                i11 = i12 + 1;
                iF = i11;
            } else {
                i11 = i12;
            }
        }
    }

    public static boolean c(c0 c0Var) {
        char cJ = j(c0Var, c0Var.e());
        if (cJ != '\t' && cJ != '\n' && cJ != '\f' && cJ != '\r' && cJ != ' ') {
            return false;
        }
        c0Var.T(1);
        return true;
    }

    public static String e(c0 c0Var, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF && !z10) {
            char c10 = (char) c0Var.d()[iE];
            if ((c10 < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '#' || c10 == '-' || c10 == '.' || c10 == '_'))) {
                z10 = true;
            } else {
                iE++;
                sb2.append(c10);
            }
        }
        c0Var.T(iE - c0Var.e());
        return sb2.toString();
    }

    @p0
    public static String f(c0 c0Var, StringBuilder sb2) {
        m(c0Var);
        if (c0Var.a() == 0) {
            return null;
        }
        String strE = e(c0Var, sb2);
        if (!"".equals(strE)) {
            return strE;
        }
        return "" + ((char) c0Var.G());
    }

    @p0
    public static String g(c0 c0Var, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z10 = false;
        while (!z10) {
            int iE = c0Var.e();
            String strF = f(c0Var, sb2);
            if (strF == null) {
                return null;
            }
            if (f58317e.equals(strF) || ";".equals(strF)) {
                c0Var.S(iE);
                z10 = true;
            } else {
                sb3.append(strF);
            }
        }
        return sb3.toString();
    }

    @p0
    public static String h(c0 c0Var, StringBuilder sb2) {
        m(c0Var);
        if (c0Var.a() < 5 || !"::cue".equals(c0Var.D(5))) {
            return null;
        }
        int iE = c0Var.e();
        String strF = f(c0Var, sb2);
        if (strF == null) {
            return null;
        }
        if (f58316d.equals(strF)) {
            c0Var.S(iE);
            return "";
        }
        String strK = ee.a.f26978c.equals(strF) ? k(c0Var) : null;
        if (ee.a.f26979d.equals(f(c0Var, sb2))) {
            return strK;
        }
        return null;
    }

    public static void i(c0 c0Var, d dVar, StringBuilder sb2) {
        m(c0Var);
        String strE = e(c0Var, sb2);
        if (!"".equals(strE) && ":".equals(f(c0Var, sb2))) {
            m(c0Var);
            String strG = g(c0Var, sb2);
            if (strG == null || "".equals(strG)) {
                return;
            }
            int iE = c0Var.e();
            String strF = f(c0Var, sb2);
            if (!";".equals(strF)) {
                if (!f58317e.equals(strF)) {
                    return;
                } else {
                    c0Var.S(iE);
                }
            }
            if ("color".equals(strE)) {
                dVar.q(hd.e.b(strG));
                return;
            }
            if (f58319g.equals(strE)) {
                dVar.n(hd.e.b(strG));
                return;
            }
            boolean z10 = true;
            if (f58322j.equals(strE)) {
                if (f58323k.equals(strG)) {
                    dVar.w(1);
                    return;
                } else {
                    if (f58324l.equals(strG)) {
                        dVar.w(2);
                        return;
                    }
                    return;
                }
            }
            if (f58325m.equals(strE)) {
                if (!"all".equals(strG) && !strG.startsWith(f58327o)) {
                    z10 = false;
                }
                dVar.p(z10);
                return;
            }
            if (f58328p.equals(strE)) {
                if ("underline".equals(strG)) {
                    dVar.B(true);
                }
            } else {
                if (f58320h.equals(strE)) {
                    dVar.r(strG);
                    return;
                }
                if (f58321i.equals(strE)) {
                    if ("bold".equals(strG)) {
                        dVar.o(true);
                    }
                } else if (f58331s.equals(strE) && "italic".equals(strG)) {
                    dVar.u(true);
                }
            }
        }
    }

    public static char j(c0 c0Var, int i10) {
        return (char) c0Var.d()[i10];
    }

    public static String k(c0 c0Var) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        boolean z10 = false;
        while (iE < iF && !z10) {
            int i10 = iE + 1;
            z10 = ((char) c0Var.d()[iE]) == ')';
            iE = i10;
        }
        return c0Var.D((iE - 1) - c0Var.e()).trim();
    }

    public static void l(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.q())) {
        }
    }

    public static void m(c0 c0Var) {
        while (true) {
            for (boolean z10 = true; c0Var.a() > 0 && z10; z10 = false) {
                if (c(c0Var) || b(c0Var)) {
                    break;
                }
            }
            return;
        }
    }

    public final void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f58333u.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                dVar.A((String) hd.a.g(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrN1 = u0.n1(str, "\\.");
        String str2 = strArrN1[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            dVar.z(str2.substring(0, iIndexOf2));
            dVar.y(str2.substring(iIndexOf2 + 1));
        } else {
            dVar.z(str2);
        }
        if (strArrN1.length > 1) {
            dVar.x((String[]) u0.W0(strArrN1, 1, strArrN1.length));
        }
    }

    public List<d> d(c0 c0Var) {
        this.f58335b.setLength(0);
        int iE = c0Var.e();
        l(c0Var);
        this.f58334a.Q(c0Var.d(), c0Var.e());
        this.f58334a.S(iE);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strH = h(this.f58334a, this.f58335b);
            if (strH == null || !f58316d.equals(f(this.f58334a, this.f58335b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, strH);
            String str = null;
            boolean z10 = false;
            while (!z10) {
                int iE2 = this.f58334a.e();
                String strF = f(this.f58334a, this.f58335b);
                boolean z11 = strF == null || f58317e.equals(strF);
                if (!z11) {
                    this.f58334a.S(iE2);
                    i(this.f58334a, dVar, this.f58335b);
                }
                str = strF;
                z10 = z11;
            }
            if (f58317e.equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
