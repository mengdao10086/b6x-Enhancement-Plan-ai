package androidx.constraintlayout.motion.widget;

import a0.d;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Comparable<n> {
    public static final String D = "MotionPaths";
    public static final int K0 = 1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f3800k0 = false;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f3801k1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static String[] f3802v1 = {CommonNetImpl.POSITION, "x", "y", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3805c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public w.d f3818p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3820r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3821s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3822t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f3823u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f3824v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3803a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3804b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3806d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3807e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3808f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3809g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3810h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3811i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3812j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3813k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3814l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3815m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3816n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3817o = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3819q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3825w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f3826x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3827y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f3828z = new LinkedHashMap<>();
    public int A = 0;
    public double[] B = new double[18];
    public double[] C = new double[18];

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void c(HashMap<String, a0.d> splines, int mFramePosition) {
        for (String str : splines.keySet()) {
            a0.d dVar = splines.get(str);
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
                case -1225497657:
                    if (str.equals("translationX")) {
                        b10 = 2;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b10 = 3;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b10 = 4;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b10 = 5;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b10 = 6;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b10 = 7;
                    }
                    break;
                case -760884510:
                    if (str.equals(f.f3650l)) {
                        b10 = 8;
                    }
                    break;
                case -760884509:
                    if (str.equals(f.f3651m)) {
                        b10 = 9;
                    }
                    break;
                case -40300674:
                    if (str.equals(f.f3647i)) {
                        b10 = 10;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b10 = 11;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b10 = 12;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b10 = 13;
                    }
                    break;
            }
            switch (b10) {
                case 0:
                    dVar.g(mFramePosition, Float.isNaN(this.f3809g) ? 0.0f : this.f3809g);
                    break;
                case 1:
                    dVar.g(mFramePosition, Float.isNaN(this.f3810h) ? 0.0f : this.f3810h);
                    break;
                case 2:
                    dVar.g(mFramePosition, Float.isNaN(this.f3815m) ? 0.0f : this.f3815m);
                    break;
                case 3:
                    dVar.g(mFramePosition, Float.isNaN(this.f3816n) ? 0.0f : this.f3816n);
                    break;
                case 4:
                    dVar.g(mFramePosition, Float.isNaN(this.f3817o) ? 0.0f : this.f3817o);
                    break;
                case 5:
                    dVar.g(mFramePosition, Float.isNaN(this.f3826x) ? 0.0f : this.f3826x);
                    break;
                case 6:
                    dVar.g(mFramePosition, Float.isNaN(this.f3811i) ? 1.0f : this.f3811i);
                    break;
                case 7:
                    dVar.g(mFramePosition, Float.isNaN(this.f3812j) ? 1.0f : this.f3812j);
                    break;
                case 8:
                    dVar.g(mFramePosition, Float.isNaN(this.f3813k) ? 0.0f : this.f3813k);
                    break;
                case 9:
                    dVar.g(mFramePosition, Float.isNaN(this.f3814l) ? 0.0f : this.f3814l);
                    break;
                case 10:
                    dVar.g(mFramePosition, Float.isNaN(this.f3808f) ? 0.0f : this.f3808f);
                    break;
                case 11:
                    dVar.g(mFramePosition, Float.isNaN(this.f3807e) ? 0.0f : this.f3807e);
                    break;
                case 12:
                    dVar.g(mFramePosition, Float.isNaN(this.f3825w) ? 0.0f : this.f3825w);
                    break;
                case 13:
                    dVar.g(mFramePosition, Float.isNaN(this.f3803a) ? 1.0f : this.f3803a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(ag.c.f654g)[1];
                        if (this.f3828z.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.f3828z.get(str2);
                            if (dVar instanceof d.b) {
                                ((d.b) dVar).n(mFramePosition, constraintAttribute);
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append(" ViewSpline not a CustomSet frame = ");
                                sb2.append(mFramePosition);
                                sb2.append(", value");
                                sb2.append(constraintAttribute.k());
                                sb2.append(dVar);
                            }
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("UNKNOWN spline ");
                        sb3.append(str);
                    }
                    break;
            }
        }
    }

    public void d(View view) {
        this.f3805c = view.getVisibility();
        this.f3803a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f3806d = false;
        this.f3807e = view.getElevation();
        this.f3808f = view.getRotation();
        this.f3809g = view.getRotationX();
        this.f3810h = view.getRotationY();
        this.f3811i = view.getScaleX();
        this.f3812j = view.getScaleY();
        this.f3813k = view.getPivotX();
        this.f3814l = view.getPivotY();
        this.f3815m = view.getTranslationX();
        this.f3816n = view.getTranslationY();
        this.f3817o = view.getTranslationZ();
    }

    public void e(d.a c10) {
        d.C0039d c0039d = c10.f4293c;
        int i10 = c0039d.f4421c;
        this.f3804b = i10;
        int i11 = c0039d.f4420b;
        this.f3805c = i11;
        this.f3803a = (i11 == 0 || i10 != 0) ? c0039d.f4422d : 0.0f;
        d.e eVar = c10.f4296f;
        this.f3806d = eVar.f4448m;
        this.f3807e = eVar.f4449n;
        this.f3808f = eVar.f4437b;
        this.f3809g = eVar.f4438c;
        this.f3810h = eVar.f4439d;
        this.f3811i = eVar.f4440e;
        this.f3812j = eVar.f4441f;
        this.f3813k = eVar.f4442g;
        this.f3814l = eVar.f4443h;
        this.f3815m = eVar.f4445j;
        this.f3816n = eVar.f4446k;
        this.f3817o = eVar.f4447l;
        this.f3818p = w.d.c(c10.f4294d.f4408d);
        d.c cVar = c10.f4294d;
        this.f3825w = cVar.f4413i;
        this.f3819q = cVar.f4410f;
        this.f3827y = cVar.f4406b;
        this.f3826x = c10.f4293c.f4423e;
        for (String str : c10.f4297g.keySet()) {
            ConstraintAttribute constraintAttribute = c10.f4297g.get(str);
            if (constraintAttribute.n()) {
                this.f3828z.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(n o10) {
        return Float.compare(this.f3820r, o10.f3820r);
    }

    public final boolean g(float a10, float b10) {
        return (Float.isNaN(a10) || Float.isNaN(b10)) ? Float.isNaN(a10) != Float.isNaN(b10) : Math.abs(a10 - b10) > 1.0E-6f;
    }

    public void h(n points, HashSet<String> keySet) {
        if (g(this.f3803a, points.f3803a)) {
            keySet.add("alpha");
        }
        if (g(this.f3807e, points.f3807e)) {
            keySet.add("elevation");
        }
        int i10 = this.f3805c;
        int i11 = points.f3805c;
        if (i10 != i11 && this.f3804b == 0 && (i10 == 0 || i11 == 0)) {
            keySet.add("alpha");
        }
        if (g(this.f3808f, points.f3808f)) {
            keySet.add(f.f3647i);
        }
        if (!Float.isNaN(this.f3825w) || !Float.isNaN(points.f3825w)) {
            keySet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f3826x) || !Float.isNaN(points.f3826x)) {
            keySet.add("progress");
        }
        if (g(this.f3809g, points.f3809g)) {
            keySet.add("rotationX");
        }
        if (g(this.f3810h, points.f3810h)) {
            keySet.add("rotationY");
        }
        if (g(this.f3813k, points.f3813k)) {
            keySet.add(f.f3650l);
        }
        if (g(this.f3814l, points.f3814l)) {
            keySet.add(f.f3651m);
        }
        if (g(this.f3811i, points.f3811i)) {
            keySet.add("scaleX");
        }
        if (g(this.f3812j, points.f3812j)) {
            keySet.add("scaleY");
        }
        if (g(this.f3815m, points.f3815m)) {
            keySet.add("translationX");
        }
        if (g(this.f3816n, points.f3816n)) {
            keySet.add("translationY");
        }
        if (g(this.f3817o, points.f3817o)) {
            keySet.add("translationZ");
        }
    }

    public void i(n points, boolean[] mask, String[] custom) {
        mask[0] = mask[0] | g(this.f3820r, points.f3820r);
        mask[1] = mask[1] | g(this.f3821s, points.f3821s);
        mask[2] = mask[2] | g(this.f3822t, points.f3822t);
        mask[3] = mask[3] | g(this.f3823u, points.f3823u);
        mask[4] = g(this.f3824v, points.f3824v) | mask[4];
    }

    public void j(double[] data, int[] toUse) {
        float[] fArr = {this.f3820r, this.f3821s, this.f3822t, this.f3823u, this.f3824v, this.f3803a, this.f3807e, this.f3808f, this.f3809g, this.f3810h, this.f3811i, this.f3812j, this.f3813k, this.f3814l, this.f3815m, this.f3816n, this.f3817o, this.f3825w};
        int i10 = 0;
        for (int i11 = 0; i11 < toUse.length; i11++) {
            if (toUse[i11] < 18) {
                data[i10] = fArr[toUse[i11]];
                i10++;
            }
        }
    }

    public int k(String name, double[] value, int offset) {
        ConstraintAttribute constraintAttribute = this.f3828z.get(name);
        if (constraintAttribute.p() == 1) {
            value[offset] = constraintAttribute.k();
            return 1;
        }
        int iP = constraintAttribute.p();
        constraintAttribute.l(new float[iP]);
        int i10 = 0;
        while (i10 < iP) {
            value[offset] = r1[i10];
            i10++;
            offset++;
        }
        return iP;
    }

    public int l(String name) {
        return this.f3828z.get(name).p();
    }

    public boolean m(String name) {
        return this.f3828z.containsKey(name);
    }

    public void n(float x10, float y10, float w10, float h10) {
        this.f3821s = x10;
        this.f3822t = y10;
        this.f3823u = w10;
        this.f3824v = h10;
    }

    public void o(Rect rect, View view, int rotation, float prevous) {
        n(rect.left, rect.top, rect.width(), rect.height());
        d(view);
        this.f3813k = Float.NaN;
        this.f3814l = Float.NaN;
        if (rotation == 1) {
            this.f3808f = prevous - 90.0f;
        } else {
            if (rotation != 2) {
                return;
            }
            this.f3808f = prevous + 90.0f;
        }
    }

    public void p(Rect cw, androidx.constraintlayout.widget.d constraintSet, int rotation, int viewId) {
        n(cw.left, cw.top, cw.width(), cw.height());
        e(constraintSet.q0(viewId));
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    if (rotation != 4) {
                        return;
                    }
                }
            }
            float f10 = this.f3808f + 90.0f;
            this.f3808f = f10;
            if (f10 > 180.0f) {
                this.f3808f = f10 - 360.0f;
                return;
            }
            return;
        }
        this.f3808f -= 90.0f;
    }

    public void q(View view) {
        n(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        d(view);
    }
}
