package com.alibaba.android.arouter.facade;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.IProvider;
import f0.e;
import g.p0;
import g.v0;
import h3.a;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Postcard extends RouteMeta {
    private String action;
    private Context context;
    private int enterAnim;
    private int exitAnim;
    private int flags;
    private boolean greenChannel;
    private Bundle mBundle;
    private Bundle optionsCompat;
    private IProvider provider;
    private SerializationService serializationService;
    private Object tag;
    private int timeout;
    private Uri uri;

    public Postcard() {
        this(null, null);
    }

    public Postcard addFlags(int i10) {
        this.flags = i10 | this.flags;
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public Context getContext() {
        return this.context;
    }

    public int getEnterAnim() {
        return this.enterAnim;
    }

    public int getExitAnim() {
        return this.exitAnim;
    }

    public Bundle getExtras() {
        return this.mBundle;
    }

    public int getFlags() {
        return this.flags;
    }

    public Bundle getOptionsBundle() {
        return this.optionsCompat;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Uri getUri() {
        return this.uri;
    }

    public Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    public boolean isGreenChannel() {
        return this.greenChannel;
    }

    public Object navigation() {
        return navigation(null);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Postcard setProvider(IProvider iProvider) {
        this.provider = iProvider;
        return this;
    }

    public Postcard setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public Postcard setTimeout(int i10) {
        this.timeout = i10;
        return this;
    }

    public Postcard setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    @Override // com.alibaba.android.arouter.facade.model.RouteMeta
    public String toString() {
        return "Postcard{uri=" + this.uri + ", tag=" + this.tag + ", mBundle=" + this.mBundle + ", flags=" + this.flags + ", timeout=" + this.timeout + ", provider=" + this.provider + ", greenChannel=" + this.greenChannel + ", optionsCompat=" + this.optionsCompat + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + "}\n" + super.toString();
    }

    public Postcard with(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return this;
    }

    public Postcard withAction(String str) {
        this.action = str;
        return this;
    }

    public Postcard withBoolean(@p0 String str, boolean z10) {
        this.mBundle.putBoolean(str, z10);
        return this;
    }

    public Postcard withBundle(@p0 String str, @p0 Bundle bundle) {
        this.mBundle.putBundle(str, bundle);
        return this;
    }

    public Postcard withByte(@p0 String str, byte b10) {
        this.mBundle.putByte(str, b10);
        return this;
    }

    public Postcard withByteArray(@p0 String str, @p0 byte[] bArr) {
        this.mBundle.putByteArray(str, bArr);
        return this;
    }

    public Postcard withChar(@p0 String str, char c10) {
        this.mBundle.putChar(str, c10);
        return this;
    }

    public Postcard withCharArray(@p0 String str, @p0 char[] cArr) {
        this.mBundle.putCharArray(str, cArr);
        return this;
    }

    public Postcard withCharSequence(@p0 String str, @p0 CharSequence charSequence) {
        this.mBundle.putCharSequence(str, charSequence);
        return this;
    }

    public Postcard withCharSequenceArray(@p0 String str, @p0 CharSequence[] charSequenceArr) {
        this.mBundle.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public Postcard withCharSequenceArrayList(@p0 String str, @p0 ArrayList<CharSequence> arrayList) {
        this.mBundle.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public Postcard withDouble(@p0 String str, double d10) {
        this.mBundle.putDouble(str, d10);
        return this;
    }

    public Postcard withFlags(int i10) {
        this.flags = i10;
        return this;
    }

    public Postcard withFloat(@p0 String str, float f10) {
        this.mBundle.putFloat(str, f10);
        return this;
    }

    public Postcard withFloatArray(@p0 String str, @p0 float[] fArr) {
        this.mBundle.putFloatArray(str, fArr);
        return this;
    }

    public Postcard withInt(@p0 String str, int i10) {
        this.mBundle.putInt(str, i10);
        return this;
    }

    public Postcard withIntegerArrayList(@p0 String str, @p0 ArrayList<Integer> arrayList) {
        this.mBundle.putIntegerArrayList(str, arrayList);
        return this;
    }

    public Postcard withLong(@p0 String str, long j10) {
        this.mBundle.putLong(str, j10);
        return this;
    }

    public Postcard withObject(@p0 String str, @p0 Object obj) {
        SerializationService serializationService = (SerializationService) a.j().p(SerializationService.class);
        this.serializationService = serializationService;
        this.mBundle.putString(str, serializationService.object2Json(obj));
        return this;
    }

    @v0(16)
    public Postcard withOptionsCompat(e eVar) {
        if (eVar != null) {
            this.optionsCompat = eVar.l();
        }
        return this;
    }

    public Postcard withParcelable(@p0 String str, @p0 Parcelable parcelable) {
        this.mBundle.putParcelable(str, parcelable);
        return this;
    }

    public Postcard withParcelableArray(@p0 String str, @p0 Parcelable[] parcelableArr) {
        this.mBundle.putParcelableArray(str, parcelableArr);
        return this;
    }

    public Postcard withParcelableArrayList(@p0 String str, @p0 ArrayList<? extends Parcelable> arrayList) {
        this.mBundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    public Postcard withSerializable(@p0 String str, @p0 Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
        return this;
    }

    public Postcard withShort(@p0 String str, short s10) {
        this.mBundle.putShort(str, s10);
        return this;
    }

    public Postcard withShortArray(@p0 String str, @p0 short[] sArr) {
        this.mBundle.putShortArray(str, sArr);
        return this;
    }

    public Postcard withSparseParcelableArray(@p0 String str, @p0 SparseArray<? extends Parcelable> sparseArray) {
        this.mBundle.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public Postcard withString(@p0 String str, @p0 String str2) {
        this.mBundle.putString(str, str2);
        return this;
    }

    public Postcard withStringArrayList(@p0 String str, @p0 ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
        return this;
    }

    public Postcard withTransition(int i10, int i11) {
        this.enterAnim = i10;
        this.exitAnim = i11;
        return this;
    }

    public Postcard(String str, String str2) {
        this(str, str2, null, null);
    }

    public Object navigation(Context context) {
        return navigation(context, (NavigationCallback) null);
    }

    public Postcard(String str, String str2, Uri uri, Bundle bundle) {
        this.flags = 0;
        this.timeout = 300;
        this.enterAnim = -1;
        this.exitAnim = -1;
        setPath(str);
        setGroup(str2);
        setUri(uri);
        this.mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Object navigation(Context context, NavigationCallback navigationCallback) {
        return a.j().o(context, this, -1, navigationCallback);
    }

    public void navigation(Activity activity, int i10) {
        navigation(activity, i10, null);
    }

    public void navigation(Activity activity, int i10, NavigationCallback navigationCallback) {
        a.j().o(activity, this, i10, navigationCallback);
    }
}
