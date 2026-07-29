package com.arialyy.aria.core.scheduler;

/* JADX INFO: loaded from: classes2.dex */
public interface M3U8PeerTaskListener extends TaskInternalListenerInterface {
    void onPeerComplete(String str, String str2, int i10);

    void onPeerFail(String str, String str2, int i10);

    void onPeerStart(String str, String str2, int i10);
}
