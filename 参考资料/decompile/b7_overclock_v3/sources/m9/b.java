package m9;

import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f40729a = new b();

    @hk.m
    public static final boolean A(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 16) != 0;
    }

    @hk.m
    public static final boolean B(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 32) != 0;
    }

    @hk.m
    public static final boolean C(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 64) != 0;
    }

    @hk.m
    public static final boolean D(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 128) != 0;
    }

    @hk.m
    public static final boolean E(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[8] & 255) & 1) != 0;
    }

    @hk.m
    public static final boolean F(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 8) == 0) ? false : true;
    }

    @hk.m
    public static final boolean G(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 64) == 0) ? false : true;
    }

    @hk.m
    public static final boolean H(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 16) == 0) ? false : true;
    }

    @hk.m
    public static final boolean I(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 1) == 0) ? false : true;
    }

    @hk.m
    public static final boolean J(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 4) == 0) ? false : true;
    }

    @hk.m
    public static final boolean K(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 2) == 0) ? false : true;
    }

    @hk.m
    public static final boolean L(@yt.k byte[] data) {
        f0.p(data, "data");
        return (!M(data) || (data[9] & 128) == 0 || (data[9] & 32) == 0) ? false : true;
    }

    @hk.m
    public static final boolean M(@yt.k byte[] value) {
        f0.p(value, "value");
        return (value.length == 20 && (value[18] & 255) == 254 && (value[19] & 255) == 0) || value.length == 14;
    }

    @hk.m
    public static final boolean N(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 8) != 0;
    }

    @hk.m
    public static final boolean O(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 32) != 0;
    }

    @hk.m
    public static final boolean P(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[4] & 255) & 2) != 0;
    }

    @hk.m
    public static final boolean Q(@yt.l Integer num, @yt.k byte[] data) {
        f0.p(data, "data");
        return a(num, t0(data));
    }

    public static /* synthetic */ boolean R(Integer num, byte[] bArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        return Q(num, bArr);
    }

    @hk.m
    public static final boolean S(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && data.length > 4 && ((data[4] & 255) & 64) != 0;
    }

    @hk.m
    public static final boolean T(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && (data[8] & 2) != 0;
    }

    @hk.m
    public static final boolean U(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && data.length == 20 && ((byte) (data[17] & 1)) == 1;
    }

    @hk.m
    public static final boolean V(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 2) != 0;
    }

    @hk.m
    public static final boolean W(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 64) != 0;
    }

    @hk.m
    public static final boolean X(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 128) != 0;
    }

    @hk.m
    public static final boolean Y(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[4] & 255) & 1) != 0;
    }

    @hk.m
    public static final boolean a(@yt.l Integer num, @yt.l Pair<Float, Float> pair) {
        double d10 = (num != null && num.intValue() == 68) ? 0.22d : 0.15d;
        if (pair != null) {
            return ((double) Math.abs(pair.f().floatValue())) >= d10 || ((double) Math.abs(pair.h().floatValue())) >= d10;
        }
        return false;
    }

    public static /* synthetic */ boolean b(Integer num, Pair pair, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        return a(num, pair);
    }

    @hk.m
    public static final boolean c0(@yt.l Integer num, @yt.k byte[] data) {
        f0.p(data, "data");
        return a(num, u0(data));
    }

    @hk.m
    public static final boolean d(@yt.k byte[] data) {
        f0.p(data, "data");
        if (M(data)) {
            return ((data[4] & 255) == 0 && (data[5] & 255) == 0 && (data[8] & 255) == 0 && (data[9] & 255) == 0) ? false : true;
        }
        return false;
    }

    public static /* synthetic */ boolean d0(Integer num, byte[] bArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        return c0(num, bArr);
    }

    @hk.m
    public static final boolean e(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[4] & 255) & 16) != 0;
    }

    @hk.m
    public static final boolean e0(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && (data[8] & 8) != 0;
    }

    @hk.m
    public static final boolean f(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && (data[8] & 4) != 0;
    }

    @hk.m
    public static final boolean f0(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[4] & 255) & 128) != 0;
    }

    @hk.m
    public static final boolean g(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[4] & 255) & 32) != 0;
    }

    @hk.m
    public static final boolean g0(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 1) != 0;
    }

    @hk.m
    public static final boolean h(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[8] & 255) & 16) != 0;
    }

    @hk.m
    public static final boolean h0(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 2) != 0;
    }

    @hk.m
    public static final boolean i(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 1) != 0;
    }

    public static /* synthetic */ boolean k(b bVar, byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bArr2 = null;
        }
        return bVar.j(bArr, bArr2);
    }

    @hk.m
    public static final boolean l(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && (data[8] & 1) != 0;
    }

    @hk.m
    public static final boolean n(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[4] & 255) & 4) != 0;
    }

    @hk.m
    public static final boolean o(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && data[5] == 58;
    }

    @hk.m
    @yt.k
    public static final List<Integer> o0(@yt.k byte[] data) {
        f0.p(data, "data");
        List<Integer> listE = CollectionsKt__CollectionsKt.E();
        if (!d(data)) {
            return listE;
        }
        if (Y(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 0);
        }
        if (P(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 1);
        }
        if (n(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 2);
        }
        if (v(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 3);
        }
        if (e(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 4);
        }
        if (g(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 5);
        }
        if (f0(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 7);
        }
        if (g0(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 8);
        }
        if (S(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 6);
        }
        if (V(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 9);
        }
        if (t(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 10);
        }
        if (N(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 11);
        }
        if (u(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 12);
        }
        if (O(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 13);
        }
        if (W(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 14);
        }
        if (X(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 15);
        }
        if (h(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 18);
        }
        if (r(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 19);
        }
        if (E(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 20);
        }
        if (i(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 37);
        }
        if (h0(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 38);
        }
        if (y(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 39);
        }
        if (z(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 40);
        }
        if (A(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 41);
        }
        if (B(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 42);
        }
        if (C(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 53);
        }
        return D(data) ? CollectionsKt___CollectionsKt.z4(listE, 54) : listE;
    }

    @hk.m
    public static final boolean p(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && (data[5] & 255) == 59;
    }

    @hk.m
    @yt.k
    public static final List<Integer> p0(@yt.k byte[] data) {
        f0.p(data, "data");
        List<Integer> listE = CollectionsKt__CollectionsKt.E();
        if (!d(data)) {
            return listE;
        }
        int i10 = data[1] & 255;
        int i11 = data[2] & 255;
        int i12 = data[3] & 255;
        int i13 = data[4] & 255;
        int i14 = data[5] & 255;
        int i15 = data[8] & 255;
        int i16 = data[9] & 255;
        if (i14 == 0 && i15 == 0 && (i16 & 255) == 128) {
            return listE;
        }
        if (i14 != 0) {
            listE = CollectionsKt___CollectionsKt.z4(listE, Integer.valueOf(i14));
        }
        if (i13 != 0) {
            listE = CollectionsKt___CollectionsKt.z4(listE, Integer.valueOf(i13));
        }
        if (i12 != 0) {
            listE = CollectionsKt___CollectionsKt.z4(listE, Integer.valueOf(i12));
        }
        if (i11 != 0) {
            listE = CollectionsKt___CollectionsKt.z4(listE, Integer.valueOf(i11));
        }
        if (i10 != 0) {
            listE = CollectionsKt___CollectionsKt.z4(listE, Integer.valueOf(i10));
        }
        if (l(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 109);
        }
        if (T(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 108);
        }
        if (f(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 111);
        }
        if (e0(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 110);
        }
        if (I(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 100);
        }
        if (K(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 101);
        }
        if (J(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 102);
        }
        if (H(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 104);
        }
        if (F(data)) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 103);
        }
        if (i16 == 160) {
            listE = CollectionsKt___CollectionsKt.z4(listE, 105);
        }
        return i16 == 192 ? CollectionsKt___CollectionsKt.z4(listE, 106) : listE;
    }

    @hk.m
    @yt.l
    public static final Pair<Float, Float> q0(@yt.k byte[] data) {
        f0.p(data, "data");
        if (!M(data)) {
            return null;
        }
        return new Pair<>(Float.valueOf((float) (((double) ((float) (((double) (data[0] & 255)) - 126.5d))) / 126.5d)), Float.valueOf((float) (((double) ((float) (((double) (data[1] & 255)) - 126.5d))) / 126.5d)));
    }

    @hk.m
    public static final boolean r(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[8] & 255) & 8) != 0;
    }

    @hk.m
    public static final boolean t(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 4) != 0;
    }

    @hk.m
    @yt.l
    public static final Pair<Float, Float> t0(@yt.k byte[] data) {
        f0.p(data, "data");
        if (!M(data)) {
            return null;
        }
        return new Pair<>(Float.valueOf((float) (((double) ((float) (((double) (data[2] & 255)) - 126.5d))) / 126.5d)), Float.valueOf((float) (((double) ((float) (((double) (data[3] & 255)) - 126.5d))) / 126.5d)));
    }

    @hk.m
    public static final boolean u(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[5] & 255) & 16) != 0;
    }

    @hk.m
    @yt.l
    public static final Pair<Float, Float> u0(@yt.k byte[] data) {
        f0.p(data, "data");
        if (!M(data)) {
            return null;
        }
        return new Pair<>(Float.valueOf((float) (((double) ((float) (((double) (data[6] & 255)) - 126.5d))) / 126.5d)), Float.valueOf((float) (((double) ((float) (((double) (data[7] & 255)) - 126.5d))) / 126.5d)));
    }

    @hk.m
    public static final boolean v(@yt.k byte[] data) {
        f0.p(data, "data");
        return (M(data) && ((data[4] & 255) & 8) == 0) ? false : true;
    }

    @hk.m
    @yt.k
    public static final List<Integer> v0(@yt.k byte[] data, @yt.k GamepadInfo gamepadInfo) {
        f0.p(data, "data");
        f0.p(gamepadInfo, "gamepadInfo");
        return gamepadInfo.isGamepadKeyboard() ? p0(data) : o0(data);
    }

    @hk.m
    public static final boolean w(@yt.l Integer num, @yt.k byte[] data) {
        f0.p(data, "data");
        return a(num, q0(data));
    }

    public static /* synthetic */ boolean x(Integer num, byte[] bArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = 0;
        }
        return w(num, bArr);
    }

    @hk.m
    public static final boolean y(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 4) != 0;
    }

    @hk.m
    public static final boolean z(@yt.k byte[] data) {
        f0.p(data, "data");
        return M(data) && ((data[9] & 255) & 8) != 0;
    }

    public final boolean Z(byte b10) {
        return (b10 & 64) != 0;
    }

    public final boolean a0(byte b10) {
        return (b10 & 4) != 0;
    }

    public final boolean b0(@yt.k byte[] data) {
        f0.p(data, "data");
        return Z(data[9]) || a0(data[9]);
    }

    public final boolean c(@yt.k byte[] value) {
        f0.p(value, "value");
        return q(value) && (value[18] & 255) == 253;
    }

    public final int i0(@yt.k byte[] value) {
        f0.p(value, "value");
        int iK0 = k0(value);
        if (16 == iK0 || 48 == iK0 || 50 == iK0) {
            return 255;
        }
        return 255 & value[8];
    }

    public final boolean j(@yt.k byte[] callback, @yt.l byte[] bArr) {
        f0.p(callback, "callback");
        if (callback.length == 4 && (callback[0] & 255) == 170 && (callback[1] & 255) == 204) {
            return true;
        }
        return callback.length == 20 && bArr != null && callback[18] == bArr[2] && callback[19] == bArr[3];
    }

    public final int j0(@yt.k byte[] value) {
        f0.p(value, "value");
        return value[14] & 15;
    }

    public final int k0(@yt.k byte[] value) {
        f0.p(value, "value");
        return value[13] & 255;
    }

    public final int l0(@yt.k byte[] value) {
        int i10;
        f0.p(value, "value");
        if (q(value)) {
            if ((value[18] & 255) != 253 || (i10 = value[11] & 255) == 0) {
                return 0;
            }
            if (i10 == 1) {
                return 1;
            }
            if (i10 == 2) {
                return 4;
            }
            if (i10 == 3) {
                return 3;
            }
        }
        return -1;
    }

    public final boolean m(@yt.k byte[] value) {
        f0.p(value, "value");
        return value.length == 20 && (value[18] & 255) == 192 && (value[19] & 255) == 0;
    }

    public final int m0(@yt.k byte[] value) {
        f0.p(value, "value");
        return (value[14] & 255) >> 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n0(int r6, @yt.k byte[] r7) {
        /*
            r5 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.f0.p(r7, r0)
            r0 = 9
            r0 = r7[r0]
            int r7 = r5.k0(r7)
            r1 = 33
            r2 = 0
            if (r7 == r1) goto L16
            switch(r7) {
                case 48: goto L16;
                case 49: goto L16;
                case 50: goto L16;
                default: goto L15;
            }
        L15:
            goto L1d
        L16:
            r7 = 3
            r1 = 2
            r3 = 1
            if (r6 == 0) goto L32
            if (r6 == r3) goto L1e
        L1d:
            return r2
        L1e:
            r6 = r0 & 1
            if (r6 == 0) goto L28
            r4 = r0 & 2
            if (r4 == 0) goto L28
            r2 = 3
            goto L31
        L28:
            if (r6 == 0) goto L2c
            r2 = 1
            goto L31
        L2c:
            r6 = r0 & 2
            if (r6 == 0) goto L31
            r2 = 2
        L31:
            return r2
        L32:
            r6 = r0 & 16
            if (r6 == 0) goto L3c
            r4 = r0 & 32
            if (r4 == 0) goto L3c
            r2 = 3
            goto L45
        L3c:
            if (r6 == 0) goto L40
            r2 = 1
            goto L45
        L40:
            r6 = r0 & 32
            if (r6 == 0) goto L45
            r2 = 2
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.b.n0(int, byte[]):int");
    }

    public final boolean q(@yt.k byte[] value) {
        f0.p(value, "value");
        return value.length == 20 && (value[0] & 255) == 172 && (value[1] & 255) == 192;
    }

    public final int r0(@yt.k byte[] data, int i10) {
        byte b10;
        f0.p(data, "data");
        if (!M(data)) {
            return 0;
        }
        if (i10 == 12) {
            b10 = data[6];
        } else {
            if (i10 != 13) {
                return 0;
            }
            b10 = data[7];
        }
        return b10 & 255;
    }

    public final boolean s(@yt.k byte[] value) {
        f0.p(value, "value");
        return (value[9] & 128) == 128;
    }

    @yt.k
    public final Pair<Integer, Integer> s0(@yt.k byte[] value) {
        f0.p(value, "value");
        byte b10 = value[11];
        byte b11 = value[12];
        byte b12 = value[13];
        int i10 = (b10 & 255) | ((b11 << 8) & 3840);
        if ((i10 & 2048) != 0) {
            i10 |= -4096;
        }
        int i11 = ((b12 << 4) & 4080) | ((b11 >> 4) & 15);
        if ((i11 & 2048) != 0) {
            i11 |= -4096;
        }
        return new Pair<>(Integer.valueOf(i10), Integer.valueOf(i11));
    }
}
