package g1;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.umeng.analytics.pro.an;
import g.x;
import g1.a;
import g1.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T extends b<T>> implements a.b {
    public static final float A = 1.0f;
    public static final float B = 0.1f;
    public static final float C = 0.00390625f;
    public static final float D = 0.002f;
    public static final float E = Float.MAX_VALUE;
    public static final float F = 0.75f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final s f28877m = new g("translationX");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final s f28878n = new h("translationY");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final s f28879o = new i("translationZ");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final s f28880p = new j("scaleX");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final s f28881q = new k("scaleY");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final s f28882r = new l(androidx.constraintlayout.motion.widget.f.f3647i);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final s f28883s = new m("rotationX");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final s f28884t = new n("rotationY");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final s f28885u = new o("x");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final s f28886v = new a("y");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final s f28887w = new C0344b(an.aD);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final s f28888x = new c("alpha");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final s f28889y = new d("scrollX");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final s f28890z = new e("scrollY");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f28892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f28893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f28894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1.d f28895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f28896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f28897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f28898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f28899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f28900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<q> f28901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<r> f28902l;

    public static class a extends s {
        public a(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getY();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setY(f10);
        }
    }

    /* JADX INFO: renamed from: g1.b$b, reason: collision with other inner class name */
    public static class C0344b extends s {
        public C0344b(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return u0.F0(view);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            u0.B2(view, f10);
        }
    }

    public static class c extends s {
        public c(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getAlpha();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    public static class d extends s {
        public d(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScrollX();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    public static class e extends s {
        public e(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScrollY();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    public class f extends g1.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g1.e f28903b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, g1.e eVar) {
            super(str);
            this.f28903b = eVar;
        }

        @Override // g1.d
        public float b(Object obj) {
            return this.f28903b.a();
        }

        @Override // g1.d
        public void c(Object obj, float f10) {
            this.f28903b.b(f10);
        }
    }

    public static class g extends s {
        public g(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getTranslationX();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    public static class h extends s {
        public h(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getTranslationY();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    public static class i extends s {
        public i(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return u0.A0(view);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            u0.w2(view, f10);
        }
    }

    public static class j extends s {
        public j(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScaleX();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    public static class k extends s {
        public k(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScaleY();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    public static class l extends s {
        public l(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getRotation();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setRotation(f10);
        }
    }

    public static class m extends s {
        public m(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getRotationX();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    public static class n extends s {
        public n(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getRotationY();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    public static class o extends s {
        public o(String str) {
            super(str, null);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getX();
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f10) {
            view.setX(f10);
        }
    }

    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f28905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f28906b;
    }

    public interface q {
        void a(b bVar, boolean z10, float f10, float f11);
    }

    public interface r {
        void a(b bVar, float f10, float f11);
    }

    public static abstract class s extends g1.d<View> {
        public /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        public s(String str) {
            super(str);
        }
    }

    public b(g1.e eVar) {
        this.f28891a = 0.0f;
        this.f28892b = Float.MAX_VALUE;
        this.f28893c = false;
        this.f28896f = false;
        this.f28897g = Float.MAX_VALUE;
        this.f28898h = -Float.MAX_VALUE;
        this.f28899i = 0L;
        this.f28901k = new ArrayList<>();
        this.f28902l = new ArrayList<>();
        this.f28894d = null;
        this.f28895e = new f("FloatValueHolder", eVar);
        this.f28900j = 1.0f;
    }

    public static <T> void m(ArrayList<T> arrayList, T t10) {
        int iIndexOf = arrayList.indexOf(t10);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    public static <T> void n(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // g1.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j10) {
        long j11 = this.f28899i;
        if (j11 == 0) {
            this.f28899i = j10;
            s(this.f28892b);
            return false;
        }
        this.f28899i = j10;
        boolean zY = y(j10 - j11);
        float fMin = Math.min(this.f28892b, this.f28897g);
        this.f28892b = fMin;
        float fMax = Math.max(fMin, this.f28898h);
        this.f28892b = fMax;
        s(fMax);
        if (zY) {
            e(false);
        }
        return zY;
    }

    public T b(q qVar) {
        if (!this.f28901k.contains(qVar)) {
            this.f28901k.add(qVar);
        }
        return this;
    }

    public T c(r rVar) {
        if (k()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f28902l.contains(rVar)) {
            this.f28902l.add(rVar);
        }
        return this;
    }

    public void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f28896f) {
            e(true);
        }
    }

    public final void e(boolean z10) {
        this.f28896f = false;
        g1.a.e().h(this);
        this.f28899i = 0L;
        this.f28893c = false;
        for (int i10 = 0; i10 < this.f28901k.size(); i10++) {
            if (this.f28901k.get(i10) != null) {
                this.f28901k.get(i10).a(this, z10, this.f28892b, this.f28891a);
            }
        }
        n(this.f28901k);
    }

    public abstract float f(float f10, float f11);

    public float g() {
        return this.f28900j;
    }

    public final float h() {
        return this.f28895e.b(this.f28894d);
    }

    public float i() {
        return this.f28900j * 0.75f;
    }

    public abstract boolean j(float f10, float f11);

    public boolean k() {
        return this.f28896f;
    }

    public void l(q qVar) {
        m(this.f28901k, qVar);
    }

    public void o(r rVar) {
        m(this.f28902l, rVar);
    }

    public T p(float f10) {
        this.f28897g = f10;
        return this;
    }

    public T q(float f10) {
        this.f28898h = f10;
        return this;
    }

    public T r(@x(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f28900j = f10;
        v(f10 * 0.75f);
        return this;
    }

    public void s(float f10) {
        this.f28895e.c(this.f28894d, f10);
        for (int i10 = 0; i10 < this.f28902l.size(); i10++) {
            if (this.f28902l.get(i10) != null) {
                this.f28902l.get(i10).a(this, this.f28892b, this.f28891a);
            }
        }
        n(this.f28902l);
    }

    public T t(float f10) {
        this.f28892b = f10;
        this.f28893c = true;
        return this;
    }

    public T u(float f10) {
        this.f28891a = f10;
        return this;
    }

    public abstract void v(float f10);

    public void w() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f28896f) {
            return;
        }
        x();
    }

    public final void x() {
        if (this.f28896f) {
            return;
        }
        this.f28896f = true;
        if (!this.f28893c) {
            this.f28892b = h();
        }
        float f10 = this.f28892b;
        if (f10 > this.f28897g || f10 < this.f28898h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        g1.a.e().a(this, 0L);
    }

    public abstract boolean y(long j10);

    public <K> b(K k10, g1.d<K> dVar) {
        this.f28891a = 0.0f;
        this.f28892b = Float.MAX_VALUE;
        this.f28893c = false;
        this.f28896f = false;
        this.f28897g = Float.MAX_VALUE;
        this.f28898h = -Float.MAX_VALUE;
        this.f28899i = 0L;
        this.f28901k = new ArrayList<>();
        this.f28902l = new ArrayList<>();
        this.f28894d = k10;
        this.f28895e = dVar;
        if (dVar != f28882r && dVar != f28883s && dVar != f28884t) {
            if (dVar == f28888x) {
                this.f28900j = 0.00390625f;
                return;
            } else if (dVar != f28880p && dVar != f28881q) {
                this.f28900j = 1.0f;
                return;
            } else {
                this.f28900j = 0.00390625f;
                return;
            }
        }
        this.f28900j = 0.1f;
    }
}
