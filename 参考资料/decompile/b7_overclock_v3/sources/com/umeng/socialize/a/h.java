package com.umeng.socialize.a;

import com.umeng.socialize.utils.ContextUtil;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24555a = "AL";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Future<?> f24556b;

    public static void a() {
        Future<?> future = f24556b;
        if (future == null || future.isDone() || f24556b.isCancelled()) {
            e eVarA = e.a(ContextUtil.getContext());
            eVarA.e();
            if (eVarA.d() >= eVarA.c() && eVarA.b()) {
                f24556b = j.c(new g());
            }
        }
    }
}
