package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import g.d0;
import g.n0;
import g.p0;
import g2.i0;
import g2.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q implements Cloneable {
    public static final int C1 = 1;
    public static final int C2 = 3;
    public static final int E7 = 4;
    public static final String F7 = "instance";
    public static final String G7 = "name";
    public static final String H7 = "id";
    public static final String I7 = "itemId";
    public static final int K1 = 1;
    public static final int K2 = 4;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f7953k1 = "Transition";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final boolean f7954v1 = false;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f7955v2 = 2;
    public g2.p C;
    public f D;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public androidx.collection.a<String, String> f7967k0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<g2.q> f7976t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<g2.q> f7977u;
    public static final int[] J7 = {2, 1, 3, 4};
    public static final g2.k K7 = new a();
    public static ThreadLocal<androidx.collection.a<Animator, d>> L7 = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7956a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7957b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7958c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f7959d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Integer> f7960e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<View> f7961f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<String> f7962g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<Class<?>> f7963h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<Integer> f7964i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<View> f7965j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<Class<?>> f7966k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<String> f7968l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<Integer> f7969m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<View> f7970n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<Class<?>> f7971o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public r f7972p = new r();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public r f7973q = new r();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public v f7974r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f7975s = J7;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7978v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList<Animator> f7979w = new ArrayList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7980x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7981y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7982z = false;
    public ArrayList<h> A = null;
    public ArrayList<Animator> B = new ArrayList<>();
    public g2.k K0 = K7;

    public class a extends g2.k {
        @Override // g2.k
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f7983a;

        public b(androidx.collection.a aVar) {
            this.f7983a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7983a.remove(animator);
            q.this.f7979w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            q.this.f7979w.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q.this.s();
            animator.removeListener(this);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f7986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g2.q f7988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i0 f7989d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public q f7990e;

        public d(View view, String str, q qVar, i0 i0Var, g2.q qVar2) {
            this.f7986a = view;
            this.f7987b = str;
            this.f7988c = qVar2;
            this.f7989d = i0Var;
            this.f7990e = qVar;
        }
    }

    public static class e {
        public static <T> ArrayList<T> a(ArrayList<T> arrayList, T t10) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t10)) {
                arrayList.add(t10);
            }
            return arrayList;
        }

        public static <T> ArrayList<T> b(ArrayList<T> arrayList, T t10) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t10);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class f {
        public abstract Rect a(@n0 q qVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface g {
    }

    public interface h {
        void a(@n0 q qVar);

        void b(@n0 q qVar);

        void c(@n0 q qVar);

        void d(@n0 q qVar);

        void e(@n0 q qVar);
    }

    public q() {
    }

    public static androidx.collection.a<Animator, d> P() {
        androidx.collection.a<Animator, d> aVar = L7.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a<Animator, d> aVar2 = new androidx.collection.a<>();
        L7.set(aVar2);
        return aVar2;
    }

    public static boolean e0(int i10) {
        return i10 >= 1 && i10 <= 4;
    }

    public static void g(r rVar, View view, g2.q qVar) {
        rVar.f28975a.put(view, qVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (rVar.f28976b.indexOfKey(id2) >= 0) {
                rVar.f28976b.put(id2, null);
            } else {
                rVar.f28976b.put(id2, view);
            }
        }
        String strX0 = u0.x0(view);
        if (strX0 != null) {
            if (rVar.f28978d.containsKey(strX0)) {
                rVar.f28978d.put(strX0, null);
            } else {
                rVar.f28978d.put(strX0, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (rVar.f28977c.j(itemIdAtPosition) < 0) {
                    u0.Q1(view, true);
                    rVar.f28977c.n(itemIdAtPosition, view);
                    return;
                }
                View viewH = rVar.f28977c.h(itemIdAtPosition);
                if (viewH != null) {
                    u0.Q1(viewH, false);
                    rVar.f28977c.n(itemIdAtPosition, null);
                }
            }
        }
    }

    public static boolean g0(g2.q qVar, g2.q qVar2, String str) {
        Object obj = qVar.f28972a.get(str);
        Object obj2 = qVar2.f28972a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public static boolean h(int[] iArr, int i10) {
        int i11 = iArr[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            if (iArr[i12] == i11) {
                return true;
            }
        }
        return false;
    }

    public static int[] m0(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ag.c.f654g);
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(strTrim)) {
                iArr[i10] = 3;
            } else if (F7.equalsIgnoreCase(strTrim)) {
                iArr[i10] = 1;
            } else if ("name".equalsIgnoreCase(strTrim)) {
                iArr[i10] = 2;
            } else if (I7.equalsIgnoreCase(strTrim)) {
                iArr[i10] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                i10--;
                iArr = iArr2;
            }
            i10++;
        }
        return iArr;
    }

    public static <T> ArrayList<T> x(ArrayList<T> arrayList, T t10, boolean z10) {
        return t10 != null ? z10 ? e.a(arrayList, t10) : e.b(arrayList, t10) : arrayList;
    }

    @n0
    public q A(@n0 View view, boolean z10) {
        this.f7965j = E(this.f7965j, view, z10);
        return this;
    }

    @n0
    public q A0(@p0 TimeInterpolator timeInterpolator) {
        this.f7959d = timeInterpolator;
        return this;
    }

    @n0
    public q B(@n0 Class<?> cls, boolean z10) {
        this.f7966k = D(this.f7966k, cls, z10);
        return this;
    }

    public void B0(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f7975s = J7;
            return;
        }
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (!e0(iArr[i10])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (h(iArr, i10)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.f7975s = (int[]) iArr.clone();
    }

    @n0
    public q C(@n0 String str, boolean z10) {
        this.f7968l = x(this.f7968l, str, z10);
        return this;
    }

    public void C0(@p0 g2.k kVar) {
        if (kVar == null) {
            this.K0 = K7;
        } else {
            this.K0 = kVar;
        }
    }

    public final ArrayList<Class<?>> D(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z10) {
        return cls != null ? z10 ? e.a(arrayList, cls) : e.b(arrayList, cls) : arrayList;
    }

    public void D0(@p0 g2.p pVar) {
        this.C = pVar;
    }

    public final ArrayList<View> E(ArrayList<View> arrayList, View view, boolean z10) {
        return view != null ? z10 ? e.a(arrayList, view) : e.b(arrayList, view) : arrayList;
    }

    @n0
    public q E0(long j10) {
        this.f7957b = j10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void F(ViewGroup viewGroup) {
        androidx.collection.a<Animator, d> aVarP = P();
        int size = aVarP.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        i0 i0VarD = g2.z.d(viewGroup);
        androidx.collection.a aVar = new androidx.collection.a(aVarP);
        aVarP.clear();
        for (int i10 = size - 1; i10 >= 0; i10--) {
            d dVar = (d) aVar.o(i10);
            if (dVar.f7986a != null && i0VarD != null && i0VarD.equals(dVar.f7989d)) {
                ((Animator) aVar.k(i10)).end();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void F0() {
        if (this.f7980x == 0) {
            ArrayList<h> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((h) arrayList2.get(i10)).a(this);
                }
            }
            this.f7982z = false;
        }
        this.f7980x++;
    }

    public long G() {
        return this.f7958c;
    }

    public String G0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f7958c != -1) {
            str2 = str2 + "dur(" + this.f7958c + ") ";
        }
        if (this.f7957b != -1) {
            str2 = str2 + "dly(" + this.f7957b + ") ";
        }
        if (this.f7959d != null) {
            str2 = str2 + "interp(" + this.f7959d + ") ";
        }
        if (this.f7960e.size() <= 0 && this.f7961f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f7960e.size() > 0) {
            for (int i10 = 0; i10 < this.f7960e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f7960e.get(i10);
            }
        }
        if (this.f7961f.size() > 0) {
            for (int i11 = 0; i11 < this.f7961f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f7961f.get(i11);
            }
        }
        return str3 + ee.a.f26979d;
    }

    @p0
    public Rect H() {
        f fVar = this.D;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this);
    }

    @p0
    public f I() {
        return this.D;
    }

    @p0
    public TimeInterpolator J() {
        return this.f7959d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        r7 = r6.f7977u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r7 = r6.f7976t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        return r7.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g2.q K(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            androidx.transition.v r0 = r6.f7974r
            if (r0 == 0) goto L9
            g2.q r7 = r0.K(r7, r8)
            return r7
        L9:
            if (r8 == 0) goto Le
            java.util.ArrayList<g2.q> r0 = r6.f7976t
            goto L10
        Le:
            java.util.ArrayList<g2.q> r0 = r6.f7977u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1a:
            if (r4 >= r2) goto L2e
            java.lang.Object r5 = r0.get(r4)
            g2.q r5 = (g2.q) r5
            if (r5 != 0) goto L25
            return r1
        L25:
            android.view.View r5 = r5.f28973b
            if (r5 != r7) goto L2b
            r3 = r4
            goto L2e
        L2b:
            int r4 = r4 + 1
            goto L1a
        L2e:
            if (r3 < 0) goto L3e
            if (r8 == 0) goto L35
            java.util.ArrayList<g2.q> r7 = r6.f7977u
            goto L37
        L35:
            java.util.ArrayList<g2.q> r7 = r6.f7976t
        L37:
            java.lang.Object r7 = r7.get(r3)
            r1 = r7
            g2.q r1 = (g2.q) r1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.q.K(android.view.View, boolean):g2.q");
    }

    @n0
    public String L() {
        return this.f7956a;
    }

    @n0
    public g2.k N() {
        return this.K0;
    }

    @p0
    public g2.p O() {
        return this.C;
    }

    public long Q() {
        return this.f7957b;
    }

    @n0
    public List<Integer> R() {
        return this.f7960e;
    }

    @p0
    public List<String> S() {
        return this.f7962g;
    }

    @p0
    public List<Class<?>> V() {
        return this.f7963h;
    }

    @n0
    public List<View> Y() {
        return this.f7961f;
    }

    @n0
    public q a(@n0 h hVar) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(hVar);
        return this;
    }

    @p0
    public String[] a0() {
        return null;
    }

    @n0
    public q b(@d0 int i10) {
        if (i10 != 0) {
            this.f7960e.add(Integer.valueOf(i10));
        }
        return this;
    }

    @n0
    public q c(@n0 View view) {
        this.f7961f.add(view);
        return this;
    }

    @p0
    public g2.q c0(@n0 View view, boolean z10) {
        v vVar = this.f7974r;
        if (vVar != null) {
            return vVar.c0(view, z10);
        }
        return (z10 ? this.f7972p : this.f7973q).f28975a.get(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        for (int size = this.f7979w.size() - 1; size >= 0; size--) {
            this.f7979w.get(size).cancel();
        }
        ArrayList<h> arrayList = this.A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.A.clone();
        int size2 = arrayList2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            ((h) arrayList2.get(i10)).d(this);
        }
    }

    @n0
    public q d(@n0 Class<?> cls) {
        if (this.f7963h == null) {
            this.f7963h = new ArrayList<>();
        }
        this.f7963h.add(cls);
        return this;
    }

    public boolean d0(@p0 g2.q qVar, @p0 g2.q qVar2) {
        if (qVar == null || qVar2 == null) {
            return false;
        }
        String[] strArrA0 = a0();
        if (strArrA0 == null) {
            Iterator<String> it2 = qVar.f28972a.keySet().iterator();
            while (it2.hasNext()) {
                if (g0(qVar, qVar2, it2.next())) {
                }
            }
            return false;
        }
        for (String str : strArrA0) {
            if (!g0(qVar, qVar2, str)) {
            }
        }
        return false;
        return true;
    }

    @n0
    public q e(@n0 String str) {
        if (this.f7962g == null) {
            this.f7962g = new ArrayList<>();
        }
        this.f7962g.add(str);
        return this;
    }

    public final void f(androidx.collection.a<View, g2.q> aVar, androidx.collection.a<View, g2.q> aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            g2.q qVarO = aVar.o(i10);
            if (f0(qVarO.f28973b)) {
                this.f7976t.add(qVarO);
                this.f7977u.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            g2.q qVarO2 = aVar2.o(i11);
            if (f0(qVarO2.f28973b)) {
                this.f7977u.add(qVarO2);
                this.f7976t.add(null);
            }
        }
    }

    public boolean f0(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f7964i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f7965j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f7966k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f7966k.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f7968l != null && u0.x0(view) != null && this.f7968l.contains(u0.x0(view))) {
            return false;
        }
        if ((this.f7960e.size() == 0 && this.f7961f.size() == 0 && (((arrayList = this.f7963h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f7962g) == null || arrayList2.isEmpty()))) || this.f7960e.contains(Integer.valueOf(id2)) || this.f7961f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f7962g;
        if (arrayList6 != null && arrayList6.contains(u0.x0(view))) {
            return true;
        }
        if (this.f7963h != null) {
            for (int i11 = 0; i11 < this.f7963h.size(); i11++) {
                if (this.f7963h.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h0(androidx.collection.a<View, g2.q> aVar, androidx.collection.a<View, g2.q> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewValueAt = sparseArray.valueAt(i10);
            if (viewValueAt != null && f0(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && f0(view)) {
                g2.q qVar = aVar.get(viewValueAt);
                g2.q qVar2 = aVar2.get(view);
                if (qVar != null && qVar2 != null) {
                    this.f7976t.add(qVar);
                    this.f7977u.add(qVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void i(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (G() >= 0) {
            animator.setDuration(G());
        }
        if (Q() >= 0) {
            animator.setStartDelay(Q() + animator.getStartDelay());
        }
        if (J() != null) {
            animator.setInterpolator(J());
        }
        animator.addListener(new c());
        animator.start();
    }

    public final void i0(androidx.collection.a<View, g2.q> aVar, androidx.collection.a<View, g2.q> aVar2) {
        g2.q qVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewK = aVar.k(size);
            if (viewK != null && f0(viewK) && (qVarRemove = aVar2.remove(viewK)) != null && f0(qVarRemove.f28973b)) {
                this.f7976t.add(aVar.m(size));
                this.f7977u.add(qVarRemove);
            }
        }
    }

    public abstract void j(@n0 g2.q qVar);

    public final void j0(androidx.collection.a<View, g2.q> aVar, androidx.collection.a<View, g2.q> aVar2, androidx.collection.h<View> hVar, androidx.collection.h<View> hVar2) {
        View viewH;
        int iW = hVar.w();
        for (int i10 = 0; i10 < iW; i10++) {
            View viewX = hVar.x(i10);
            if (viewX != null && f0(viewX) && (viewH = hVar2.h(hVar.m(i10))) != null && f0(viewH)) {
                g2.q qVar = aVar.get(viewX);
                g2.q qVar2 = aVar2.get(viewH);
                if (qVar != null && qVar2 != null) {
                    this.f7976t.add(qVar);
                    this.f7977u.add(qVar2);
                    aVar.remove(viewX);
                    aVar2.remove(viewH);
                }
            }
        }
    }

    public final void k(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.f7964i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
            ArrayList<View> arrayList2 = this.f7965j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f7966k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f7966k.get(i10).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    g2.q qVar = new g2.q(view);
                    if (z10) {
                        m(qVar);
                    } else {
                        j(qVar);
                    }
                    qVar.f28974c.add(this);
                    l(qVar);
                    if (z10) {
                        g(this.f7972p, view, qVar);
                    } else {
                        g(this.f7973q, view, qVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f7969m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                        ArrayList<View> arrayList5 = this.f7970n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f7971o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    if (this.f7971o.get(i11).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                k(viewGroup.getChildAt(i12), z10);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void k0(androidx.collection.a<View, g2.q> aVar, androidx.collection.a<View, g2.q> aVar2, androidx.collection.a<String, View> aVar3, androidx.collection.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewO = aVar3.o(i10);
            if (viewO != null && f0(viewO) && (view = aVar4.get(aVar3.k(i10))) != null && f0(view)) {
                g2.q qVar = aVar.get(viewO);
                g2.q qVar2 = aVar2.get(view);
                if (qVar != null && qVar2 != null) {
                    this.f7976t.add(qVar);
                    this.f7977u.add(qVar2);
                    aVar.remove(viewO);
                    aVar2.remove(view);
                }
            }
        }
    }

    public void l(g2.q qVar) {
        String[] strArrB;
        if (this.C == null || qVar.f28972a.isEmpty() || (strArrB = this.C.b()) == null) {
            return;
        }
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= strArrB.length) {
                z10 = true;
                break;
            } else if (!qVar.f28972a.containsKey(strArrB[i10])) {
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            return;
        }
        this.C.a(qVar);
    }

    public final void l0(r rVar, r rVar2) {
        androidx.collection.a<View, g2.q> aVar = new androidx.collection.a<>(rVar.f28975a);
        androidx.collection.a<View, g2.q> aVar2 = new androidx.collection.a<>(rVar2.f28975a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f7975s;
            if (i10 >= iArr.length) {
                f(aVar, aVar2);
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 1) {
                i0(aVar, aVar2);
            } else if (i11 == 2) {
                k0(aVar, aVar2, rVar.f28978d, rVar2.f28978d);
            } else if (i11 == 3) {
                h0(aVar, aVar2, rVar.f28976b, rVar2.f28976b);
            } else if (i11 == 4) {
                j0(aVar, aVar2, rVar.f28977c, rVar2.f28977c);
            }
            i10++;
        }
    }

    public abstract void m(@n0 g2.q qVar);

    public void n(ViewGroup viewGroup, boolean z10) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        androidx.collection.a<String, String> aVar;
        o(z10);
        if ((this.f7960e.size() > 0 || this.f7961f.size() > 0) && (((arrayList = this.f7962g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f7963h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f7960e.size(); i10++) {
                View viewFindViewById = viewGroup.findViewById(this.f7960e.get(i10).intValue());
                if (viewFindViewById != null) {
                    g2.q qVar = new g2.q(viewFindViewById);
                    if (z10) {
                        m(qVar);
                    } else {
                        j(qVar);
                    }
                    qVar.f28974c.add(this);
                    l(qVar);
                    if (z10) {
                        g(this.f7972p, viewFindViewById, qVar);
                    } else {
                        g(this.f7973q, viewFindViewById, qVar);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f7961f.size(); i11++) {
                View view = this.f7961f.get(i11);
                g2.q qVar2 = new g2.q(view);
                if (z10) {
                    m(qVar2);
                } else {
                    j(qVar2);
                }
                qVar2.f28974c.add(this);
                l(qVar2);
                if (z10) {
                    g(this.f7972p, view, qVar2);
                } else {
                    g(this.f7973q, view, qVar2);
                }
            }
        } else {
            k(viewGroup, z10);
        }
        if (z10 || (aVar = this.f7967k0) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList3.add(this.f7972p.f28978d.remove(this.f7967k0.k(i12)));
        }
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = (View) arrayList3.get(i13);
            if (view2 != null) {
                this.f7972p.f28978d.put(this.f7967k0.o(i13), view2);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void n0(View view) {
        if (this.f7982z) {
            return;
        }
        for (int size = this.f7979w.size() - 1; size >= 0; size--) {
            androidx.transition.a.b(this.f7979w.get(size));
        }
        ArrayList<h> arrayList = this.A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.A.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((h) arrayList2.get(i10)).b(this);
            }
        }
        this.f7981y = true;
    }

    public void o(boolean z10) {
        if (z10) {
            this.f7972p.f28975a.clear();
            this.f7972p.f28976b.clear();
            this.f7972p.f28977c.b();
        } else {
            this.f7973q.f28975a.clear();
            this.f7973q.f28976b.clear();
            this.f7973q.f28977c.b();
        }
    }

    public void o0(ViewGroup viewGroup) {
        d dVar;
        this.f7976t = new ArrayList<>();
        this.f7977u = new ArrayList<>();
        l0(this.f7972p, this.f7973q);
        androidx.collection.a<Animator, d> aVarP = P();
        int size = aVarP.size();
        i0 i0VarD = g2.z.d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animatorK = aVarP.k(i10);
            if (animatorK != null && (dVar = aVarP.get(animatorK)) != null && dVar.f7986a != null && i0VarD.equals(dVar.f7989d)) {
                g2.q qVar = dVar.f7988c;
                View view = dVar.f7986a;
                g2.q qVarC0 = c0(view, true);
                g2.q qVarK = K(view, true);
                if (qVarC0 == null && qVarK == null) {
                    qVarK = this.f7973q.f28975a.get(view);
                }
                if (!(qVarC0 == null && qVarK == null) && dVar.f7990e.d0(qVar, qVarK)) {
                    if (animatorK.isRunning() || animatorK.isStarted()) {
                        animatorK.cancel();
                    } else {
                        aVarP.remove(animatorK);
                    }
                }
            }
        }
        r(viewGroup, this.f7972p, this.f7973q, this.f7976t, this.f7977u);
        w0();
    }

    @Override // 
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public q clone() {
        try {
            q qVar = (q) super.clone();
            qVar.B = new ArrayList<>();
            qVar.f7972p = new r();
            qVar.f7973q = new r();
            qVar.f7976t = null;
            qVar.f7977u = null;
            return qVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @n0
    public q p0(@n0 h hVar) {
        ArrayList<h> arrayList = this.A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(hVar);
        if (this.A.size() == 0) {
            this.A = null;
        }
        return this;
    }

    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        return null;
    }

    @n0
    public q q0(@d0 int i10) {
        if (i10 != 0) {
            this.f7960e.remove(Integer.valueOf(i10));
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(android.view.ViewGroup r21, g2.r r22, g2.r r23, java.util.ArrayList<g2.q> r24, java.util.ArrayList<g2.q> r25) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.q.r(android.view.ViewGroup, g2.r, g2.r, java.util.ArrayList, java.util.ArrayList):void");
    }

    @n0
    public q r0(@n0 View view) {
        this.f7961f.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void s() {
        int i10 = this.f7980x - 1;
        this.f7980x = i10;
        if (i10 == 0) {
            ArrayList<h> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((h) arrayList2.get(i11)).c(this);
                }
            }
            for (int i12 = 0; i12 < this.f7972p.f28977c.w(); i12++) {
                View viewX = this.f7972p.f28977c.x(i12);
                if (viewX != null) {
                    u0.Q1(viewX, false);
                }
            }
            for (int i13 = 0; i13 < this.f7973q.f28977c.w(); i13++) {
                View viewX2 = this.f7973q.f28977c.x(i13);
                if (viewX2 != null) {
                    u0.Q1(viewX2, false);
                }
            }
            this.f7982z = true;
        }
    }

    @n0
    public q s0(@n0 Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.f7963h;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @n0
    public q t(@d0 int i10, boolean z10) {
        this.f7969m = w(this.f7969m, i10, z10);
        return this;
    }

    @n0
    public q t0(@n0 String str) {
        ArrayList<String> arrayList = this.f7962g;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public String toString() {
        return G0("");
    }

    @n0
    public q u(@n0 View view, boolean z10) {
        this.f7970n = E(this.f7970n, view, z10);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void u0(View view) {
        if (this.f7981y) {
            if (!this.f7982z) {
                for (int size = this.f7979w.size() - 1; size >= 0; size--) {
                    androidx.transition.a.c(this.f7979w.get(size));
                }
                ArrayList<h> arrayList = this.A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.A.clone();
                    int size2 = arrayList2.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        ((h) arrayList2.get(i10)).e(this);
                    }
                }
            }
            this.f7981y = false;
        }
    }

    @n0
    public q v(@n0 Class<?> cls, boolean z10) {
        this.f7971o = D(this.f7971o, cls, z10);
        return this;
    }

    public final void v0(Animator animator, androidx.collection.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            i(animator);
        }
    }

    public final ArrayList<Integer> w(ArrayList<Integer> arrayList, int i10, boolean z10) {
        return i10 > 0 ? z10 ? e.a(arrayList, Integer.valueOf(i10)) : e.b(arrayList, Integer.valueOf(i10)) : arrayList;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void w0() {
        F0();
        androidx.collection.a<Animator, d> aVarP = P();
        for (Animator animator : this.B) {
            if (aVarP.containsKey(animator)) {
                F0();
                v0(animator, aVarP);
            }
        }
        this.B.clear();
        s();
    }

    public void x0(boolean z10) {
        this.f7978v = z10;
    }

    @n0
    public q y(@d0 int i10, boolean z10) {
        this.f7964i = w(this.f7964i, i10, z10);
        return this;
    }

    @n0
    public q y0(long j10) {
        this.f7958c = j10;
        return this;
    }

    public void z0(@p0 f fVar) {
        this.D = fVar;
    }

    @SuppressLint({"RestrictedApi"})
    public q(@n0 Context context, @n0 AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7920c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jK = j0.n.k(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (jK >= 0) {
            y0(jK);
        }
        long jK2 = j0.n.k(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (jK2 > 0) {
            E0(jK2);
        }
        int iL = j0.n.l(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iL > 0) {
            A0(AnimationUtils.loadInterpolator(context, iL));
        }
        String strM = j0.n.m(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strM != null) {
            B0(m0(strM));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
