package kb;

import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import g.p0;
import hb.j;
import hd.c0;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends TagPayloadReader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f37150e = "onMetaData";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f37151f = "duration";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f37152g = "keyframes";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f37153h = "filepositions";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f37154i = "times";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f37155j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f37156k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f37157l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f37158m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f37159n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f37160o = 9;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f37161p = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f37162q = 11;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f37163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f37164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f37165d;

    public c() {
        super(new j());
        this.f37163b = g.f56663b;
        this.f37164c = new long[0];
        this.f37165d = new long[0];
    }

    public static Boolean h(c0 c0Var) {
        return Boolean.valueOf(c0Var.G() == 1);
    }

    @p0
    public static Object i(c0 c0Var, int i10) {
        if (i10 == 0) {
            return k(c0Var);
        }
        if (i10 == 1) {
            return h(c0Var);
        }
        if (i10 == 2) {
            return o(c0Var);
        }
        if (i10 == 3) {
            return m(c0Var);
        }
        if (i10 == 8) {
            return l(c0Var);
        }
        if (i10 == 10) {
            return n(c0Var);
        }
        if (i10 != 11) {
            return null;
        }
        return j(c0Var);
    }

    public static Date j(c0 c0Var) {
        Date date = new Date((long) k(c0Var).doubleValue());
        c0Var.T(2);
        return date;
    }

    public static Double k(c0 c0Var) {
        return Double.valueOf(Double.longBitsToDouble(c0Var.z()));
    }

    public static HashMap<String, Object> l(c0 c0Var) {
        int iK = c0Var.K();
        HashMap<String, Object> map = new HashMap<>(iK);
        for (int i10 = 0; i10 < iK; i10++) {
            String strO = o(c0Var);
            Object objI = i(c0Var, p(c0Var));
            if (objI != null) {
                map.put(strO, objI);
            }
        }
        return map;
    }

    public static HashMap<String, Object> m(c0 c0Var) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strO = o(c0Var);
            int iP = p(c0Var);
            if (iP == 9) {
                return map;
            }
            Object objI = i(c0Var, iP);
            if (objI != null) {
                map.put(strO, objI);
            }
        }
    }

    public static ArrayList<Object> n(c0 c0Var) {
        int iK = c0Var.K();
        ArrayList<Object> arrayList = new ArrayList<>(iK);
        for (int i10 = 0; i10 < iK; i10++) {
            Object objI = i(c0Var, p(c0Var));
            if (objI != null) {
                arrayList.add(objI);
            }
        }
        return arrayList;
    }

    public static String o(c0 c0Var) {
        int iM = c0Var.M();
        int iE = c0Var.e();
        c0Var.T(iM);
        return new String(c0Var.d(), iE, iM);
    }

    public static int p(c0 c0Var) {
        return c0Var.G();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j10) {
        if (p(c0Var) != 2 || !f37150e.equals(o(c0Var)) || p(c0Var) != 8) {
            return false;
        }
        HashMap<String, Object> mapL = l(c0Var);
        Object obj = mapL.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f37163b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapL.get(f37152g);
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(f37153h);
            Object obj4 = map.get(f37154i);
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f37164c = new long[size];
                this.f37165d = new long[size];
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj5 = list.get(i10);
                    Object obj6 = list2.get(i10);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f37164c = new long[0];
                        this.f37165d = new long[0];
                        break;
                    }
                    this.f37164c[i10] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f37165d[i10] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void d() {
    }

    public long e() {
        return this.f37163b;
    }

    public long[] f() {
        return this.f37165d;
    }

    public long[] g() {
        return this.f37164c;
    }
}
