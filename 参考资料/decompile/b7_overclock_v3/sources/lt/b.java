package lt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.util.io.pem.PemGenerationException;

/* JADX INFO: loaded from: classes6.dex */
public class b implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f40448d = Collections.unmodifiableList(new ArrayList());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f40450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f40451c;

    public b(String str, List list, byte[] bArr) {
        this.f40449a = str;
        this.f40450b = Collections.unmodifiableList(list);
        this.f40451c = bArr;
    }

    public b(String str, byte[] bArr) {
        this(str, f40448d, bArr);
    }

    public byte[] a() {
        return this.f40451c;
    }

    public List b() {
        return this.f40450b;
    }

    public String c() {
        return this.f40449a;
    }

    @Override // lt.c
    public b generate() throws PemGenerationException {
        return this;
    }
}
