package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f22677a;

    public c(Bundle bundle) {
        this.f22677a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f22677a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f22677a.get("time") + ", name=" + this.f22677a.get("interface_name") + '}';
    }

    public c(HashMap<String, String> map) {
        this.f22677a = new HashMap<>(map);
    }
}
