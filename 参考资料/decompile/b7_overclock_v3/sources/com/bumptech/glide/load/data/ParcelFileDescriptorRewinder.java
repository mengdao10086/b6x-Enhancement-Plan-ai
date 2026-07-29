package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.e;
import g.n0;
import g.v0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InternalRewinder f12179a;

    @v0(21)
    public static final class InternalRewinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ParcelFileDescriptor f12180a;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f12180a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.f12180a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f12180a;
            } catch (ErrnoException e10) {
                throw new IOException(e10);
            }
        }
    }

    @v0(21)
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.e.a
        @n0
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<ParcelFileDescriptor> b(@n0 ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    @v0(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f12179a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        return true;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.e
    @n0
    @v0(21)
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor a() throws IOException {
        return this.f12179a.rewind();
    }
}
