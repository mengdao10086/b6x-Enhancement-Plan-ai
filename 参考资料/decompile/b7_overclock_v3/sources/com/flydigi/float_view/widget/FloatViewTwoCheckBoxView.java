package com.flydigi.float_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import hk.i;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import w7.l2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FloatViewTwoCheckBoxView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final l2 f15786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public b f15792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public a f15793h;

    public interface a {
        void a(boolean z10);

        void b(boolean z10);
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewTwoCheckBoxView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewTwoCheckBoxView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewTwoCheckBoxView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void h(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f15789d && this$0.f15786a.f54257e.isSelected()) {
            return;
        }
        this$0.f15786a.f54257e.setSelected(!r2.isSelected());
        if (this$0.f15789d) {
            this$0.f15786a.f54259g.setSelected(!r2.isSelected());
        }
        a aVar = this$0.f15793h;
        if (aVar != null) {
            aVar.a(this$0.f15786a.f54257e.isSelected());
        }
    }

    public static final void i(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f15786a.f54257e.performClick();
    }

    public static final void j(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f15789d && this$0.f15786a.f54259g.isSelected()) {
            return;
        }
        this$0.f15786a.f54259g.setSelected(!r2.isSelected());
        if (this$0.f15789d) {
            this$0.f15786a.f54257e.setSelected(!r2.isSelected());
        }
        a aVar = this$0.f15793h;
        if (aVar != null) {
            aVar.b(this$0.f15786a.f54259g.isSelected());
        }
    }

    public static final void k(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f15786a.f54259g.performClick();
    }

    public static final void l(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15792g;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static final void m(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15792g;
        if (bVar != null) {
            bVar.b();
        }
    }

    public static final void n(FloatViewTwoCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15792g;
        if (bVar != null) {
            bVar.c();
        }
    }

    @l
    public final a getOnCheckBoxClickListener$float_view_officialRelease() {
        return this.f15793h;
    }

    @l
    public final b getOnHelpClickListener$float_view_officialRelease() {
        return this.f15792g;
    }

    @k
    public final Pair<Boolean, Boolean> getValue() {
        return new Pair<>(Boolean.valueOf(this.f15786a.f54257e.isSelected()), Boolean.valueOf(this.f15786a.f54259g.isSelected()));
    }

    public final void o() {
        q(this.f15787b, this.f15788c);
    }

    public final void p(boolean z10, boolean z11) {
        this.f15786a.f54257e.setEnabled(z10);
        this.f15786a.f54259g.setEnabled(z11);
        if (z10) {
            ImageButton imageButton = this.f15786a.f54257e;
            f0.o(imageButton, "viewBinding.ivCheckbox1");
            Boolean bool = Boolean.TRUE;
            c.b(imageButton, bool, false, 2, null);
            TextView textView = this.f15786a.f54262j;
            f0.o(textView, "viewBinding.tvCheckbox1");
            c.b(textView, bool, false, 2, null);
            if (this.f15790e) {
                ImageView imageView = this.f15786a.f54258f;
                f0.o(imageView, "viewBinding.ivCheckbox1Help");
                c.b(imageView, bool, false, 2, null);
            }
        } else {
            ImageButton imageButton2 = this.f15786a.f54257e;
            f0.o(imageButton2, "viewBinding.ivCheckbox1");
            Boolean bool2 = Boolean.FALSE;
            c.b(imageButton2, bool2, false, 2, null);
            TextView textView2 = this.f15786a.f54262j;
            f0.o(textView2, "viewBinding.tvCheckbox1");
            c.b(textView2, bool2, false, 2, null);
        }
        if (!z11) {
            ImageButton imageButton3 = this.f15786a.f54259g;
            f0.o(imageButton3, "viewBinding.ivCheckbox2");
            Boolean bool3 = Boolean.FALSE;
            c.b(imageButton3, bool3, false, 2, null);
            TextView textView3 = this.f15786a.f54263k;
            f0.o(textView3, "viewBinding.tvCheckbox2");
            c.b(textView3, bool3, false, 2, null);
            return;
        }
        ImageButton imageButton4 = this.f15786a.f54259g;
        f0.o(imageButton4, "viewBinding.ivCheckbox2");
        Boolean bool4 = Boolean.TRUE;
        c.b(imageButton4, bool4, false, 2, null);
        TextView textView4 = this.f15786a.f54263k;
        f0.o(textView4, "viewBinding.tvCheckbox2");
        c.b(textView4, bool4, false, 2, null);
        if (this.f15791f) {
            ImageView imageView2 = this.f15786a.f54260h;
            f0.o(imageView2, "viewBinding.ivCheckbox2Help");
            c.b(imageView2, bool4, false, 2, null);
        }
    }

    public final void q(boolean z10, boolean z11) {
        this.f15786a.f54257e.setSelected(z10);
        this.f15786a.f54259g.setSelected(z11);
    }

    public final void setOnCheckBoxClickListener$float_view_officialRelease(@l a aVar) {
        this.f15793h = aVar;
    }

    public final void setOnHelpClickListener$float_view_officialRelease(@l b bVar) {
        this.f15792g = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewTwoCheckBoxView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        l2 l2VarD = l2.d(LayoutInflater.from(context), null, false);
        f0.o(l2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.f15786a = l2VarD;
        addView(l2VarD.getRoot(), new LinearLayout.LayoutParams(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewTwoCheckBoxView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…FloatViewTwoCheckBoxView)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_title);
        l2VarD.f54265m.setText(string);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_show_title, false) || TextUtils.isEmpty(string)) {
            LinearLayout linearLayout = l2VarD.f54255c;
            f0.o(linearLayout, "viewBinding.areaTitle");
            c.b(linearLayout, Boolean.FALSE, false, 2, null);
        } else {
            LinearLayout linearLayout2 = l2VarD.f54255c;
            f0.o(linearLayout2, "viewBinding.areaTitle");
            c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        }
        l2VarD.f54261i.setVisibility(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_show_title_help, false) ? 0 : 8);
        l2VarD.f54262j.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_checkbox_name_1));
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_show_checkbox_1_help, false);
        this.f15790e = z10;
        l2VarD.f54258f.setVisibility(z10 ? 0 : 8);
        l2VarD.f54263k.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_checkbox_name_2));
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_show_checkbox_2_help, false);
        this.f15791f = z11;
        l2VarD.f54260h.setVisibility(z11 ? 0 : 8);
        this.f15787b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_checkbox_1_default, false);
        this.f15788c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_checkbox_2_default, false);
        this.f15789d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_checkbox_mode_single, false);
        l2VarD.f54264l.setVisibility(TextUtils.isEmpty(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_desc)) ? 8 : 0);
        l2VarD.f54256d.setOrientation(!typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoCheckBoxView_floatview_tcb_inline, false) ? 1 : 0);
        typedArrayObtainStyledAttributes.recycle();
        o.r(l2VarD.f54257e, new View.OnClickListener() { // from class: o8.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.h(this.f42859a, view);
            }
        });
        o.r(l2VarD.f54262j, new View.OnClickListener() { // from class: o8.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.i(this.f42858a, view);
            }
        });
        o.r(l2VarD.f54259g, new View.OnClickListener() { // from class: o8.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.j(this.f42855a, view);
            }
        });
        o.r(l2VarD.f54263k, new View.OnClickListener() { // from class: o8.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.k(this.f42856a, view);
            }
        });
        o.r(l2VarD.f54261i, new View.OnClickListener() { // from class: o8.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.l(this.f42811a, view);
            }
        });
        o.r(l2VarD.f54258f, new View.OnClickListener() { // from class: o8.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.m(this.f42854a, view);
            }
        });
        o.r(l2VarD.f54260h, new View.OnClickListener() { // from class: o8.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoCheckBoxView.n(this.f42857a, view);
            }
        });
        o();
    }
}
