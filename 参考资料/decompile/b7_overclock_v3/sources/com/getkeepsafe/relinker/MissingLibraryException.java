package com.getkeepsafe.relinker;

import j3.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class MissingLibraryException extends RuntimeException {
    public MissingLibraryException(final String library, final String[] wantedABIs, final String[] supportedABIs) {
        super("Could not find '" + library + "'. Looked for: " + Arrays.toString(wantedABIs) + ", but only found: " + Arrays.toString(supportedABIs) + b.f36044h);
    }
}
