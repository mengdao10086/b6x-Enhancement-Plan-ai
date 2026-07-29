package com.tencent.open.utils;

/* JADX INFO: loaded from: classes5.dex */
public final class l implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22835a;

    public l(long j10) {
        this.f22835a = j10;
    }

    public byte[] a() {
        long j10 = this.f22835a;
        return new byte[]{(byte) (255 & j10), (byte) ((65280 & j10) >> 8), (byte) ((16711680 & j10) >> 16), (byte) ((j10 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f22835a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.f22835a == ((l) obj).b();
    }

    public int hashCode() {
        return (int) this.f22835a;
    }
}
