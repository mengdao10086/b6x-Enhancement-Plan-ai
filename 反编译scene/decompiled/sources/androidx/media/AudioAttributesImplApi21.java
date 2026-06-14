package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@TargetApi(21)
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8212a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AudioAttributes f4290a;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f4290a.equals(((AudioAttributesImplApi21) obj).f4290a);
        }
        return false;
    }

    public int hashCode() {
        return this.f4290a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f4290a;
    }
}
