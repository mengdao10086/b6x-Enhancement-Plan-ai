package t;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import w.e0;
import w.m;
import w.o;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Comparable<c> {
    public static final String D = "MotionPaths";
    public static final int K0 = 1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f50570k0 = false;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f50571k1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static String[] f50572v1 = {CommonNetImpl.POSITION, "x", "y", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50575c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public w.d f50588p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f50590r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f50591s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f50592t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f50593u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f50594v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f50573a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50574b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50576d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f50577e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f50578f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f50579g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f50580h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f50581i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f50582j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f50583k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f50584l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f50585m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f50586n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f50587o = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f50589q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f50595w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f50596x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f50597y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinkedHashMap<String, a> f50598z = new LinkedHashMap<>();
    public int A = 0;
    public double[] B = new double[18];
    public double[] C = new double[18];

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void c(HashMap<String, o> map, int i10) {
        for (String str : map.keySet()) {
            o oVar = map.get(str);
            str.hashCode();
            byte b10 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b10 = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b10 = 1;
                    }
                    break;
                case -1249320804:
                    if (str.equals("rotationZ")) {
                        b10 = 2;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b10 = 3;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b10 = 4;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b10 = 5;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b10 = 6;
                    }
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        b10 = 7;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        b10 = 8;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b10 = 9;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b10 = 10;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b10 = 11;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        b10 = 12;
                    }
                    break;
            }
            switch (b10) {
                case 0:
                    oVar.g(i10, Float.isNaN(this.f50579g) ? 0.0f : this.f50579g);
                    break;
                case 1:
                    oVar.g(i10, Float.isNaN(this.f50580h) ? 0.0f : this.f50580h);
                    break;
                case 2:
                    oVar.g(i10, Float.isNaN(this.f50578f) ? 0.0f : this.f50578f);
                    break;
                case 3:
                    oVar.g(i10, Float.isNaN(this.f50585m) ? 0.0f : this.f50585m);
                    break;
                case 4:
                    oVar.g(i10, Float.isNaN(this.f50586n) ? 0.0f : this.f50586n);
                    break;
                case 5:
                    oVar.g(i10, Float.isNaN(this.f50587o) ? 0.0f : this.f50587o);
                    break;
                case 6:
                    oVar.g(i10, Float.isNaN(this.f50596x) ? 0.0f : this.f50596x);
                    break;
                case 7:
                    oVar.g(i10, Float.isNaN(this.f50583k) ? 0.0f : this.f50583k);
                    break;
                case 8:
                    oVar.g(i10, Float.isNaN(this.f50584l) ? 0.0f : this.f50584l);
                    break;
                case 9:
                    oVar.g(i10, Float.isNaN(this.f50581i) ? 1.0f : this.f50581i);
                    break;
                case 10:
                    oVar.g(i10, Float.isNaN(this.f50582j) ? 1.0f : this.f50582j);
                    break;
                case 11:
                    oVar.g(i10, Float.isNaN(this.f50573a) ? 1.0f : this.f50573a);
                    break;
                case 12:
                    oVar.g(i10, Float.isNaN(this.f50595w) ? 0.0f : this.f50595w);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(ag.c.f654g)[1];
                        if (this.f50598z.containsKey(str2)) {
                            a aVar = this.f50598z.get(str2);
                            if (oVar instanceof o.c) {
                                ((o.c) oVar).k(i10, aVar);
                            } else {
                                e0.f("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i10 + ", value" + aVar.n() + oVar);
                            }
                        }
                    } else {
                        e0.f("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void d(e eVar) {
        this.f50575c = eVar.B();
        this.f50573a = eVar.B() != 4 ? 0.0f : eVar.g();
        this.f50576d = false;
        this.f50578f = eVar.t();
        this.f50579g = eVar.r();
        this.f50580h = eVar.s();
        this.f50581i = eVar.u();
        this.f50582j = eVar.v();
        this.f50583k = eVar.o();
        this.f50584l = eVar.p();
        this.f50585m = eVar.x();
        this.f50586n = eVar.y();
        this.f50587o = eVar.z();
        for (String str : eVar.j()) {
            a aVarI = eVar.i(str);
            if (aVarI != null && aVarI.q()) {
                this.f50598z.put(str, aVarI);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return Float.compare(this.f50590r, cVar.f50590r);
    }

    public final boolean f(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    public void g(c cVar, HashSet<String> hashSet) {
        if (f(this.f50573a, cVar.f50573a)) {
            hashSet.add("alpha");
        }
        if (f(this.f50577e, cVar.f50577e)) {
            hashSet.add("translationZ");
        }
        int i10 = this.f50575c;
        int i11 = cVar.f50575c;
        if (i10 != i11 && this.f50574b == 0 && (i10 == 4 || i11 == 4)) {
            hashSet.add("alpha");
        }
        if (f(this.f50578f, cVar.f50578f)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f50595w) || !Float.isNaN(cVar.f50595w)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f50596x) || !Float.isNaN(cVar.f50596x)) {
            hashSet.add("progress");
        }
        if (f(this.f50579g, cVar.f50579g)) {
            hashSet.add("rotationX");
        }
        if (f(this.f50580h, cVar.f50580h)) {
            hashSet.add("rotationY");
        }
        if (f(this.f50583k, cVar.f50583k)) {
            hashSet.add("pivotX");
        }
        if (f(this.f50584l, cVar.f50584l)) {
            hashSet.add("pivotY");
        }
        if (f(this.f50581i, cVar.f50581i)) {
            hashSet.add("scaleX");
        }
        if (f(this.f50582j, cVar.f50582j)) {
            hashSet.add("scaleY");
        }
        if (f(this.f50585m, cVar.f50585m)) {
            hashSet.add("translationX");
        }
        if (f(this.f50586n, cVar.f50586n)) {
            hashSet.add("translationY");
        }
        if (f(this.f50587o, cVar.f50587o)) {
            hashSet.add("translationZ");
        }
        if (f(this.f50577e, cVar.f50577e)) {
            hashSet.add("elevation");
        }
    }

    public void h(c cVar, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | f(this.f50590r, cVar.f50590r);
        zArr[1] = zArr[1] | f(this.f50591s, cVar.f50591s);
        zArr[2] = zArr[2] | f(this.f50592t, cVar.f50592t);
        zArr[3] = zArr[3] | f(this.f50593u, cVar.f50593u);
        zArr[4] = f(this.f50594v, cVar.f50594v) | zArr[4];
    }

    public void i(double[] dArr, int[] iArr) {
        float[] fArr = {this.f50590r, this.f50591s, this.f50592t, this.f50593u, this.f50594v, this.f50573a, this.f50577e, this.f50578f, this.f50579g, this.f50580h, this.f50581i, this.f50582j, this.f50583k, this.f50584l, this.f50585m, this.f50586n, this.f50587o, this.f50595w};
        int i10 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] < 18) {
                dArr[i10] = fArr[iArr[i11]];
                i10++;
            }
        }
    }

    public int j(String str, double[] dArr, int i10) {
        a aVar = this.f50598z.get(str);
        if (aVar.r() == 1) {
            dArr[i10] = aVar.n();
            return 1;
        }
        int iR = aVar.r();
        aVar.o(new float[iR]);
        int i11 = 0;
        while (i11 < iR) {
            dArr[i10] = r1[i11];
            i11++;
            i10++;
        }
        return iR;
    }

    public int k(String str) {
        return this.f50598z.get(str).r();
    }

    public boolean l(String str) {
        return this.f50598z.containsKey(str);
    }

    public void m(float f10, float f11, float f12, float f13) {
        this.f50591s = f10;
        this.f50592t = f11;
        this.f50593u = f12;
        this.f50594v = f13;
    }

    public void n(e eVar) {
        m(eVar.E(), eVar.F(), eVar.D(), eVar.k());
        d(eVar);
    }

    public void o(m mVar, e eVar, int i10, float f10) {
        m(mVar.f53540b, mVar.f53542d, mVar.b(), mVar.a());
        d(eVar);
        this.f50583k = Float.NaN;
        this.f50584l = Float.NaN;
        if (i10 == 1) {
            this.f50578f = f10 - 90.0f;
        } else {
            if (i10 != 2) {
                return;
            }
            this.f50578f = f10 + 90.0f;
        }
    }
}
