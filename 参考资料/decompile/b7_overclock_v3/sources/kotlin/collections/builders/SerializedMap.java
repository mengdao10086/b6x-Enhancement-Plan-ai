package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
final class SerializedMap implements Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f37709a = new a(null);
    private static final long serialVersionUID = 0;

    @k
    private Map<?, ?> map;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public SerializedMap(@k Map<?, ?> map) {
        f0.p(map, "map");
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@k ObjectInput input) throws InvalidObjectException {
        f0.p(input, "input");
        byte b10 = input.readByte();
        if (b10 != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b10));
        }
        int i10 = input.readInt();
        if (i10 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i10 + '.');
        }
        Map mapH = r0.h(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            mapH.put(input.readObject(), input.readObject());
        }
        this.map = r0.d(mapH);
    }

    @Override // java.io.Externalizable
    public void writeExternal(@k ObjectOutput output) throws IOException {
        f0.p(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public SerializedMap() {
        this(s0.z());
    }
}
