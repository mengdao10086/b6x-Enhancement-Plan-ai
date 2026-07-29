package com.flydigi.qiji.ui.account;

import com.flydigi.qiji.ui.UpdateDialog;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements UpdateDialog.UpdateDialogAction, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccountFragment f16062a;

    public /* synthetic */ h(AccountFragment accountFragment) {
        this.f16062a = accountFragment;
    }

    @Override // com.flydigi.qiji.ui.UpdateDialog.UpdateDialogAction
    public final void F(androidx.appcompat.app.j jVar) {
        AccountFragment.B6(this.f16062a, jVar);
    }
}
