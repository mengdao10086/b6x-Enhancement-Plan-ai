package org.bouncycastle.est;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface s<T> {
    OutputStream b() throws IOException;

    InputStream c() throws IOException;

    void close() throws IOException;

    T d();
}
