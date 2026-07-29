package u;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import w.v;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    public static final String P = "KeyAttribute";
    public static final String Q = "KeyAttributes";
    public static final boolean R = false;
    public static final int S = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f51753y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f51754z = -1;
    public int A = 0;
    public float B = Float.NaN;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public float E = Float.NaN;
    public float F = Float.NaN;
    public float G = Float.NaN;
    public float H = Float.NaN;
    public float I = Float.NaN;
    public float J = Float.NaN;
    public float K = Float.NaN;
    public float L = Float.NaN;
    public float M = Float.NaN;
    public float N = Float.NaN;
    public float O = Float.NaN;

    public c() {
        this.f51751k = 1;
        this.f51752l = new HashMap<>();
    }

    @Override // u.b, w.w
    public boolean a(int i10, int i11) {
        if (i10 == 100) {
            this.f51748h = i11;
            return true;
        }
        if (i10 == 301) {
            this.f51754z = i11;
            return true;
        }
        if (i10 == 302) {
            this.A = i11;
            return true;
        }
        if (a(i10, i11)) {
            return true;
        }
        return super.a(i10, i11);
    }

    @Override // u.b, w.w
    public boolean b(int i10, float f10) {
        if (i10 == 100) {
            this.I = f10;
            return true;
        }
        switch (i10) {
            case 303:
                this.B = f10;
                return true;
            case 304:
                this.L = f10;
                return true;
            case 305:
                this.M = f10;
                return true;
            case 306:
                this.N = f10;
                return true;
            case 307:
                this.C = f10;
                return true;
            case 308:
                this.E = f10;
                return true;
            case 309:
                this.F = f10;
                return true;
            case 310:
                this.D = f10;
                return true;
            case 311:
                this.J = f10;
                return true;
            case 312:
                this.K = f10;
                return true;
            case 313:
                this.G = f10;
                return true;
            case 314:
                this.H = f10;
                return true;
            case 315:
                this.O = f10;
                return true;
            case w.a.f53655q /* 316 */:
                this.I = f10;
                return true;
            default:
                return super.b(i10, f10);
        }
    }

    @Override // u.b, w.w
    public boolean c(int i10, String str) {
        if (i10 == 101) {
            this.f51750j = str;
            return true;
        }
        if (i10 != 317) {
            return super.c(i10, str);
        }
        this.f51753y = str;
        return true;
    }

    @Override // w.w
    public int e(String str) {
        return v.a(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // u.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.util.HashMap<java.lang.String, w.o> r7) {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.c.f(java.util.HashMap):void");
    }

    @Override // u.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return null;
    }

    @Override // u.b
    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.B)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.C)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.D)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("pivotY");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("progress");
        }
        if (this.f51752l.size() > 0) {
            Iterator<String> it2 = this.f51752l.keySet().iterator();
            while (it2.hasNext()) {
                hashSet.add("CUSTOM," + it2.next());
            }
        }
    }

    @Override // u.b
    public void q(HashMap<String, Integer> map) {
        if (!Float.isNaN(this.B)) {
            map.put("alpha", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.C)) {
            map.put("elevation", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.D)) {
            map.put("rotationZ", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.E)) {
            map.put("rotationX", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.F)) {
            map.put("rotationY", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.G)) {
            map.put("pivotX", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.H)) {
            map.put("pivotY", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.L)) {
            map.put("translationX", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.M)) {
            map.put("translationY", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.N)) {
            map.put("translationZ", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.I)) {
            map.put("pathRotate", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.J)) {
            map.put("scaleX", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.K)) {
            map.put("scaleY", Integer.valueOf(this.f51754z));
        }
        if (!Float.isNaN(this.O)) {
            map.put("progress", Integer.valueOf(this.f51754z));
        }
        if (this.f51752l.size() > 0) {
            Iterator<String> it2 = this.f51752l.keySet().iterator();
            while (it2.hasNext()) {
                map.put("CUSTOM," + it2.next(), Integer.valueOf(this.f51754z));
            }
        }
    }

    public int v() {
        return this.f51754z;
    }

    public final float w(int i10) {
        if (i10 == 100) {
            return this.f51748h;
        }
        switch (i10) {
            case 303:
                return this.B;
            case 304:
                return this.L;
            case 305:
                return this.M;
            case 306:
                return this.N;
            case 307:
                return this.C;
            case 308:
                return this.E;
            case 309:
                return this.F;
            case 310:
                return this.D;
            case 311:
                return this.J;
            case 312:
                return this.K;
            case 313:
                return this.G;
            case 314:
                return this.H;
            case 315:
                return this.O;
            case w.a.f53655q /* 316 */:
                return this.I;
            default:
                return Float.NaN;
        }
    }

    public void x() {
        HashSet<String> hashSet = new HashSet<>();
        i(hashSet);
        System.out.println(" ------------- " + this.f51748h + " -------------");
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            int iA = v.a(strArr[i10]);
            System.out.println(strArr[i10] + ":" + w(iA));
        }
    }
}
