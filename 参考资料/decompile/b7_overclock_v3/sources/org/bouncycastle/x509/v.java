package org.bouncycastle.x509;

import java.io.InputStream;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class v {
    public abstract void a(InputStream inputStream);

    public abstract Object b() throws StreamParsingException;

    public abstract Collection c() throws StreamParsingException;
}
