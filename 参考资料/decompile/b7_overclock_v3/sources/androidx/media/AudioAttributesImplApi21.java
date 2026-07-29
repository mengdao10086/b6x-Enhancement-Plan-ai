package androidx.media;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(21)
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributes f6341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f6342b;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi21() {
        this.f6342b = -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        return this.f6341a.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    @p0
    public Object b() {
        return this.f6341a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        int i10 = this.f6342b;
        return i10 != -1 ? i10 : AudioAttributesCompat.i(false, e(), f());
    }

    @Override // androidx.media.AudioAttributesImpl
    public int d() {
        return this.f6342b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int e() {
        return this.f6341a.getFlags();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f6341a.equals(((AudioAttributesImplApi21) obj).f6341a);
        }
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int f() {
        return this.f6341a.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    @SuppressLint({"NewApi"})
    public int g() {
        return AudioAttributesCompat.i(true, e(), f());
    }

    public int hashCode() {
        return this.f6341a.hashCode();
    }

    @n0
    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f6341a;
    }

    public static class a implements AudioAttributesImpl.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes.Builder f6343a;

        public a() {
            this.f6343a = new AudioAttributes.Builder();
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        public AudioAttributesImpl a() {
            return new AudioAttributesImplApi21(this.f6343a.build());
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a d(int i10) {
            this.f6343a.setContentType(i10);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a b(int i10) {
            this.f6343a.setFlags(i10);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a c(int i10) {
            this.f6343a.setLegacyStreamType(i10);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a e(int i10) {
            if (i10 == 16) {
                i10 = 12;
            }
            this.f6343a.setUsage(i10);
            return this;
        }

        public a(Object obj) {
            this.f6343a = new AudioAttributes.Builder((AudioAttributes) obj);
        }
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i10) {
        this.f6341a = audioAttributes;
        this.f6342b = i10;
    }
}
