package com.flydigi.base.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.R;
import com.flydigi.base.widget.superlink.SuperLinkTextView;
import com.flydigi.base.widget.superlink.a;
import g.d0;
import g.n0;
import g.p0;
import g.v;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f13419s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f13420t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f13421u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f13422v = 8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f13423w = 300;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final float f13424x = 0.7f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SuperLinkTextView f13425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f13426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f13433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @d0
    public int f13437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @d0
    public int f13438n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13439o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f13440p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SparseBooleanArray f13441q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13442r;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ExpandableTextView.this.clearAnimation();
            ExpandableTextView.this.f13436l = false;
            if (ExpandableTextView.this.f13440p != null) {
                ExpandableTextView.this.f13440p.a(ExpandableTextView.this.f13425a, !r0.f13428d);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            ExpandableTextView.i(expandableTextView.f13425a, expandableTextView.f13435k);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.f13432h = expandableTextView.getHeight() - ExpandableTextView.this.f13425a.getHeight();
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f13445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13447c;

        public c(View view, int i10, int i11) {
            this.f13445a = view;
            this.f13446b = i10;
            this.f13447c = i11;
            setDuration(ExpandableTextView.this.f13434j);
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            int i10 = this.f13447c;
            int i11 = (int) (((i10 - r0) * f10) + this.f13446b);
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.f13425a.setMaxHeight(i11 - expandableTextView.f13432h);
            if (Float.compare(ExpandableTextView.this.f13435k, 1.0f) != 0) {
                ExpandableTextView expandableTextView2 = ExpandableTextView.this;
                ExpandableTextView.i(expandableTextView2.f13425a, expandableTextView2.f13435k + (f10 * (1.0f - ExpandableTextView.this.f13435k)));
            }
            this.f13445a.getLayoutParams().height = i11;
            this.f13445a.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int i10, int i11, int i12, int i13) {
            super.initialize(i10, i11, i12, i13);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public interface d {
        void a(boolean z10);

        void b(View view);
    }

    public static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f13449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f13450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SuperButton f13451c;

        public e(Drawable drawable, Drawable drawable2) {
            this.f13449a = drawable;
            this.f13450b = drawable2;
        }

        @Override // com.flydigi.base.widget.ExpandableTextView.d
        public void a(boolean z10) {
            this.f13451c.setIcon(z10 ? this.f13449a : this.f13450b);
        }

        @Override // com.flydigi.base.widget.ExpandableTextView.d
        public void b(View view) {
            this.f13451c = (SuperButton) view;
        }
    }

    public interface f {
        void a(TextView textView, boolean z10);
    }

    public static class g implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f13453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SuperButton f13454c;

        public g(String str, String str2) {
            this.f13452a = str;
            this.f13453b = str2;
        }

        @Override // com.flydigi.base.widget.ExpandableTextView.d
        public void a(boolean z10) {
            this.f13454c.setText(z10 ? this.f13452a : this.f13453b);
        }

        @Override // com.flydigi.base.widget.ExpandableTextView.d
        public void b(View view) {
            this.f13454c = (SuperButton) view;
        }
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    @TargetApi(11)
    public static void i(View view, float f10) {
        if (n()) {
            view.setAlpha(f10);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f10, f10);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    @TargetApi(21)
    public static Drawable k(@n0 Context context, @v int i10) {
        Resources resources = context.getResources();
        return o() ? resources.getDrawable(i10, context.getTheme()) : resources.getDrawable(i10);
    }

    public static int l(@n0 TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    public static boolean n() {
        return true;
    }

    public static boolean o() {
        return true;
    }

    public static d q(@n0 Context context, TypedArray typedArray) {
        int i10 = typedArray.getInt(R.styleable.ExpandableTextView_expandToggleType, 0);
        if (i10 == 0) {
            Drawable drawable = typedArray.getDrawable(R.styleable.ExpandableTextView_expandIndicator);
            Drawable drawable2 = typedArray.getDrawable(R.styleable.ExpandableTextView_collapseIndicator);
            if (drawable == null) {
                drawable = k(context, R.drawable.ic_expand_more);
            }
            if (drawable2 == null) {
                drawable2 = k(context, R.drawable.ic_expand_less);
            }
            return new e(drawable, drawable2);
        }
        if (i10 != 1) {
            throw new IllegalStateException("Must be of enum: ExpandableTextView_expandToggleType, one of EXPAND_INDICATOR_IMAGE_BUTTON or EXPAND_INDICATOR_TEXT_VIEW.");
        }
        String string = typedArray.getString(R.styleable.ExpandableTextView_expandIndicator);
        String string2 = typedArray.getString(R.styleable.ExpandableTextView_collapseIndicator);
        if (string == null) {
            string = context.getString(R.string.expand);
        }
        if (string2 == null) {
            string2 = context.getString(R.string.collapsed);
        }
        return new g(string, string2);
    }

    @p0
    public CharSequence getText() {
        SuperLinkTextView superLinkTextView = this.f13425a;
        return superLinkTextView == null ? "" : superLinkTextView.getText();
    }

    public final void j() {
        SuperLinkTextView superLinkTextView = (SuperLinkTextView) findViewById(this.f13437m);
        this.f13425a = superLinkTextView;
        if (this.f13439o) {
            superLinkTextView.setOnClickListener(this);
        } else {
            superLinkTextView.setOnClickListener(null);
        }
        View viewFindViewById = findViewById(this.f13438n);
        this.f13426b = viewFindViewById;
        this.f13433i.b(viewFindViewById);
        this.f13433i.a(this.f13428d);
        this.f13426b.setOnClickListener(this);
    }

    public final void m(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.expandabletextview, (ViewGroup) this, true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        this.f13431g = typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_maxCollapsedLines, 8);
        this.f13434j = typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_animDuration, 300);
        this.f13435k = typedArrayObtainStyledAttributes.getFloat(R.styleable.ExpandableTextView_animAlphaStart, 0.7f);
        this.f13437m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_expandableTextId, R.id.expandable_text);
        this.f13438n = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_expandCollapseToggleId, R.id.expand_collapse);
        this.f13439o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_expandToggleOnTextClick, true);
        this.f13433i = q(getContext(), typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13426b.getVisibility() != 0) {
            return;
        }
        boolean z10 = !this.f13428d;
        this.f13428d = z10;
        this.f13433i.a(z10);
        SparseBooleanArray sparseBooleanArray = this.f13441q;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.f13442r, this.f13428d);
        }
        this.f13436l = true;
        c cVar = this.f13428d ? new c(this, getHeight(), this.f13429e) : new c(this, getHeight(), (getHeight() + this.f13430f) - this.f13425a.getHeight());
        cVar.setFillAfter(true);
        cVar.setAnimationListener(new a());
        clearAnimation();
        startAnimation(cVar);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        j();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f13436l;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!this.f13427c || getVisibility() == 8) {
            super.onMeasure(i10, i11);
            return;
        }
        this.f13427c = false;
        this.f13426b.setVisibility(8);
        this.f13425a.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i10, i11);
        this.f13425a.getLineCount();
        if (this.f13425a.getLineCount() <= this.f13431g) {
            return;
        }
        this.f13430f = l(this.f13425a);
        if (this.f13428d) {
            this.f13425a.setMaxLines(this.f13431g);
        }
        this.f13426b.setVisibility(0);
        super.onMeasure(i10, i11);
        if (this.f13428d) {
            this.f13425a.post(new b());
            this.f13429e = getMeasuredHeight();
        }
    }

    public void p(@p0 CharSequence charSequence, @n0 SparseBooleanArray sparseBooleanArray, int i10) {
        this.f13441q = sparseBooleanArray;
        this.f13442r = i10;
        boolean z10 = sparseBooleanArray.get(i10, true);
        clearAnimation();
        this.f13428d = z10;
        this.f13433i.a(z10);
        setText(charSequence);
    }

    public void setMaxCollapsedLines(int i10) {
        this.f13431g = i10;
    }

    public void setOnExpandStateChangeListener(@p0 f fVar) {
        this.f13440p = fVar;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
        }
        super.setOrientation(i10);
    }

    public void setSuperLinkClickListener(a.InterfaceC0134a interfaceC0134a) {
        this.f13425a.setSuperLinkClickListener(interfaceC0134a);
    }

    public void setText(@p0 CharSequence charSequence) {
        this.f13427c = true;
        this.f13425a.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        clearAnimation();
        getLayoutParams().height = -2;
        requestLayout();
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13428d = true;
        this.f13437m = R.id.expandable_text;
        this.f13438n = R.id.expand_collapse;
        m(context, attributeSet);
    }
}
