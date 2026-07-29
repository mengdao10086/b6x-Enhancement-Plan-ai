package so;

import java.util.Map;
import org.bouncycastle.cms.CMSAttributeTableGenerationException;

/* JADX INFO: loaded from: classes5.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f50127a = "contentType";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f50128b = "digest";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f50129c = "encryptedDigest";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f50130d = "digestAlgID";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f50131e = "macAlgID";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f50132f = "signatureAlgID";

    mm.b a(Map map) throws CMSAttributeTableGenerationException;
}
