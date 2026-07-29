package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.c1;
import g.d1;
import g.e1;
import g.f;
import g.k1;
import g.l;
import g.n0;
import g.p0;
import g.r;
import g.s0;
import ie.c;
import ie.d;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BadgeState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19556f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f19557g = "badge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f19558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final State f19559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f19560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f19561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f19562e;

    public BadgeState(Context context, @k1 int i10, @f int i11, @d1 int i12, @p0 State state) {
        State state2 = new State();
        this.f19559b = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            state.f19565a = i10;
        }
        TypedArray typedArrayB = b(context, state.f19565a, i11, i12);
        Resources resources = context.getResources();
        this.f19560c = typedArrayB.getDimensionPixelSize(R.styleable.Badge_badgeRadius, resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius));
        this.f19562e = typedArrayB.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.f19561d = typedArrayB.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius));
        state2.f19568d = state.f19568d == -2 ? 255 : state.f19568d;
        state2.f19572h = state.f19572h == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : state.f19572h;
        state2.f19573i = state.f19573i == 0 ? R.plurals.mtrl_badge_content_description : state.f19573i;
        state2.f19574j = state.f19574j == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : state.f19574j;
        state2.f19576l = Boolean.valueOf(state.f19576l == null || state.f19576l.booleanValue());
        state2.f19570f = state.f19570f == -2 ? typedArrayB.getInt(R.styleable.Badge_maxCharacterCount, 4) : state.f19570f;
        if (state.f19569e != -2) {
            state2.f19569e = state.f19569e;
        } else {
            int i13 = R.styleable.Badge_number;
            if (typedArrayB.hasValue(i13)) {
                state2.f19569e = typedArrayB.getInt(i13, 0);
            } else {
                state2.f19569e = -1;
            }
        }
        state2.f19566b = Integer.valueOf(state.f19566b == null ? v(context, typedArrayB, R.styleable.Badge_backgroundColor) : state.f19566b.intValue());
        if (state.f19567c != null) {
            state2.f19567c = state.f19567c;
        } else {
            int i14 = R.styleable.Badge_badgeTextColor;
            if (typedArrayB.hasValue(i14)) {
                state2.f19567c = Integer.valueOf(v(context, typedArrayB, i14));
            } else {
                state2.f19567c = Integer.valueOf(new d(context, R.style.TextAppearance_MaterialComponents_Badge).i().getDefaultColor());
            }
        }
        state2.f19575k = Integer.valueOf(state.f19575k == null ? typedArrayB.getInt(R.styleable.Badge_badgeGravity, 8388661) : state.f19575k.intValue());
        state2.f19577m = Integer.valueOf(state.f19577m == null ? typedArrayB.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0) : state.f19577m.intValue());
        state2.f19578n = Integer.valueOf(state.f19578n == null ? typedArrayB.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0) : state.f19578n.intValue());
        state2.f19579o = Integer.valueOf(state.f19579o == null ? typedArrayB.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, state2.f19577m.intValue()) : state.f19579o.intValue());
        state2.f19580p = Integer.valueOf(state.f19580p == null ? typedArrayB.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, state2.f19578n.intValue()) : state.f19580p.intValue());
        state2.f19581q = Integer.valueOf(state.f19581q == null ? 0 : state.f19581q.intValue());
        state2.f19582r = Integer.valueOf(state.f19582r != null ? state.f19582r.intValue() : 0);
        typedArrayB.recycle();
        if (state.f19571g == null) {
            state2.f19571g = Build.VERSION.SDK_INT >= 24 ? Locale.getDefault(Locale.Category.FORMAT) : Locale.getDefault();
        } else {
            state2.f19571g = state.f19571g;
        }
        this.f19558a = state;
    }

    public static int v(Context context, @n0 TypedArray typedArray, @e1 int i10) {
        return c.a(context, typedArray, i10).getDefaultColor();
    }

    public void A(int i10) {
        this.f19558a.f19575k = Integer.valueOf(i10);
        this.f19559b.f19575k = Integer.valueOf(i10);
    }

    public void B(@l int i10) {
        this.f19558a.f19567c = Integer.valueOf(i10);
        this.f19559b.f19567c = Integer.valueOf(i10);
    }

    public void C(@c1 int i10) {
        this.f19558a.f19574j = i10;
        this.f19559b.f19574j = i10;
    }

    public void D(CharSequence charSequence) {
        this.f19558a.f19572h = charSequence;
        this.f19559b.f19572h = charSequence;
    }

    public void E(@s0 int i10) {
        this.f19558a.f19573i = i10;
        this.f19559b.f19573i = i10;
    }

    public void F(@r(unit = 1) int i10) {
        this.f19558a.f19579o = Integer.valueOf(i10);
        this.f19559b.f19579o = Integer.valueOf(i10);
    }

    public void G(@r(unit = 1) int i10) {
        this.f19558a.f19577m = Integer.valueOf(i10);
        this.f19559b.f19577m = Integer.valueOf(i10);
    }

    public void H(int i10) {
        this.f19558a.f19570f = i10;
        this.f19559b.f19570f = i10;
    }

    public void I(int i10) {
        this.f19558a.f19569e = i10;
        this.f19559b.f19569e = i10;
    }

    public void J(Locale locale) {
        this.f19558a.f19571g = locale;
        this.f19559b.f19571g = locale;
    }

    public void K(@r(unit = 1) int i10) {
        this.f19558a.f19580p = Integer.valueOf(i10);
        this.f19559b.f19580p = Integer.valueOf(i10);
    }

    public void L(@r(unit = 1) int i10) {
        this.f19558a.f19578n = Integer.valueOf(i10);
        this.f19559b.f19578n = Integer.valueOf(i10);
    }

    public void M(boolean z10) {
        this.f19558a.f19576l = Boolean.valueOf(z10);
        this.f19559b.f19576l = Boolean.valueOf(z10);
    }

    public void a() {
        I(-1);
    }

    public final TypedArray b(Context context, @k1 int i10, @f int i11, @d1 int i12) {
        AttributeSet attributeSet;
        int styleAttribute;
        if (i10 != 0) {
            AttributeSet attributeSetG = yd.a.g(context, i10, f19557g);
            styleAttribute = attributeSetG.getStyleAttribute();
            attributeSet = attributeSetG;
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        return t.k(context, attributeSet, R.styleable.Badge, i11, styleAttribute == 0 ? i12 : styleAttribute, new int[0]);
    }

    @r(unit = 1)
    public int c() {
        return this.f19559b.f19581q.intValue();
    }

    @r(unit = 1)
    public int d() {
        return this.f19559b.f19582r.intValue();
    }

    public int e() {
        return this.f19559b.f19568d;
    }

    @l
    public int f() {
        return this.f19559b.f19566b.intValue();
    }

    public int g() {
        return this.f19559b.f19575k.intValue();
    }

    @l
    public int h() {
        return this.f19559b.f19567c.intValue();
    }

    @c1
    public int i() {
        return this.f19559b.f19574j;
    }

    public CharSequence j() {
        return this.f19559b.f19572h;
    }

    @s0
    public int k() {
        return this.f19559b.f19573i;
    }

    @r(unit = 1)
    public int l() {
        return this.f19559b.f19579o.intValue();
    }

    @r(unit = 1)
    public int m() {
        return this.f19559b.f19577m.intValue();
    }

    public int n() {
        return this.f19559b.f19570f;
    }

    public int o() {
        return this.f19559b.f19569e;
    }

    public Locale p() {
        return this.f19559b.f19571g;
    }

    public State q() {
        return this.f19558a;
    }

    @r(unit = 1)
    public int r() {
        return this.f19559b.f19580p.intValue();
    }

    @r(unit = 1)
    public int s() {
        return this.f19559b.f19578n.intValue();
    }

    public boolean t() {
        return this.f19559b.f19569e != -1;
    }

    public boolean u() {
        return this.f19559b.f19576l.booleanValue();
    }

    public void w(@r(unit = 1) int i10) {
        this.f19558a.f19581q = Integer.valueOf(i10);
        this.f19559b.f19581q = Integer.valueOf(i10);
    }

    public void x(@r(unit = 1) int i10) {
        this.f19558a.f19582r = Integer.valueOf(i10);
        this.f19559b.f19582r = Integer.valueOf(i10);
    }

    public void y(int i10) {
        this.f19558a.f19568d = i10;
        this.f19559b.f19568d = i10;
    }

    public void z(@l int i10) {
        this.f19558a.f19566b = Integer.valueOf(i10);
        this.f19559b.f19566b = Integer.valueOf(i10);
    }

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f19563s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f19564t = -2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k1
        public int f19565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public Integer f19566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public Integer f19567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19569e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19570f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Locale f19571g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public CharSequence f19572h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @s0
        public int f19573i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @c1
        public int f19574j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f19575k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Boolean f19576l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @r(unit = 1)
        public Integer f19577m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @r(unit = 1)
        public Integer f19578n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @r(unit = 1)
        public Integer f19579o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @r(unit = 1)
        public Integer f19580p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @r(unit = 1)
        public Integer f19581q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @r(unit = 1)
        public Integer f19582r;

        public class a implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(@n0 Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
            this.f19568d = 255;
            this.f19569e = -2;
            this.f19570f = -2;
            this.f19576l = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            parcel.writeInt(this.f19565a);
            parcel.writeSerializable(this.f19566b);
            parcel.writeSerializable(this.f19567c);
            parcel.writeInt(this.f19568d);
            parcel.writeInt(this.f19569e);
            parcel.writeInt(this.f19570f);
            CharSequence charSequence = this.f19572h;
            parcel.writeString(charSequence == null ? null : charSequence.toString());
            parcel.writeInt(this.f19573i);
            parcel.writeSerializable(this.f19575k);
            parcel.writeSerializable(this.f19577m);
            parcel.writeSerializable(this.f19578n);
            parcel.writeSerializable(this.f19579o);
            parcel.writeSerializable(this.f19580p);
            parcel.writeSerializable(this.f19581q);
            parcel.writeSerializable(this.f19582r);
            parcel.writeSerializable(this.f19576l);
            parcel.writeSerializable(this.f19571g);
        }

        public State(@n0 Parcel parcel) {
            this.f19568d = 255;
            this.f19569e = -2;
            this.f19570f = -2;
            this.f19576l = Boolean.TRUE;
            this.f19565a = parcel.readInt();
            this.f19566b = (Integer) parcel.readSerializable();
            this.f19567c = (Integer) parcel.readSerializable();
            this.f19568d = parcel.readInt();
            this.f19569e = parcel.readInt();
            this.f19570f = parcel.readInt();
            this.f19572h = parcel.readString();
            this.f19573i = parcel.readInt();
            this.f19575k = (Integer) parcel.readSerializable();
            this.f19577m = (Integer) parcel.readSerializable();
            this.f19578n = (Integer) parcel.readSerializable();
            this.f19579o = (Integer) parcel.readSerializable();
            this.f19580p = (Integer) parcel.readSerializable();
            this.f19581q = (Integer) parcel.readSerializable();
            this.f19582r = (Integer) parcel.readSerializable();
            this.f19576l = (Boolean) parcel.readSerializable();
            this.f19571g = (Locale) parcel.readSerializable();
        }
    }
}
