package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f12890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f12891b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f12892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f12893d;

    public b(String str, byte b10) {
        this.f12890a = new a(str, b10);
    }

    private void d() {
        byte[] bArr;
        a aVar = this.f12890a;
        int i10 = aVar.f12885c;
        if (i10 == 0 && (bArr = this.f12892c) != null) {
            aVar.f12888f = bArr.length;
        } else if (i10 == 1 && this.f12893d.exists()) {
            this.f12890a.f12888f = this.f12893d.length();
        }
    }

    public final long a() {
        d();
        return this.f12890a.f12888f;
    }

    public final boolean b() {
        return !"none".equals(this.f12890a.f12886d);
    }

    public final void c() {
        this.f12891b.f12894a = true;
    }

    public final void b(int i10) {
        this.f12890a.f12885c = i10;
    }

    public final void a(String str) {
        this.f12890a.f12886d = str;
    }

    public final void a(int i10) {
        this.f12890a.f12887e = i10;
        d();
    }

    public final void a(byte[] bArr) {
        this.f12892c = bArr;
        d();
    }

    public static b a(ILogProtocol iLogProtocol) {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (Exception e10) {
            e = e10;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                bVar.b(0);
                bVar.a(iLogProtocol.generate());
            } else if (bodyType != 1) {
                Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
            } else {
                bVar.b(1);
                bVar.f12893d = new File(iLogProtocol.getFilePath());
            }
            return bVar;
        } catch (Exception e11) {
            e = e11;
            bVar2 = bVar;
            Log.e("efs.base", "log send error", e);
            return bVar2;
        }
    }
}
