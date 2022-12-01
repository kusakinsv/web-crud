package ru.one.crud.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrowserLauncher {
    @Value("${server.startpage}")
    private String url;
    @Value("${server.launch-browser-on-start}")
    private String launchBrowser;

    public void start(){
        if (launchBrowser.equals("true")) launchBrowser();
    }

    @SneakyThrows
    private void launchBrowser() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);

        } else if (os.contains("mac")) {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("open " + url);
        } else if (os.contains("nix") || os.contains("nux")) {
            Runtime runtime = Runtime.getRuntime();
            String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror",
                    "netscape", "opera", "links", "lynx"};
            StringBuffer cmd = new StringBuffer();
            for (int i = 0; i < browsers.length; i++) {
                if (i == 0)
                    cmd.append(String.format("%s \"%s\"", browsers[i], url));
                else
                    cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
            }
            runtime.exec(new String[]{"sh", "-c", cmd.toString()});
        }

    }

}

