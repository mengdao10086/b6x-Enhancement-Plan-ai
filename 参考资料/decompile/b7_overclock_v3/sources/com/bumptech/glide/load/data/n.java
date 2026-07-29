package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import g.n0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class n extends l<InputStream> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12216e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12217f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12218g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12219h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12220i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final UriMatcher f12221j;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f12221j = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.l
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.l
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamI = i(uri, contentResolver);
        if (inputStreamI != null) {
            return inputStreamI;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    public final InputStream i(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = f12221j.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return j(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return j(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    public final InputStream j(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
