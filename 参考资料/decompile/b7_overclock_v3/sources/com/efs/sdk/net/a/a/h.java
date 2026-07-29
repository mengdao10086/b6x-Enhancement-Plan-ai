package com.efs.sdk.net.a.a;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteArrayOutputStream f13069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f13070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13071d;

    public h(f fVar, String str) {
        this.f13068a = fVar;
        this.f13071d = str;
    }

    public final boolean a() {
        return this.f13069b != null;
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
