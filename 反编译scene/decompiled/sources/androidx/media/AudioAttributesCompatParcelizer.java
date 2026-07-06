package androidx.media;

import a.hu;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(hu huVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f4289a = (AudioAttributesImpl) huVar.v(audioAttributesCompat.f4289a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, hu huVar) {
        huVar.x(false, false);
        huVar.M(audioAttributesCompat.f4289a, 1);
    }
}
