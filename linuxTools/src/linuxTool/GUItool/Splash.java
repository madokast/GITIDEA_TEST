package linuxTool.GUItool;

import linuxTool.Enviroment;
import linuxTool.tool.ThreadSleep;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Splash {
    /**
     * 以下变量用于得到鼠标移动过程，从而控制splash的移动
     * 性能意外的好
     */
    private static int oldX = -1;
    private static int oldY = -1;
    private static int jFrameNewLocalX;
    private static int jFrameNewLocalY;
    private static int moveX;
    private static int moveY;


//    private static Splash splash = new Splash();
//    private static Splash getInstance()
//    {
//        if(splash==null)
//            splash = new Splash();
//
//        return splash;
//    }

//    private static int width;
//    private static int height;

//    private Image splashImage;

//    private MyCanvas myCanvas;

//    private static String imageDirection;
//    private static BufferedImage bufferedImage;
//    private BufferedImage bufferedImage;


//    private Splash()
//    {
//        int width, height;
//
//        try{
//            bufferedImage = ImageIO.read(new File(imageDirection));
//            width = bufferedImage.getWidth();
//            height = bufferedImage.getHeight();
//            Graphics2D graphics2D = (Graphics2D)this.getGraphics();
//            graphics2D.drawImage(bufferedImage,0,0,width,height,null);
////            myCanvas.setSize(width,height);
////            myCanvas.setBackground(new Color(0,0,0,0));
////            myCanvas.getImageAndPrintIt(bufferedImage);
//            this.setBounds(0,0,width,height);
//            this.setBackground(new Color(0,0,0,0));
//        }catch (Exception e){
//            e.printStackTrace();
//            if(imageDirection == null){
//                System.err.println("警告：图片地址参数为空，显示空白图");
//            }else {
//                System.err.println("警告：图片载入失败，显示空白图");
//            }
//            width = GUItools.getScreenWidth()/2;
//            height = GUItools.getScreenHeight()/8;
////            myCanvas.setSize(width,height);
////            myCanvas.setBackground(Color.pink);
//            this.setBounds(0,0,width,height);
//        }finally {
////            this.add(myCanvas,BorderLayout.CENTER);
//            this.setUndecorated(true);
//            this.setAlwaysOnTop(true);
//            this.pack();
//            GUItools.frameCenter(this);
//        }

//        this.setUndecorated(true);
//        this.setBackground(new Color(0,0,0,0));//设置透明
//        this.setAlwaysOnTop(true);
//    }

//    public void paint(Graphics g) {
//        super.paint(g);
//        Graphics2D graphics2D = (Graphics2D)g;
//        graphics2D.drawImage(Splash.bufferedImage,0,0,Splash.width,Splash.height,null);

//        try{
//            graphics2D.drawImage(bufferedImage,0,0,width,height,null);
//        }catch (Exception e){
////            if(imageDirection == null){
////                System.err.println("警告：图片地址参数为空，显示空白图");
////            }else {
////                System.err.println("警告：图片载入失败，显示空白图");
////            }
////            myCanvas = new MyCanvas();
////            width = GUItools.getScreenWidth()/2;
////            height = GUItools.getScreenHeight()/8;
////            myCanvas.setSize(width,height);
////            myCanvas.setBackground(Color.pink);
//            width = GUItools.getScreenWidth()/2;
//            height = GUItools.getScreenHeight()/8;
//            graphics2D.setColor(Color.pink);
//            graphics2D.drawRect(0,0,width,height);
//        }


//        ImageIcon imageIcon = new ImageIcon("/home/madokast/Documents/JavaLearning/linuxTools/image/splash.png");
//        graphics2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getIconWidth() ,imageIcon.getIconHeight(),null);

//    }

    public static synchronized void exhibit(String imageDir, int duration) {
        BufferedImage bufferedImage;
        if (imageDir != null && imageDir.endsWith(Enviroment.PRELOAD_IMAGE)) {
//            System.out.println("是预载入的图片");
//            ThreadSleep.sleep(Thread.currentThread(),5000);
//            System.out.println("休息结束");
            synchronized (ImagePreloading.class) {
                if (ImagePreloading.isPreloaded()) {
//                    System.out.println("拿到图片");
                    bufferedImage = ImagePreloading.getBufferedImage();
                } else {
//                    System.out.println("然而预载入未完成,阻塞自己？");
//                    System.out.println("可是我偷懒了怎么办呢？");
//                    ThreadSleep.sleep(Thread.currentThread(), 10000);
                    try {
                        ImagePreloading.class.wait();
                    } catch (Exception e) {
                    }
//                    System.out.println("被唤醒了");
                    bufferedImage = ImagePreloading.getBufferedImage();

                }
            }

        } else {
            bufferedImage = opaque(getImage(imageDir));
        }

//        System.out.println("拿到图片了，可惜我要偷懒");
//        ThreadSleep.sleep(Thread.currentThread(),5000);
//        System.out.println("干活了干活了");

        MyCanvas myCanvas = new MyCanvas();
        myCanvas.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
        myCanvas.getImageAndPrintIt(bufferedImage);

        Frame jFrame = new Frame();
        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(0, 0, 0, 0));
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        jFrame.setOpacity(0.3f);

        myCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }

            long lastClick = 0L;
            long currentClick;
            @Override
            public void mouseClicked(MouseEvent e){
                currentClick = e.getWhen();
                if(currentClick-lastClick<500){
                    jFrame.dispose();
                }else {
                    lastClick = currentClick;
                }
            }
        });

        myCanvas.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {

                moveX = e.getX() - oldX;
                moveY = e.getY() - oldY;

//                oldX = e.getX();
//                oldY = e.getY();

                jFrameNewLocalX = jFrame.getX() + moveX;
                jFrameNewLocalY = jFrame.getY() + moveY;

                jFrame.setLocation(jFrameNewLocalX, jFrameNewLocalY);


            }
        });


        jFrame.add(myCanvas, BorderLayout.CENTER);
        jFrame.setAlwaysOnTop(true);
        jFrame.pack();
