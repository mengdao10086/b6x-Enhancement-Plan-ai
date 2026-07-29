package com.flydigi.device_manager.ui.driver_active;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.device_manager.R;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.v0;

/* JADX INFO: loaded from: classes7.dex */
public final class UsbDebugGuideDialog extends BaseDialogFragment {

    @yt.k
    public static final a J8 = new a(null);

    @yt.k
    public static final String K8 = "key_active_failed";

    @yt.l
    public io.reactivex.disposables.b E8;
    public long F8 = 5;

    @yt.l
    public b G8;
    public boolean H8;
    public c7.b0 I8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ UsbDebugGuideDialog b(a aVar, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.a(z10);
        }

        @yt.k
        public final UsbDebugGuideDialog a(boolean z10) {
            UsbDebugGuideDialog usbDebugGuideDialog = new UsbDebugGuideDialog();
            usbDebugGuideDialog.c5(androidx.core.os.e.b(new Pair(UsbDebugGuideDialog.K8, Boolean.valueOf(z10))));
            return usbDebugGuideDialog;
        }
    }

    public interface b {
        void open();
    }

    public static final class c extends m5.a<Long> {
        public c() {
        }

        public void a(long j10) {
            UsbDebugGuideDialog.this.F8 = j10;
            UsbDebugGuideDialog.this.r6(j10);
        }

        @Override // m5.a, xi.g0
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        @Override // m5.a, xi.g0
        public void onSubscribe(@yt.k io.reactivex.disposables.b d10) {
            kotlin.jvm.internal.f0.p(d10, "d");
            super.onSubscribe(d10);
            UsbDebugGuideDialog.this.E8 = d10;
        }
    }

    public static final Long n6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (Long) tmp0.i(obj);
    }

    public static final void p6(UsbDebugGuideDialog this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        b bVar = this$0.G8;
        if (bVar != null) {
            bVar.open();
        }
    }

    public static final void q6(UsbDebugGuideDialog this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.m6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.H8 = bundleT1 != null ? bundleT1.getBoolean(K8) : false;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        c7.b0 b0VarD = c7.b0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(b0VarD, "inflate(inflater, container, false)");
        this.I8 = b0VarD;
        if (b0VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            b0VarD = null;
        }
        LinearLayout root = b0VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        super.R3();
        io.reactivex.disposables.b bVar = this.E8;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return this.H8 ? R.layout.device_dialog_active_failed : R.layout.device_dialog_usb_debug;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        long j10 = this.F8;
        if (j10 > 0) {
            m6();
        } else {
            r6(j10);
        }
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        if (this.H8) {
            View viewFindViewById = view.findViewById(R.id.tv_option_1);
            kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(\n     …tv_option_1\n            )");
            TextView textView = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_option_2);
            kotlin.jvm.internal.f0.o(viewFindViewById2, "view.findViewById(\n     …tv_option_2\n            )");
            TextView textView2 = (TextView) viewFindViewById2;
            textView.setCompoundDrawablesWithIntrinsicBounds(o5.b.k(X1()) ? R.drawable.device_ic_success : R.drawable.device_ic_error, 0, 0, 0);
            if (o5.h.l() || o5.h.d()) {
                textView2.setCompoundDrawablesWithIntrinsicBounds(o5.b.l() ? R.drawable.device_ic_success : R.drawable.device_ic_error, 0, 0, 0);
            }
        } else {
            View viewFindViewById3 = view.findViewById(R.id.tv_title);
            kotlin.jvm.internal.f0.o(viewFindViewById3, "view.findViewById(\n     …id.tv_title\n            )");
            TextView textView3 = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.tv_option_1);
            kotlin.jvm.internal.f0.o(viewFindViewById4, "view.findViewById(\n     …tv_option_1\n            )");
            TextView textView4 = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.tv_option_2);
            kotlin.jvm.internal.f0.o(viewFindViewById5, "view.findViewById(\n     …tv_option_2\n            )");
            TextView textView5 = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.tv_option_3);
            kotlin.jvm.internal.f0.o(viewFindViewById6, "view.findViewById(\n     …tv_option_3\n            )");
            TextView textView6 = (TextView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.tv_option_4);
            kotlin.jvm.internal.f0.o(viewFindViewById7, "view.findViewById(\n     …tv_option_4\n            )");
            TextView textView7 = (TextView) viewFindViewById7;
            textView4.setText(R.string.floatview_usb_debug_enable_content_developer_option);
            if (o5.h.h()) {
                textView3.setText(y0.c.a(c3(R.string.floatview_usb_debug_enable_title), 0));
                textView5.setText(R.string.floatview_usb_debug_enable_content_adb_in_charging);
                textView6.setText(R.string.floatview_usb_debug_enable_content_promt_always);
                textView7.setText(R.string.floatview_usb_debug_enable_content_usb_debug);
                Object parent = textView5.getParent();
                kotlin.jvm.internal.f0.n(parent, "null cannot be cast to non-null type android.view.View");
                Boolean bool = Boolean.TRUE;
                o5.c.b((View) parent, bool, false, 2, null);
                Object parent2 = textView6.getParent();
                kotlin.jvm.internal.f0.n(parent2, "null cannot be cast to non-null type android.view.View");
                o5.c.b((View) parent2, bool, false, 2, null);
                Object parent3 = textView7.getParent();
                kotlin.jvm.internal.f0.n(parent3, "null cannot be cast to non-null type android.view.View");
                o5.c.b((View) parent3, bool, false, 2, null);
            } else if (o5.h.p()) {
                textView3.setText(R.string.floatview_usb_debug_enable_title_single);
                textView4.setText(R.string.floatview_usb_debug_enable_content_usb_debug);
            } else {
                int i10 = R.string.floatview_usb_debug_enable_title;
                textView3.setText(y0.c.a(c3(i10), 0));
                textView5.setText(R.string.floatview_usb_debug_enable_content_usb_debug);
                Object parent4 = textView5.getParent();
                kotlin.jvm.internal.f0.n(parent4, "null cannot be cast to non-null type android.view.View");
                Boolean bool2 = Boolean.TRUE;
                o5.c.b((View) parent4, bool2, false, 2, null);
                if (o5.h.A() || o5.h.d()) {
                    textView3.setText(y0.c.a(c3(i10), 0));
                    textView6.setText(R.string.floatview_usb_debug_enable_content_usb_debug_safe);
                    Object parent5 = textView6.getParent();
                    kotlin.jvm.internal.f0.n(parent5, "null cannot be cast to non-null type android.view.View");
                    o5.c.b((View) parent5, bool2, false, 2, null);
                }
            }
        }
        com.blankj.utilcode.util.o.r((TextView) view.findViewById(R.id.btn_action), new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UsbDebugGuideDialog.p6(this.f14943a, view2);
            }
        });
        r6(this.F8);
        view.post(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.x
            @Override // java.lang.Runnable
            public final void run() {
                UsbDebugGuideDialog.q6(this.f14945a);
            }
        });
    }

    public final void m6() {
        io.reactivex.disposables.b bVar = this.E8;
        if (bVar != null && !bVar.isDisposed()) {
            bVar.dispose();
        }
        final long j10 = this.F8;
        xi.z<Long> zVarA6 = xi.z.g3(1L, TimeUnit.SECONDS).a6(1 + j10);
        final ik.l<Long, Long> lVar = new ik.l<Long, Long>() { // from class: com.flydigi.device_manager.ui.driver_active.UsbDebugGuideDialog$countDown$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Long b(long j11) {
                return Long.valueOf(j10 - j11);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ Long i(Long l10) {
                return b(l10.longValue());
            }
        };
        zVarA6.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.driver_active.w
            @Override // dj.o
            public final Object apply(Object obj) {
                return UsbDebugGuideDialog.n6(lVar, obj);
            }
        }).s0(m5.c0.t()).s0(o5.l.d()).c(new c());
    }

    @yt.l
    public final b o6() {
        return this.G8;
    }

    public final void r6(long j10) {
        c7.b0 b0Var = this.I8;
        if (b0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            b0Var = null;
        }
        TextView textView = b0Var.f9826b;
        if (j10 <= 0) {
            textView.setText(c3(R.string.device_go_to_setting));
            textView.setEnabled(true);
            return;
        }
        v0 v0Var = v0.f37964a;
        String strC3 = c3(R.string.device_go_to_setting_countdown);
        kotlin.jvm.internal.f0.o(strC3, "getString(R.string.device_go_to_setting_countdown)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{Long.valueOf(j10)}, 1));
        kotlin.jvm.internal.f0.o(str, "format(format, *args)");
        textView.setText(str);
        textView.setEnabled(false);
    }

    public final void s6(@yt.l b bVar) {
        this.G8 = bVar;
    }
}
