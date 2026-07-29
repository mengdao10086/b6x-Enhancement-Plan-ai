package com.google.android.exoplayer2.audio;

import ab.u;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink;
import g.p0;
import java.nio.ByteBuffer;
import ya.h1;

/* JADX INFO: loaded from: classes3.dex */
public class g implements AudioSink {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AudioSink f16891e;

    public g(AudioSink audioSink) {
        this.f16891e = audioSink;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void A() {
        this.f16891e.A();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(Format format) {
        return this.f16891e.a(format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return this.f16891e.b();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c(h1 h1Var) {
        this.f16891e.c(h1Var);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public h1 e() {
        return this.f16891e.e();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        this.f16891e.flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(int i10) {
        this.f16891e.h(i10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i() {
        this.f16891e.i();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l(u uVar) {
        this.f16891e.l(uVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m(float f10) {
        this.f16891e.m(f10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean n() {
        return this.f16891e.n();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void o(boolean z10) {
        this.f16891e.o(z10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p() throws AudioSink.WriteException {
        this.f16891e.p();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.f16891e.pause();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean q() {
        return this.f16891e.q();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long r(boolean z10) {
        return this.f16891e.r(z10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        this.f16891e.reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void s() {
        this.f16891e.s();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t() {
        this.f16891e.t();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void u() {
        this.f16891e.u();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void v(ab.d dVar) {
        this.f16891e.v(dVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean w(ByteBuffer byteBuffer, long j10, int i10) throws AudioSink.WriteException, AudioSink.InitializationException {
        return this.f16891e.w(byteBuffer, j10, i10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void x(AudioSink.a aVar) {
        this.f16891e.x(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int y(Format format) {
        return this.f16891e.y(format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void z(Format format, int i10, @p0 int[] iArr) throws AudioSink.ConfigurationException {
        this.f16891e.z(format, i10, iArr);
    }
}
