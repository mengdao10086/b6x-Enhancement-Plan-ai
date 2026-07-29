package com.flydigi.device_manager.ui.remove_bond;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.d1;
import com.bumptech.glide.b;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import g.n0;
import g.p0;
import i9.a;
import java.util.Iterator;
import m9.s;
import m9.t;
import o5.f;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class RemoveBondFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public String f15383o8 = "all";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f15384p8 = false;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public a f15385q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public TextView f15386r8;

    public interface a {
        void d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c6(View view) {
        f.e(X1());
    }

    public static RemoveBondFragment d6(String str, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("key_device_code", str);
        bundle.putBoolean(DataConstant.DEVICE_KEY_REMOVE_BOND_WHEN_UPGRADE_FIRMWARE, z10);
        RemoveBondFragment removeBondFragment = new RemoveBondFragment();
        removeBondFragment.c5(bundle);
        return removeBondFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@n0 Context context) {
        super.H3(context);
        if (context instanceof a) {
            this.f15385q8 = (a) context;
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_remove_bond;
    }

    public final boolean a6(String str) {
        Iterator<BluetoothDevice> it2 = s.g().iterator();
        while (it2.hasNext()) {
            if (com.blankj.utilcode.util.n0.b(t.i(it2.next().getName()), str)) {
                return true;
            }
        }
        return false;
    }

    public final void b6() {
        x(c3(R.string.device_tips_check_device_bonded), true);
        boolean zA6 = a6(this.f15383o8);
        E0();
        e6(zA6);
        if (zA6) {
            return;
        }
        if (!this.f15384p8) {
            this.f13317d8.finish();
            return;
        }
        a aVar = this.f15385q8;
        if (aVar != null) {
            aVar.d();
        } else {
            h3.a.j().d(a.d.f31952h).withString("key_device_code", this.f15383o8).navigation(w1());
            this.f13317d8.finish();
        }
    }

    public final void e6(boolean z10) {
        if (z10) {
            this.f15386r8.setText(R.string.device_bluetooth_bond_state_bonded);
            Drawable drawable = V2().getDrawable(R.drawable.device_ic_error);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f15386r8.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        this.f15386r8.setText(R.string.device_bluetooth_bond_state_notbond);
        Drawable drawable2 = V2().getDrawable(R.drawable.device_ic_success);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.f15386r8.setCompoundDrawables(null, null, drawable2, null);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        b6();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        if (T1() != null) {
            String string = T1().getString("key_device_code");
            this.f15383o8 = string;
            this.f15383o8 = d1.g(string) ? "all" : this.f15383o8;
            this.f15384p8 = T1().getBoolean(DataConstant.DEVICE_KEY_REMOVE_BOND_WHEN_UPGRADE_FIRMWARE, false);
        }
        this.f15386r8 = (TextView) F5(R.id.tv_bond_state);
        TextView textView = (TextView) F5(R.id.btn_go_bluetooth_setting);
        b.G(this).p(Integer.valueOf(R.drawable.device_bluetooth_remove_bond)).s1((ImageView) F5(R.id.iv_pic));
        textView.setOnClickListener(new View.OnClickListener() { // from class: p7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f46498a.c6(view2);
            }
        });
    }
}
