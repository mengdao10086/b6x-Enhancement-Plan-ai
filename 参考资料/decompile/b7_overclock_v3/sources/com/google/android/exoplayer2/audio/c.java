package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioProcessor.a f16862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioProcessor.a f16863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioProcessor.a f16864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f16865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ByteBuffer f16866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f16867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16868h;

    public c() {
        ByteBuffer byteBuffer = AudioProcessor.f16752a;
        this.f16866f = byteBuffer;
        this.f16867g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f16753e;
        this.f16864d = aVar;
        this.f16865e = aVar;
        this.f16862b = aVar;
        this.f16863c = aVar;
    }

    public final boolean a() {
        return this.f16867g.hasRemaining();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @g.i
    public boolean b() {
        return this.f16868h && this.f16867g == AudioProcessor.f16752a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @g.i
    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.f16867g;
        this.f16867g = AudioProcessor.f16752a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.a e(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.f16864d = aVar;
        this.f16865e = g(aVar);
        return isActive() ? this.f16865e : AudioProcessor.a.f16753e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void f() {
        this.f16868h = true;
        i();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f16867g = AudioProcessor.f16752a;
        this.f16868h = false;
        this.f16862b = this.f16864d;
        this.f16863c = this.f16865e;
        h();
    }

    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        return AudioProcessor.a.f16753e;
    }

    public void h() {
    }

    public void i() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f16865e != AudioProcessor.a.f16753e;
    }

    public void j() {
    }

    public final ByteBuffer k(int i10) {
        if (this.f16866f.capacity() < i10) {
            this.f16866f = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        } else {
            this.f16866f.clear();
        }
        ByteBuffer byteBuffer = this.f16866f;
        this.f16867g = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f16866f = AudioProcessor.f16752a;
        AudioProcessor.a aVar = AudioProcessor.a.f16753e;
        this.f16864d = aVar;
        this.f16865e = aVar;
        this.f16862b = aVar;
        this.f16863c = aVar;
        j();
    }
}
