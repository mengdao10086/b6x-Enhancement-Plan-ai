package dp;

import cp.t;
import fp.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
import jp.c;
import jt.h;
import mp.e;
import np.n1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f26444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BufferedInputStream f26445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BufferedOutputStream f26446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f26447e;

    public a() {
        this.f26443a = true;
        this.f26444b = null;
        this.f26445c = null;
        this.f26446d = null;
        this.f26447e = null;
    }

    public a(String str, String str2, String str3, boolean z10) {
        SecureRandom secureRandom;
        PrintStream printStream;
        StringBuilder sb2;
        String str4;
        SecureRandom secureRandom2 = null;
        this.f26444b = null;
        this.f26445c = null;
        this.f26446d = null;
        this.f26447e = null;
        this.f26443a = z10;
        try {
            this.f26445c = new BufferedInputStream(new FileInputStream(str));
        } catch (FileNotFoundException unused) {
            System.err.println("Input file not found [" + str + "]");
            System.exit(1);
        }
        try {
            this.f26446d = new BufferedOutputStream(new FileOutputStream(str2));
        } catch (IOException unused2) {
            System.err.println("Output file not created [" + str2 + "]");
            System.exit(1);
        }
        if (z10) {
            try {
                secureRandom = new SecureRandom();
            } catch (Exception unused3) {
            }
            try {
                secureRandom.setSeed("www.bouncycastle.org".getBytes());
            } catch (Exception unused4) {
                secureRandom2 = secureRandom;
                try {
                    System.err.println("Hmmm, no SHA1PRNG, you need the Sun implementation");
                    System.exit(1);
                    secureRandom = secureRandom2;
                } catch (IOException unused5) {
                    printStream = System.err;
                    sb2 = new StringBuilder();
                    str4 = "Could not decryption create key file [";
                }
            }
            y yVar = new y(secureRandom, 192);
            g gVar = new g();
            gVar.b(yVar);
            this.f26447e = gVar.a();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
            byte[] bArrH = h.h(this.f26447e);
            bufferedOutputStream.write(bArrH, 0, bArrH.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str3));
            int iAvailable = bufferedInputStream.available();
            byte[] bArr = new byte[iAvailable];
            bufferedInputStream.read(bArr, 0, iAvailable);
            this.f26447e = h.c(bArr);
            return;
        } catch (IOException unused6) {
            printStream = System.err;
            sb2 = new StringBuilder();
            str4 = "Decryption key file not found, or not valid [";
        }
        sb2.append(str4);
        sb2.append(str3);
        sb2.append("]");
        printStream.println(sb2.toString());
        System.exit(1);
    }

    public static void a(String[] strArr) {
        String str;
        boolean z10 = true;
        if (strArr.length < 2) {
            new a();
            System.err.println("Usage: java " + a.class.getName() + " infile outfile [keyfile]");
            System.exit(1);
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        if (strArr.length > 2) {
            str = strArr[2];
            z10 = false;
        } else {
            str = "deskey.dat";
        }
        new a(str2, str3, str, z10).d();
    }

    public final void b(byte[] bArr) {
        this.f26444b.f(false, new n1(bArr));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f26445c));
        byte[] bArr2 = null;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    try {
                        break;
                    } catch (CryptoException unused) {
                        return;
                    }
                }
                byte[] bArrB = h.b(line);
                bArr2 = new byte[this.f26444b.c(bArrB.length)];
                int iH = this.f26444b.h(bArrB, 0, bArrB.length, bArr2, 0);
                if (iH > 0) {
                    this.f26446d.write(bArr2, 0, iH);
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            }
        }
        int iA = this.f26444b.a(bArr2, 0);
        if (iA > 0) {
            this.f26446d.write(bArr2, 0, iA);
        }
    }

    public final void c(byte[] bArr) {
        this.f26444b.f(true, new n1(bArr));
        byte[] bArr2 = new byte[47];
        byte[] bArr3 = new byte[this.f26444b.c(47)];
        while (true) {
            try {
                int i10 = this.f26445c.read(bArr2, 0, 47);
                if (i10 <= 0) {
                    try {
                        break;
                    } catch (CryptoException unused) {
                        return;
                    }
                }
                int iH = this.f26444b.h(bArr2, 0, i10, bArr3, 0);
                if (iH > 0) {
                    byte[] bArrI = h.i(bArr3, 0, iH);
                    this.f26446d.write(bArrI, 0, bArrI.length);
                    this.f26446d.write(10);
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            }
        }
        int iA = this.f26444b.a(bArr3, 0);
        if (iA > 0) {
            byte[] bArrI2 = h.i(bArr3, 0, iA);
            this.f26446d.write(bArrI2, 0, bArrI2.length);
            this.f26446d.write(10);
        }
    }

    public final void d() {
        this.f26444b = new e(new c(new t()));
        if (this.f26443a) {
            c(this.f26447e);
        } else {
            b(this.f26447e);
        }
        try {
            this.f26445c.close();
            this.f26446d.flush();
            this.f26446d.close();
        } catch (IOException e10) {
            System.err.println("exception closing resources: " + e10.getMessage());
        }
    }
}
