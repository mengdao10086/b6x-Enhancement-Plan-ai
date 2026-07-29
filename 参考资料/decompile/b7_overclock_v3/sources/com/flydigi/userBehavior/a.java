package com.flydigi.userBehavior;

import android.content.Context;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import i9.a;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16384a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16385a = new a();
    }

    public static a a() {
        return b.f16385a;
    }

    public void b(Context context, String eventName) {
        IRemoteProvider iRemoteProvider;
        if (!this.f16384a || (iRemoteProvider = (IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()) == null) {
            return;
        }
        iRemoteProvider.e(context, DataConstant.REMOTE_ACTION_USER_BEHAVIOR_EVENT, DataConstant.EVENT_NAME, eventName);
    }

    public a() {
        this.f16384a = o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_REPORT_USER_BEHAVIOR, true);
    }
}
