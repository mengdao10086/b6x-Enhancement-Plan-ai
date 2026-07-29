package z7;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public class j extends y7.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f57847x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f57848y = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f57849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f57850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f57851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f57852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f57853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f57854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f57855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f57856w;

    public interface a {
        void a();

        void b(boolean z10);
    }

    public j(Context context, String str, int i10, @g.p0 a aVar) {
        this(context, null, str, i10, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        a aVar = this.f57856w;
        if (aVar != null) {
            aVar.a();
        }
        h();
    }

    public static /* synthetic */ void G(TextView textView, View view) {
        boolean z10 = !((Boolean) textView.getTag()).booleanValue();
        textView.setCompoundDrawablesWithIntrinsicBounds(z10 ? R.drawable.floatingsetting_checkbox_yes : R.drawable.floatingsetting_checkbox_no, 0, 0, 0);
        textView.setTag(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        a aVar = this.f57856w;
        if (aVar != null) {
            aVar.a();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(TextView textView, View view) {
        a aVar = this.f57856w;
        if (aVar != null) {
            aVar.b(((Boolean) textView.getTag()).booleanValue());
        }
        h();
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_dialog_common;
    }

    @Override // y7.b
    public void n() {
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_title);
        if (com.blankj.utilcode.util.n0.x(this.f57849p)) {
            textView.setText(this.f57849p);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        SuperButton superButton = (SuperButton) this.f56479b.findViewById(R.id.btn_close);
        superButton.setVisibility(this.f57854u ? 0 : 8);
        com.blankj.utilcode.util.o.r(superButton, new View.OnClickListener() { // from class: z7.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57829a.F(view);
            }
        });
        TextView textView2 = (TextView) this.f56479b.findViewById(R.id.tv_content);
        if (com.blankj.utilcode.util.n0.x(this.f57850q)) {
            textView2.setText(this.f57850q);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) this.f56479b.findViewById(R.id.tv_ok);
        if (com.blankj.utilcode.util.n0.x(this.f57851r)) {
            textView3.setText(this.f57851r);
        }
        TextView textView4 = (TextView) this.f56479b.findViewById(R.id.tv_cancel);
        if (com.blankj.utilcode.util.n0.x(this.f57852s)) {
            textView4.setText(this.f57852s);
        }
        if (this.f57853t == 1) {
            textView4.setVisibility(8);
        }
        final TextView textView5 = (TextView) this.f56479b.findViewById(R.id.tv_never_notice);
        textView5.setTag(Boolean.FALSE);
        if (this.f57855v) {
            textView5.setVisibility(0);
            com.blankj.utilcode.util.o.r(textView5, new View.OnClickListener() { // from class: z7.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.G(textView5, view);
                }
            });
        } else {
            textView5.setVisibility(8);
        }
        com.blankj.utilcode.util.o.r(textView4, new View.OnClickListener() { // from class: z7.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57827a.H(view);
            }
        });
        com.blankj.utilcode.util.o.r(textView3, new View.OnClickListener() { // from class: z7.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57832a.I(textView5, view);
            }
        });
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }

    public j(Context context, String str, String str2, int i10, @g.p0 a aVar) {
        this(context, i10, str, str2, "", "", aVar);
    }

    public j(Context context, int i10, String str, String str2, String str3, String str4, a aVar) {
        this(context, i10, str, str2, str3, str4, false, aVar);
    }

    public j(Context context, int i10, String str, String str2, String str3, String str4, boolean z10, a aVar) {
        this(context, i10, str, str2, str3, str4, z10, false, aVar);
    }

    public j(Context context, int i10, String str, String str2, String str3, String str4, boolean z10, boolean z11, a aVar) {
        super(context);
        this.f57849p = str;
        this.f57850q = str2;
        this.f57853t = i10;
        this.f57851r = str3;
        this.f57854u = z10;
        this.f57852s = str4;
        this.f57855v = z11;
        this.f57856w = aVar;
    }
}
