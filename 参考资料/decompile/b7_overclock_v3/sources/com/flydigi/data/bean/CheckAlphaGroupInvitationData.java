package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class CheckAlphaGroupInvitationData {

    @SerializedName("is_remind")
    private boolean shouldShow;

    public boolean isShouldShow() {
        return this.shouldShow;
    }

    public void setShouldShow(boolean shouldShow) {
        this.shouldShow = shouldShow;
    }
}
