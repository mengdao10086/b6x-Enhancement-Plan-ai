package com.flydigi.base.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.R;
import com.flydigi.base.common.BaseDialogFragment;
import g.n;
import g.p0;
import g.v;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class FZDialogV2 extends BaseDialogFragment {
    public TextView E8;
    public TextView F8;
    public TextView G8;
    public TextView H8;
    public View I8;
    public c J8;
    public c K8;
    public b L8;
    public d M8;
    public ImageView N8;
    public ImageView O8;
    public View P8;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f13477a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FZDialogV2 f13478b;

        public FZDialogV2 a() {
            FZDialogV2 fZDialogV2S6 = FZDialogV2.s6();
            this.f13478b = fZDialogV2S6;
            fZDialogV2S6.w6(this.f13477a);
            return this.f13478b;
        }

        public a b(Boolean bool) {
            this.f13477a.f13479a = bool.booleanValue();
            return this;
        }

        public a c(c cVar) {
            this.f13477a.f13493o = cVar;
            return this;
        }

        public a d(String str) {
            this.f13477a.f13486h = str;
            return this;
        }

        public a e(@n int i10) {
            this.f13477a.f13487i = i10;
            return this;
        }

        public a f(c cVar) {
            this.f13477a.f13492n = cVar;
            return this;
        }

        public a g(String str) {
            this.f13477a.f13484f = str;
            return this;
        }

        public a h(@n int i10) {
            this.f13477a.f13485g = i10;
            return this;
        }

        public a i(@k Spanned spanned) {
            this.f13477a.f13483e = spanned;
            return this;
        }

        public a j(String str) {
            this.f13477a.f13482d = str;
            return this;
        }

        public a k(int i10) {
            this.f13477a.f13494p = i10;
            return this;
        }

        public a l(boolean z10) {
            this.f13477a.f13480b = z10;
            return this;
        }

        public a m(@v int i10) {
            this.f13477a.f13490l = i10;
            return this;
        }

        public a n(String str) {
            this.f13477a.f13488j = str;
            return this;
        }

        public a o(boolean z10) {
            this.f13477a.f13491m = z10;
            return this;
        }

        public a p(boolean z10) {
            this.f13477a.f13489k = z10;
            return this;
        }

        public a q(String str) {
            this.f13477a.f13481c = str;
            return this;
        }

        public void r(FragmentManager fragmentManager, String str) {
            if (this.f13478b != null) {
                Fragment fragmentS0 = fragmentManager.s0(str);
                if (fragmentS0 == null || !fragmentS0.s3()) {
                    this.f13478b.Z5(fragmentManager, str);
                    return;
                }
                return;
            }
            a();
            Fragment fragmentS02 = fragmentManager.s0(str);
            if (fragmentS02 == null || !fragmentS02.s3()) {
                r(fragmentManager, str);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Spanned f13483e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f13484f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f13486h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f13488j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f13489k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f13491m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public c f13492n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public c f13493o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13479a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13480b = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @n
        public int f13485g = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @n
        public int f13487i = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @v
        public int f13490l = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f13494p = -1;
    }

    public interface c {
        void a(DialogFragment dialogFragment);
    }

    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o6(View view) {
        I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p6(View view) {
        c cVar = this.J8;
        if (cVar != null) {
            cVar.a(l6());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q6(View view) {
        c cVar = this.K8;
        if (cVar != null) {
            cVar.a(l6());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r6(View view) {
        ImageView imageView = (ImageView) this.I8.findViewById(R.id.iv_checkbox);
        boolean z10 = !this.I8.isSelected();
        this.I8.setSelected(z10);
        imageView.setSelected(z10);
    }

    public static FZDialogV2 s6() {
        return new FZDialogV2();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        W5(1, R.style.DialogTheme);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.base_layout_fz_dialog_v2;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        if (L5() == null || L5().getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = L5().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 17;
        L5().getWindow().setAttributes(attributes);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.P8 = view.findViewById(R.id.area_root);
        this.E8 = (TextView) view.findViewById(R.id.tv_title);
        this.O8 = (ImageView) view.findViewById(R.id.iv_close);
        this.F8 = (TextView) view.findViewById(R.id.tv_content);
        this.N8 = (ImageView) view.findViewById(R.id.iv_content);
        View viewFindViewById = view.findViewById(R.id.cb_no_more_notice);
        this.I8 = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: p5.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f46430a.r6(view2);
            }
        });
        this.G8 = (TextView) view.findViewById(R.id.tv_cancel);
        this.H8 = (TextView) view.findViewById(R.id.tv_confirm);
        m6();
    }

    public final DialogFragment l6() {
        return this;
    }

    public final void m6() {
        if (this.L8.f13480b) {
            this.P8.setBackgroundResource(R.drawable.base_bg_dialog_dark);
            TextView textView = this.E8;
            Context contextX1 = X1();
            int i10 = R.color.color_ffffff_a90;
            textView.setTextColor(h0.d.f(contextX1, i10));
            this.F8.setTextColor(h0.d.f(X1(), i10));
            this.G8.setTextColor(h0.d.f(X1(), R.color.color_ffffff_a50));
        } else {
            this.P8.setBackgroundResource(R.drawable.base_bg_dialog);
            TextView textView2 = this.E8;
            Context contextX12 = X1();
            int i11 = R.color.color_000000_a90;
            textView2.setTextColor(h0.d.f(contextX12, i11));
            this.F8.setTextColor(h0.d.f(X1(), i11));
            this.G8.setTextColor(h0.d.f(X1(), R.color.color_000000_a50));
        }
        if (TextUtils.isEmpty(this.L8.f13481c)) {
            this.E8.setVisibility(8);
        } else {
            this.E8.setText(this.L8.f13481c);
        }
        b bVar = this.L8;
        Spanned spanned = bVar.f13483e;
        if (spanned != null) {
            this.F8.setText(spanned);
        } else {
            this.F8.setText(bVar.f13482d);
        }
        int i12 = this.L8.f13494p;
        if (i12 != -1) {
            this.F8.setGravity(i12);
        }
        this.H8.setText(this.L8.f13484f);
        if (this.L8.f13485g != -1) {
            this.H8.setTextColor(h0.d.f(X1(), this.L8.f13485g));
        }
        if (n0.x(this.L8.f13486h)) {
            this.G8.setText(this.L8.f13486h);
            if (this.L8.f13487i != -1) {
                this.G8.setTextColor(h0.d.f(X1(), this.L8.f13487i));
            }
        } else {
            this.G8.setVisibility(8);
        }
        if (this.L8.f13491m) {
            this.O8.setVisibility(0);
            this.O8.setOnClickListener(new View.OnClickListener() { // from class: p5.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f46431a.o6(view);
                }
            });
        }
        if (!d1.g(this.L8.f13488j)) {
            com.bumptech.glide.b.G(this).t(this.L8.f13488j).s1(this.N8);
            this.N8.setVisibility(0);
        } else if (this.L8.f13490l != -1) {
            com.bumptech.glide.b.G(this).p(Integer.valueOf(this.L8.f13490l)).s1(this.N8);
            this.N8.setVisibility(0);
        }
        this.I8.setVisibility(this.L8.f13489k ? 0 : 8);
        U5(this.L8.f13479a);
        t6(this.L8.f13493o);
        u6(this.L8.f13492n);
        this.G8.setOnClickListener(new View.OnClickListener() { // from class: p5.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46433a.p6(view);
            }
        });
        this.H8.setOnClickListener(new View.OnClickListener() { // from class: p5.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46432a.q6(view);
            }
        });
    }

    public boolean n6() {
        return this.I8.isSelected();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@k DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        d dVar = this.M8;
        if (dVar != null) {
            dVar.a();
        }
    }

    public final void t6(c cVar) {
        this.J8 = cVar;
    }

    public final void u6(c cVar) {
        this.K8 = cVar;
    }

    public void v6(d dVar) {
        this.M8 = dVar;
    }

    public final void w6(b bVar) {
        this.L8 = bVar;
    }
}
