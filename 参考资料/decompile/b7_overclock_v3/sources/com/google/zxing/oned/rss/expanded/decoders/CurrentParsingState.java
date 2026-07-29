package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes7.dex */
public final class CurrentParsingState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21468a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f21469b = State.NUMERIC;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f21468a;
    }

    public void b(int i10) {
        this.f21468a += i10;
    }

    public boolean c() {
        return this.f21469b == State.ALPHA;
    }

    public boolean d() {
        return this.f21469b == State.ISO_IEC_646;
    }

    public boolean e() {
        return this.f21469b == State.NUMERIC;
    }

    public void f() {
        this.f21469b = State.ALPHA;
    }

    public void g() {
        this.f21469b = State.ISO_IEC_646;
    }

    public void h() {
        this.f21469b = State.NUMERIC;
    }

    public void i(int i10) {
        this.f21468a = i10;
    }
}
