package com.efs.sdk.h5pagesdk;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes2.dex */
public class UApmJSBridge {
    @JavascriptInterface
    public String getLaunchOptionsSync() {
        if (H5Manager.getH5ConfigMananger() == null) {
            boolean z10 = H5Manager.isDebug;
            return "";
        }
        String strGenerateLaunchOptions = H5Manager.getH5ConfigMananger().generateLaunchOptions();
        boolean z11 = H5Manager.isDebug;
        return strGenerateLaunchOptions;
    }

    @JavascriptInterface
    public void sendData(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    boolean z10 = H5Manager.isDebug;
                    if (H5Manager.getH5ConfigMananger() != null) {
                        H5Manager.getH5ConfigMananger().sendData(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
