package h2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import g.n0;
import g.p0;
import g.v;
import g.v0;
import h2.b;
import j0.n;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class c extends h implements h2.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f30278i = "AnimatedVDCompat";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f30279j = "animated-vector";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f30280k = "target";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f30281l = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0358c f30282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f30283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f30284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f30285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator.AnimatorListener f30286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<b.a> f30287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable.Callback f30288h;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            c.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f30287g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((b.a) arrayList.get(i10)).b(c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f30287g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((b.a) arrayList.get(i10)).c(c.this);
            }
        }
    }

    /* JADX INFO: renamed from: h2.c$c, reason: collision with other inner class name */
    public static class C0358c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f30292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AnimatorSet f30293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f30294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.collection.a<Animator, String> f30295e;

        public C0358c(Context context, C0358c c0358c, Drawable.Callback callback, Resources resources) {
            if (c0358c != null) {
                this.f30291a = c0358c.f30291a;
                i iVar = c0358c.f30292b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f30292b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f30292b = (i) constantState.newDrawable();
                    }
                    i iVar2 = (i) this.f30292b.mutate();
                    this.f30292b = iVar2;
                    iVar2.setCallback(callback);
                    this.f30292b.setBounds(c0358c.f30292b.getBounds());
                    this.f30292b.m(false);
                }
                ArrayList<Animator> arrayList = c0358c.f30294d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f30294d = new ArrayList<>(size);
                    this.f30295e = new androidx.collection.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = c0358c.f30294d.get(i10);
                        Animator animatorClone = animator.clone();
                        String str = c0358c.f30295e.get(animator);
                        animatorClone.setTarget(this.f30292b.h(str));
                        this.f30294d.add(animatorClone);
                        this.f30295e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f30293c == null) {
                this.f30293c = new AnimatorSet();
            }
            this.f30293c.playTogether(this.f30294d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f30291a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public c() {
        this(null, null, null);
    }

    public static void a(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((c) drawable).d();
            }
        }
    }

    @p0
    public static c e(@n0 Context context, @v int i10) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            c cVar = new c(context);
            Drawable drawableG = j0.i.g(context.getResources(), i10, context.getTheme());
            cVar.f30313a = drawableG;
            drawableG.setCallback(cVar.f30288h);
            cVar.f30285e = new d(cVar.f30313a.getConstantState());
            return cVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i10);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return f(context, context.getResources(), xml, attributeSetAsAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    public static c f(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public static void g(Drawable drawable, b.a aVar) {
        if (drawable == null || aVar == null || !(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            h((AnimatedVectorDrawable) drawable, aVar);
        } else {
            ((c) drawable).c(aVar);
        }
    }

    @v0(23)
    public static void h(@n0 AnimatedVectorDrawable animatedVectorDrawable, @n0 b.a aVar) {
        animatedVectorDrawable.registerAnimationCallback(aVar.a());
    }

    public static boolean l(Drawable drawable, b.a aVar) {
        if (drawable == null || aVar == null || !(drawable instanceof Animatable)) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 24 ? m((AnimatedVectorDrawable) drawable, aVar) : ((c) drawable).b(aVar);
    }

    @v0(23)
    public static boolean m(AnimatedVectorDrawable animatedVectorDrawable, b.a aVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(aVar.a());
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.a(drawable, theme);
        }
    }

    @Override // h2.b
    public boolean b(@n0 b.a aVar) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            m((AnimatedVectorDrawable) drawable, aVar);
        }
        ArrayList<b.a> arrayList = this.f30287g;
        if (arrayList == null || aVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(aVar);
        if (this.f30287g.size() == 0) {
            i();
        }
        return zRemove;
    }

    @Override // h2.b
    public void c(@n0 b.a aVar) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        if (this.f30287g == null) {
            this.f30287g = new ArrayList<>();
        }
        if (this.f30287g.contains(aVar)) {
            return;
        }
        this.f30287g.add(aVar);
        if (this.f30286f == null) {
            this.f30286f = new b();
        }
        this.f30282b.f30293c.addListener(this.f30286f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            return n0.c.b(drawable);
        }
        return false;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // h2.b
    public void d() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        i();
        ArrayList<b.a> arrayList = this.f30287g;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f30282b.f30292b.draw(canvas);
        if (this.f30282b.f30293c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f30313a;
        return drawable != null ? n0.c.d(drawable) : this.f30282b.f30292b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f30282b.f30291a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f30313a;
        return drawable != null ? n0.c.e(drawable) : this.f30282b.f30292b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f30313a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.f30313a.getConstantState());
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f30282b.f30292b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f30282b.f30292b.getIntrinsicWidth();
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getOpacity() : this.f30282b.f30292b.getOpacity();
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final void i() {
        Animator.AnimatorListener animatorListener = this.f30286f;
        if (animatorListener != null) {
            this.f30282b.f30293c.removeListener(animatorListener);
            this.f30286f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (f30279j.equals(name)) {
                    TypedArray typedArrayS = n.s(resources, theme, attributeSet, h2.a.M);
                    int resourceId = typedArrayS.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i iVarE = i.e(resources, resourceId, theme);
                        iVarE.m(false);
                        iVarE.setCallback(this.f30288h);
                        i iVar = this.f30282b.f30292b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f30282b.f30292b = iVarE;
                    }
                    typedArrayS.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, h2.a.O);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f30283c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        j(string, e.j(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f30282b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f30313a;
        return drawable != null ? n0.c.h(drawable) : this.f30282b.f30292b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f30313a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f30282b.f30293c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.isStateful() : this.f30282b.f30292b.isStateful();
    }

    public final void j(String str, Animator animator) {
        animator.setTarget(this.f30282b.f30292b.h(str));
        C0358c c0358c = this.f30282b;
        if (c0358c.f30294d == null) {
            c0358c.f30294d = new ArrayList<>();
            this.f30282b.f30295e = new androidx.collection.a<>();
        }
        this.f30282b.f30294d.add(animator);
        this.f30282b.f30295e.put(animator, str);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final void k(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                k(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f30284d == null) {
                    this.f30284d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f30284d);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f30282b.f30292b.setBounds(rect);
        }
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.setLevel(i10) : this.f30282b.f30292b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.setState(iArr) : this.f30282b.f30292b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f30282b.f30292b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.j(drawable, z10);
        } else {
            this.f30282b.f30292b.setAutoMirrored(z10);
        }
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTint(int i10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.n(drawable, i10);
        } else {
            this.f30282b.f30292b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.o(drawable, colorStateList);
        } else {
            this.f30282b.f30292b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.p(drawable, mode);
        } else {
            this.f30282b.f30292b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f30282b.f30292b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f30282b.f30293c.isStarted()) {
                return;
            }
            this.f30282b.f30293c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f30282b.f30293c.end();
        }
    }

    public c(@p0 Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f30282b.f30292b.setColorFilter(colorFilter);
        }
    }

    @v0(24)
    public static class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f30296a;

        public d(Drawable.ConstantState constantState) {
            this.f30296a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f30296a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f30296a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f30296a.newDrawable();
            cVar.f30313a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f30288h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f30296a.newDrawable(resources);
            cVar.f30313a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f30288h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f30296a.newDrawable(resources, theme);
            cVar.f30313a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f30288h);
            return cVar;
        }
    }

    public c(@p0 Context context, @p0 C0358c c0358c, @p0 Resources resources) {
        this.f30284d = null;
        this.f30286f = null;
        this.f30287g = null;
        a aVar = new a();
        this.f30288h = aVar;
        this.f30283c = context;
        if (c0358c != null) {
            this.f30282b = c0358c;
        } else {
            this.f30282b = new C0358c(context, c0358c, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