//        jFrame.setBounds(0,0,bufferedImage.getWidth(),bufferedImage.getHeight());
        GUItools.frameCenter(jFrame);
        new Thread(() -> {
            jFrame.setVisible(true);
            try {
                Thread.currentThread().sleep(duration);
            } catch (Exception e) {
            }
            jFrame.dispose();
        }).start();
    }


    public static void exhibit2(String imageDir, int duration) {
//        BufferedImage bufferedImage = opaque(getImage());
        BufferedImage bufferedImage = getImage(imageDir);
//        try{
//            ImageIO.write(bufferedImage,"png",new File("/home/madokast/Documents/JavaLearning/linuxTools/image/kuronew.png"));
//        }catch (Exception e){}


        JFrame jFrame = new JFrame() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
//                g2.drawImage(backImage,0,0,backImage.getWidth(),backImage.getHeight(),null);
                g2.setColor(new Color(0, 0, 0, 0));
                g2.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
                try {
                    Thread.currentThread().sleep(10);
                } catch (Exception e) {
                }
                g2.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

            }
        };

        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(0, 0, 0, 0));
        jFrame.setBounds(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
//        jFrame.pack();
        GUItools.frameCenter(jFrame);
        jFrame.repaint();


        new Thread(() -> {
            jFrame.setVisible(true);
            try {
                jFrame.repaint();
                Thread.currentThread().sleep(duration);
            } catch (Exception e) {
            }
            jFrame.dispose();
        }).start();


//        final BufferedImage bufferedImage = getImage(imageDir);
//        final int width = bufferedImage.getWidth();
//        final int height = bufferedImage.getHeight();
//
//        final JFrame jFrame = new JFrame() {
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                Graphics2D graphics = (Graphics2D) g;
//                for (int i = 0; i < width; i++) {
//                    for (int j = 0; j < height; j++) {
//
//                        int rgb = bufferedImage.getRGB(i, j);
//
//                        if ((rgb >> 24) == 0) {
//                            graphics.setColor(new Color(00, 0, 0, 0));
//                            graphics.drawLine(i, j, i, j);
//                        } else {
//                            graphics.setColor(new Color(rgb | 0xff000000));
//                            graphics.drawLine(i, j, i, j);
//                        }
//                    }
//                }
//            }
//        };
//
//        jFrame.setUndecorated(true);
//        jFrame.setBackground(new Color(0,0,0,0));
//        jFrame.setBounds(0,0,width,height);
//        GUItools.frameCenter(jFrame);
//
//        new Thread(()->{jFrame.setVisible(true);
//            try {
//                Thread.currentThread().sleep(duration);
//            } catch (Exception ee) {
//                ee.printStackTrace();
//            }
//            jFrame.dispose();}).start();

//        int i = 100;
//        while(--i<0){
//            try {
//                jFrame.repaint();
//                Thread.currentThread().sleep(duration/100);
//            } catch (Exception ee) {
//                ee.printStackTrace();
//            }
//        }


//            JFrame jFrame = new JFrame() {
//                @Override
//                public void paint(Graphics g) {
//                    super.paint(g);
//                    Graphics2D g2 = (Graphics2D) g;
//                    BufferedImage imageIcon = ImageIO.read(new File(imageDir));
//                    g2.drawImage(imageIcon, 0, 0, 300, 300, null);
//                }
//            };
//
//            jFrame.setUndecorated(true);
//            jFrame.setBackground(new Color(0,0,0,0));
//            jFrame.setBounds(0,0,300,300);
//            GUItools.frameCenter(jFrame);
//
//            jFrame.setVisible(true);
//
//
//
//
//
//
//
//
//
//
//
//        JFrame jFrame = new JFrame() {
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                Graphics2D g2 = (Graphics2D) g;
//                try {
//                    final BufferedImage bufferedImage = ImageIO.read(new File(imageDir));
//                    final int width = bufferedImage.getWidth();
//                    final int height = bufferedImage.getHeight();
//                    g2.drawImage(bufferedImage, 0, 0, width, height, null);
//                    this.setUndecorated(true);
//                    this.setBackground(new Color(0,0,0,0));
//                    this.setBounds(0,0,width,height);
//                } catch (Exception e) {
//                    if(imageDir == null){
//                        System.err.println("警告：图片地址参数为空，显示空白图");
//                    }else {
//                        System.err.println("警告：图片载入失败，显示空白图");
//                    }
//                    final int width = GUItools.getScreenWidth()/2;
//                    final int height = GUItools.getScreenHeight()/8;
//
//                    g2.setColor(Color.pink);
//                    g2.setBackground(Color.pink);
//                    g2.drawRect(0,0,width,height);
//                    this.setBounds(0,0,width,height);
//                    this.setUndecorated(true);
//                }finally {
//                    GUItools.frameCenter(this);
//                }
//            }
//        };
//
////        jFrame.setUndecorated(true);
////        jFrame.setBackground(new Color(0,0,0,0));
//////        jFrame.setBounds(0,0,300,300);
////        jFrame.pack();
//
//        jFrame.setVisible(true);
//
//        try {
//            Thread.currentThread().sleep(duration);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        jFrame.dispose();


//        imageDirection = imageDir;
//        JFrame splash;
//        try{
//            BufferedImage bufferedImage = ImageIO.read(new File(imageDirection));
//            width = bufferedImage.getWidth();
//            height = bufferedImage.getHeight();
//
//            splash = new Splash();
//            splash.setUndecorated(true);
//            splash.setBackground(new Color(0, 0, 0, 0));
//            splash.setBounds(0, 0, width, height);
//            GUItools.frameCenter(splash);
////            System.out.println("try");
//        }catch (Exception e){
//            //e.printStackTrace();
//            if(imageDirection == null){
//                System.err.println("警告：图片地址参数为空，显示空白图");
//            }else {
//                System.err.println("警告：图片载入失败，显示空白图");
//            }
//            width = GUItools.getScreenWidth()/2;
//            height = GUItools.getScreenHeight()/8;
//
//            splash = new JFrame();
//            splash.setUndecorated(true);
//            splash.setBackground(Color.pink);
//            splash.setBounds(0, 0, width, height);
//            GUItools.frameCenter(splash);
////            System.out.println("catch");
//        }


//        splash.setBounds(0, 0, width, height);
//        GUItools.frameCenter(splash);
//        splash.repaint();


//        splash.setVisible(true);
//        try {
//            Thread.currentThread().sleep(duration);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        splash.dispose();
    }

