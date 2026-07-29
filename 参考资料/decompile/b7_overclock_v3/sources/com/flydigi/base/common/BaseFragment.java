package com.flydigi.base.common;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.base.common.y;
import com.trello.rxlifecycle3.components.support.RxFragment;
import g.d0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class BaseFragment extends RxFragment implements y.a, a, t {

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public androidx.appcompat.app.f f13317d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public y f13318e8;

    @Override // com.flydigi.base.common.y.a
    public boolean D2(Message message, int i10, boolean z10) {
        return false;
    }

    public <T extends View> T F5(@d0 int i10) {
        if (k3() != null) {
            return (T) k3().findViewById(i10);
        }
        return null;
    }

    public Handler G5() {
        return H5().b();
    }

    @Override // com.flydigi.base.common.a
    public Context H1() {
        return this.f13317d8;
    }

    @Override // androidx.fragment.app.Fragment
    public void H3(@n0 Context context) {
        super.H3(context);
        this.f13317d8 = (androidx.appcompat.app.f) context;
        String.format("%s(%d) onAttach(Context)", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    public y H5() {
        if (this.f13318e8 == null) {
            this.f13318e8 = new y(this);
        }
        return this.f13318e8;
    }

    public boolean I5() {
        return ((c) this.f13317d8).d4();
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        String.format("%s(%d) onCreate()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        String.format("%s(%d) onCreateView()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        return super.O3(layoutInflater, viewGroup, bundle);
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        String.format("%s(%d) onDestroy()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        y yVar = this.f13318e8;
        if (yVar != null) {
            yVar.i(false);
        }
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        super.R3();
        String.format("%s(%d) onDestroyView()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        y yVar = this.f13318e8;
        if (yVar != null) {
            yVar.i(false);
        }
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void S3() {
        super.S3();
        String.format("%s(%d) onDetach()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        Object[] objArr = new Object[3];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Integer.valueOf(System.identityHashCode(this));
        objArr[2] = z10 ? "hide" : "show";
        String.format("%s(%d) onHiddenChanged(%s)", objArr);
    }

    @Override // com.flydigi.base.common.t
    public boolean V() {
        return false;
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        y yVar = this.f13318e8;
        if (yVar != null) {
            yVar.i(false);
        }
        String.format("%s(%d) onPause()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        y yVar = this.f13318e8;
        if (yVar != null) {
            yVar.i(true);
        }
        String.format("%s(%d) onResume()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public void g4(@n0 Bundle bundle) {
        View viewFindViewById;
        super.g4(bundle);
        String.format("%s(%d) onSaveInstanceState()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        androidx.appcompat.app.f fVar = this.f13317d8;
        if (fVar == null || (viewFindViewById = fVar.findViewById(R.id.content)) == null) {
            return;
        }
        viewFindViewById.cancelPendingInputEvents();
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        String.format("%s(%d) onStart()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        String.format("%s(%d) onStop()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        view.setClickable(true);
        String.format("%s(%d) onViewCreated()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public void k4(@p0 Bundle bundle) {
        super.k4(bundle);
        String.format("%s(%d) onViewStateRestored()", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }
}
