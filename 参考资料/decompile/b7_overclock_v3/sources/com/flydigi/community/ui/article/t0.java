package com.flydigi.community.ui.article;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import cn.jzvd.JZMediaInterface;
import cn.jzvd.JZTextureView;
import cn.jzvd.Jzvd;
import com.flydigi.base.R;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import ed.n;
import java.util.List;
import ya.h1;
import ya.j1;
import ya.k;
import ya.k1;
import ya.u1;
import ya.x1;

/* JADX INFO: loaded from: classes2.dex */
public class t0 extends JZMediaInterface implements j1.f, id.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u1 f13769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f13770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13772d;

    public class b implements Runnable {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i10) {
            t0.this.jzvd.setBufferProgress(i10);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t0.this.f13769a != null) {
                final int iN = t0.this.f13769a.N();
                t0.this.handler.post(new Runnable() { // from class: com.flydigi.community.ui.article.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13775a.b(iN);
                    }
                });
                if (iN < 100) {
                    t0 t0Var = t0.this;
                    t0Var.handler.postDelayed(t0Var.f13770b, 300L);
                } else {
                    t0 t0Var2 = t0.this;
                    t0Var2.handler.removeCallbacks(t0Var2.f13770b);
                }
            }
        }
    }

    public t0(Jzvd jzvd) {
        super(jzvd);
        this.f13771c = "JZMediaExo";
        this.f13772d = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(int i10, boolean z10) {
        if (i10 == 2) {
            this.jzvd.onStatePreparingPlaying();
            this.handler.post(this.f13770b);
        } else if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            this.jzvd.onCompletion();
        } else if (z10) {
            this.jzvd.onStatePlaying();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.jzvd.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(int i10, float f10, int i11) {
        this.jzvd.onVideoSizeChanged((int) (i10 * f10), i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Context context) {
        SurfaceTexture surfaceTexture;
        this.f13769a = new u1.b(context, new ya.m(context)).M(new DefaultTrackSelector(context)).E(new k.a().c(new ed.m(true, 65536)).e(360000, 600000, 1000, 5000).f(false).g(-1).a()).z(new n.b(context).a()).w();
        com.google.android.exoplayer2.upstream.d dVar = new com.google.android.exoplayer2.upstream.d(context, hd.u0.v0(context, context.getResources().getString(R.string.app_name)));
        String string = this.jzvd.jzDataSource.getCurrentUrl().toString();
        com.google.android.exoplayer2.source.l lVarH = string.contains(".m3u8") ? new HlsMediaSource.Factory(dVar).h(Uri.parse(string)) : new p.b(dVar).h(Uri.parse(string));
        this.f13769a.P0(this);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("URL Link = ");
        sb2.append(string);
        this.f13769a.y(this);
        if (this.jzvd.jzDataSource.looping) {
            this.f13769a.j(1);
        } else {
            this.f13769a.j(0);
        }
        this.f13769a.W0(lVarH);
        this.f13769a.x0(true);
        this.f13770b = new b();
        JZTextureView jZTextureView = this.jzvd.textureView;
        if (jZTextureView == null || (surfaceTexture = jZTextureView.getSurfaceTexture()) == null) {
            return;
        }
        this.f13769a.q(new Surface(surfaceTexture));
    }

    public static /* synthetic */ void G(u1 u1Var, HandlerThread handlerThread) {
        u1Var.release();
        handlerThread.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        this.jzvd.onError(1000, 1000);
    }

    @Override // ya.j1.f
    public /* synthetic */ void B(boolean z10) {
        k1.c(this, z10);
    }

    @Override // ya.j1.f
    public void D(final boolean z10, final int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onPlayerStateChanged");
        sb2.append(i10);
        sb2.append("/ready=");
        sb2.append(z10);
        this.handler.post(new Runnable() { // from class: com.flydigi.community.ui.article.q0
            @Override // java.lang.Runnable
            public final void run() {
                this.f13759a.A(i10, z10);
            }
        });
    }

    @Override // ya.j1.f
    public /* synthetic */ void R(boolean z10, int i10) {
        k1.h(this, z10, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void S(x1 x1Var, int i10) {
        k1.s(this, x1Var, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void V(boolean z10) {
        k1.b(this, z10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void Z(ya.v0 v0Var, int i10) {
        k1.g(this, v0Var, i10);
    }

    @Override // ya.j1.f
    public void b(h1 h1Var) {
    }

    @Override // ya.j1.f
    public /* synthetic */ void b0(boolean z10) {
        k1.e(this, z10);
    }

    @Override // id.o
    public void c(final int i10, final int i11, int i12, final float f10) {
        this.handler.post(new Runnable() { // from class: com.flydigi.community.ui.article.p0
            @Override // java.lang.Runnable
            public final void run() {
                this.f13754a.E(i10, f10, i11);
            }
        });
    }

    @Override // id.o
    public void d() {
    }

    @Override // ya.j1.f
    public /* synthetic */ void e(int i10) {
        k1.k(this, i10);
    }

    @Override // ya.j1.f
    public void f(x1 x1Var, Object obj, int i10) {
    }

    @Override // ya.j1.f
    public void g(boolean z10) {
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        u1 u1Var = this.f13769a;
        if (u1Var != null) {
            return u1Var.H1();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        u1 u1Var = this.f13769a;
        if (u1Var != null) {
            return u1Var.m1();
        }
        return 0L;
    }

    @Override // ya.j1.f
    public void h(TrackGroupArray trackGroupArray, ad.i iVar) {
    }

    @Override // ya.j1.f
    public void i(int i10) {
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.f13769a.D();
    }

    @Override // id.o
    public /* synthetic */ void j(int i10, int i11) {
        id.n.b(this, i10, i11);
    }

    @Override // ya.j1.f
    public /* synthetic */ void k(List list) {
        k1.r(this, list);
    }

    @Override // ya.j1.f
    public void m(ExoPlaybackException exoPlaybackException) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onPlayerError");
        sb2.append(exoPlaybackException.toString());
        this.handler.post(new Runnable() { // from class: com.flydigi.community.ui.article.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f13752a.z();
            }
        });
    }

    @Override // ya.j1.f
    public /* synthetic */ void n(boolean z10) {
        k1.d(this, z10);
    }

    @Override // ya.j1.f
    public void o() {
        this.handler.post(new Runnable() { // from class: com.flydigi.community.ui.article.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.f13750a.C();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        SurfaceTexture surfaceTexture2 = JZMediaInterface.SAVED_SURFACE;
        if (surfaceTexture2 != null) {
            this.jzvd.textureView.setSurfaceTexture(surfaceTexture2);
        } else {
            JZMediaInterface.SAVED_SURFACE = surfaceTexture;
            prepare();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // ya.j1.f
    public /* synthetic */ void p(j1 j1Var, j1.g gVar) {
        k1.a(this, j1Var, gVar);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        this.f13769a.x0(false);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        final Context context = this.jzvd.getContext();
        release();
        HandlerThread handlerThread = new HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new Handler(context.getMainLooper());
        this.handler = new Handler();
        this.mMediaHandler.post(new Runnable() { // from class: com.flydigi.community.ui.article.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f13763a.F(context);
            }
        });
    }

    @Override // ya.j1.f
    public /* synthetic */ void r(int i10) {
        k1.j(this, i10);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        final HandlerThread handlerThread;
        final u1 u1Var;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (u1Var = this.f13769a) == null) {
            return;
        }
        JZMediaInterface.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: com.flydigi.community.ui.article.s0
            @Override // java.lang.Runnable
            public final void run() {
                t0.G(u1Var, handlerThread);
            }
        });
        this.f13769a = null;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(long j10) {
        u1 u1Var = this.f13769a;
        if (u1Var == null || j10 == this.f13772d) {
            return;
        }
        if (j10 >= u1Var.I0()) {
            this.jzvd.onStatePreparingPlaying();
        }
        this.f13769a.g(j10);
        this.f13772d = j10;
        this.jzvd.seekToInAdvance = j10;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSpeed(float f10) {
        this.f13769a.c(new h1(f10, 1.0f));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(Surface surface) {
        u1 u1Var = this.f13769a;
        if (u1Var != null) {
            u1Var.q(surface);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(float f10, float f11) {
        this.f13769a.m(f10);
        this.f13769a.m(f11);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        this.f13769a.x0(true);
    }

    @Override // ya.j1.f
    public void v(int i10) {
    }

    @Override // ya.j1.f
    public void y(boolean z10) {
    }
}
