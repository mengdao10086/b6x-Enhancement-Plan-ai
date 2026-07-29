package com.flydigi.cyberfox.ui.upgrade.h1;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.g;
import com.flydigi.cyberfox.R;
import com.flydigi.cyberfox.h1.base.CyberFoxFragment;
import com.flydigi.cyberfox.h1.services.b;
import com.flydigi.cyberfox.ui.upgrade.h1.UpgradeFragment;
import h6.l;
import java.io.File;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class UpgradeFragment extends CyberFoxFragment {

    @k
    public static final a E8 = new a(null);
    public l D8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final UpgradeFragment a() {
            UpgradeFragment upgradeFragment = new UpgradeFragment();
            upgradeFragment.c5(new Bundle());
            return upgradeFragment;
        }
    }

    public static final void J6(UpgradeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.K6(new File("/storage/emulated/0/20191227_FLYDIGI_Cyberfox_BT_OTA_FW_MP_Ver0.0.1.6.bin"));
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void B6(double d10) {
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void C6(int i10) {
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void H6() {
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        Window window;
        super.K3(bundle);
        g gVarW1 = w1();
        if (gVarW1 == null || (window = gVarW1.getWindow()) == null) {
            return;
        }
        window.addFlags(128);
    }

    public final void K6(File file) {
        if (file != null) {
            G6(0L);
            this.f14120o8.z(file);
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.cf_fragment_upgrade;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        l lVarD = l.d(inflater, viewGroup, false);
        f0.o(lVarD, "inflate(inflater, container, false)");
        this.D8 = lVarD;
        if (lVarD == null) {
            f0.S("viewBinding");
            lVarD = null;
        }
        LinearLayout root = lVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        b bVar = this.f14120o8;
        if (bVar != null && bVar.N()) {
            this.f14120o8.K(false);
        }
        super.a4();
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, com.flydigi.cyberfox.h1.base.ServiceFragment
    public void e6(@k Message msg) {
        f0.p(msg, "msg");
        int i10 = msg.what;
        if (i10 == -1) {
            Object obj = msg.obj;
            f0.n(obj, "null cannot be cast to non-null type kotlin.Int");
            p6(((Integer) obj).intValue());
            return;
        }
        if (i10 == 0) {
            Object obj2 = msg.obj;
            f0.n(obj2, "null cannot be cast to non-null type kotlin.Int");
            ((Integer) obj2).intValue();
            b bVar = this.f14120o8;
            if (bVar == null || !bVar.N()) {
                Object obj3 = msg.obj;
                f0.n(obj3, "null cannot be cast to non-null type kotlin.Int");
                v6(((Integer) obj3).intValue());
                return;
            }
            return;
        }
        if (i10 == 1) {
            Object obj4 = msg.obj;
            f0.n(obj4, "null cannot be cast to non-null type kotlin.Int");
            ((Integer) obj4).intValue();
        } else if (i10 == 6) {
            q6(msg.arg1, msg.obj);
        } else {
            if (i10 != 7) {
                return;
            }
            s6(msg.arg1, msg.obj);
        }
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        b bVar = this.f14120o8;
        if (bVar == null || !bVar.N()) {
            return;
        }
        this.f14120o8.K(false);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment, com.flydigi.cyberfox.h1.base.ServiceFragment
    public void i6() {
        this.f14120o8.K(true);
        this.f14120o8.m(false);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        l lVar = this.D8;
        if (lVar == null) {
            f0.S("viewBinding");
            lVar = null;
        }
        lVar.f30658b.setOnClickListener(new View.OnClickListener() { // from class: r6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UpgradeFragment.J6(this.f47746a, view2);
            }
        });
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment
    public void j6() {
        this.f14120o8.K(false);
        this.f14120o8.m(false);
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void l6(int i10) {
        if (i10 == 1) {
            this.f14120o8.d(i10, true);
            return;
        }
        if (i10 == 2) {
            this.f14120o8.d(i10, true);
            return;
        }
        if (i10 == 3) {
            this.f14120o8.d(i10, true);
        } else if (i10 == 4) {
            this.f14120o8.d(i10, false);
        } else {
            if (i10 != 5) {
                return;
            }
            this.f14120o8.d(i10, false);
        }
    }

    @Override // com.flydigi.cyberfox.h1.base.CyberFoxFragment
    public void r6(@k jg.b error) {
        f0.p(error, "error");
        error.a();
    }
}
