package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX INFO: loaded from: classes5.dex */
public class b extends EventList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f23153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f23154b;

    public b(String str, String str2) {
        super(str, str2);
        this.f23154b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f23154b) {
            this.f23153a = null;
            this.f23153a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f23154b) {
            if (this.f23153a == null) {
                this.f23153a = new d(true, this.mEventList);
            }
            zA = this.f23153a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_WL = z10;
    }
}
