package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.b;
import androidx.appcompat.resources.R;
import g.n0;
import g.p0;
import g.v0;
import j.a;
import j0.n;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class e extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f1829r = "StateListDrawable";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f1830s = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f1831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1832q;

    public static class a extends b.d {
        public int[][] J;

        public a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[g()][];
            }
        }

        public int D(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.J[iA] = iArr;
            return iA;
        }

        public int E(int[] iArr) {
            int[][] iArr2 = this.J;
            int i10 = i();
            for (int i11 = 0; i11 < i10; i11++) {
                if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                    return i11;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            return new e(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.b.d
        public void r(int i10, int i11) {
            super.r(i10, i11);
            int[][] iArr = new int[i11][];
            System.arraycopy(this.J, 0, iArr, 0, i10);
            this.J = iArr;
        }

        @Override // androidx.appcompat.graphics.drawable.b.d
        public void v() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    public e() {
        this(null, null);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @v0(21)
    public void applyTheme(@n0 Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public void b() {
        super.b();
        this.f1832q = false;
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public void i(@n0 b.d dVar) {
        super.i(dVar);
        if (dVar instanceof a) {
            this.f1831p = (a) dVar;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @n0
    public Drawable mutate() {
        if (!this.f1832q && super.mutate() == this) {
            this.f1831p.v();
            this.f1832q = true;
        }
        return this;
    }

    public void n(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.f1831p.D(iArr, drawable);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public a o() {
        return new a(this.f1831p, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean onStateChange(@n0 int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iE = this.f1831p.E(iArr);
        if (iE < 0) {
            iE = this.f1831p.E(StateSet.WILD_CARD);
        }
        return h(iE) || zOnStateChange;
    }

    public int[] p(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i10 = 0;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i12 = i10 + 1;
                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i10] = attributeNameResource;
                i10 = i12;
            }
        }
        return StateSet.trimStateSet(iArr, i10);
    }

    int q() {
        return this.f1831p.i();
    }

    Drawable r(int i10) {
        return this.f1831p.h(i10);
    }

    public int s(int[] iArr) {
        return this.f1831p.E(iArr);
    }

    public a t() {
        return this.f1831p;
    }

    int[] u(int i10) {
        return this.f1831p.J[i10];
    }

    public void v(@n0 Context context, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayS = n.s(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(typedArrayS.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        x(typedArrayS);
        m(resources);
        typedArrayS.recycle();
        w(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public final void w(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.f1831p;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = n.s(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = typedArrayS.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable drawableJ = resourceId > 0 ? androidx.appcompat.widget.n0.h().j(context, resourceId) : null;
                typedArrayS.recycle();
                int[] iArrP = p(attributeSet);
                if (drawableJ == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + androidx.appcompat.graphics.drawable.a.D);
                    }
                    drawableJ = a.c.a(resources, xmlPullParser, attributeSet, theme);
                }
                aVar.D(iArrP, drawableJ);
            }
        }
    }

    public final void x(TypedArray typedArray) {
        a aVar = this.f1831p;
        aVar.f1788d |= a.c.b(typedArray);
        aVar.f1793i = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f1793i);
        aVar.f1796l = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f1796l);
        aVar.A = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.A);
        aVar.B = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.B);
        aVar.f1808x = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f1808x);
    }

    public e(a aVar, Resources resources) {
        i(new a(aVar, this, resources));
        onStateChange(getState());
    }

    public e(@p0 a aVar) {
        if (aVar != null) {
            i(aVar);
        }
    }
}
