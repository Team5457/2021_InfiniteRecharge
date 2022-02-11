package frc.robot;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

//I've no idea how class works, figure it out

public class CameraManager extends Subsystem {

    { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    private Timer timer = new Timer();

    CvSink sinkA;
    CvSink sinkB;

    CvSource sourceA;
    CvSource sourceB;
    Mat aMat = new Mat();
    Mat bMat = new Mat();

    CameraServer server = CameraServer.getInstance();
    private final UsbCamera main = CameraServer.startAutomaticCapture(0);

    public void SetupVision() {
        sinkA = server.getVideo();
        sourceA = server.putVideo("Source A", 640, 480);
        sourceB = server.putVideo("Source B", 640, 480);
        timer.start();
    }

    public void UpdateVision(int aType, int bType) {
        if (timer.get() < 5)
            return; 
        /*if (aType == 0)
            Otsu(sinkA, sourceA, aMat);
        if (bType == 0)
            Otsu(sinkB, sourceB, bMat);
        if (aType == 1)
            RGB(sinkA, sourceA, aMat);
        if (bType == 1)
            RGB(sinkB, sourceB, bMat);
        */
    }

    private void Otsu(CvSink a, CvSource s, Mat r) {
        a.grabFrame(r);
        Imgproc.cvtColor(r, r, Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(r, r, 0, 255, Imgproc.THRESH_OTSU);
        s.putFrame(r);
    }

    private void RGB(CvSink a, CvSource s, Mat r) {
        a.grabFrame(r);
        Imgproc.cvtColor(r, r, Imgproc.COLOR_BGR2RGB);
        Core.inRange(r, new Scalar(140, 140, 0), new Scalar(255, 255, 110), r);
        s.putFrame(r);
    }
    @Override
    protected void initDefaultCommand() {
        
    }
    
}