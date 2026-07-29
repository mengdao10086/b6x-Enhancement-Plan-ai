package com.umeng.umlink;

import android.net.Uri;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public interface UMLinkListener {
    void onError(String str);

    void onInstall(HashMap<String, String> map, Uri uri);

    void onLink(String str, HashMap<String, String> map);
}
