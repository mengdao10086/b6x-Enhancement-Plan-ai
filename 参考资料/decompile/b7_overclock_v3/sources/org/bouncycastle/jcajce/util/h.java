package org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class h {
    public static AnnotatedPrivateKey a(PrivateKey privateKey, String str) {
        return new AnnotatedPrivateKey(privateKey, str);
    }

    public static AnnotatedPrivateKey b(PrivateKey privateKey, Map<String, Object> map) {
        return new AnnotatedPrivateKey(privateKey, (Map<String, Object>) Collections.unmodifiableMap(new HashMap(map)));
    }
}
