package com.flydigi.cyberfox.ui.detail.h1;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.blankj.utilcode.util.o;
import com.flydigi.cyberfox.R;
import com.flydigi.cyberfox.h1.base.CyberFoxFragment;
import com.flydigi.cyberfox.ui.detail.h1.H1DetailFragment;
import com.flydigi.data.DataConstant;
import h6.j;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v0;
import kotlin.text.StringsKt__StringsKt;
import o5.c;
import o5.m;
import u9.g;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class H1DetailFragment extends CyberFoxFragment {
    public static final long L8 = 4000;
    public int D8;
    public boolean E8;
    public int F8;
    public boolean G8;

    @k
    public final Runnable H8 = new Runnable() { // from class: q6.g
        @Override // java.lang.Runnable
        public final void run() {
            H1DetailFragment.R6(this.f47126a);
        }
    };

    @k
    public final Runnable I8 = new Runnable() { // from class: q6.f
        @Override // java.lang.Runnable
        public final void run() {
            H1DetailFragment.S6(this.f47125a);
        }
    };
    public j J8;

    @k
    public static final a K8 = new a(null);

    @k
    public static String M8 = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final H1DetailFragment a(@k String deviceCode) {
            f0.p(deviceCode, "deviceCode");
            H1DetailFragment h1DetailFragment = new H1DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key_device_code", deviceCode);
            h1DetailFragment.c5(bundle);
            return h1DetailFragment;
        }

        @k
        public final String b() {
            return H1DetailFragment.M8;
        }

        public final void c(@k String str) {
            f0.p(str, "<set-?>");
            H1DetailFragment.M8 = str;
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f14233a;

        public b(LinearLayout linearLayout) {
            this.f14233a = linearLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@l Animation animation) {
            LinearLayout it2 = this.f14233a;
            f0.o(it2, "it");
            c.b(it2, Boolean.FALSE, false, 2, null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@l Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@l Animation animation) {
        }
    }

    public static final void R6(H1DetailFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.U6();
    }

    public static final void S6(H1DetailFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.T6(false);
    }

    public static final void V6(H1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.E6(!view.isSelected());
    }

    public static final void W6(H1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, f6.b.f27992b).navigation(this$0.w1());
    }

    public static final void X6(H1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.D6(0);
    }

    public static final void Y6(H1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.D6(1);
    }

    public static final void Z6(H1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.D6(2);
    }

    public static /* synthetic */ void d7(H1DetailFragment h1DetailFragment, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        h1DetailFragment.c7(i10, z10);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void D6(int i10) {
        if (this.f14117y8 == i10) {
            return;
        }
        d7(this, i10, false, 2, null);
        T6(true);
        H5().g(this.I8);
        super.D6(i10);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void E6(boolean z10) {
        T6(true);
        super.E6(z10);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, k6.g.c
    public void K0(@k String command, @k String status) {
        f0.p(command, "command");
        f0.p(status, "status");
        super.K0(command, status);
        T6(false);
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        if (!TextUtils.isEmpty(M8)) {
            HashMap map = new HashMap();
            map.put("source", M8);
            g.a().e(X1(), "cyberfox_page", map);
            M8 = "";
        }
        F6(true);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.cf_fragment_detail_h1;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        j jVarD = j.d(inflater, viewGroup, false);
        f0.o(jVarD, "inflate(inflater, container, false)");
        this.J8 = jVarD;
        if (jVarD == null) {
            f0.S("viewBinding");
            jVarD = null;
        }
        NestedScrollView root = jVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        H5().g(this.H8);
        H5().g(this.I8);
        super.R3();
    }

    public final void T6(boolean z10) {
        j jVar = this.J8;
        j jVar2 = null;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        jVar.f30620m.setEnabled(!z10);
        j jVar3 = this.J8;
        if (jVar3 == null) {
            f0.S("viewBinding");
            jVar3 = null;
        }
        jVar3.f30617j.setEnabled(!z10);
        j jVar4 = this.J8;
        if (jVar4 == null) {
            f0.S("viewBinding");
            jVar4 = null;
        }
        jVar4.f30616i.setEnabled(!z10);
        j jVar5 = this.J8;
        if (jVar5 == null) {
            f0.S("viewBinding");
            jVar5 = null;
        }
        jVar5.f30614g.setEnabled(!z10);
        j jVar6 = this.J8;
        if (jVar6 == null) {
            f0.S("viewBinding");
            jVar6 = null;
        }
        jVar6.f30615h.setEnabled(!z10);
        j jVar7 = this.J8;
        if (jVar7 == null) {
            f0.S("viewBinding");
        } else {
            jVar2 = jVar7;
        }
        jVar2.f30613f.setEnabled(!z10);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, k6.g.c
    public void U0() {
        super.U0();
        this.G8 = true;
        this.F8++;
        H5().f(this.I8, 2000L);
    }

    public final void U6() {
        j jVar = this.J8;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        LinearLayout linearLayout = jVar.f30609b;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setAnimationListener(new b(linearLayout));
        linearLayout.startAnimation(translateAnimation);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, k6.g.c
    public void a0(@k String command) {
        f0.p(command, "command");
        super.a0(command);
        T6(false);
    }

    public void a7(boolean z10) {
        super.z6(Boolean.valueOf(z10));
        j jVar = this.J8;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        jVar.f30620m.setSelected(z10);
        T6(false);
    }

    public final void b7() {
        j jVar = this.J8;
        j jVar2 = null;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        jVar.f30614g.setSelected(false);
        j jVar3 = this.J8;
        if (jVar3 == null) {
            f0.S("viewBinding");
            jVar3 = null;
        }
        jVar3.f30615h.setSelected(false);
        j jVar4 = this.J8;
        if (jVar4 == null) {
            f0.S("viewBinding");
        } else {
            jVar2 = jVar4;
        }
        jVar2.f30613f.setSelected(false);
    }

    public final void c7(int i10, boolean z10) {
        H5().g(this.H8);
        j jVar = this.J8;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        LinearLayout it2 = jVar.f30609b;
        if (it2.getVisibility() == 8) {
            if (z10) {
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
                translateAnimation.setDuration(250L);
                it2.startAnimation(translateAnimation);
            }
            f0.o(it2, "it");
            c.b(it2, Boolean.TRUE, false, 2, null);
        }
        if (i10 == 0) {
            j jVar2 = this.J8;
            if (jVar2 == null) {
                f0.S("viewBinding");
                jVar2 = null;
            }
            jVar2.f30622o.setText(R.string.cf_latency_name_low);
            j jVar3 = this.J8;
            if (jVar3 == null) {
                f0.S("viewBinding");
                jVar3 = null;
            }
            jVar3.f30623p.setText(R.string.cf_latency_desc_low);
            if (!m.k(DataConstant.SP_APP).e(DataConstant.SP_CYBERFOX_LATENCY_LOW_HINT_SHOWN)) {
                j jVar4 = this.J8;
                if (jVar4 == null) {
                    f0.S("viewBinding");
                    jVar4 = null;
                }
                TextView textView = jVar4.f30624q;
                f0.o(textView, "viewBinding.tvLatencyLowHint");
                c.b(textView, Boolean.TRUE, false, 2, null);
                m.k(DataConstant.SP_APP).F(DataConstant.SP_CYBERFOX_LATENCY_LOW_HINT_SHOWN, true);
            }
        } else if (i10 == 1) {
            j jVar5 = this.J8;
            if (jVar5 == null) {
                f0.S("viewBinding");
                jVar5 = null;
            }
            jVar5.f30622o.setText(R.string.cf_latency_name_middle);
            j jVar6 = this.J8;
            if (jVar6 == null) {
                f0.S("viewBinding");
                jVar6 = null;
            }
            jVar6.f30623p.setText(R.string.cf_latency_desc_middle);
            j jVar7 = this.J8;
            if (jVar7 == null) {
                f0.S("viewBinding");
                jVar7 = null;
            }
            TextView textView2 = jVar7.f30624q;
            f0.o(textView2, "viewBinding.tvLatencyLowHint");
            c.b(textView2, Boolean.FALSE, false, 2, null);
        } else if (i10 == 2) {
            j jVar8 = this.J8;
            if (jVar8 == null) {
                f0.S("viewBinding");
                jVar8 = null;
            }
            jVar8.f30622o.setText(R.string.cf_latency_name_high);
            j jVar9 = this.J8;
            if (jVar9 == null) {
                f0.S("viewBinding");
                jVar9 = null;
            }
            jVar9.f30623p.setText(R.string.cf_latency_desc_high);
            j jVar10 = this.J8;
            if (jVar10 == null) {
                f0.S("viewBinding");
                jVar10 = null;
            }
            TextView textView3 = jVar10.f30624q;
            f0.o(textView3, "viewBinding.tvLatencyLowHint");
            c.b(textView3, Boolean.FALSE, false, 2, null);
        }
        if (z10) {
            H5().f(this.H8, L8);
        }
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, k6.g.c
    public void f1(@k String command) {
        f0.p(command, "command");
        super.f1(command);
        T6(false);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        String string;
        f0.p(view, "view");
        super.j4(view, bundle);
        Bundle bundleT1 = T1();
        j jVar = null;
        if (bundleT1 != null && (string = bundleT1.getString("key_device_code")) != null) {
            j jVar2 = this.J8;
            if (jVar2 == null) {
                f0.S("viewBinding");
                jVar2 = null;
            }
            jVar2.f30621n.setText(s6.a.b(string));
        }
        j jVar3 = this.J8;
        if (jVar3 == null) {
            f0.S("viewBinding");
            jVar3 = null;
        }
        TextView textView = jVar3.f30617j;
        v0 v0Var = v0.f37964a;
        String strC3 = c3(R.string.cf_current_version_);
        f0.o(strC3, "getString(R.string.cf_current_version_)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{""}, 1));
        f0.o(str, "format(format, *args)");
        textView.setText(str);
        j jVar4 = this.J8;
        if (jVar4 == null) {
            f0.S("viewBinding");
            jVar4 = null;
        }
        o.r(jVar4.f30620m, new View.OnClickListener() { // from class: q6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                H1DetailFragment.V6(this.f47121a, view2);
            }
        });
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(14, true);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c3(R.string.cf_label_setting_latency_hint));
        spannableStringBuilder.setSpan(absoluteSizeSpan, StringsKt__StringsKt.s3(spannableStringBuilder, "－", 0, false, 6, null), StringsKt__StringsKt.s3(spannableStringBuilder, "－", 0, false, 6, null) + 1, 17);
        j jVar5 = this.J8;
        if (jVar5 == null) {
            f0.S("viewBinding");
            jVar5 = null;
        }
        jVar5.f30625r.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(c3(R.string.cf_label_setting_led_hint));
        spannableStringBuilder2.setSpan(absoluteSizeSpan, StringsKt__StringsKt.s3(spannableStringBuilder2, "＋", 0, false, 6, null), StringsKt__StringsKt.s3(spannableStringBuilder2, "＋", 0, false, 6, null) + 1, 17);
        j jVar6 = this.J8;
        if (jVar6 == null) {
            f0.S("viewBinding");
            jVar6 = null;
        }
        jVar6.f30625r.setText(spannableStringBuilder2);
        j jVar7 = this.J8;
        if (jVar7 == null) {
            f0.S("viewBinding");
            jVar7 = null;
        }
        o.r(jVar7.f30616i, new View.OnClickListener() { // from class: q6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                H1DetailFragment.W6(this.f47120a, view2);
            }
        });
        j jVar8 = this.J8;
        if (jVar8 == null) {
            f0.S("viewBinding");
            jVar8 = null;
        }
        o.r(jVar8.f30614g, new View.OnClickListener() { // from class: q6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                H1DetailFragment.X6(this.f47123a, view2);
            }
        });
        j jVar9 = this.J8;
        if (jVar9 == null) {
            f0.S("viewBinding");
            jVar9 = null;
        }
        o.r(jVar9.f30615h, new View.OnClickListener() { // from class: q6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                H1DetailFragment.Y6(this.f47124a, view2);
            }
        });
        j jVar10 = this.J8;
        if (jVar10 == null) {
            f0.S("viewBinding");
        } else {
            jVar = jVar10;
        }
        o.r(jVar.f30613f, new View.OnClickListener() { // from class: q6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                H1DetailFragment.Z6(this.f47122a, view2);
            }
        });
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void v6(int i10) {
        j jVar = null;
        if (i10 == 0) {
            j jVar2 = this.J8;
            if (jVar2 == null) {
                f0.S("viewBinding");
            } else {
                jVar = jVar2;
            }
            jVar.f30628u.setText(R.string.cf_state_unconnected);
        } else {
            j jVar3 = this.J8;
            if (jVar3 == null) {
                f0.S("viewBinding");
            } else {
                jVar = jVar3;
            }
            jVar.f30628u.setText(R.string.cf_state_connected);
        }
        T6(2 != i10);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, k6.g.c
    public void w0() {
        super.w0();
        j jVar = this.J8;
        j jVar2 = null;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        ImageView imageView = jVar.f30620m;
        j jVar3 = this.J8;
        if (jVar3 == null) {
            f0.S("viewBinding");
        } else {
            jVar2 = jVar3;
        }
        imageView.setSelected(!jVar2.f30620m.isSelected());
        T6(false);
        this.E8 = true;
        this.D8++;
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void x6(int i10) {
        super.x6(i10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append((i10 % 10000) / 1000);
        sb2.append('.');
        sb2.append((i10 % 1000) / 100);
        sb2.append('.');
        sb2.append((i10 % 100) / 10);
        sb2.append('.');
        sb2.append(i10 % 10);
        String string = sb2.toString();
        j jVar = this.J8;
        if (jVar == null) {
            f0.S("viewBinding");
            jVar = null;
        }
        TextView textView = jVar.f30617j;
        v0 v0Var = v0.f37964a;
        String strC3 = c3(R.string.cf_current_version_);
        f0.o(strC3, "getString(R.string.cf_current_version_)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{string}, 1));
        f0.o(str, "format(format, *args)");
        textView.setText(str);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void y6(int i10) {
        super.y6(i10);
        b7();
        j jVar = null;
        if (i10 == 0) {
            j jVar2 = this.J8;
            if (jVar2 == null) {
                f0.S("viewBinding");
            } else {
                jVar = jVar2;
            }
            jVar.f30614g.setSelected(true);
        } else if (i10 == 1) {
            j jVar3 = this.J8;
            if (jVar3 == null) {
                f0.S("viewBinding");
                jVar3 = null;
            }
            jVar3.f30615h.setSelected(true);
            j jVar4 = this.J8;
            if (jVar4 == null) {
                f0.S("viewBinding");
                jVar4 = null;
            }
            TextView textView = jVar4.f30624q;
            f0.o(textView, "viewBinding.tvLatencyLowHint");
            c.b(textView, Boolean.FALSE, false, 2, null);
        } else if (i10 == 2) {
            j jVar5 = this.J8;
            if (jVar5 == null) {
                f0.S("viewBinding");
                jVar5 = null;
            }
            jVar5.f30613f.setSelected(true);
            j jVar6 = this.J8;
            if (jVar6 == null) {
                f0.S("viewBinding");
                jVar6 = null;
            }
            TextView textView2 = jVar6.f30624q;
            f0.o(textView2, "viewBinding.tvLatencyLowHint");
            c.b(textView2, Boolean.FALSE, false, 2, null);
        }
        c7(i10, m.k(DataConstant.SP_APP).e(DataConstant.SP_CYBERFOX_LATENCY_LOW_HINT_SHOWN));
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public /* bridge */ /* synthetic */ void z6(Boolean bool) {
        a7(bool.booleanValue());
    }
}
