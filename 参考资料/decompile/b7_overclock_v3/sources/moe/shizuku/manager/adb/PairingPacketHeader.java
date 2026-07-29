package moe.shizuku.manager.adb;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class PairingPacketHeader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final a f41479d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f41480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f41481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41482c;

    public enum Type {
        SPAKE2_MSG((byte) 0),
        PEER_INFO((byte) 1);

        private final byte value;

        Type(byte b10) {
            this.value = b10;
        }

        public final byte getValue() {
            return this.value;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @l
        public final PairingPacketHeader a(@k ByteBuffer buffer) {
            f0.p(buffer, "buffer");
            byte b10 = buffer.get();
            byte b11 = buffer.get();
            int i10 = buffer.getInt();
            if (b10 < 1 || b10 > 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PairingPacketHeader version mismatch (us=1 them=");
                sb2.append((int) b10);
                sb2.append(')');
                return null;
            }
            if (b11 != Type.SPAKE2_MSG.getValue() && b11 != Type.PEER_INFO.getValue()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown PairingPacket type=");
                sb3.append((int) b11);
                return null;
            }
            if (i10 <= 0 || i10 > 16384) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("header payload not within a safe payload size (size=");
                sb4.append(i10);
                sb4.append(')');
                return null;
            }
            PairingPacketHeader pairingPacketHeader = new PairingPacketHeader(b10, b11, i10);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("read PairingPacketHeader ");
            sb5.append(pairingPacketHeader.d());
            return pairingPacketHeader;
        }
    }

    public PairingPacketHeader(byte b10, byte b11, int i10) {
        this.f41480a = b10;
        this.f41481b = b11;
        this.f41482c = i10;
    }

    public final int a() {
        return this.f41482c;
    }

    public final byte b() {
        return this.f41481b;
    }

    public final byte c() {
        return this.f41480a;
    }

    @k
    public final String d() {
        return "version=" + ((int) this.f41480a) + ", type=" + ((int) this.f41481b) + ", payload=" + this.f41482c;
    }

    public final void e(@k ByteBuffer buffer) {
        f0.p(buffer, "buffer");
        buffer.put(this.f41480a);
        buffer.put(this.f41481b);
        buffer.putInt(this.f41482c);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("write PairingPacketHeader ");
        sb2.append(d());
    }

    @k
    public String toString() {
        return "PairingPacketHeader(" + d() + ')';
    }
}
