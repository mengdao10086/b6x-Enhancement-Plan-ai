package com.flydigi.base.common;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FZLazyFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f13328o8 = true;

    public abstract void Z5();

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        if (this.f13328o8) {
            Z5();
            this.f13328o8 = false;
        }
    }
}
