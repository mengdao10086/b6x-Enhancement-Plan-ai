package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class JZMediaSystem extends JZMediaInterface implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer mediaPlayer;

    public JZMediaSystem(Jzvd jzvd) {
        super(jzvd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBufferingUpdate$8(int i10) {
        this.jzvd.setBufferProgress(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCompletion$7() {
        this.jzvd.onCompletion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$10(int i10, int i11) {
        this.jzvd.onError(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInfo$11(int i10, int i11) {
        this.jzvd.onInfo(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrepared$6() {
        this.jzvd.onPrepared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSeekComplete$9() {
        this.jzvd.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoSizeChanged$12(int i10, int i11) {
        this.jzvd.onVideoSizeChanged(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pause$2() {
        this.mediaPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepare$0() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setLooping(this.jzvd.jzDataSource.looping);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnBufferingUpdateListener(this);
            this.mediaPlayer.setScreenOnWhilePlaying(true);
            this.mediaPlayer.setOnSeekCompleteListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.setOnInfoListener(this);
            this.mediaPlayer.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.mediaPlayer, this.jzvd.jzDataSource.getCurrentUrl().toString(), this.jzvd.jzDataSource.headerMap);
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setSurface(new Surface(JZMediaInterface.SAVED_SURFACE));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$release$4(MediaPlayer mediaPlayer, HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seekTo$3(long j10) {
        try {
            this.mediaPlayer.seekTo((int) j10);
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVolume$5(float f10, float f11) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f10, f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1() {
        this.mediaPlayer.start();
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        if (this.mediaPlayer != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        if (this.mediaPlayer != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i10) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f11006a.lambda$onBufferingUpdate$8(i10);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f10999a.lambda$onCompletion$7();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i10, final int i11) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f11008a.lambda$onError$10(i10, i11);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i10, final int i11) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f10989a.lambda$onInfo$11(i10, i11);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f11000a.lambda$onPrepared$6();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f10997a.lambda$onSeekComplete$9();
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

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i10, final int i11) {
        this.handler.post(new Runnable() { // from class: cn.jzvd.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f10992a.lambda$onVideoSizeChanged$12(i10, i11);
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f10998a.lambda$pause$2();
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        release();
        HandlerThread handlerThread = new HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new Handler(this.mMediaHandlerThread.getLooper());
        this.handler = new Handler();
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f11001a.lambda$prepare$0();
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        final HandlerThread handlerThread;
        final MediaPlayer mediaPlayer;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (mediaPlayer = this.mediaPlayer) == null) {
            return;
        }
        JZMediaInterface.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: cn.jzvd.a
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaSystem.lambda$release$4(mediaPlayer, handlerThread);
            }
        });
        this.mediaPlayer = null;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(final long j10) {
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f10995a.lambda$seekTo$3(j10);
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSpeed(float f10) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f10);
            this.mediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(Surface surface) {
        this.mediaPlayer.setSurface(surface);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(final float f10, final float f11) {
        Handler handler = this.mMediaHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: cn.jzvd.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f11003a.lambda$setVolume$5(f10, f11);
            }
        });
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        this.mMediaHandler.post(new Runnable() { // from class: cn.jzvd.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f11002a.lambda$start$1();
            }
        });
    }
}
