package a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class er extends as {

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f782c = new int[2];

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f783e = false;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f784f = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f781a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Property<Drawable, PointF> f780a = new uq(PointF.class, "boundsOrigin");
    public static final Property<dr, PointF> b = new vq(PointF.class, "topLeft");
    public static final Property<dr, PointF> c = new wq(PointF.class, "bottomRight");
    public static final Property<View, PointF> d = new xq(PointF.class, "bottomRight");
    public static final Property<View, PointF> e = new yq(PointF.class, "topLeft");
    public static final Property<View, PointF> f = new zq(PointF.class, "position");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static sr f6032a = new sr();

    @Override // a.as
    public String[] D() {
        return f781a;
    }

    public final void c0(ks ksVar) {
        View view = ksVar.f6635a;
        if (!eh.Q(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        ksVar.f1686a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        ksVar.f1686a.put("android:changeBounds:parent", ksVar.f6635a.getParent());
        if (this.f784f) {
            ksVar.f6635a.getLocationInWindow(this.f782c);
            ksVar.f1686a.put("android:changeBounds:windowX", Integer.valueOf(this.f782c[0]));
            ksVar.f1686a.put("android:changeBounds:windowY", Integer.valueOf(this.f782c[1]));
        }
        if (this.f783e) {
            ksVar.f1686a.put("android:changeBounds:clip", eh.r(view));
        }
    }

    public final boolean d0(View view, View view2) {
        if (!this.f784f) {
            return true;
        }
        ks ksVarT = t(view, true);
        if (ksVarT == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == ksVarT.f6635a) {
            return true;
        }
        return false;
    }

    @Override // a.as
    public void g(ks ksVar) {
        c0(ksVar);
    }

    @Override // a.as
    public void j(ks ksVar) {
        c0(ksVar);
    }

    @Override // a.as
    public Animator n(ViewGroup viewGroup, ks ksVar, ks ksVar2) {
        int i;
        View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        Path pathA;
        Property<View, PointF> property;
        if (ksVar == null || ksVar2 == null) {
            return null;
        }
        Map<String, Object> map = ksVar.f1686a;
        Map<String, Object> map2 = ksVar2.f1686a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = ksVar2.f6635a;
        if (!d0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) ksVar.f1686a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) ksVar.f1686a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) ksVar2.f1686a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) ksVar2.f1686a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f782c);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = ys.c(view2);
            ys.g(view2, 0.0f);
            ys.b(viewGroup).a(bitmapDrawable);
            or orVarV = v();
            int[] iArr = this.f782c;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, qr.a(f780a, orVarV.a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
            objectAnimatorOfPropertyValuesHolder.addListener(new tq(this, viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) ksVar.f1686a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) ksVar2.f1686a.get("android:changeBounds:bounds");
        int i3 = rect2.left;
        int i4 = rect3.left;
        int i5 = rect2.top;
        int i6 = rect3.top;
        int i7 = rect2.right;
        int i8 = rect3.right;
        int i9 = rect2.bottom;
        int i10 = rect3.bottom;
        int i11 = i7 - i3;
        int i12 = i9 - i5;
        int i13 = i8 - i4;
        int i14 = i10 - i6;
        Rect rect4 = (Rect) ksVar.f1686a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) ksVar2.f1686a.get("android:changeBounds:clip");
        if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
            i = 0;
        } else {
            i = (i3 == i4 && i5 == i6) ? 0 : 1;
            if (i7 != i8 || i9 != i10) {
                i++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i++;
        }
        if (i <= 0) {
            return null;
        }
        if (this.f783e) {
            view = view2;
            ys.f(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
            ObjectAnimator objectAnimatorA = (i3 == i4 && i5 == i6) ? null : nr.a(view, f, v().a(i3, i5, i4, i6));
            if (rect4 == null) {
                i2 = 0;
                rect = new Rect(0, 0, i11, i12);
            } else {
                i2 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                eh.p0(view, rect);
                sr srVar = f6032a;
                Object[] objArr = new Object[2];
                objArr[i2] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", srVar, objArr);
                objectAnimatorOfObject.addListener(new br(this, view, rect5, i4, i6, i8, i10));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = js.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            ys.f(view, i3, i5, i7, i9);
            if (i == 2) {
                if (i11 == i13 && i12 == i14) {
                    pathA = v().a(i3, i5, i4, i6);
                    property = f;
                } else {
                    dr drVar = new dr(view);
                    ObjectAnimator objectAnimatorA2 = nr.a(drVar, b, v().a(i3, i5, i4, i6));
                    ObjectAnimator objectAnimatorA3 = nr.a(drVar, c, v().a(i7, i9, i8, i10));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                    animatorSet.addListener(new ar(this, drVar));
                    animatorC = animatorSet;
                }
            } else if (i3 == i4 && i5 == i6) {
                pathA = v().a(i7, i9, i8, i10);
                property = d;
            } else {
                pathA = v().a(i3, i5, i4, i6);
                property = e;
            }
            animatorC = nr.a(view, property, pathA);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            ps.c(viewGroup4, true);
            a(new cr(this, viewGroup4));
        }
        return animatorC;
    }
}
