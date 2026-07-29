package com.tencent.mm.opensdk.diffdev.a;

import v7.a;

/* JADX INFO: loaded from: classes5.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(a.c.C),
    UUID_CONFIRM(a.c.D),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22593a;

    d(int i10) {
        this.f22593a = i10;
    }

    public int a() {
        return this.f22593a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f22593a;
    }
}
