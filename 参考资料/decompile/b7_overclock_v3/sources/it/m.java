package it;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class m extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f35862b;

    public m(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("directory not allowed");
        }
        this.f35862b = new FileInputStream(file);
    }

    public m(InputStream inputStream) {
        this.f35862b = inputStream;
    }

    @Override // it.f
    public byte[] b(cs.o oVar) {
        return o.e(oVar, this.f35862b);
    }
}
