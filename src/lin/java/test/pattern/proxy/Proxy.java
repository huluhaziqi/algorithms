package lin.java.test.pattern.proxy;

public class Proxy implements Image {

    private HighResolutionImage highResolutionImage;


    public Proxy(HighResolutionImage highResolutionImage) {
        this.highResolutionImage = highResolutionImage;
    }

    @Override
    public void showImage() {
        while (!highResolutionImage.isLoad()) {
            try {
                System.out.println("temp image" + highResolutionImage.getHeight() + " " + highResolutionImage.getWidth());
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        highResolutionImage.showImage();
    }
}