//    private static void exhibt(){
//        splash.setVisible(true);
//    }
//
//    private static void close()
//    {
//        splash.dispose();
//
//    }

    private static BufferedImage opaque(BufferedImage source) {
        BufferedImage bufferedImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
//        System.out.println("des.getRGB(0,0) = " + String.format("%x",source.getRGB(0, 0)));

        for (int i = source.getMinX(); i < source.getWidth(); i++) {
            for (int j = source.getMinY(); j < source.getHeight(); j++) {
                int rgb = source.getRGB(i, j);

                if ((rgb >> 24) == 0) {
                    graphics.setColor(new Color(00, 0, 0, 0));
                    graphics.drawLine(i, j, i, j);
                } else {
                    graphics.setColor(new Color(rgb | 0xff000000));
                    graphics.drawLine(i, j, i, j);
                }
            }
        }

//        System.out.println("des.getRGB(0,0) = " + String.format("%x",source.getRGB(0, 0)));

        return bufferedImage;
    }

    private static BufferedImage getImage(String imageDir) {
        try {
            BufferedImage imageIcon = ImageIO.read(
                    new File(imageDir));
            return imageIcon;
        } catch (Exception e) {
//            e.printStackTrace();
            if (imageDir == null) {
                System.err.println("警告：图片地址参数为空，显示空白图");
            } else {
                System.err.println("警告：图片载入失败，显示空白图");
            }

//            BufferedImage bufferedImage = new BufferedImage(GUItools.getScreenWidth() / 2, GUItools.getScreenHeight() / 8, TYPE_INT_RGB);
//            Graphics graphics = bufferedImage.getGraphics();
//            graphics.setColor(Color.RED);
//            graphics.fillRect(0, 0, GUItools.getScreenWidth() / 2, GUItools.getScreenHeight() / 8);
//            return bufferedImage;

            return imageWord();
        }
    }

    private static BufferedImage imageWord() {
        int width = GUItools.getScreenWidth() / 3;
        int height = GUItools.getScreenHeight() / 8;
        String string = "さくら  もゆ";

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(0, 0, 0, 0));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.CYAN);
        graphics.fillOval(0, 0, width, height);

//        Font font = new Font(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[1],Font.BOLD,40);
        Font font = new Font(/*"AR PL UKai CN"*/"Noto Serif CJK JP", Font.BOLD, 80);

        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        int x = (width - fontMetrics.stringWidth(string)) / 2;
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        graphics.setFont(font);
        graphics.setColor(Color.RED);
        graphics.drawString(string, x, y);

        return bufferedImage;
    }

}
