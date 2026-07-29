package com.flydigi.data.event;

import com.flydigi.data.bean.FZUserAccount;

/* JADX INFO: loaded from: classes7.dex */
public class FZAccountLoginChangeEvent {
    private final FZUserAccount account;
    private final boolean login;

    public FZAccountLoginChangeEvent(final FZUserAccount account, boolean login) {
        this.account = account;
        this.login = login;
    }

    public FZUserAccount getAccount() {
        return this.account;
    }

    public boolean isLogin() {
        return this.login;
    }
}
