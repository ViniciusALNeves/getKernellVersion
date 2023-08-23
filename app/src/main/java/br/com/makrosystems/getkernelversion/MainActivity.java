package br.com.makrosystems.getkernelversion;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        String kernelVersion = System.getProperty("os.version");

        ApplicationInfo info=getApplicationInfo();
        final int target=info.targetSdkVersion;

        File arq;
        String caminho = "/storage/emulated/0/TesteFile.txt";

        arq = new File(caminho);

        Long ultDt = arq.lastModified();

        DateFormat df = DateFormat.getDateTimeInstance();
        String novaData = df.format(ultDt);

        System.out.println("DDDAAATTTTAAA"+novaData);

        System.out.println("VERSAO DO SDK\n"+target);
        textView.setText(kernelVersion);
        System.out.println(kernelVersion);
        System.out.println(myPlataforn());
    }

    public static String myPlataforn(){

        String plataforma = "";

        if(Build.FINGERPRINT.contains("generic"))
        {
            plataforma = "Emulador";
        }else if(Build.FINGERPRINT.contains("vbox"))
        {
            plataforma = "VirtualBox";
        }else if(Build.FINGERPRINT.contains("generic_x86"))
        {
            plataforma = "Emulator x86";
        }else if(Build.BRAND.contains("google") && Build.MODEL.startsWith("Pixel"))
        {
            plataforma = "Dispositivo pixel";
        }else if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
        {
            plataforma = "Dispositivo Sansung";
        }else if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi"))
        {
            plataforma = "Dispositivo Xiomi";
        }
        System.out.println("PLATAFORMA: "+plataforma);
        return plataforma;
    }
}