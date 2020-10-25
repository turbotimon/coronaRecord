// Disclaimer: Code base from https://learntodroid.com/how-to-create-a-qr-code-scanner-app-in-android/

package ch.ost.mge.testat.coronarecord.services;

public interface QRCodeFoundListener {
    void onQRCodeFound(String qrCode);
    void qrCodeNotFound();

    //


}
