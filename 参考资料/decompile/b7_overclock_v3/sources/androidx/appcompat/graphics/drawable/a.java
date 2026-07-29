package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.b;
import androidx.appcompat.graphics.drawable.e;
import androidx.appcompat.resources.R;
import androidx.collection.h;
import androidx.collection.m;
import androidx.core.util.j;
import g.l;
import g.n0;
import g.p0;
import g.v;
import g.v0;
import j.a;
import j0.n;
import java.io.IOException;
import n0.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class a extends androidx.appcompat.graphics.drawable.e implements i {
    public static final String A = "item";
    public static final String B = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    public static final String C = ": <transition> tag requires 'fromId' & 'toId' attributes";
    public static final String D = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f1754y = a.class.getSimpleName();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f1755z = "transition";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f1756t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g f1757u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1758v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1759w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1760x;

    public static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animatable f1761a;

        public b(Animatable animatable) {
            super();
            this.f1761a = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f1761a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f1761a.stop();
        }
    }

    public static class c extends e.a {
        public static final long M = 4294967296L;
        public static final long N = 8589934592L;
        public h<Long> K;
        public m<Integer> L;

        public c(@p0 c cVar, @n0 a aVar, @p0 Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new h<>();
                this.L = new m<>();
            }
        }

        public static long H(int i10, int i11) {
            return ((long) i11) | (((long) i10) << 32);
        }

        public int F(@n0 int[] iArr, @n0 Drawable drawable, int i10) {
            int iD = super.D(iArr, drawable);
            this.L.n(iD, Integer.valueOf(i10));
            return iD;
        }

        public int G(int i10, int i11, @n0 Drawable drawable, boolean z10) {
            int iA = super.a(drawable);
            long jH = H(i10, i11);
            long j10 = z10 ? 8589934592L : 0L;
            long j11 = iA;
            this.K.a(jH, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.a(H(i11, i10), Long.valueOf(4294967296L | j11 | j10));
            }
            return iA;
        }

        public int I(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return this.L.i(i10, 0).intValue();
        }

        public int J(@n0 int[] iArr) {
            int iE = super.E(iArr);
            return iE >= 0 ? iE : super.E(StateSet.WILD_CARD);
        }

        public int K(int i10, int i11) {
            return (int) this.K.i(H(i10, i11), -1L).longValue();
        }

        public boolean L(int i10, int i11) {
            return (this.K.i(H(i10, i11), -1L).longValue() & 4294967296L) != 0;
        }

        public boolean M(int i10, int i11) {
            return (this.K.i(H(i10, i11), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.graphics.drawable.e.a, android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.e.a, androidx.appcompat.graphics.drawable.b.d
        public void v() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.e.a, android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    public static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h2.c f1762a;

        public d(h2.c cVar) {
            super();
            this.f1762a = cVar;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f1762a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f1762a.stop();
        }
    }

    public static class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f1763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1764b;

        public e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i10 = z10 ? numberOfFrames - 1 : 0;
            int i11 = z10 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
            a.b.a(objectAnimatorOfInt, true);
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f1764b = z11;
            this.f1763a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public boolean a() {
            return this.f1764b;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void b() {
            this.f1763a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f1763a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f1763a.cancel();
        }
    }

    public static class f implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f1765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1767c;

        public f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        public int a() {
            return this.f1767c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z10) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1766b = numberOfFrames;
            int[] iArr = this.f1765a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1765a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1765a;
            int i10 = 0;
            for (int i11 = 0; i11 < numberOfFrames; i11++) {
                int duration = animationDrawable.getDuration(z10 ? (numberOfFrames - i11) - 1 : i11);
                iArr2[i11] = duration;
                i10 += duration;
            }
            this.f1767c = i10;
            return i10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            int i10 = (int) ((f10 * this.f1767c) + 0.5f);
            int i11 = this.f1766b;
            int[] iArr = this.f1765a;
            int i12 = 0;
            while (i12 < i11 && i10 >= iArr[i12]) {
                i10 -= iArr[i12];
                i12++;
            }
            return (i12 / i11) + (i12 < i11 ? i10 / this.f1767c : 0.0f);
        }
    }

    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    @p0
    public static a B(@n0 Context context, @v int i10, @p0 Resources.Theme theme) {
        int next;
        try {
            Resources resources = context.getResources();
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C(context, resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    @n0
    public static a C(@n0 Context context, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.v(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void w(@n0 Context context, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    E(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals(f1755z)) {
                    F(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void x(TypedArray typedArray) {
        c cVar = this.f1756t;
        cVar.f1788d |= a.c.b(typedArray);
        cVar.B(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f1793i));
        cVar.x(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f1796l));
        cVar.y(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.z(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f1808x));
    }

    @Override // androidx.appcompat.graphics.drawable.e
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c o() {
        return new c(this.f1756t, this, null);
    }

    public final void D() {
        onStateChange(getState());
    }

    public final int E(@n0 Context context, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = n.s(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableJ = resourceId2 > 0 ? androidx.appcompat.widget.n0.h().j(context, resourceId2) : null;
        typedArrayS.recycle();
        int[] iArrP = p(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + D);
            }
            drawableJ = xmlPullParser.getName().equals(h2.i.f30319p) ? h2.i.f(resources, xmlPullParser, attributeSet, theme) : a.c.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ != null) {
            return this.f1756t.F(iArrP, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + D);
    }

    public final int F(@n0 Context context, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = n.s(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableJ = resourceId3 > 0 ? androidx.appcompat.widget.n0.h().j(context, resourceId3) : null;
        boolean z10 = typedArrayS.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayS.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + B);
            }
            drawableJ = xmlPullParser.getName().equals(h2.c.f30279j) ? h2.c.f(context, resources, xmlPullParser, attributeSet, theme) : a.c.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + B);
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f1756t.G(resourceId, resourceId2, drawableJ, z10);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + C);
    }

    public final boolean G(int i10) {
        int iD;
        int iK;
        g bVar;
        g gVar = this.f1757u;
        if (gVar == null) {
            iD = d();
        } else {
            if (i10 == this.f1758v) {
                return true;
            }
            if (i10 == this.f1759w && gVar.a()) {
                gVar.b();
                this.f1758v = this.f1759w;
                this.f1759w = i10;
                return true;
            }
            iD = this.f1758v;
            gVar.d();
        }
        this.f1757u = null;
        this.f1759w = -1;
        this.f1758v = -1;
        c cVar = this.f1756t;
        int I = cVar.I(iD);
        int I2 = cVar.I(i10);
        if (I2 == 0 || I == 0 || (iK = cVar.K(I, I2)) < 0) {
            return false;
        }
        boolean zM = cVar.M(I, I2);
        h(iK);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.L(I, I2), zM);
        } else {
            if (!(current instanceof h2.c)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((h2.c) current);
        }
        bVar.c();
        this.f1757u = bVar;
        this.f1759w = iD;
        this.f1758v = i10;
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @v0(21)
    public /* bridge */ /* synthetic */ void applyTheme(@n0 Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b
    public void b() {
        super.b();
        this.f1760x = false;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @v0(21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@n0 Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @n0
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@n0 Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @v0(21)
    public /* bridge */ /* synthetic */ void getOutline(@n0 Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@n0 Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b
    public void i(@n0 b.d dVar) {
        super.i(dVar);
        if (dVar instanceof c) {
            this.f1756t = (c) dVar;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@n0 Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f1757u;
        if (gVar != null) {
            gVar.d();
            this.f1757u = null;
            h(this.f1758v);
            this.f1758v = -1;
            this.f1759w = -1;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public /* bridge */ /* synthetic */ void k(int i10) {
        super.k(i10);
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public /* bridge */ /* synthetic */ void l(int i10) {
        super.l(i10);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @n0
    public Drawable mutate() {
        if (!this.f1760x && super.mutate() == this) {
            this.f1756t.v();
            this.f1760x = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.e
    public /* bridge */ /* synthetic */ void n(int[] iArr, Drawable drawable) {
        super.n(iArr, drawable);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i10) {
        return super.onLayoutDirectionChanged(i10);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean onStateChange(@n0 int[] iArr) {
        int iJ = this.f1756t.J(iArr);
        boolean z10 = iJ != d() && (G(iJ) || h(iJ));
        Drawable current = getCurrent();
        return current != null ? z10 | current.setState(iArr) : z10;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable, long j10) {
        super.scheduleDrawable(drawable, runnable, j10);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z10) {
        super.setAutoMirrored(z10);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z10) {
        super.setDither(z10);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable, n0.i
    public /* bridge */ /* synthetic */ void setTint(@l int i10) {
        super.setTint(i10);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable, n0.i
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable, n0.i
    public /* bridge */ /* synthetic */ void setTintMode(@n0 PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.f1757u;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    @Override // androidx.appcompat.graphics.drawable.e
    public void v(@n0 Context context, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayS = n.s(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayS.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        x(typedArrayS);
        m(resources);
        typedArrayS.recycle();
        w(context, resources, xmlPullParser, attributeSet, theme);
        D();
    }

    public void y(@n0 int[] iArr, @n0 Drawable drawable, int i10) {
        j.d(drawable);
        this.f1756t.F(iArr, drawable, i10);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void z(int i10, int i11, @n0 T t10, boolean z10) {
        j.d(t10);
        this.f1756t.G(i10, i11, t10, z10);
    }

    public a(@p0 c cVar, @p0 Resources resources) {
        super(null);
        this.f1758v = -1;
        this.f1759w = -1;
        i(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
