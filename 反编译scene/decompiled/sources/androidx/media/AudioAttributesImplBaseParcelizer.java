package androidx.media;

import a.hu;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(hu huVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f8213a = huVar.p(audioAttributesImplBase.f8213a, 1);
        audioAttributesImplBase.b = huVar.p(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = huVar.p(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = huVar.p(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, hu huVar) {
        huVar.x(false, false);
        huVar.F(audioAttributesImplBase.f8213a, 1);
        huVar.F(audioAttributesImplBase.b, 2);
        huVar.F(audioAttributesImplBase.c, 3);
        huVar.F(audioAttributesImplBase.d, 4);
    }
}
