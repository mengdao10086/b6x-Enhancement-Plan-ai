package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ch extends cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f23464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OutputStream f23465b;

    public ch() {
        this.f23464a = null;
        this.f23465b = null;
    }

    @Override // com.umeng.analytics.pro.cj
    public int a(byte[] bArr, int i10, int i11) throws ck {
        InputStream inputStream = this.f23464a;
        if (inputStream == null) {
            throw new ck(1, "Cannot read from null inputStream");
        }
        try {
            int i12 = inputStream.read(bArr, i10, i11);
            if (i12 >= 0) {
                return i12;
            }
            throw new ck(4);
        } catch (IOException e10) {
            throw new ck(0, e10);
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cj
    public void b() throws ck {
    }

    @Override // com.umeng.analytics.pro.cj
    public void b(byte[] bArr, int i10, int i11) throws ck {
        OutputStream outputStream = this.f23465b;
        if (outputStream == null) {
            throw new ck(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i10, i11);
        } catch (IOException e10) {
            throw new ck(0, e10);
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public void c() {
        InputStream inputStream = this.f23464a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.f23464a = null;
        }
        OutputStream outputStream = this.f23465b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            this.f23465b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public void d() throws ck {
        OutputStream outputStream = this.f23465b;
        if (outputStream == null) {
            throw new ck(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e10) {
            throw new ck(0, e10);
        }
    }

    public ch(InputStream inputStream) {
        this.f23465b = null;
        this.f23464a = inputStream;
    }

    public ch(OutputStream outputStream) {
        this.f23464a = null;
        this.f23465b = outputStream;
    }

    public ch(InputStream inputStream, OutputStream outputStream) {
        this.f23464a = inputStream;
        this.f23465b = outputStream;
    }
}
