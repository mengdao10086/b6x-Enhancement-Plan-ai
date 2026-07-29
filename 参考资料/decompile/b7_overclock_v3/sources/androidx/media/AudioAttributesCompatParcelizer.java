package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f6335a = (AudioAttributesImpl) versionedParcel.h0(audioAttributesCompat.f6335a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.j0(false, false);
        versionedParcel.m1(audioAttributesCompat.f6335a, 1);
    }
}
