package no.nordicsemi.android.dfu.internal;

import com.google.gson.Gson;
import g.n0;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

/* JADX INFO: loaded from: classes5.dex */
public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead;
    private int bytesReadFromCurrentSource;
    private int bytesReadFromMarkedSource;
    private final CRC32 crc32;
    private byte[] currentSource;
    private final Map<String, byte[]> entries;
    private Manifest manifest;
    private byte[] markedSource;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    /* JADX WARN: Removed duplicated region for block: B:72:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0242  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArchiveInputStream(final java.io.InputStream r6, final int r7, final int r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private void parseZip(final int mbrSize) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("A directory found in the ZIP: ");
                sb2.append(name);
                sb2.append("!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i10 = this.zipInputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i10);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (name.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, mbrSize);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if (MANIFEST.equals(name)) {
                    str = new String(byteArray, StandardCharsets.UTF_8);
                } else {
                    this.entries.put(name, byteArray);
                }
            }
        }
        if (this.entries.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        }
        if (str != null) {
            this.manifest = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
        }
    }

    private int rawRead(@n0 final byte[] buffer, final int offset, final int length) {
        byte[] bArr = this.currentSource;
        int length2 = bArr.length;
        int i10 = this.bytesReadFromCurrentSource;
        int i11 = length2 - i10;
        if (length > i11) {
            length = i11;
        }
        System.arraycopy(bArr, i10, buffer, offset, length);
        this.bytesReadFromCurrentSource += length;
        this.bytesRead += length;
        this.crc32.update(buffer, offset, length);
        return length;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 != this.softDeviceBytes || (bArr = this.bootloaderBytes) == null || (this.type & 2) <= 0) {
            bArr = this.applicationBytes;
            if (bArr2 == bArr || bArr == null || (this.type & 4) <= 0) {
                bArr = null;
                this.currentSource = null;
            } else {
                this.currentSource = bArr;
            }
        } else {
            this.currentSource = bArr;
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int available() {
        int iSoftDeviceImageSize;
        int i10;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr == null || this.softDeviceSize != 0 || this.bootloaderSize != 0 || (this.type & 3) <= 0) {
            iSoftDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i10 = this.bytesRead;
        } else {
            iSoftDeviceImageSize = bArr.length + applicationImageSize();
            i10 = this.bytesRead;
        }
        return iSoftDeviceImageSize - i10;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (bArr2 != null && (bArr = this.bootloaderBytes) != null && this.currentSource == bArr) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 0 | 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest = this.manifest;
        return manifest != null && manifest.isSecureDfuRequired();
    }

    @Override // java.io.InputStream
    public void mark(final int readlimit) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i10 = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i10;
        this.bytesRead = i10;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        this.crc32.update(this.currentSource, 0, this.bytesReadFromCurrentSource);
    }

    public int setContentType(final int type) {
        byte[] bArr;
        this.type = type;
        int i10 = type & 4;
        if (i10 > 0 && this.applicationBytes == null) {
            this.type = type & (-5);
        }
        int i11 = type & 3;
        if (i11 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i11 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((type & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((type & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i10 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    @Override // java.io.InputStream
    public long skip(final long n10) {
        return 0L;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(@n0 final byte[] buffer) {
        return read(buffer, 0, buffer.length);
    }

    @Override // java.io.InputStream
    public int read(@n0 final byte[] buffer, final int offset, final int length) {
        int iRawRead = rawRead(buffer, offset, length);
        return (length <= iRawRead || startNextFile() == null) ? iRawRead : iRawRead + rawRead(buffer, offset + iRawRead, length - iRawRead);
    }
}
