package lin.java.test.pattern.proxy;

import java.net.URL;

public class HighResolutionImage implements Image {
    private URL image;

    private long startTime;

    private int height;

    private int width;

    public HighResolutionImage(URL image) {
        this.image = image;
        this.startTime = System.currentTimeMillis();
        this.width = 1000;
        this.height = 900;
    }

    public boolean isLoad() {
        long endTime = System.currentTimeMillis();
        return endTime - startTime > 3000;
    }


    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void showImage() {
        System.out.println("image" + image);
    }
}
