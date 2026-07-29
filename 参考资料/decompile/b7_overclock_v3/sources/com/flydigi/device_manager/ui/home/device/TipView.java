package com.flydigi.device_manager.ui.home.device;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import g.c1;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class TipView extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final a f15157k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f15158l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f15159m = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f15162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f15163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f15164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f15165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SuperButton f15166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProgressBar f15167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.l
    public View.OnClickListener f15168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public View.OnClickListener f15169j;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public TipView(@yt.k Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public TipView(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.f0.p(context, "context");
    }

    public /* synthetic */ TipView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void c(TipView this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.setTag(R.id.device_tag_tip_ignored, Boolean.TRUE);
        this$0.setVisibility(8);
        View.OnClickListener onClickListener = this$0.f15168i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void d(TipView this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.f15169j;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void e(boolean z10) {
        ProgressBar progressBar = this.f15167h;
        TextView textView = null;
        if (progressBar == null) {
            kotlin.jvm.internal.f0.S("pbLoading");
            progressBar = null;
        }
        progressBar.setVisibility(z10 ? 0 : 8);
        TextView textView2 = this.f15164e;
        if (textView2 == null) {
            kotlin.jvm.internal.f0.S("btnPositive");
            textView2 = null;
        }
        textView2.setVisibility(z10 ? 8 : 0);
        if (this.f15161b) {
            TextView textView3 = this.f15165f;
            if (textView3 == null) {
                kotlin.jvm.internal.f0.S("btnNegative");
            } else {
                textView = textView3;
            }
            textView.setVisibility(z10 ? 8 : 0);
        }
    }

    public final void f(boolean z10, @c1 int i10, @c1 int i11, @c1 int i12, @yt.k View.OnClickListener onPositiveClickListener, @yt.l View.OnClickListener onClickListener, int i13, @yt.l View.OnClickListener onClickListener2) {
        kotlin.jvm.internal.f0.p(onPositiveClickListener, "onPositiveClickListener");
        this.f15161b = z10;
        this.f15160a = i13;
        TextView textView = this.f15162c;
        if (textView == null) {
            kotlin.jvm.internal.f0.S("tvTitle");
            textView = null;
        }
        textView.setText(getResources().getString(i10));
        TextView textView2 = this.f15163d;
        if (textView2 == null) {
            kotlin.jvm.internal.f0.S("tvDesc");
            textView2 = null;
        }
        textView2.setText(getResources().getString(i11));
        TextView textView3 = this.f15164e;
        if (textView3 == null) {
            kotlin.jvm.internal.f0.S("btnPositive");
            textView3 = null;
        }
        textView3.setText(getResources().getString(i12));
        TextView textView4 = this.f15164e;
        if (textView4 == null) {
            kotlin.jvm.internal.f0.S("btnPositive");
            textView4 = null;
        }
        textView4.setBackgroundResource(z10 ? R.drawable.shape_bg_positive_button : R.drawable.shape_bg_positive_button_force);
        setBackgroundColor(getResources().getColor(z10 ? R.color.colorPrimaryA08 : R.color.color_notice_a08));
        TextView textView5 = this.f15164e;
        if (textView5 == null) {
            kotlin.jvm.internal.f0.S("btnPositive");
            textView5 = null;
        }
        com.blankj.utilcode.util.o.r(textView5, onPositiveClickListener);
        TextView textView6 = this.f15164e;
        if (textView6 == null) {
            kotlin.jvm.internal.f0.S("btnPositive");
            textView6 = null;
        }
        Boolean bool = Boolean.TRUE;
        o5.c.b(textView6, bool, false, 2, null);
        TextView textView7 = this.f15165f;
        if (textView7 == null) {
            kotlin.jvm.internal.f0.S("btnNegative");
            textView7 = null;
        }
        textView7.setVisibility(z10 ? 0 : 8);
        ProgressBar progressBar = this.f15167h;
        if (progressBar == null) {
            kotlin.jvm.internal.f0.S("pbLoading");
            progressBar = null;
        }
        Boolean bool2 = Boolean.FALSE;
        o5.c.b(progressBar, bool2, false, 2, null);
        this.f15168i = onClickListener;
        this.f15169j = onClickListener2;
        if (onClickListener2 != null) {
            SuperButton superButton = this.f15166g;
            if (superButton == null) {
                kotlin.jvm.internal.f0.S("btnInfo");
                superButton = null;
            }
            o5.c.b(superButton, bool, false, 2, null);
            return;
        }
        SuperButton superButton2 = this.f15166g;
        if (superButton2 == null) {
            kotlin.jvm.internal.f0.S("btnInfo");
            superButton2 = null;
        }
        o5.c.b(superButton2, bool2, false, 2, null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(R.id.tv_tips_title);
        kotlin.jvm.internal.f0.o(viewFindViewById, "findViewById(R.id.tv_tips_title)");
        this.f15162c = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_tips_desc);
        kotlin.jvm.internal.f0.o(viewFindViewById2, "findViewById(R.id.tv_tips_desc)");
        this.f15163d = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.btn_positive);
        kotlin.jvm.internal.f0.o(viewFindViewById3, "findViewById(R.id.btn_positive)");
        this.f15164e = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.btn_negative);
        kotlin.jvm.internal.f0.o(viewFindViewById4, "findViewById(R.id.btn_negative)");
        this.f15165f = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.pb_loading);
        kotlin.jvm.internal.f0.o(viewFindViewById5, "findViewById(R.id.pb_loading)");
        this.f15167h = (ProgressBar) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.btn_info);
        kotlin.jvm.internal.f0.o(viewFindViewById6, "findViewById(R.id.btn_info)");
        this.f15166g = (SuperButton) viewFindViewById6;
        TextView textView = this.f15165f;
        SuperButton superButton = null;
        if (textView == null) {
            kotlin.jvm.internal.f0.S("btnNegative");
            textView = null;
        }
        com.blankj.utilcode.util.o.r(textView, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipView.c(this.f15193a, view);
            }
        });
        SuperButton superButton2 = this.f15166g;
        if (superButton2 == null) {
            kotlin.jvm.internal.f0.S("btnInfo");
        } else {
            superButton = superButton2;
        }
        com.blankj.utilcode.util.o.r(superButton, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipView.d(this.f15191a, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public TipView(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.f0.p(context, "context");
        this.f15160a = 1;
    }
}
