package lin.java.test.pattern.proxy;

import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) {
        //使用虚拟的代理，模拟图片延时加载过程，用临时图片片去替换，指导图片加载完毕
        String image = "http://image.jpg";
        try {
            URL url = new URL(image);
            HighResolutionImage highResolutionImage = new HighResolutionImage(url);
            Proxy proxy = new Proxy(highResolutionImage);
//            Concu
            proxy.showImage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
