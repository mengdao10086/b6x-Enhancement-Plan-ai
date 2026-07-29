package it;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class l extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f35861b;

    public l(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("directory not allowed as ERSFileData");
        }
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath() + " does not exist");
        }
        if (file.canRead()) {
            this.f35861b = file;
            return;
        }
        throw new FileNotFoundException(file.getAbsolutePath() + " is not readable");
    }

    @Override // it.f
    public byte[] b(cs.o oVar) {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f35861b);
            byte[] bArrE = o.e(oVar, fileInputStream);
            fileInputStream.close();
            return bArrE;
        } catch (IOException unused) {
            throw new IllegalStateException("unable to process " + this.f35861b.getAbsolutePath());
        }
    }
}
