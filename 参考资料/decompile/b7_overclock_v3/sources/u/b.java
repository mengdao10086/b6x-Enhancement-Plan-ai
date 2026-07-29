package u;

import java.util.HashMap;
import java.util.HashSet;
import w.o;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements w {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f51736m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f51737n = "alpha";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f51738o = "elevation";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f51739p = "rotationZ";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f51740q = "rotationX";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f51741r = "transitionPathRotate";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f51742s = "scaleX";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f51743t = "scaleY";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f51744u = "translationX";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f51745v = "translationY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f51746w = "CUSTOM";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f51747x = "visibility";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f51748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f51749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f51750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f51751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, t.a> f51752l;

    public b() {
        int i10 = f51736m;
        this.f51748h = i10;
        this.f51749i = i10;
        this.f51750j = null;
    }

    @Override // w.w
    public boolean a(int i10, int i11) {
        if (i10 != 100) {
            return false;
        }
        this.f51748h = i11;
        return true;
    }

    @Override // w.w
    public boolean b(int i10, float f10) {
        return false;
    }

    @Override // w.w
    public boolean c(int i10, String str) {
        if (i10 != 101) {
            return false;
        }
        this.f51750j = str;
        return true;
    }

    @Override // w.w
    public boolean d(int i10, boolean z10) {
        return false;
    }

    public abstract void f(HashMap<String, o> map);

    @Override // 
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public abstract b clone();

    public b h(b bVar) {
        this.f51748h = bVar.f51748h;
        this.f51749i = bVar.f51749i;
        this.f51750j = bVar.f51750j;
        this.f51751k = bVar.f51751k;
        return this;
    }

    public abstract void i(HashSet<String> hashSet);

    public int j() {
        return this.f51748h;
    }

    public boolean k(String str) {
        String str2 = this.f51750j;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void l(String str, int i10, float f10) {
        this.f51752l.put(str, new t.a(str, i10, f10));
    }

    public void m(String str, int i10, int i11) {
        this.f51752l.put(str, new t.a(str, i10, i11));
    }

    public void n(String str, int i10, String str2) {
        this.f51752l.put(str, new t.a(str, i10, str2));
    }

    public void o(String str, int i10, boolean z10) {
        this.f51752l.put(str, new t.a(str, i10, z10));
    }

    public void p(int i10) {
        this.f51748h = i10;
    }

    public void q(HashMap<String, Integer> map) {
    }

    public b r(int i10) {
        this.f51749i = i10;
        return this;
    }

    public boolean s(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public float t(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public int u(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
