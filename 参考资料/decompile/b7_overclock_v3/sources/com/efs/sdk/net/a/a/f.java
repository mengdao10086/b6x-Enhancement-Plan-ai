package com.efs.sdk.net.a.a;

import java.io.InputStream;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public interface a extends b {
        String b();

        String c();

        @l
        byte[] d();
    }

    public interface b {
        String a();
    }

    public interface c extends d {
    }

    public interface d {
        String a();

        int b();
    }

    @l
    InputStream a(String str, @l String str2, @l String str3, @l InputStream inputStream);

    void a();

    void a(a aVar);

    void a(c cVar);

    String b();
}
