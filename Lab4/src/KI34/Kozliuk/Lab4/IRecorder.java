package KI34.Kozliuk.Lab4;

/**
 * Interface that contain method for recording video
 */
public interface IRecorder extends IPromptableKey
{
    void startRecord(String resolution, int fps) throws InterruptedException;
    void stopRecord();

    double sizeOfVideo(String resolution, int fps);
}
