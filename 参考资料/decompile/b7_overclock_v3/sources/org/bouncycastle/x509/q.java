package org.bouncycastle.x509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class q implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection f46140a;

    public q(Collection collection) {
        Objects.requireNonNull(collection, "collection cannot be null");
        this.f46140a = collection;
    }

    public Collection a() {
        return new ArrayList(this.f46140a);
    }

    public Object clone() {
        return new q(this.f46140a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        stringBuffer.append("  collection: " + this.f46140a + "\n");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
