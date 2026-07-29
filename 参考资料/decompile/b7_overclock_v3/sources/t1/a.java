package t1;

import android.media.AudioManager;
import android.os.Build;
import g.f0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f50665a = "AudioManCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f50666b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f50667c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f50668d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f50669e = 4;

    public static int a(@n0 AudioManager audioManager, @n0 androidx.media.a aVar) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        if (aVar != null) {
            return Build.VERSION.SDK_INT >= 26 ? audioManager.abandonAudioFocusRequest(aVar.c()) : audioManager.abandonAudioFocus(aVar.f());
        }
        throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
    }

    @f0(from = 0)
    public static int b(@n0 AudioManager audioManager, int i10) {
        return audioManager.getStreamMaxVolume(i10);
    }

    @f0(from = 0)
    public static int c(@n0 AudioManager audioManager, int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return audioManager.getStreamMinVolume(i10);
        }
        return 0;
    }

    public static int d(@n0 AudioManager audioManager, @n0 androidx.media.a aVar) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        if (aVar != null) {
            return Build.VERSION.SDK_INT >= 26 ? audioManager.requestAudioFocus(aVar.c()) : audioManager.requestAudioFocus(aVar.f(), aVar.b().c(), aVar.e());
        }
        throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
    }
}
