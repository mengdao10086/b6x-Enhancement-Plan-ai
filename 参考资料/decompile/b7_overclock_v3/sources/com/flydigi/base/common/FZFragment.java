package com.flydigi.base.common;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.flydigi.base.R;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.google.android.material.appbar.AppBarLayout;
import g.c1;
import g.i0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FZFragment extends BaseFragment implements u {

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public AppBarLayout f13319f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public Toolbar f13320g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public TextView f13321h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public View f13322i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public View f13323j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public View f13324k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public ViewGroup f13325l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public LoadingDialogFragment f13326m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public io.reactivex.disposables.a f13327n8 = new io.reactivex.disposables.a();

    @Override // com.flydigi.base.common.u
    public void E0() {
        LoadingDialogFragment loadingDialogFragment = this.f13326m8;
        if (loadingDialogFragment != null) {
            loadingDialogFragment.I5();
            this.f13326m8 = null;
        }
    }

    public void J5(View view) {
        this.f13319f8 = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        this.f13320g8 = (Toolbar) view.findViewById(R.id.toolbar);
        this.f13321h8 = (TextView) view.findViewById(R.id.tv_title_toolbar);
        Drawable navigationIcon = this.f13320g8.getNavigationIcon();
        if (navigationIcon != null) {
            n0.c.n(navigationIcon, h0.d.f(X1(), R.color.color_black));
        }
        i5(true);
        Toolbar toolbar = this.f13320g8;
        if (toolbar != null) {
            Q5(toolbar);
        }
        if (M5() != null) {
            M5().Y(true);
            M5().d0(false);
        }
    }

    public Fragment K5() {
        return this;
    }

    @i0
    public abstract int L5();

    public androidx.appcompat.app.a M5() {
        return this.f13317d8.I3();
    }

    public void N5() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @p0
    public View O3(@yt.k LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        if (L5() == 0) {
            return super.O3(layoutInflater, viewGroup, bundle);
        }
        String.format("%s(%d) onCreateView()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        return layoutInflater.inflate(L5(), viewGroup, false);
    }

    public void O5(@c1 int i10, @g.v int i11) {
        ImageView imageView;
        TextView textView;
        View view = this.f13322i8;
        if (view == null) {
            return;
        }
        if (i10 != -1 && (textView = (TextView) view.findViewById(R.id.tv_message)) != null) {
            textView.setText(i10);
        }
        if (i11 == -1 || (imageView = (ImageView) this.f13322i8.findViewById(R.id.iv_message)) == null) {
            return;
        }
        imageView.setImageResource(i11);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        Y5();
        super.P3();
    }

    public void P5(RecyclerView recyclerView) {
        this.f13325l8 = (ViewGroup) recyclerView.getParent();
        this.f13322i8 = w2().inflate(R.layout.base_layout_view_placehoder_empty, this.f13325l8, false);
        this.f13323j8 = w2().inflate(R.layout.base_layout_view_placeholder_loading, this.f13325l8, false);
        this.f13324k8 = w2().inflate(R.layout.base_layout_view_placehoder_error, this.f13325l8, false);
    }

    public final void Q5(Toolbar toolbar) {
        i5(true);
        this.f13317d8.Q3(toolbar);
        M5().Y(false);
        M5().d0(false);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        E0();
        this.f13327n8.dispose();
        super.R3();
    }

    public void R5(String str) {
        TextView textView = this.f13321h8;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void S5() {
    }

    public void T5() {
        if (this.f13325l8 == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f13325l8.getChildCount(); i10++) {
            View childAt = this.f13325l8.getChildAt(i10);
            if (childAt == this.f13322i8 || childAt == this.f13323j8 || childAt == this.f13324k8) {
                childAt.setVisibility(8);
            } else {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        if (z10) {
            return;
        }
        S5();
    }

    public void U5() {
        if (this.f13325l8 == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f13325l8.getChildCount(); i10++) {
            View childAt = this.f13325l8.getChildAt(i10);
            if (childAt == this.f13322i8) {
                childAt.setVisibility(0);
            } else {
                childAt.setVisibility(8);
            }
        }
    }

    public void V5() {
        if (this.f13325l8 == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f13325l8.getChildCount(); i10++) {
            View childAt = this.f13325l8.getChildAt(i10);
            if (childAt == this.f13324k8) {
                childAt.setVisibility(0);
                childAt.bringToFront();
            } else {
                childAt.setVisibility(8);
            }
        }
    }

    public void W5(String str, @g.v int i10) {
        ImageView imageView;
        TextView textView;
        if (this.f13324k8 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && (textView = (TextView) this.f13324k8.findViewById(R.id.tv_error_tip)) != null) {
            textView.setText(str);
        }
        if (i10 != -1 && (imageView = (ImageView) this.f13324k8.findViewById(R.id.iv_message)) != null) {
            imageView.setImageResource(i10);
        }
        V5();
    }

    public void X5() {
        if (this.f13325l8 == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f13325l8.getChildCount(); i10++) {
            View childAt = this.f13325l8.getChildAt(i10);
            if (childAt == this.f13323j8) {
                childAt.setVisibility(0);
            } else {
                childAt.setVisibility(8);
            }
        }
    }

    public void Y5() {
        if (tt.c.f().o(this)) {
            tt.c.f().A(this);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        KeyboardUtils.j(this.f13317d8);
        super.a4();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        if (C3()) {
            S5();
        }
    }

    @Override // com.flydigi.base.common.u
    public void x(String str, boolean z10) {
        LoadingDialogFragment loadingDialogFragment = this.f13326m8;
        if (loadingDialogFragment != null) {
            loadingDialogFragment.d6(str);
            this.f13326m8.U5(z10);
            return;
        }
        E0();
        LoadingDialogFragment loadingDialogFragmentB6 = LoadingDialogFragment.b6(str);
        this.f13326m8 = loadingDialogFragmentB6;
        loadingDialogFragmentB6.U5(z10);
        o5.a.t0(U1(), this.f13326m8);
    }
}
