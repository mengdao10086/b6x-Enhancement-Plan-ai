package com.tencent.open.a;

import java.io.IOException;
import okhttp3.d0;
import okhttp3.e0;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d0 f22650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22651b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22654e;

    public b(d0 d0Var, int i10) {
        this.f22650a = d0Var;
        this.f22653d = i10;
        this.f22652c = d0Var.W();
        e0 e0VarL = this.f22650a.L();
        if (e0VarL != null) {
            this.f22654e = (int) e0VarL.contentLength();
        } else {
            this.f22654e = 0;
        }
    }

    public String a() throws IOException {
        if (this.f22651b == null) {
            e0 e0VarL = this.f22650a.L();
            if (e0VarL != null) {
                this.f22651b = e0VarL.string();
            }
            if (this.f22651b == null) {
                this.f22651b = "";
            }
        }
        return this.f22651b;
    }

    public int b() {
        return this.f22654e;
    }

    public int c() {
        return this.f22653d;
    }

    public int d() {
        return this.f22652c;
    }
}
