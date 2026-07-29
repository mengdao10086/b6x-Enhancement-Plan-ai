package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import g.p0;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f12934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f12935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f12936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f12938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12939g = false;

    @Override // com.efs.sdk.base.core.util.concurrent.c
    @p0
    public final /* synthetic */ HttpResponse a() {
        String str = this.f12937e;
        str.hashCode();
        if (str.equals("get")) {
            return HttpEnv.getInstance().getHttpUtil().get(this.f12933a, this.f12934b);
        }
        if (str.equals("post")) {
            byte[] bArr = this.f12935c;
            return (bArr == null || bArr.length <= 0) ? HttpEnv.getInstance().getHttpUtil().post(this.f12933a, this.f12934b, this.f12936d) : this.f12939g ? HttpEnv.getInstance().getHttpUtil().postAsFile(this.f12933a, this.f12934b, this.f12935c) : HttpEnv.getInstance().getHttpUtil().post(this.f12933a, this.f12934b, this.f12935c);
        }
        Log.e("efs.util.http", "request not support method '" + this.f12937e + "'");
        return null;
    }
}
