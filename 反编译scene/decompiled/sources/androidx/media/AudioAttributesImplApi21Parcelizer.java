package androidx.media;

import a.hu;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(hu huVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f4290a = (AudioAttributes) huVar.r(audioAttributesImplApi21.f4290a, 1);
        audioAttributesImplApi21.f8212a = huVar.p(audioAttributesImplApi21.f8212a, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, hu huVar) {
        huVar.x(false, false);
        huVar.H(audioAttributesImplApi21.f4290a, 1);
        huVar.F(audioAttributesImplApi21.f8212a, 2);
    }
}
