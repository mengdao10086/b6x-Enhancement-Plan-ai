package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import g.n0;
import g.p0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends q {
    public static final String P7 = "android:changeBounds:bounds";
    public static final String Q7 = "android:changeBounds:clip";
    public static final String R7 = "android:changeBounds:parent";
    public static final String S7 = "android:changeBounds:windowX";
    public static final String T7 = "android:changeBounds:windowY";
    public static final String[] U7 = {P7, Q7, R7, S7, T7};
    public static final Property<Drawable, PointF> V7 = new b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> W7 = new C0074c(PointF.class, "topLeft");
    public static final Property<k, PointF> X7 = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> Y7 = new e(PointF.class, "bottomRight");
    public static final Property<View, PointF> Z7 = new f(PointF.class, "topLeft");

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final Property<View, PointF> f7820a8 = new g(PointF.class, CommonNetImpl.POSITION);

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static g2.n f7821b8 = new g2.n();
    public int[] M7;
    public boolean N7;
    public boolean O7;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f7822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f7823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f7824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f7825d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f7822a = viewGroup;
            this.f7823b = bitmapDrawable;
            this.f7824c = view;
            this.f7825d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g2.z.b(this.f7822a).b(this.f7823b);
            g2.z.h(this.f7824c, this.f7825d);
        }
    }

    public class b extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f7827a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f7827a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f7827a);
            Rect rect = this.f7827a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f7827a);
            this.f7827a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f7827a);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.c$c, reason: collision with other inner class name */
    public class C0074c extends Property<k, PointF> {
        public C0074c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    public class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    public class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            g2.z.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            g2.z.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            g2.z.g(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f7828a;
        private k mViewBounds;

        public h(k kVar) {
            this.f7828a = kVar;
            this.mViewBounds = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f7831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f7832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f7833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f7834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f7835f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f7836g;

        public i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f7831b = view;
            this.f7832c = rect;
            this.f7833d = i10;
            this.f7834e = i11;
            this.f7835f = i12;
            this.f7836g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7830a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f7830a) {
                return;
            }
            u0.M1(this.f7831b, this.f7832c);
            g2.z.g(this.f7831b, this.f7833d, this.f7834e, this.f7835f, this.f7836g);
        }
    }

    public class j extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7838a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f7839b;

        public j(ViewGroup viewGroup) {
            this.f7839b = viewGroup;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void b(@n0 q qVar) {
            g2.v.d(this.f7839b, false);
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            if (!this.f7838a) {
                g2.v.d(this.f7839b, false);
            }
            qVar.p0(this);
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void d(@n0 q qVar) {
            g2.v.d(this.f7839b, false);
            this.f7838a = true;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void e(@n0 q qVar) {
            g2.v.d(this.f7839b, true);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f7845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7846f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7847g;

        public k(View view) {
            this.f7845e = view;
        }

        public void a(PointF pointF) {
            this.f7843c = Math.round(pointF.x);
            this.f7844d = Math.round(pointF.y);
            int i10 = this.f7847g + 1;
            this.f7847g = i10;
            if (this.f7846f == i10) {
                b();
            }
        }

        public final void b() {
            g2.z.g(this.f7845e, this.f7841a, this.f7842b, this.f7843c, this.f7844d);
            this.f7846f = 0;
            this.f7847g = 0;
        }

        public void c(PointF pointF) {
            this.f7841a = Math.round(pointF.x);
            this.f7842b = Math.round(pointF.y);
            int i10 = this.f7846f + 1;
            this.f7846f = i10;
            if (i10 == this.f7847g) {
                b();
            }
        }
    }

    public c() {
        this.M7 = new int[2];
        this.N7 = false;
        this.O7 = false;
    }

    public final void H0(g2.q qVar) {
        View view = qVar.f28973b;
        if (!u0.U0(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        qVar.f28972a.put(P7, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        qVar.f28972a.put(R7, qVar.f28973b.getParent());
        if (this.O7) {
            qVar.f28973b.getLocationInWindow(this.M7);
            qVar.f28972a.put(S7, Integer.valueOf(this.M7[0]));
            qVar.f28972a.put(T7, Integer.valueOf(this.M7[1]));
        }
        if (this.N7) {
            qVar.f28972a.put(Q7, u0.P(view));
        }
    }

    public boolean I0() {
        return this.N7;
    }

    public final boolean J0(View view, View view2) {
        if (!this.O7) {
            return true;
        }
        g2.q qVarK = K(view, true);
        if (qVarK == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == qVarK.f28973b) {
            return true;
        }
        return false;
    }

    public void K0(boolean z10) {
        this.N7 = z10;
    }

    @Override // androidx.transition.q
    @n0
    public String[] a0() {
        return U7;
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        int i10;
        View view;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (qVar == null || qVar2 == null) {
            return null;
        }
        Map<String, Object> map = qVar.f28972a;
        Map<String, Object> map2 = qVar2.f28972a;
        ViewGroup viewGroup2 = (ViewGroup) map.get(R7);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(R7);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = qVar2.f28973b;
        if (!J0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) qVar.f28972a.get(S7)).intValue();
            int iIntValue2 = ((Integer) qVar.f28972a.get(T7)).intValue();
            int iIntValue3 = ((Integer) qVar2.f28972a.get(S7)).intValue();
            int iIntValue4 = ((Integer) qVar2.f28972a.get(T7)).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.M7);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = g2.z.c(view2);
            g2.z.h(view2, 0.0f);
            g2.z.b(viewGroup).a(bitmapDrawable);
            g2.k kVarN = N();
            int[] iArr = this.M7;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, g2.m.a(V7, kVarN.a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) qVar.f28972a.get(P7);
        Rect rect3 = (Rect) qVar2.f28972a.get(P7);
        int i12 = rect2.left;
        int i13 = rect3.left;
        int i14 = rect2.top;
        int i15 = rect3.top;
        int i16 = rect2.right;
        int i17 = rect3.right;
        int i18 = rect2.bottom;
        int i19 = rect3.bottom;
        int i20 = i16 - i12;
        int i21 = i18 - i14;
        int i22 = i17 - i13;
        int i23 = i19 - i15;
        Rect rect4 = (Rect) qVar.f28972a.get(Q7);
        Rect rect5 = (Rect) qVar2.f28972a.get(Q7);
        if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
            i10 = 0;
        } else {
            i10 = (i12 == i13 && i14 == i15) ? 0 : 1;
            if (i16 != i17 || i18 != i19) {
                i10++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        if (i10 <= 0) {
            return null;
        }
        if (this.N7) {
            view = view2;
            g2.z.g(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
            ObjectAnimator objectAnimatorA = (i12 == i13 && i14 == i15) ? null : g2.j.a(view, f7820a8, N().a(i12, i14, i13, i15));
            if (rect4 == null) {
                i11 = 0;
                rect = new Rect(0, 0, i20, i21);
            } else {
                i11 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i11, i11, i22, i23) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                u0.M1(view, rect);
                g2.n nVar = f7821b8;
                Object[] objArr = new Object[2];
                objArr[i11] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", nVar, objArr);
                objectAnimatorOfObject.addListener(new i(view, rect5, i13, i15, i17, i19));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = w.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            g2.z.g(view, i12, i14, i16, i18);
            if (i10 != 2) {
                animatorC = (i12 == i13 && i14 == i15) ? g2.j.a(view, Y7, N().a(i16, i18, i17, i19)) : g2.j.a(view, Z7, N().a(i12, i14, i13, i15));
            } else if (i20 == i22 && i21 == i23) {
                animatorC = g2.j.a(view, f7820a8, N().a(i12, i14, i13, i15));
            } else {
                k kVar = new k(view);
                ObjectAnimator objectAnimatorA2 = g2.j.a(kVar, W7, N().a(i12, i14, i13, i15));
                ObjectAnimator objectAnimatorA3 = g2.j.a(kVar, X7, N().a(i16, i18, i17, i19));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new h(kVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            g2.v.d(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return animatorC;
    }

    @SuppressLint({"RestrictedApi"})
    public c(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M7 = new int[2];
        this.N7 = false;
        this.O7 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7921d);
        boolean zE = j0.n.e(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        K0(zE);
    }
}
