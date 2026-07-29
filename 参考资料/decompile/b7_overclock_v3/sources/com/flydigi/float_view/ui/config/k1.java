package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class k1 extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w7.d2 f15657q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(@yt.k Context context, @yt.k Handler handler, int i10) {
        super(context, (y7.n) null, handler);
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(handler, "handler");
        this.f15656p = i10;
    }

    public static final void D(k1 this$0, RadioGroup radioGroup, int i10) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        int i11 = 0;
        if (i10 != R.id.rb_mode_both) {
            if (i10 == R.id.rb_mode_none) {
                i11 = 1;
            } else if (i10 == R.id.rb_mode_first) {
                i11 = 2;
            } else if (i10 == R.id.rb_mode_second) {
                i11 = 3;
            }
        }
        this$0.f15656p = i11;
    }

    public static final void E(k1 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.r(24, this$0.f15656p);
        this$0.h();
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_setting_combo_key_mode;
    }

    @Override // y7.b
    public void n() {
        w7.d2 d2VarA = w7.d2.a(j());
        kotlin.jvm.internal.f0.o(d2VarA, "bind(view)");
        this.f15657q = d2VarA;
        if (d2VarA == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            d2VarA = null;
        }
        d2VarA.f54043g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.flydigi.float_view.ui.config.j1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                k1.D(this.f15652a, radioGroup, i10);
            }
        });
        com.blankj.utilcode.util.o.r(d2VarA.f54038b, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.E(this.f15647a, view);
            }
        });
        int i10 = this.f15656p;
        if (i10 == 0) {
            d2VarA.f54043g.check(R.id.rb_mode_both);
            return;
        }
        if (i10 == 1) {
            d2VarA.f54043g.check(R.id.rb_mode_none);
            return;
        }
        if (i10 == 2) {
            d2VarA.f54043g.check(R.id.rb_mode_first);
        } else if (i10 != 3) {
            d2VarA.f54043g.check(R.id.rb_mode_both);
        } else {
            d2VarA.f54043g.check(R.id.rb_mode_second);
        }
    }

    @Override // y7.b
    @yt.l
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }
}
