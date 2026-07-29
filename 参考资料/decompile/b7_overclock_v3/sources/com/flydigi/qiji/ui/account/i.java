package com.flydigi.qiji.ui.account;

import com.flydigi.qiji.ui.UpdateDialog;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements UpdateDialog.UpdateDialogAction, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccountFragment f16063a;

    public /* synthetic */ i(AccountFragment accountFragment) {
        this.f16063a = accountFragment;
    }

    @Override // com.flydigi.qiji.ui.UpdateDialog.UpdateDialogAction
    public final void F(androidx.appcompat.app.j jVar) {
        AccountFragment.z6(this.f16063a, jVar);
    }
}
