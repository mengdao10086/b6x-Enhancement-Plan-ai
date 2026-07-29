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
import com.flydigi.float_view.widget.FloatViewThreeCheckBoxView;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import w7.k2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FloatViewThreeCheckBoxView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final k2 f15776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public b f15784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public a f15785j;

    public interface a {
        void a(boolean z10);

        void b(boolean z10);

        void c(boolean z10);
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewThreeCheckBoxView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewThreeCheckBoxView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewThreeCheckBoxView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void k(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f15776a.f54230e.isSelected()) {
            return;
        }
        this$0.f15776a.f54230e.setSelected(!r2.isSelected());
        if (this$0.f15777b) {
            this$0.f15776a.f54232g.setSelected(!r2.f54230e.isSelected());
            this$0.f15776a.f54234i.setSelected(!r2.f54230e.isSelected());
        }
        a aVar = this$0.f15785j;
        if (aVar != null) {
            aVar.a(this$0.f15776a.f54230e.isSelected());
        }
    }

    public static final void l(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f15776a.f54232g.isSelected()) {
            return;
        }
        this$0.f15776a.f54232g.setSelected(!r2.isSelected());
        if (this$0.f15777b) {
            this$0.f15776a.f54230e.setSelected(!r2.f54232g.isSelected());
            this$0.f15776a.f54234i.setSelected(!r2.f54232g.isSelected());
        }
        a aVar = this$0.f15785j;
        if (aVar != null) {
            aVar.b(this$0.f15776a.f54232g.isSelected());
        }
    }

    public static final void m(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f15776a.f54234i.isSelected()) {
            return;
        }
        this$0.f15776a.f54234i.setSelected(!r2.isSelected());
        if (this$0.f15777b) {
            this$0.f15776a.f54230e.setSelected(!r2.f54234i.isSelected());
            this$0.f15776a.f54232g.setSelected(!r2.f54234i.isSelected());
        }
        a aVar = this$0.f15785j;
        if (aVar != null) {
            aVar.c(this$0.f15776a.f54234i.isSelected());
        }
    }

    public static final void n(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f15776a.f54230e.performClick();
    }

    public static final void o(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f15776a.f54232g.performClick();
    }

    public static final void p(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f15776a.f54234i.performClick();
    }

    public static final void q(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15784i;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static final void r(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15784i;
        if (bVar != null) {
            bVar.b();
        }
    }

    public static final void s(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15784i;
        if (bVar != null) {
            bVar.c();
        }
    }

    public static final void t(FloatViewThreeCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15784i;
        if (bVar != null) {
            bVar.d();
        }
    }

    @l
    public final a getOnCheckBoxClickListener$float_view_officialRelease() {
        return this.f15785j;
    }

    @l
    public final b getOnHelpClickListener$float_view_officialRelease() {
        return this.f15784i;
    }

    @k
    public final Boolean[] getValue() {
        return new Boolean[]{Boolean.valueOf(this.f15776a.f54230e.isSelected()), Boolean.valueOf(this.f15776a.f54232g.isSelected()), Boolean.valueOf(this.f15776a.f54234i.isSelected())};
    }

    public final void setOnCheckBoxClickListener$float_view_officialRelease(@l a aVar) {
        this.f15785j = aVar;
    }

    public final void setOnHelpClickListener$float_view_officialRelease(@l b bVar) {
        this.f15784i = bVar;
    }

    public final void u() {
        w(this.f15778c, this.f15779d, this.f15780e);
    }

    public final void v(boolean z10, boolean z11, boolean z12) {
        this.f15776a.f54230e.setEnabled(z10);
        this.f15776a.f54232g.setEnabled(z11);
        if (z10) {
            ImageButton imageButton = this.f15776a.f54230e;
            f0.o(imageButton, "viewBinding.ivCheckbox1");
            Boolean bool = Boolean.TRUE;
            c.b(imageButton, bool, false, 2, null);
            TextView textView = this.f15776a.f54237l;
            f0.o(textView, "viewBinding.tvCheckbox1");
            c.b(textView, bool, false, 2, null);
            if (this.f15781f) {
                ImageView imageView = this.f15776a.f54231f;
                f0.o(imageView, "viewBinding.ivCheckbox1Help");
                c.b(imageView, bool, false, 2, null);
            }
        } else {
            ImageButton imageButton2 = this.f15776a.f54230e;
            f0.o(imageButton2, "viewBinding.ivCheckbox1");
            Boolean bool2 = Boolean.FALSE;
            c.b(imageButton2, bool2, false, 2, null);
            TextView textView2 = this.f15776a.f54237l;
            f0.o(textView2, "viewBinding.tvCheckbox1");
            c.b(textView2, bool2, false, 2, null);
        }
        if (z11) {
            ImageButton imageButton3 = this.f15776a.f54232g;
            f0.o(imageButton3, "viewBinding.ivCheckbox2");
            Boolean bool3 = Boolean.TRUE;
            c.b(imageButton3, bool3, false, 2, null);
            TextView textView3 = this.f15776a.f54238m;
            f0.o(textView3, "viewBinding.tvCheckbox2");
            c.b(textView3, bool3, false, 2, null);
            if (this.f15782g) {
                ImageView imageView2 = this.f15776a.f54233h;
                f0.o(imageView2, "viewBinding.ivCheckbox2Help");
                c.b(imageView2, bool3, false, 2, null);
            }
        } else {
            ImageButton imageButton4 = this.f15776a.f54232g;
            f0.o(imageButton4, "viewBinding.ivCheckbox2");
            Boolean bool4 = Boolean.FALSE;
            c.b(imageButton4, bool4, false, 2, null);
            TextView textView4 = this.f15776a.f54238m;
            f0.o(textView4, "viewBinding.tvCheckbox2");
            c.b(textView4, bool4, false, 2, null);
        }
        if (!z12) {
            ImageButton imageButton5 = this.f15776a.f54234i;
            f0.o(imageButton5, "viewBinding.ivCheckbox3");
            Boolean bool5 = Boolean.FALSE;
            c.b(imageButton5, bool5, false, 2, null);
            TextView textView5 = this.f15776a.f54239n;
            f0.o(textView5, "viewBinding.tvCheckbox3");
            c.b(textView5, bool5, false, 2, null);
            return;
        }
        ImageButton imageButton6 = this.f15776a.f54234i;
        f0.o(imageButton6, "viewBinding.ivCheckbox3");
        Boolean bool6 = Boolean.TRUE;
        c.b(imageButton6, bool6, false, 2, null);
        TextView textView6 = this.f15776a.f54239n;
        f0.o(textView6, "viewBinding.tvCheckbox3");
        c.b(textView6, bool6, false, 2, null);
        if (this.f15783h) {
            ImageView imageView3 = this.f15776a.f54235j;
            f0.o(imageView3, "viewBinding.ivCheckbox3Help");
            c.b(imageView3, bool6, false, 2, null);
        }
    }

    public final void w(boolean z10, boolean z11, boolean z12) {
        this.f15776a.f54230e.setSelected(z10);
        this.f15776a.f54232g.setSelected(z11);
        this.f15776a.f54234i.setSelected(z12);
    }

    public final void x(@k String desc) {
        f0.p(desc, "desc");
        this.f15776a.f54240o.setText(desc);
        this.f15776a.f54240o.setVisibility(TextUtils.isEmpty(desc) ? 8 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewThreeCheckBoxView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        k2 k2VarD = k2.d(LayoutInflater.from(context), null, false);
        f0.o(k2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.f15776a = k2VarD;
        addView(k2VarD.getRoot(), new LinearLayout.LayoutParams(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewThreeCheckBoxView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…oatViewThreeCheckBoxView)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_title);
        k2VarD.f54241p.setText(string);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_show_title, false) || TextUtils.isEmpty(string)) {
            LinearLayout linearLayout = k2VarD.f54228c;
            f0.o(linearLayout, "viewBinding.areaTitle");
            c.b(linearLayout, Boolean.FALSE, false, 2, null);
        } else {
            LinearLayout linearLayout2 = k2VarD.f54228c;
            f0.o(linearLayout2, "viewBinding.areaTitle");
            c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        }
        k2VarD.f54236k.setVisibility(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_show_title_help, false) ? 0 : 8);
        k2VarD.f54237l.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_name_1));
        k2VarD.f54238m.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_name_2));
        k2VarD.f54239n.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_name_3));
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_show_checkbox_1_help, false);
        this.f15781f = z10;
        k2VarD.f54231f.setVisibility(z10 ? 0 : 8);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_show_checkbox_2_help, false);
        this.f15782g = z11;
        k2VarD.f54233h.setVisibility(z11 ? 0 : 8);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_show_checkbox_3_help, false);
        this.f15783h = z12;
        k2VarD.f54235j.setVisibility(z12 ? 0 : 8);
        this.f15778c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_1_default, false);
        this.f15779d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_2_default, false);
        this.f15780e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_3_default, false);
        this.f15777b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_checkbox_mode_single, false);
        k2VarD.f54240o.setVisibility(TextUtils.isEmpty(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_desc)) ? 8 : 0);
        k2VarD.f54229d.setOrientation(!typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewThreeCheckBoxView_floatview_mcb_inline, false) ? 1 : 0);
        typedArrayObtainStyledAttributes.recycle();
        o.r(k2VarD.f54230e, new View.OnClickListener() { // from class: o8.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.k(this.f42851a, view);
            }
        });
        o.r(k2VarD.f54232g, new View.OnClickListener() { // from class: o8.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.l(this.f42846a, view);
            }
        });
        o.r(k2VarD.f54234i, new View.OnClickListener() { // from class: o8.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.m(this.f42848a, view);
            }
        });
        o.r(k2VarD.f54237l, new View.OnClickListener() { // from class: o8.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.n(this.f42853a, view);
            }
        });
        o.r(k2VarD.f54238m, new View.OnClickListener() { // from class: o8.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.o(this.f42850a, view);
            }
        });
        o.r(k2VarD.f54239n, new View.OnClickListener() { // from class: o8.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.p(this.f42841a, view);
            }
        });
        o.r(k2VarD.f54236k, new View.OnClickListener() { // from class: o8.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.q(this.f42852a, view);
            }
        });
        o.r(k2VarD.f54231f, new View.OnClickListener() { // from class: o8.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.r(this.f42847a, view);
            }
        });
        o.r(k2VarD.f54233h, new View.OnClickListener() { // from class: o8.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.s(this.f42849a, view);
            }
        });
        o.r(k2VarD.f54235j, new View.OnClickListener() { // from class: o8.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewThreeCheckBoxView.t(this.f42843a, view);
            }
        });
        u();
    }
}
