package org.bouncycastle.crypto.util;

import gm.f0;
import gm.f2;
import gm.j2;
import gm.z;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class JournaledAlgorithm implements org.bouncycastle.util.g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient JournalingSecureRandom f44716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient zn.b f44717b;

    public JournaledAlgorithm(zn.b bVar, JournalingSecureRandom journalingSecureRandom) {
        Objects.requireNonNull(bVar, "AlgorithmIdentifier passed to JournaledAlgorithm is null");
        Objects.requireNonNull(journalingSecureRandom, "JournalingSecureRandom passed to JournaledAlgorithm is null");
        this.f44716a = journalingSecureRandom;
        this.f44717b = bVar;
    }

    public JournaledAlgorithm(byte[] bArr) {
        this(bArr, org.bouncycastle.crypto.n.f());
    }

    public JournaledAlgorithm(byte[] bArr, SecureRandom secureRandom) {
        Objects.requireNonNull(bArr, "encoding passed to JournaledAlgorithm is null");
        Objects.requireNonNull(secureRandom, "random passed to JournaledAlgorithm is null");
        f(bArr, secureRandom);
    }

    public static JournaledAlgorithm c(File file, SecureRandom secureRandom) throws IOException, ClassNotFoundException {
        Objects.requireNonNull(file, "File for loading is null in JournaledAlgorithm");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return new JournaledAlgorithm(kt.c.e(bufferedInputStream), secureRandom);
        } finally {
            bufferedInputStream.close();
        }
    }

    public static JournaledAlgorithm d(InputStream inputStream, SecureRandom secureRandom) throws IOException, ClassNotFoundException {
        Objects.requireNonNull(inputStream, "stream for loading is null in JournaledAlgorithm");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            return new JournaledAlgorithm(kt.c.e(bufferedInputStream), secureRandom);
        } finally {
            bufferedInputStream.close();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        f((byte[]) objectInputStream.readObject(), org.bouncycastle.crypto.n.f());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public zn.b a() {
        return this.f44717b;
    }

    public JournalingSecureRandom b() {
        return this.f44716a;
    }

    public final void f(byte[] bArr, SecureRandom secureRandom) {
        f0 f0VarJ = f0.J(bArr);
        this.f44717b = zn.b.z(f0VarJ.K(0));
        this.f44716a = new JournalingSecureRandom(z.I(f0VarJ.K(1)).J(), secureRandom);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        gm.i iVar = new gm.i();
        iVar.a(this.f44717b);
        iVar.a(new f2(this.f44716a.a()));
        return new j2(iVar).getEncoded();
    }

    public void h(File file) throws IOException {
        Objects.requireNonNull(file, "file for storage is null in JournaledAlgorithm");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            i(fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public void i(OutputStream outputStream) throws IOException {
        Objects.requireNonNull(outputStream, "output stream for storage is null in JournaledAlgorithm");
        outputStream.write(getEncoded());
    }
}
