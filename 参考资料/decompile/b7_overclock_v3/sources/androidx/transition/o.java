package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class o extends a0 {
    public static final String X7 = "android:slide:screenPosition";
    public g T7;
    public int U7;
    public static final TimeInterpolator V7 = new DecelerateInterpolator();
    public static final TimeInterpolator W7 = new AccelerateInterpolator();
    public static final g Y7 = new a();
    public static final g Z7 = new b();

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final g f7914a8 = new c();

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final g f7915b8 = new d();

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final g f7916c8 = new e();

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final g f7917d8 = new f();

    public class a extends h {
        public a() {
            super(null);
        }

        @Override // androidx.transition.o.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    public class b extends h {
        public b() {
            super(null);
        }

        @Override // androidx.transition.o.g
        public float b(ViewGroup viewGroup, View view) {
            return u0.Z(viewGroup) == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    }

    public class c extends i {
        public c() {
            super(null);
        }

        @Override // androidx.transition.o.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    public class d extends h {
        public d() {
            super(null);
        }

        @Override // androidx.transition.o.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    public class e extends h {
        public e() {
            super(null);
        }

        @Override // androidx.transition.o.g
        public float b(ViewGroup viewGroup, View view) {
            return u0.Z(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }

    public class f extends i {
        public f() {
            super(null);
        }

        @Override // androidx.transition.o.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    public interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    public static abstract class h implements g {
        public h() {
        }

        @Override // androidx.transition.o.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public static abstract class i implements g {
        public i() {
        }

        @Override // androidx.transition.o.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface j {
    }

    public o() {
        this.T7 = f7917d8;
        this.U7 = 80;
        R0(80);
    }

    private void H0(g2.q qVar) {
        int[] iArr = new int[2];
        qVar.f28973b.getLocationOnScreen(iArr);
        qVar.f28972a.put(X7, iArr);
    }

    @Override // androidx.transition.a0
    @p0
    public Animator L0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        if (qVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) qVar2.f28972a.get(X7);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return x.a(view, qVar2, iArr[0], iArr[1], this.T7.b(viewGroup, view), this.T7.a(viewGroup, view), translationX, translationY, V7, this);
    }

    @Override // androidx.transition.a0
    @p0
    public Animator N0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        if (qVar == null) {
            return null;
        }
        int[] iArr = (int[]) qVar.f28972a.get(X7);
        return x.a(view, qVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.T7.b(viewGroup, view), this.T7.a(viewGroup, view), W7, this);
    }

    public int Q0() {
        return this.U7;
    }

    public void R0(int i10) {
        if (i10 == 3) {
            this.T7 = Y7;
        } else if (i10 == 5) {
            this.T7 = f7915b8;
        } else if (i10 == 48) {
            this.T7 = f7914a8;
        } else if (i10 == 80) {
            this.T7 = f7917d8;
        } else if (i10 == 8388611) {
            this.T7 = Z7;
        } else {
            if (i10 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.T7 = f7916c8;
        }
        this.U7 = i10;
        g2.o oVar = new g2.o();
        oVar.k(i10);
        D0(oVar);
    }

    @Override // androidx.transition.a0, androidx.transition.q
    public void j(@n0 g2.q qVar) {
        super.j(qVar);
        H0(qVar);
    }

    @Override // androidx.transition.a0, androidx.transition.q
    public void m(@n0 g2.q qVar) {
        super.m(qVar);
        H0(qVar);
    }

    public o(int i10) {
        this.T7 = f7917d8;
        this.U7 = 80;
        R0(i10);
    }

    @SuppressLint({"RestrictedApi"})
    public o(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T7 = f7917d8;
        this.U7 = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7925h);
        int iK = j0.n.k(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        R0(iK);
    }
}
