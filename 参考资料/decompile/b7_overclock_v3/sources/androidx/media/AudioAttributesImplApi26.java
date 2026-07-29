package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplApi21;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(26)
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    public static class a extends AudioAttributesImplApi21.a {
        public a() {
        }

        @Override // androidx.media.AudioAttributesImplApi21.a, androidx.media.AudioAttributesImpl.a
        @n0
        public AudioAttributesImpl a() {
            return new AudioAttributesImplApi26(this.f6343a.build());
        }

        @Override // androidx.media.AudioAttributesImplApi21.a
        @n0
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a e(int i10) {
            this.f6343a.setUsage(i10);
            return this;
        }

        public a(Object obj) {
            super(obj);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi26() {
    }

    @Override // androidx.media.AudioAttributesImplApi21, androidx.media.AudioAttributesImpl
    public int g() {
        return this.f6341a.getVolumeControlStream();
    }

    public AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
}
