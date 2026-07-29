package com.flydigi.base.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.g0;
import com.trello.rxlifecycle3.components.support.RxDialogFragment;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDialogFragment extends RxDialogFragment {
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void E3(@p0 Bundle bundle) {
        super.E3(bundle);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onActivityCreated");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void H3(@n0 Context context) {
        super.H3(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onAttach");
    }

    @Override // androidx.fragment.app.Fragment
    public void I3(@n0 Fragment fragment) {
        super.I3(fragment);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onAttachFragment");
    }

    @Override // androidx.fragment.app.DialogFragment
    public void I5() {
        super.I5();
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onCreateView");
        return layoutInflater.inflate(c6(), viewGroup);
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onDestroy");
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void R3() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onDestroyView");
        f6();
        super.R3();
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void S3() {
        super.S3();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onDetach");
    }

    @Override // androidx.fragment.app.DialogFragment
    public void Z5(@n0 FragmentManager fragmentManager, @p0 String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass().getSimpleName());
            sb2.append(" show");
            g0 g0VarU = fragmentManager.u();
            g0VarU.k(this, str);
            g0VarU.r();
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onPause");
    }

    public abstract int c6();

    public void d6() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    public void e6() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" safeDismiss");
        I5();
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onResume");
    }

    public void f6() {
        if (tt.c.f().o(this)) {
            tt.c.f().A(this);
        }
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onStart");
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onStop");
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onViewCreated");
    }
}
