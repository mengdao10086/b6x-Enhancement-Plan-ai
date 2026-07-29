package j9;

import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final UUID f36211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final byte[] f36212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final Integer f36213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final Integer f36214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final Boolean f36215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final a f36216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public Long f36217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36218h;

    public b(@l UUID uuid, @k byte[] data, @l Integer num, @l Integer num2, @l Boolean bool, @l a aVar, @l Long l10) {
        f0.p(data, "data");
        this.f36211a = uuid;
        this.f36212b = data;
        this.f36213c = num;
        this.f36214d = num2;
        this.f36215e = bool;
        this.f36216f = aVar;
        this.f36217g = l10;
        this.f36218h = f0.g(bool, Boolean.TRUE) ? 3 : 0;
    }

    public static /* synthetic */ b i(b bVar, UUID uuid, byte[] bArr, Integer num, Integer num2, Boolean bool, a aVar, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            uuid = bVar.f36211a;
        }
        if ((i10 & 2) != 0) {
            bArr = bVar.f36212b;
        }
        byte[] bArr2 = bArr;
        if ((i10 & 4) != 0) {
            num = bVar.f36213c;
        }
        Integer num3 = num;
        if ((i10 & 8) != 0) {
            num2 = bVar.f36214d;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            bool = bVar.f36215e;
        }
        Boolean bool2 = bool;
        if ((i10 & 32) != 0) {
            aVar = bVar.f36216f;
        }
        a aVar2 = aVar;
        if ((i10 & 64) != 0) {
            l10 = bVar.f36217g;
        }
        return bVar.h(uuid, bArr2, num3, num4, bool2, aVar2, l10);
    }

    @l
    public final UUID a() {
        return this.f36211a;
    }

    @k
    public final byte[] b() {
        return this.f36212b;
    }

    @l
    public final Integer c() {
        return this.f36213c;
    }

    @l
    public final Integer d() {
        return this.f36214d;
    }

    @l
    public final Boolean e() {
        return this.f36215e;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return f0.g(this.f36211a, bVar.f36211a) && f0.g(this.f36212b, bVar.f36212b) && f0.g(this.f36213c, bVar.f36213c) && f0.g(this.f36214d, bVar.f36214d) && f0.g(this.f36215e, bVar.f36215e) && f0.g(this.f36216f, bVar.f36216f) && f0.g(this.f36217g, bVar.f36217g);
    }

    @l
    public final a f() {
        return this.f36216f;
    }

    @l
    public final Long g() {
        return this.f36217g;
    }

    @k
    public final b h(@l UUID uuid, @k byte[] data, @l Integer num, @l Integer num2, @l Boolean bool, @l a aVar, @l Long l10) {
        f0.p(data, "data");
        return new b(uuid, data, num, num2, bool, aVar, l10);
    }

    public int hashCode() {
        UUID uuid = this.f36211a;
        int iHashCode = (((uuid == null ? 0 : uuid.hashCode()) * 31) + Arrays.hashCode(this.f36212b)) * 31;
        Integer num = this.f36213c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f36214d;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.f36215e;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        a aVar = this.f36216f;
        int iHashCode5 = (iHashCode4 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        Long l10 = this.f36217g;
        return iHashCode5 + (l10 != null ? l10.hashCode() : 0);
    }

    @l
    public final a j() {
        return this.f36216f;
    }

    @k
    public final byte[] k() {
        return this.f36212b;
    }

    @l
    public final Long l() {
        return this.f36217g;
    }

    @l
    public final Integer m() {
        return this.f36213c;
    }

    @l
    public final Boolean n() {
        return this.f36215e;
    }

    public final int o() {
        return this.f36218h;
    }

    @l
    public final Integer p() {
        return this.f36214d;
    }

    @l
    public final UUID q() {
        return this.f36211a;
    }

    public final void r(@l Long l10) {
        this.f36217g = l10;
    }

    public final void s(int i10) {
        this.f36218h = i10;
    }

    @k
    public String toString() {
        return "RequestPack(uuid=" + this.f36211a + ", data=" + Arrays.toString(this.f36212b) + ", index=" + this.f36213c + ", totalPage=" + this.f36214d + ", requireCallback=" + this.f36215e + ", callback=" + this.f36216f + ", delay=" + this.f36217g + ee.a.f26979d;
    }

    public /* synthetic */ b(UUID uuid, byte[] bArr, Integer num, Integer num2, Boolean bool, a aVar, Long l10, int i10, u uVar) {
        this((i10 & 1) != 0 ? null : uuid, bArr, (i10 & 4) != 0 ? 1 : num, (i10 & 8) != 0 ? 1 : num2, (i10 & 16) != 0 ? Boolean.FALSE : bool, (i10 & 32) != 0 ? null : aVar, (i10 & 64) != 0 ? 1L : l10);
    }
}
