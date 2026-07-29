package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import g.n0;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f6344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f6345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f6346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f6347d;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplBase() {
        this.f6344a = 0;
        this.f6345b = 0;
        this.f6346c = 0;
        this.f6347d = -1;
    }

    public static int h(int i10) {
        switch (i10) {
        }
        return 2;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        return this.f6345b;
    }

    @Override // androidx.media.AudioAttributesImpl
    @p0
    public Object b() {
        return null;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int c() {
        int i10 = this.f6347d;
        return i10 != -1 ? i10 : AudioAttributesCompat.i(false, this.f6346c, this.f6344a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int d() {
        return this.f6347d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int e() {
        int i10 = this.f6346c;
        int iC = c();
        if (iC == 6) {
            i10 |= 4;
        } else if (iC == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f6345b == audioAttributesImplBase.a() && this.f6346c == audioAttributesImplBase.e() && this.f6344a == audioAttributesImplBase.f() && this.f6347d == audioAttributesImplBase.f6347d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int f() {
        return this.f6344a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int g() {
        return AudioAttributesCompat.i(true, this.f6346c, this.f6344a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6345b), Integer.valueOf(this.f6346c), Integer.valueOf(this.f6344a), Integer.valueOf(this.f6347d)});
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f6347d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f6347d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.k(this.f6344a));
        sb2.append(" content=");
        sb2.append(this.f6345b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f6346c).toUpperCase());
        return sb2.toString();
    }

    public static class a implements AudioAttributesImpl.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6351d;

        public a() {
            this.f6348a = 0;
            this.f6349b = 0;
            this.f6350c = 0;
            this.f6351d = -1;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        public AudioAttributesImpl a() {
            return new AudioAttributesImplBase(this.f6349b, this.f6350c, this.f6348a, this.f6351d);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a d(int i10) {
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
                this.f6349b = i10;
            } else {
                this.f6349b = 0;
            }
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a b(int i10) {
            this.f6350c = (i10 & 1023) | this.f6350c;
            return this;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final a h(int i10) {
            switch (i10) {
                case 0:
                    this.f6349b = 1;
                    break;
                case 1:
                    this.f6349b = 4;
                    break;
                case 2:
                    this.f6349b = 4;
                    break;
                case 3:
                    this.f6349b = 2;
                    break;
                case 4:
                    this.f6349b = 4;
                    break;
                case 5:
                    this.f6349b = 4;
                    break;
                case 6:
                    this.f6349b = 1;
                    this.f6350c |= 4;
                    break;
                case 7:
                    this.f6350c = 1 | this.f6350c;
                    this.f6349b = 4;
                    break;
                case 8:
                    this.f6349b = 4;
                    break;
                case 9:
                    this.f6349b = 4;
                    break;
                case 10:
                    this.f6349b = 1;
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid stream type ");
                    sb2.append(i10);
                    sb2.append(" for AudioAttributesCompat");
                    break;
            }
            this.f6348a = AudioAttributesImplBase.h(i10);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a c(int i10) {
            if (i10 == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.f6351d = i10;
            return h(i10);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        @n0
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a e(int i10) {
            switch (i10) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.f6348a = i10;
                    return this;
                case 16:
                    this.f6348a = 12;
                    return this;
                default:
                    this.f6348a = 0;
                    return this;
            }
        }

        public a(AudioAttributesCompat audioAttributesCompat) {
            this.f6348a = 0;
            this.f6349b = 0;
            this.f6350c = 0;
            this.f6351d = -1;
            this.f6348a = audioAttributesCompat.f();
            this.f6349b = audioAttributesCompat.a();
            this.f6350c = audioAttributesCompat.e();
            this.f6351d = audioAttributesCompat.d();
        }
    }

    public AudioAttributesImplBase(int i10, int i11, int i12, int i13) {
        this.f6345b = i10;
        this.f6346c = i11;
        this.f6344a = i12;
        this.f6347d = i13;
    }
}
