package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.util.j;
import androidx.media.AudioAttributesCompat;
import g.n0;
import g.v0;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AudioAttributesCompat f6352g = new AudioAttributesCompat.d().e(1).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f6354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f6355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioAttributesCompat f6356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f6358f;

    public static class b implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6364c = 2782386;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f6365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioManager.OnAudioFocusChangeListener f6366b;

        public b(@n0 AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, @n0 Handler handler) {
            this.f6366b = onAudioFocusChangeListener;
            this.f6365a = new Handler(handler.getLooper(), this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 2782386) {
                return false;
            }
            this.f6366b.onAudioFocusChange(message.arg1);
            return true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            Handler handler = this.f6365a;
            handler.sendMessage(Message.obtain(handler, f6364c, i10, 0));
        }
    }

    public a(int i10, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z10) {
        this.f6353a = i10;
        this.f6355c = handler;
        this.f6356d = audioAttributesCompat;
        this.f6357e = z10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26 || handler.getLooper() == Looper.getMainLooper()) {
            this.f6354b = onAudioFocusChangeListener;
        } else {
            this.f6354b = new b(onAudioFocusChangeListener, handler);
        }
        if (i11 >= 26) {
            this.f6358f = new AudioFocusRequest.Builder(i10).setAudioAttributes(a()).setWillPauseWhenDucked(z10).setOnAudioFocusChangeListener(this.f6354b, handler).build();
        } else {
            this.f6358f = null;
        }
    }

    @v0(21)
    public AudioAttributes a() {
        AudioAttributesCompat audioAttributesCompat = this.f6356d;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.j();
        }
        return null;
    }

    @n0
    public AudioAttributesCompat b() {
        return this.f6356d;
    }

    @v0(26)
    public AudioFocusRequest c() {
        return (AudioFocusRequest) this.f6358f;
    }

    @n0
    public Handler d() {
        return this.f6355c;
    }

    public int e() {
        return this.f6353a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6353a == aVar.f6353a && this.f6357e == aVar.f6357e && j.a(this.f6354b, aVar.f6354b) && j.a(this.f6355c, aVar.f6355c) && j.a(this.f6356d, aVar.f6356d);
    }

    @n0
    public AudioManager.OnAudioFocusChangeListener f() {
        return this.f6354b;
    }

    public boolean g() {
        return this.f6357e;
    }

    public int hashCode() {
        return j.b(Integer.valueOf(this.f6353a), this.f6354b, this.f6355c, this.f6356d, Boolean.valueOf(this.f6357e));
    }

    /* JADX INFO: renamed from: androidx.media.a$a, reason: collision with other inner class name */
    public static final class C0057a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AudioManager.OnAudioFocusChangeListener f6360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f6361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AudioAttributesCompat f6362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6363e;

        public C0057a(int i10) {
            this.f6362d = a.f6352g;
            d(i10);
        }

        public static boolean b(int i10) {
            return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4;
        }

        public a a() {
            if (this.f6360b != null) {
                return new a(this.f6359a, this.f6360b, this.f6361c, this.f6362d, this.f6363e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        @n0
        public C0057a c(@n0 AudioAttributesCompat audioAttributesCompat) {
            Objects.requireNonNull(audioAttributesCompat, "Illegal null AudioAttributes");
            this.f6362d = audioAttributesCompat;
            return this;
        }

        @n0
        public C0057a d(int i10) {
            if (b(i10)) {
                this.f6359a = i10;
                return this;
            }
            throw new IllegalArgumentException("Illegal audio focus gain type " + i10);
        }

        @n0
        public C0057a e(@n0 AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
            return f(onAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
        }

        @n0
        public C0057a f(@n0 AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, @n0 Handler handler) {
            if (onAudioFocusChangeListener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            }
            if (handler == null) {
                throw new IllegalArgumentException("Handler must not be null");
            }
            this.f6360b = onAudioFocusChangeListener;
            this.f6361c = handler;
            return this;
        }

        @n0
        public C0057a g(boolean z10) {
            this.f6363e = z10;
            return this;
        }

        public C0057a(@n0 a aVar) {
            this.f6362d = a.f6352g;
            if (aVar != null) {
                this.f6359a = aVar.e();
                this.f6360b = aVar.f();
                this.f6361c = aVar.d();
                this.f6362d = aVar.b();
                this.f6363e = aVar.g();
                return;
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
        }
    }
}
