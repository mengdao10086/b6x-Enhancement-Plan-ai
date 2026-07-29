package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.n;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.blankj.utilcode.util.i0;
import java.util.HashMap;
import java.util.Set;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f3175u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static float f3176v = Float.NaN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidget f3177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, t.a> f3195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f3196t;

    public o() {
        this.f3177a = null;
        this.f3178b = 0;
        this.f3179c = 0;
        this.f3180d = 0;
        this.f3181e = 0;
        this.f3182f = Float.NaN;
        this.f3183g = Float.NaN;
        this.f3184h = Float.NaN;
        this.f3185i = Float.NaN;
        this.f3186j = Float.NaN;
        this.f3187k = Float.NaN;
        this.f3188l = Float.NaN;
        this.f3189m = Float.NaN;
        this.f3190n = Float.NaN;
        this.f3191o = Float.NaN;
        this.f3192p = Float.NaN;
        this.f3193q = Float.NaN;
        this.f3194r = 0;
        this.f3195s = new HashMap<>();
        this.f3196t = null;
    }

    public static void a(StringBuilder sb2, String str, float f10) {
        if (Float.isNaN(f10)) {
            return;
        }
        sb2.append(str);
        sb2.append(": ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    public static void b(StringBuilder sb2, String str, int i10) {
        sb2.append(str);
        sb2.append(": ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    public static float m(float f10, float f11, float f12, float f13) {
        boolean zIsNaN = Float.isNaN(f10);
        boolean zIsNaN2 = Float.isNaN(f11);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f10 = f12;
        }
        if (zIsNaN2) {
            f11 = f12;
        }
        return f10 + (f13 * (f11 - f10));
    }

    public static void n(int i10, int i11, o oVar, o oVar2, o oVar3, n nVar, float f10) {
        int i12;
        float f11;
        int i13;
        float f12;
        float f13;
        int i14;
        float f14;
        int i15;
        int i16;
        int i17;
        int i18;
        float f15 = 100.0f * f10;
        int i19 = (int) f15;
        int i20 = oVar2.f3178b;
        int i21 = oVar2.f3179c;
        int i22 = oVar3.f3178b;
        int i23 = oVar3.f3179c;
        int i24 = oVar2.f3180d - i20;
        int i25 = oVar2.f3181e - i21;
        int i26 = oVar3.f3180d - i22;
        int i27 = oVar3.f3181e - i23;
        float f16 = oVar2.f3192p;
        float f17 = oVar3.f3192p;
        if (oVar2.f3194r == 8) {
            i20 = (int) (i20 - (i26 / 2.0f));
            i21 = (int) (i21 - (i27 / 2.0f));
            if (Float.isNaN(f16)) {
                i13 = i27;
                i12 = i26;
                f11 = 0.0f;
            } else {
                f11 = f16;
                i12 = i26;
                i13 = i27;
            }
        } else {
            i12 = i24;
            f11 = f16;
            i13 = i25;
        }
        if (oVar3.f3194r == 8) {
            i22 = (int) (i22 - (i12 / 2.0f));
            i23 = (int) (i23 - (i13 / 2.0f));
            i26 = i12;
            i27 = i13;
            if (Float.isNaN(f17)) {
                f17 = 0.0f;
            }
        }
        if (Float.isNaN(f11) && !Float.isNaN(f17)) {
            f11 = 1.0f;
        }
        if (!Float.isNaN(f11) && Float.isNaN(f17)) {
            f17 = 1.0f;
        }
        if (oVar2.f3194r == 4) {
            f13 = f17;
            f12 = 0.0f;
        } else {
            f12 = f11;
            f13 = f17;
        }
        float f18 = oVar3.f3194r == 4 ? 0.0f : f13;
        if (oVar.f3177a == null || !nVar.N()) {
            i14 = i20;
            f14 = f10;
        } else {
            n.a aVarX = nVar.x(oVar.f3177a.f3263o, i19);
            i14 = i20;
            n.a aVarW = nVar.w(oVar.f3177a.f3263o, i19);
            if (aVarX == aVarW) {
                aVarW = null;
            }
            if (aVarX != null) {
                i14 = (int) (aVarX.f3163d * i10);
                i16 = i11;
                i21 = (int) (aVarX.f3164e * i16);
                i17 = aVarX.f3160a;
                i15 = i10;
            } else {
                i15 = i10;
                i16 = i11;
                i17 = 0;
            }
            if (aVarW != null) {
                i22 = (int) (aVarW.f3163d * i15);
                i23 = (int) (aVarW.f3164e * i16);
                i18 = aVarW.f3160a;
            } else {
                i18 = 100;
            }
            f14 = (f15 - i17) / (i18 - i17);
        }
        oVar.f3177a = oVar2.f3177a;
        int i28 = (int) (i14 + ((i22 - r9) * f14));
        oVar.f3178b = i28;
        int i29 = (int) (i21 + (f14 * (i23 - i21)));
        oVar.f3179c = i29;
        float f19 = 1.0f - f10;
        oVar.f3180d = i28 + ((int) ((i12 * f19) + (i26 * f10)));
        oVar.f3181e = i29 + ((int) ((f19 * i13) + (i27 * f10)));
        oVar.f3182f = m(oVar2.f3182f, oVar3.f3182f, 0.5f, f10);
        oVar.f3183g = m(oVar2.f3183g, oVar3.f3183g, 0.5f, f10);
        oVar.f3184h = m(oVar2.f3184h, oVar3.f3184h, 0.0f, f10);
        oVar.f3185i = m(oVar2.f3185i, oVar3.f3185i, 0.0f, f10);
        oVar.f3186j = m(oVar2.f3186j, oVar3.f3186j, 0.0f, f10);
        oVar.f3190n = m(oVar2.f3190n, oVar3.f3190n, 1.0f, f10);
        oVar.f3191o = m(oVar2.f3191o, oVar3.f3191o, 1.0f, f10);
        oVar.f3187k = m(oVar2.f3187k, oVar3.f3187k, 0.0f, f10);
        oVar.f3188l = m(oVar2.f3188l, oVar3.f3188l, 0.0f, f10);
        oVar.f3189m = m(oVar2.f3189m, oVar3.f3189m, 0.0f, f10);
        oVar.f3192p = m(f12, f18, 1.0f, f10);
        Set<String> setKeySet = oVar3.f3195s.keySet();
        oVar.f3195s.clear();
        for (String str : setKeySet) {
            if (oVar2.f3195s.containsKey(str)) {
                t.a aVar = oVar2.f3195s.get(str);
                t.a aVar2 = oVar3.f3195s.get(str);
                t.a aVar3 = new t.a(aVar);
                oVar.f3195s.put(str, aVar3);
                if (aVar.r() == 1) {
                    aVar3.y(Float.valueOf(m(aVar.n(), aVar2.n(), 0.0f, f10)));
                } else {
                    int iR = aVar.r();
                    float[] fArr = new float[iR];
                    float[] fArr2 = new float[iR];
                    aVar.o(fArr);
                    aVar2.o(fArr2);
                    for (int i30 = 0; i30 < iR; i30++) {
                        fArr[i30] = m(fArr[i30], fArr2[i30], 0.0f, f10);
                        aVar3.z(fArr);
                    }
                }
            }
        }
    }

    public boolean A(String str, androidx.constraintlayout.core.parser.c cVar) throws CLParsingException {
        str.hashCode();
        switch (str) {
            case "phone_orientation":
                f3176v = cVar.g();
                return true;
            case "bottom":
                this.f3181e = cVar.i();
                return true;
            case "custom":
                q(cVar);
                return true;
            case "rotationX":
                this.f3184h = cVar.g();
                return true;
            case "rotationY":
                this.f3185i = cVar.g();
                return true;
            case "rotationZ":
                this.f3186j = cVar.g();
                return true;
            case "translationX":
                this.f3187k = cVar.g();
                return true;
            case "translationY":
                this.f3188l = cVar.g();
                return true;
            case "translationZ":
                this.f3189m = cVar.g();
                return true;
            case "pivotX":
                this.f3182f = cVar.g();
                return true;
            case "pivotY":
                this.f3183g = cVar.g();
                return true;
            case "scaleX":
                this.f3190n = cVar.g();
                return true;
            case "scaleY":
                this.f3191o = cVar.g();
                return true;
            case "top":
                this.f3179c = cVar.i();
                return true;
            case "left":
                this.f3178b = cVar.i();
                return true;
            case "alpha":
                this.f3192p = cVar.g();
                return true;
            case "right":
                this.f3180d = cVar.i();
                return true;
            case "interpolatedPos":
                this.f3193q = cVar.g();
                return true;
            default:
                return false;
        }
    }

    public o B() {
        ConstraintWidget constraintWidget = this.f3177a;
        if (constraintWidget != null) {
            this.f3178b = constraintWidget.L();
            this.f3179c = this.f3177a.e0();
            this.f3180d = this.f3177a.X();
            this.f3181e = this.f3177a.v();
            D(this.f3177a.f3261n);
        }
        return this;
    }

    public o C(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.f3177a = constraintWidget;
        B();
        return this;
    }

    public void D(o oVar) {
        this.f3182f = oVar.f3182f;
        this.f3183g = oVar.f3183g;
        this.f3184h = oVar.f3184h;
        this.f3185i = oVar.f3185i;
        this.f3186j = oVar.f3186j;
        this.f3187k = oVar.f3187k;
        this.f3188l = oVar.f3188l;
        this.f3189m = oVar.f3189m;
        this.f3190n = oVar.f3190n;
        this.f3191o = oVar.f3191o;
        this.f3192p = oVar.f3192p;
        this.f3194r = oVar.f3194r;
        this.f3195s.clear();
        for (t.a aVar : oVar.f3195s.values()) {
            this.f3195s.put(aVar.k(), aVar.d());
        }
    }

    public int E() {
        return Math.max(0, this.f3180d - this.f3178b);
    }

    public void c(String str, int i10) {
        w(str, 902, i10);
    }

    public void d(String str, float f10) {
        v(str, 901, f10);
    }

    public float e() {
        return this.f3178b + ((this.f3180d - r0) / 2.0f);
    }

    public float f() {
        return this.f3179c + ((this.f3181e - r0) / 2.0f);
    }

    public t.a g(String str) {
        return this.f3195s.get(str);
    }

    public Set<String> h() {
        return this.f3195s.keySet();
    }

    public int i(String str) {
        if (this.f3195s.containsKey(str)) {
            return this.f3195s.get(str).g();
        }
        return -21880;
    }

    public float j(String str) {
        if (this.f3195s.containsKey(str)) {
            return this.f3195s.get(str).h();
        }
        return Float.NaN;
    }

    public String k() {
        ConstraintWidget constraintWidget = this.f3177a;
        return constraintWidget == null ? "unknown" : constraintWidget.f3263o;
    }

    public int l() {
        return Math.max(0, this.f3181e - this.f3179c);
    }

    public boolean o() {
        return Float.isNaN(this.f3184h) && Float.isNaN(this.f3185i) && Float.isNaN(this.f3186j) && Float.isNaN(this.f3187k) && Float.isNaN(this.f3188l) && Float.isNaN(this.f3189m) && Float.isNaN(this.f3190n) && Float.isNaN(this.f3191o) && Float.isNaN(this.f3192p);
    }

    public void p(String str) {
        String str2;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str3 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + i0.f11861z + (hashCode() % 1000);
        if (this.f3177a != null) {
            str2 = str3 + fh.a.f28350w + (this.f3177a.hashCode() % 1000);
        } else {
            str2 = str3 + "/NULL";
        }
        System.out.println(str2 + i0.f11861z + str);
    }

    public void q(androidx.constraintlayout.core.parser.c cVar) throws CLParsingException {
        androidx.constraintlayout.core.parser.f fVar = (androidx.constraintlayout.core.parser.f) cVar;
        int size = fVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            androidx.constraintlayout.core.parser.d dVar = (androidx.constraintlayout.core.parser.d) fVar.z(i10);
            dVar.b();
            androidx.constraintlayout.core.parser.c cVarB0 = dVar.b0();
            String strB = cVarB0.b();
            if (strB.matches("#[0-9a-fA-F]+")) {
                w(dVar.b(), 902, Integer.parseInt(strB.substring(1), 16));
            } else if (cVarB0 instanceof androidx.constraintlayout.core.parser.e) {
                v(dVar.b(), 901, cVarB0.g());
            } else {
                x(dVar.b(), w.b.f53677m, strB);
            }
        }
    }

    public void r() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + i0.f11861z + (hashCode() % 1000);
        String str2 = this.f3177a != null ? str + fh.a.f28350w + (this.f3177a.hashCode() % 1000) + i0.f11861z : str + "/NULL ";
        HashMap<String, t.a> map = this.f3195s;
        if (map != null) {
            for (String str3 : map.keySet()) {
                System.out.println(str2 + this.f3195s.get(str3).toString());
            }
        }
    }

    public StringBuilder s(StringBuilder sb2) {
        return t(sb2, false);
    }

    public StringBuilder t(StringBuilder sb2, boolean z10) {
        sb2.append("{\n");
        b(sb2, xc.d.f55080k0, this.f3178b);
        b(sb2, "top", this.f3179c);
        b(sb2, xc.d.f55082m0, this.f3180d);
        b(sb2, "bottom", this.f3181e);
        a(sb2, "pivotX", this.f3182f);
        a(sb2, "pivotY", this.f3183g);
        a(sb2, "rotationX", this.f3184h);
        a(sb2, "rotationY", this.f3185i);
        a(sb2, "rotationZ", this.f3186j);
        a(sb2, "translationX", this.f3187k);
        a(sb2, "translationY", this.f3188l);
        a(sb2, "translationZ", this.f3189m);
        a(sb2, "scaleX", this.f3190n);
        a(sb2, "scaleY", this.f3191o);
        a(sb2, "alpha", this.f3192p);
        b(sb2, "visibility", this.f3194r);
        a(sb2, "interpolatedPos", this.f3193q);
        if (this.f3177a != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                u(sb2, type);
            }
        }
        if (z10) {
            a(sb2, "phone_orientation", f3176v);
        }
        if (z10) {
            a(sb2, "phone_orientation", f3176v);
        }
        if (this.f3195s.size() != 0) {
            sb2.append("custom : {\n");
            for (String str : this.f3195s.keySet()) {
                t.a aVar = this.f3195s.get(str);
                sb2.append(str);
                sb2.append(": ");
                switch (aVar.m()) {
                    case 900:
                        sb2.append(aVar.i());
                        sb2.append(",\n");
                        break;
                    case 901:
                    case w.b.f53679o /* 905 */:
                        sb2.append(aVar.h());
                        sb2.append(",\n");
                        break;
                    case 902:
                        sb2.append("'");
                        sb2.append(t.a.c(aVar.i()));
                        sb2.append("',\n");
                        break;
                    case w.b.f53677m /* 903 */:
                        sb2.append("'");
                        sb2.append(aVar.l());
                        sb2.append("',\n");
                        break;
                    case w.b.f53678n /* 904 */:
                        sb2.append("'");
                        sb2.append(aVar.f());
                        sb2.append("',\n");
                        break;
                }
            }
            sb2.append("}\n");
        }
        sb2.append("}\n");
        return sb2;
    }

    public final void u(StringBuilder sb2, ConstraintAnchor.Type type) {
        ConstraintAnchor constraintAnchorR = this.f3177a.r(type);
        if (constraintAnchorR == null || constraintAnchorR.f3204f == null) {
            return;
        }
        sb2.append("Anchor");
        sb2.append(type.name());
        sb2.append(": ['");
        String str = constraintAnchorR.f3204f.i().f3263o;
        if (str == null) {
            str = "#PARENT";
        }
        sb2.append(str);
        sb2.append("', '");
        sb2.append(constraintAnchorR.f3204f.l().name());
        sb2.append("', '");
        sb2.append(constraintAnchorR.f3205g);
        sb2.append("'],\n");
    }

    public void v(String str, int i10, float f10) {
        if (this.f3195s.containsKey(str)) {
            this.f3195s.get(str).u(f10);
        } else {
            this.f3195s.put(str, new t.a(str, i10, f10));
        }
    }

    public void w(String str, int i10, int i11) {
        if (this.f3195s.containsKey(str)) {
            this.f3195s.get(str).v(i11);
        } else {
            this.f3195s.put(str, new t.a(str, i10, i11));
        }
    }

    public void x(String str, int i10, String str2) {
        if (this.f3195s.containsKey(str)) {
            this.f3195s.get(str).x(str2);
        } else {
            this.f3195s.put(str, new t.a(str, i10, str2));
        }
    }

    public void y(String str, int i10, boolean z10) {
        if (this.f3195s.containsKey(str)) {
            this.f3195s.get(str).t(z10);
        } else {
            this.f3195s.put(str, new t.a(str, i10, z10));
        }
    }

    public void z(CustomAttribute customAttribute, float[] fArr) {
    }

    public o(ConstraintWidget constraintWidget) {
        this.f3177a = null;
        this.f3178b = 0;
        this.f3179c = 0;
        this.f3180d = 0;
        this.f3181e = 0;
        this.f3182f = Float.NaN;
        this.f3183g = Float.NaN;
        this.f3184h = Float.NaN;
        this.f3185i = Float.NaN;
        this.f3186j = Float.NaN;
        this.f3187k = Float.NaN;
        this.f3188l = Float.NaN;
        this.f3189m = Float.NaN;
        this.f3190n = Float.NaN;
        this.f3191o = Float.NaN;
        this.f3192p = Float.NaN;
        this.f3193q = Float.NaN;
        this.f3194r = 0;
        this.f3195s = new HashMap<>();
        this.f3196t = null;
        this.f3177a = constraintWidget;
    }

    public o(o oVar) {
        this.f3177a = null;
        this.f3178b = 0;
        this.f3179c = 0;
        this.f3180d = 0;
        this.f3181e = 0;
        this.f3182f = Float.NaN;
        this.f3183g = Float.NaN;
        this.f3184h = Float.NaN;
        this.f3185i = Float.NaN;
        this.f3186j = Float.NaN;
        this.f3187k = Float.NaN;
        this.f3188l = Float.NaN;
        this.f3189m = Float.NaN;
        this.f3190n = Float.NaN;
        this.f3191o = Float.NaN;
        this.f3192p = Float.NaN;
        this.f3193q = Float.NaN;
        this.f3194r = 0;
        this.f3195s = new HashMap<>();
        this.f3196t = null;
        this.f3177a = oVar.f3177a;
        this.f3178b = oVar.f3178b;
        this.f3179c = oVar.f3179c;
        this.f3180d = oVar.f3180d;
        this.f3181e = oVar.f3181e;
        D(oVar);
    }
}
