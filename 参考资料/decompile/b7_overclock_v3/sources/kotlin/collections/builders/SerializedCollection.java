package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c1;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1#2:430\n*E\n"})
public final class SerializedCollection implements Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f37706a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37707b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f37708c = 1;
    private static final long serialVersionUID = 0;

    @k
    private Collection<?> collection;
    private final int tag;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public SerializedCollection(@k Collection<?> collection, int i10) {
        f0.p(collection, "collection");
        this.collection = collection;
        this.tag = i10;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@k ObjectInput input) throws InvalidObjectException {
        Collection<?> collectionA;
        f0.p(input, "input");
        byte b10 = input.readByte();
        int i10 = b10 & 1;
        if ((b10 & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b10) + '.');
        }
        int i11 = input.readInt();
        if (i11 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i11 + '.');
        }
        int i12 = 0;
        if (i10 == 0) {
            List listJ = s.j(i11);
            while (i12 < i11) {
                listJ.add(input.readObject());
                i12++;
            }
            collectionA = s.a(listJ);
        } else {
            if (i10 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i10 + '.');
            }
            Set setE = c1.e(i11);
            while (i12 < i11) {
                setE.add(input.readObject());
                i12++;
            }
            collectionA = c1.a(setE);
        }
        this.collection = collectionA;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@k ObjectOutput output) throws IOException {
        f0.p(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it2 = this.collection.iterator();
        while (it2.hasNext()) {
            output.writeObject(it2.next());
        }
    }

    public SerializedCollection() {
        this(CollectionsKt__CollectionsKt.E(), 0);
    }
}
