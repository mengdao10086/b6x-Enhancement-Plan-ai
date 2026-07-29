package z7;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import java.util.Arrays;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class o0 extends y7.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(@yt.k Context context) {
        super(context);
        kotlin.jvm.internal.f0.p(context, "context");
    }

    public static final void E(TextView textView, View view) {
        Object tag = textView.getTag();
        kotlin.jvm.internal.f0.n(tag, "null cannot be cast to non-null type kotlin.Boolean");
        boolean z10 = !((Boolean) tag).booleanValue();
        textView.setCompoundDrawablesWithIntrinsicBounds(z10 ? R.drawable.floatingsetting_checkbox_yes : R.drawable.floatingsetting_checkbox_no, 0, 0, 0);
        textView.setTag(Boolean.valueOf(z10));
    }

    public static final void F(TextView textView, o0 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Object tag = textView.getTag();
        kotlin.jvm.internal.f0.n(tag, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) tag).booleanValue()) {
            o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_KEY_NEED_START_FROM_APP_DIALOG_SHOWN, true);
        }
        this$0.h();
    }

    public static final void G(TextView textView, o0 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Object tag = textView.getTag();
        kotlin.jvm.internal.f0.n(tag, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) tag).booleanValue()) {
            o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_FLOAT_KEY_NEED_START_FROM_APP_DIALOG_SHOWN, true);
        }
        Intent intentB = o5.f.b(this$0.f56478a);
        intentB.setFlags(268435456);
        this$0.f56478a.startActivity(intentB);
        this$0.h();
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_joystick_cannot_use;
    }

    @Override // y7.b
    public void n() {
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_content);
        kotlin.jvm.internal.v0 v0Var = kotlin.jvm.internal.v0.f37964a;
        String string = this.f56478a.getString(R.string.floatview_joystick_not_working_content);
        kotlin.jvm.internal.f0.o(string, "mContext.getString(R.str…tick_not_working_content)");
        String str = String.format(string, Arrays.copyOf(new Object[]{this.f56478a.getString(R.string.app_name)}, 1));
        kotlin.jvm.internal.f0.o(str, "format(format, *args)");
        textView.setText(str);
        final TextView textView2 = (TextView) this.f56479b.findViewById(R.id.tv_never_notice);
        textView2.setTag(Boolean.FALSE);
        com.blankj.utilcode.util.o.r(textView2, new View.OnClickListener() { // from class: z7.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o0.E(textView2, view);
            }
        });
        View viewFindViewById = this.f56479b.findViewById(R.id.btn_close);
        kotlin.jvm.internal.f0.o(viewFindViewById, "mLayout.findViewById(R.id.btn_close)");
        com.blankj.utilcode.util.o.r((SuperButton) viewFindViewById, new View.OnClickListener() { // from class: z7.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o0.F(textView2, this, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f56479b.findViewById(R.id.tv_ok), new View.OnClickListener() { // from class: z7.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o0.G(textView2, this, view);
            }
        });
    }

    @Override // y7.b
    @yt.l
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }
}
