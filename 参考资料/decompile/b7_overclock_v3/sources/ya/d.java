package ya;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f56582j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f56583k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f56584l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f56585m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56586n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f56587o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f56588p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f56589q = "AudioFocusManager";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f56590r = 0.2f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f56591s = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f56592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f56593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public c f56594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.p0
    public ab.d f56595d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56597f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f56599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56600i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f56598g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f56596e = 0;

    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f56601a;

        public a(Handler handler) {
            this.f56601a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i10) {
            d.this.i(i10);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i10) {
            this.f56601a.post(new Runnable() { // from class: ya.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f56577a.b(i10);
                }
            });
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void C(float f10);

        void E(int i10);
    }

    public d(Context context, Handler handler, c cVar) {
        this.f56592a = (AudioManager) hd.a.g((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f56594c = cVar;
        this.f56593b = new a(handler);
    }

    public static int e(@g.p0 ab.d dVar) {
        if (dVar == null) {
            return 0;
        }
        switch (dVar.f420c) {
            case 0:
                hd.t.n(f56589q, "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (dVar.f418a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                hd.t.n(f56589q, "Unidentified audio usage: " + dVar.f420c);
                return 0;
            case 16:
                return hd.u0.f31154a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        if (this.f56596e == 0) {
            return;
        }
        if (hd.u0.f31154a >= 26) {
            c();
        } else {
            b();
        }
        o(0);
    }

    public final void b() {
        this.f56592a.abandonAudioFocus(this.f56593b);
    }

    @g.v0(26)
    public final void c() {
        AudioFocusRequest audioFocusRequest = this.f56599h;
        if (audioFocusRequest != null) {
            this.f56592a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i10) {
        c cVar = this.f56594c;
        if (cVar != null) {
            cVar.E(i10);
        }
    }

    @g.i1
    public AudioManager.OnAudioFocusChangeListener g() {
        return this.f56593b;
    }

    public float h() {
        return this.f56598g;
    }

    public final void i(int i10) {
        if (i10 == -3 || i10 == -2) {
            if (i10 != -2 && !r()) {
                o(3);
                return;
            } else {
                f(0);
                o(2);
                return;
            }
        }
        if (i10 == -1) {
            f(-1);
            a();
        } else if (i10 == 1) {
            o(1);
            f(1);
        } else {
            hd.t.n(f56589q, "Unknown focus change type: " + i10);
        }
    }

    public void j() {
        this.f56594c = null;
        a();
    }

    public final int k() {
        if (this.f56596e == 1) {
            return 1;
        }
        if ((hd.u0.f31154a >= 26 ? m() : l()) == 1) {
            o(1);
            return 1;
        }
        o(0);
        return -1;
    }

    public final int l() {
        return this.f56592a.requestAudioFocus(this.f56593b, hd.u0.o0(((ab.d) hd.a.g(this.f56595d)).f420c), this.f56597f);
    }

    @g.v0(26)
    public final int m() {
        AudioFocusRequest audioFocusRequest = this.f56599h;
        if (audioFocusRequest == null || this.f56600i) {
            this.f56599h = (audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f56597f) : new AudioFocusRequest.Builder(this.f56599h)).setAudioAttributes(((ab.d) hd.a.g(this.f56595d)).a()).setWillPauseWhenDucked(r()).setOnAudioFocusChangeListener(this.f56593b).build();
            this.f56600i = false;
        }
        return this.f56592a.requestAudioFocus(this.f56599h);
    }

    public void n(@g.p0 ab.d dVar) {
        if (hd.u0.c(this.f56595d, dVar)) {
            return;
        }
        this.f56595d = dVar;
        int iE = e(dVar);
        this.f56597f = iE;
        boolean z10 = true;
        if (iE != 1 && iE != 0) {
            z10 = false;
        }
        hd.a.b(z10, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void o(int i10) {
        if (this.f56596e == i10) {
            return;
        }
        this.f56596e = i10;
        float f10 = i10 == 3 ? 0.2f : 1.0f;
        if (this.f56598g == f10) {
            return;
        }
        this.f56598g = f10;
        c cVar = this.f56594c;
        if (cVar != null) {
            cVar.C(f10);
        }
    }

    public final boolean p(int i10) {
        return i10 == 1 || this.f56597f != 1;
    }

    public int q(boolean z10, int i10) {
        if (p(i10)) {
            a();
            return z10 ? 1 : -1;
        }
        if (z10) {
            return k();
        }
        return -1;
    }

    public final boolean r() {
        ab.d dVar = this.f56595d;
        return dVar != null && dVar.f418a == 1;
    }
}
