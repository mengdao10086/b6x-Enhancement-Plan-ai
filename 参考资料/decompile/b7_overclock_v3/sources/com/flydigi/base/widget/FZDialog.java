package com.flydigi.base.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.d1;
import com.flydigi.base.R;
import com.flydigi.base.common.BaseDialogFragment;
import dj.g;
import g.n;
import g.n0;
import g.p0;
import g.v;
import o5.l;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class FZDialog extends BaseDialogFragment {
    public TextView E8;
    public TextView F8;
    public LinearLayout G8;
    public TextView H8;
    public TextView I8;
    public View J8;
    public c K8;
    public c L8;
    public c M8;
    public LinearLayout N8;
    public TextView O8;
    public b P8;
    public d Q8;
    public ImageView R8;
    public ImageView S8;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f13455a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FZDialog f13456b;

        public FZDialog a() {
            FZDialog fZDialogC6 = FZDialog.C6();
            this.f13456b = fZDialogC6;
            fZDialogC6.H6(this.f13455a);
            return this.f13456b;
        }

        public a b(Boolean bool) {
            this.f13455a.f13458b = bool.booleanValue();
            return this;
        }

        public a c(c cVar) {
            this.f13455a.f13472p = cVar;
            return this;
        }

        public a d(String str) {
            b bVar = this.f13455a;
            bVar.f13464h = str;
            bVar.f13457a = false;
            return this;
        }

        public a e(@n int i10) {
            this.f13455a.f13465i = i10;
            return this;
        }

        public a f(c cVar) {
            this.f13455a.f13471o = cVar;
            return this;
        }

        public a g(String str) {
            b bVar = this.f13455a;
            bVar.f13462f = str;
            bVar.f13457a = false;
            return this;
        }

        public a h(@n int i10) {
            this.f13455a.f13463g = i10;
            return this;
        }

        public a i(@k Spanned spanned) {
            this.f13455a.f13461e = spanned;
            return this;
        }

        public a j(String str) {
            this.f13455a.f13460d = str;
            return this;
        }

        public a k(int i10) {
            this.f13455a.f13476t = i10;
            return this;
        }

        public a l(int i10) {
            this.f13455a.f13474r = i10;
            return this;
        }

        public a m(int i10) {
            this.f13455a.f13475s = i10;
            return this;
        }

        public a n(@v int i10) {
            this.f13455a.f13469m = i10;
            return this;
        }

        public a o(String str) {
            this.f13455a.f13467k = str;
            return this;
        }

        public a p(c cVar) {
            this.f13455a.f13473q = cVar;
            return this;
        }

        public a q(String str) {
            b bVar = this.f13455a;
            bVar.f13466j = str;
            bVar.f13457a = true;
            return this;
        }

        public a r(boolean z10) {
            this.f13455a.f13470n = z10;
            return this;
        }

        public a s(boolean z10) {
            this.f13455a.f13468l = z10;
            return this;
        }

        public a t(String str) {
            this.f13455a.f13459c = str;
            return this;
        }

        public void u(FragmentManager fragmentManager, String str) {
            if (this.f13456b != null) {
                Fragment fragmentS0 = fragmentManager.s0(str);
                if (fragmentS0 == null || !fragmentS0.s3()) {
                    this.f13456b.Z5(fragmentManager, str);
                    return;
                }
                return;
            }
            a();
            Fragment fragmentS02 = fragmentManager.s0(str);
            if (fragmentS02 == null || !fragmentS02.s3()) {
                u(fragmentManager, str);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13457a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Spanned f13461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f13462f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f13464h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f13466j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f13467k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f13468l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f13470n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public c f13471o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public c f13472p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public c f13473q;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f13476t;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13458b = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @n
        public int f13463g = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @n
        public int f13465i = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @v
        public int f13469m = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f13474r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f13475s = 0;
    }

    public interface c {
        void a(DialogFragment dialogFragment);
    }

    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A6(Throwable th2) throws Exception {
        this.I8.setText(this.P8.f13462f);
        this.I8.setEnabled(true);
        this.I8.setTextColor(h0.d.f(X1(), this.P8.f13463g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B6(View view) {
        ImageView imageView = (ImageView) this.J8.findViewById(R.id.iv_checkbox);
        boolean z10 = !this.J8.isSelected();
        this.J8.setSelected(z10);
        imageView.setSelected(z10);
    }

    public static FZDialog C6() {
        return new FZDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(View view) {
        I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u6(View view) {
        c cVar = this.K8;
        if (cVar != null) {
            cVar.a(q6());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v6(View view) {
        c cVar = this.L8;
        if (cVar != null) {
            cVar.a(q6());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w6(View view) {
        c cVar = this.M8;
        if (cVar != null) {
            cVar.a(q6());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x6(io.reactivex.disposables.b bVar) throws Exception {
        this.I8.setEnabled(false);
        TextView textView = this.I8;
        b bVar2 = this.P8;
        textView.setText(String.format("%s（%ds）", bVar2.f13462f, Integer.valueOf(bVar2.f13475s)));
        this.I8.setTextColor(h0.d.f(X1(), R.color.color_000000_a30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y6() throws Exception {
        this.I8.setText(this.P8.f13462f);
        this.I8.setEnabled(true);
        this.I8.setTextColor(h0.d.f(X1(), this.P8.f13463g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z6(Long l10) throws Exception {
        this.I8.setText(String.format("%s（%ds）", this.P8.f13462f, Long.valueOf(l10.longValue() - 1)));
    }

    public final void D6(c cVar) {
        this.K8 = cVar;
    }

    public final void E6(c cVar) {
        this.L8 = cVar;
    }

    public final void F6(c cVar) {
        this.M8 = cVar;
    }

    public void G6(d dVar) {
        this.Q8 = dVar;
    }

    public final void H6(b bVar) {
        this.P8 = bVar;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        W5(1, R.style.DialogTheme);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.layout_fz_dialog;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        if (L5() != null && L5().getWindow() != null) {
            WindowManager.LayoutParams attributes = L5().getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            L5().getWindow().setAttributes(attributes);
        }
        int i10 = this.P8.f13475s;
        if (i10 != 0) {
            l.f(i10).b4(aj.a.c()).s0(y1()).Z1(new g() { // from class: p5.k
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f46427a.x6((io.reactivex.disposables.b) obj);
                }
            }).R1(new dj.a() { // from class: p5.j
                @Override // dj.a
                public final void run() throws Exception {
                    this.f46426a.y6();
                }
            }).F5(new g() { // from class: p5.l
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f46428a.z6((Long) obj);
                }
            }, new g() { // from class: p5.m
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f46429a.A6((Throwable) obj);
                }
            });
        }
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.E8 = (TextView) view.findViewById(R.id.tv_title);
        this.S8 = (ImageView) view.findViewById(R.id.iv_close);
        this.F8 = (TextView) view.findViewById(R.id.tv_content);
        this.R8 = (ImageView) view.findViewById(R.id.iv_content);
        View viewFindViewById = view.findViewById(R.id.cb_no_more_notice);
        this.J8 = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: p5.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f46423a.B6(view2);
            }
        });
        this.G8 = (LinearLayout) view.findViewById(R.id.ll_double);
        this.H8 = (TextView) view.findViewById(R.id.tv_cancel);
        this.I8 = (TextView) view.findViewById(R.id.tv_confirm);
        this.N8 = (LinearLayout) view.findViewById(R.id.ll_ok);
        this.O8 = (TextView) view.findViewById(R.id.tv_ok);
        r6();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@k DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        d dVar = this.Q8;
        if (dVar != null) {
            dVar.a();
        }
    }

    public final DialogFragment q6() {
        return this;
    }

    public final void r6() {
        b bVar = this.P8;
        if (bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(bVar.f13459c)) {
            this.E8.setVisibility(8);
        } else {
            this.E8.setText(this.P8.f13459c);
        }
        b bVar2 = this.P8;
        Spanned spanned = bVar2.f13461e;
        if (spanned != null) {
            this.F8.setText(spanned);
        } else {
            this.F8.setText(bVar2.f13460d);
        }
        int i10 = this.P8.f13474r;
        if (i10 != -1) {
            this.F8.setGravity(i10);
        }
        int i11 = this.P8.f13476t;
        if (i11 != 0) {
            this.F8.setTextColor(i11);
        }
        this.I8.setText(this.P8.f13462f);
        if (this.P8.f13463g != -1) {
            this.I8.setTextColor(h0.d.f(X1(), this.P8.f13463g));
            if (this.P8.f13475s != 0) {
                this.I8.setEnabled(false);
                this.I8.setTextColor(h0.d.f(X1(), R.color.color_000000_a30));
            }
        }
        this.H8.setText(this.P8.f13464h);
        if (this.P8.f13465i != -1) {
            this.H8.setTextColor(h0.d.f(X1(), this.P8.f13465i));
        }
        this.O8.setText(this.P8.f13466j);
        if (this.P8.f13470n) {
            this.S8.setVisibility(0);
            this.S8.setOnClickListener(new View.OnClickListener() { // from class: p5.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f46425a.t6(view);
                }
            });
        }
        if (!d1.g(this.P8.f13467k)) {
            com.bumptech.glide.b.G(this).t(this.P8.f13467k).s1(this.R8);
            this.R8.setVisibility(0);
        } else if (this.P8.f13469m != -1) {
            com.bumptech.glide.b.G(this).p(Integer.valueOf(this.P8.f13469m)).s1(this.R8);
            this.R8.setVisibility(0);
        }
        this.J8.setVisibility(this.P8.f13468l ? 0 : 8);
        if (this.P8.f13457a) {
            this.N8.setVisibility(0);
            this.G8.setVisibility(8);
        } else {
            this.N8.setVisibility(8);
            this.G8.setVisibility(0);
        }
        U5(this.P8.f13458b);
        D6(this.P8.f13472p);
        E6(this.P8.f13471o);
        F6(this.P8.f13473q);
        this.H8.setOnClickListener(new View.OnClickListener() { // from class: p5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46422a.u6(view);
            }
        });
        this.I8.setOnClickListener(new View.OnClickListener() { // from class: p5.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46421a.v6(view);
            }
        });
        this.O8.setOnClickListener(new View.OnClickListener() { // from class: p5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46424a.w6(view);
            }
        });
    }

    public boolean s6() {
        return this.J8.isSelected();
    }
}
