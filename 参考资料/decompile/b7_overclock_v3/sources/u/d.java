package u;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import w.e0;
import w.h;
import w.o;
import w.v;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {
    public static final String R = "KeyCycle";
    public static final String S = "KeyCycle";
    public static final String T = "wavePeriod";
    public static final String U = "waveOffset";
    public static final String V = "wavePhase";
    public static final String W = "waveShape";
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f51755a0 = 3;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f51756b0 = 4;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f51757c0 = 5;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f51758d0 = 6;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f51759e0 = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f51760y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f51761z = 0;
    public int A = -1;
    public String B = null;
    public float C = Float.NaN;
    public float D = 0.0f;
    public float E = 0.0f;
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
    public float P = Float.NaN;
    public float Q = Float.NaN;

    public d() {
        this.f51751k = 4;
        this.f51752l = new HashMap<>();
    }

    @Override // u.b, w.w
    public boolean a(int i10, int i11) {
        if (i10 == 401) {
            this.f51761z = i11;
            return true;
        }
        if (i10 == 421) {
            this.A = i11;
            return true;
        }
        if (b(i10, i11)) {
            return true;
        }
        return super.a(i10, i11);
    }

    @Override // u.b, w.w
    public boolean b(int i10, float f10) {
        if (i10 == 315) {
            this.F = f10;
            return true;
        }
        if (i10 == 403) {
            this.G = f10;
            return true;
        }
        if (i10 == 416) {
            this.J = f10;
            return true;
        }
        switch (i10) {
            case 304:
                this.O = f10;
                return true;
            case 305:
                this.P = f10;
                return true;
            case 306:
                this.Q = f10;
                return true;
            case 307:
                this.H = f10;
                return true;
            case 308:
                this.K = f10;
                return true;
            case 309:
                this.L = f10;
                return true;
            case 310:
                this.I = f10;
                return true;
            case 311:
                this.M = f10;
                return true;
            case 312:
                this.N = f10;
                return true;
            default:
                switch (i10) {
                    case w.c.f53701u /* 423 */:
                        this.C = f10;
                        return true;
                    case w.c.f53702v /* 424 */:
                        this.D = f10;
                        return true;
                    case w.c.f53703w /* 425 */:
                        this.E = f10;
                        return true;
                    default:
                        return super.b(i10, f10);
                }
        }
    }

    @Override // u.b, w.w
    public boolean c(int i10, String str) {
        if (i10 == 420) {
            this.f51760y = str;
            return true;
        }
        if (i10 != 422) {
            return super.c(i10, str);
        }
        this.B = str;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    @Override // w.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int e(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.e(java.lang.String):int");
    }

    @Override // u.b
    public void f(HashMap<String, o> map) {
    }

    @Override // u.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return null;
    }

    @Override // u.b
    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.G)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("translationZ");
        }
        if (this.f51752l.size() > 0) {
            Iterator<String> it2 = this.f51752l.keySet().iterator();
            while (it2.hasNext()) {
                hashSet.add("CUSTOM," + it2.next());
            }
        }
    }

    public void v(HashMap<String, h> map) {
        h hVar;
        h hVar2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                t.a aVar = this.f51752l.get(str.substring(7));
                if (aVar != null && aVar.m() == 901 && (hVar = map.get(str)) != null) {
                    hVar.g(this.f51748h, this.A, this.B, -1, this.C, this.D, this.E, aVar.n(), aVar);
                }
            } else {
                float fX = x(str);
                if (!Float.isNaN(fX) && (hVar2 = map.get(str)) != null) {
                    hVar2.f(this.f51748h, this.A, this.B, -1, this.C, this.D, this.E, fX);
                }
            }
        }
    }

    public void w() {
        System.out.println("MotionKeyCycle{mWaveShape=" + this.A + ", mWavePeriod=" + this.C + ", mWaveOffset=" + this.D + ", mWavePhase=" + this.E + ", mRotation=" + this.I + '}');
    }

    public float x(String str) {
        str.hashCode();
        switch (str) {
            case "rotationX":
                return this.K;
            case "rotationY":
                return this.L;
            case "rotationZ":
                return this.I;
            case "translationX":
                return this.O;
            case "translationY":
                return this.P;
            case "translationZ":
                return this.Q;
            case "offset":
                return this.D;
            case "progress":
                return this.F;
            case "scaleX":
                return this.M;
            case "scaleY":
                return this.N;
            case "elevation":
                return this.H;
            case "alpha":
                return this.G;
            case "phase":
                return this.E;
            case "pathRotate":
                return this.J;
            default:
                return Float.NaN;
        }
    }

    public void y() {
        HashSet<String> hashSet = new HashSet<>();
        i(hashSet);
        e0.c(" ------------- " + this.f51748h + " -------------");
        e0.c("MotionKeyCycle{Shape=" + this.A + ", Period=" + this.C + ", Offset=" + this.D + ", Phase=" + this.E + '}');
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            v.a(strArr[i10]);
            e0.c(strArr[i10] + ":" + x(strArr[i10]));
        }
    }
}
