package z7;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public class u0 extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f57901p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.core.util.k<Integer, String> f57902q;

    public u0(Context context, @g.n0 androidx.core.util.k<Integer, String> kVar) {
        super(context);
        this.f57902q = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, D(this.f57902q.f4741a)).navigation();
        l();
    }

    public final String D(Integer num) {
        return num.intValue() == -3 ? u7.b.f51949b : num.intValue() == -4 ? u7.b.f51950c : num.intValue() == -2 ? u7.b.f51949b : "";
    }

    public void G(androidx.core.util.k<Integer, String> kVar) {
        this.f57902q = kVar;
        this.f57901p.setText(kVar.f4742b);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_notice_dialog;
    }

    @Override // y7.b
    public void n() {
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_warning_title);
        this.f57901p = (TextView) this.f56479b.findViewById(R.id.tv_warning_content);
        Button button = (Button) this.f56479b.findViewById(R.id.layout_question_cancel);
        Button button2 = (Button) this.f56479b.findViewById(R.id.layout_question_confirm);
        textView.setText(this.f56478a.getString(R.string.notice));
        this.f57901p.setText(this.f57902q.f4742b);
        button.setOnClickListener(new View.OnClickListener() { // from class: z7.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57899a.E(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: z7.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57898a.F(view);
            }
        });
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
