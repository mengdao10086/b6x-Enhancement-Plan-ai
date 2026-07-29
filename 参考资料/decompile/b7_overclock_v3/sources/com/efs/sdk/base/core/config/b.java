package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.efs.sdk.base.core.config.a f12869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f12870b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12871a = new b(0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    private static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public final String b() {
        return this.f12869a.b("net", NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    private b() {
        this.f12870b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    public final com.efs.sdk.base.core.config.a a() {
        try {
            String strA = a(this.f12870b);
            if (!TextUtils.isEmpty(strA)) {
                this.f12869a.a(UMCrash.KEY_CALLBACK_SESSION_ID, strA);
            }
        } catch (Throwable th2) {
            Log.d("efs.info.manager", "refreshSessionId caused error: " + th2.getMessage());
        }
        return this.f12869a;
    }
}
