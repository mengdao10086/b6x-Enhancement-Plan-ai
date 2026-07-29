package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f6344a = versionedParcel.M(audioAttributesImplBase.f6344a, 1);
        audioAttributesImplBase.f6345b = versionedParcel.M(audioAttributesImplBase.f6345b, 2);
        audioAttributesImplBase.f6346c = versionedParcel.M(audioAttributesImplBase.f6346c, 3);
        audioAttributesImplBase.f6347d = versionedParcel.M(audioAttributesImplBase.f6347d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.j0(false, false);
        versionedParcel.M0(audioAttributesImplBase.f6344a, 1);
        versionedParcel.M0(audioAttributesImplBase.f6345b, 2);
        versionedParcel.M0(audioAttributesImplBase.f6346c, 3);
        versionedParcel.M0(audioAttributesImplBase.f6347d, 4);
    }
}
