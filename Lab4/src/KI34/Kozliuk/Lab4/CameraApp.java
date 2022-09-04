package KI34.Kozliuk.Lab4;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class CameraApp
{
    public static void main(String[] args) throws IOException, InterruptedException {
        Human Vasya = new Human();
        //put your path to file info.txt
        VideoCamera videoCamera = new VideoCamera("D:\\University\\3 course\\1 semestr\\Кросплатформні_засоби_програмування\\Clone_rep\\CPPT_Kozliuk_DS_KI-34_1\\Lab4\\src\\info.txt");
        Vasya.takeItem(videoCamera);
    }
}


class Human
{
    private Scanner scanner;

    public void takeItem(VideoCamera camera) throws InterruptedException {
        scanner = new Scanner(System.in);
        while (camera.isCameraOn)
        {
            out.println("Please select what do you want to do");
            out.println("1. Take photo");
            out.println("2. Change lens");
            out.println("3. Turn on flash");
            out.println("4. Turn off flash");
            out.println("5. Increase zoom");
            out.println("6. Decrease zoom");
            out.println("7. Set default zoom");
            out.println("8. Is flash off?");
            out.println("9. What zoom level is now? ");
            out.println("10. View list of photo");
            out.println("11. What is my memory status?");
            out.println("12. Clear memory");
            out.println("13. Delete some picture by name");
            out.println("14. Get full size of memory");
            out.println("15. Get memory in usage");
            out.println("16. Get camera info");
            out.println("17. Get lens info");
            out.println("18. Turn off divice");
            out.println("19. Record video");
            out.println("20. Viev list of video");

            out.print("Enter you choice > ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    camera.takePhoto();
                    out.println("\n------------------------------------");
                }
                case 2 -> {
                    camera.changeLens();
                    out.println("\n------------------------------------");
                }
                case 3 -> {
                    camera.turnONFlash();
                    out.println("\n------------------------------------");
                }
                case 4 -> {
                    camera.turnOffFlash();
                    out.println("\n------------------------------------");
                }
                case 5 -> {
                    out.print("How much to increase the zoom ? \nEnter >");
                    camera.increaseZoom(scanner.nextInt());
                    out.println("\n------------------------------------");
                }
                case 6 -> {
                    out.print("How much to decrease the zoom ? \nEnter >");
                    camera.decreaseZoom(scanner.nextInt());
                    out.println("\n------------------------------------");
                }
                case 7 -> {
                    camera.setZoomDefault();
                    out.println("\n------------------------------------");
                }
                case 8 -> {
                    if(camera.getFlashInfo()){
                        out.println("Flash is in");
                    }else
                    {
                        out.println("Flash is off");
                    }
                    out.println("\n------------------------------------");
                }
                case 9 -> {
                    camera.getZoomInfo();
                    out.println("\n------------------------------------");
                }
                case 10 -> {
                    camera.viewListPhotos();
                    out.println("\n------------------------------------");
                }
                case 11 -> {
                    camera.getMemoryStatus();
                    out.println("\n------------------------------------");
                }
                case 12 -> {
                    camera.clearMemory();
                    out.println("\n------------------------------------");
                }
                case 13 -> {
                    out.print("Picture name that you want to delete ? \nEnter >");
                    var namePhoto = scanner.next();
                    if(camera.deletePicture(namePhoto))
                        out.println("Photo " + namePhoto + " was successfully deleted");
                    else
                        out.println("Photo " + namePhoto + " was failed to delete. Incorrect name");
                    out.println("\n------------------------------------");
                }
                case 14 -> {
                    int mem = camera.getFullMemory();
                    out.println("Full memory is " + mem + " mb");
                    out.println("\n------------------------------------");
                }
                case 15 -> {
                    int memInUse = camera.getMemoryInUsage();
                    out.println("\n------------------------------------");
                    out.println(memInUse + " mb");
                }
                case 16 -> {
                    String name = camera.getName();
                    String firm = camera.getFirm();
                    int mgPx = camera.getMegapixels();
                    var matrixName = camera.getMatrixName();
                    out.println("Name is " + name + "\nFirm is " + firm + "\nMegapixels is " + mgPx + "\nMatrix is " + matrixName);
                    out.println("\n------------------------------------");
                }
                case 17 -> {
                    camera.viewLens();
                }
                case 18 -> {
                    camera.turnOffCamera();
                    out.println("\n------Camera is off---------");
                    out.println("\n------GOODBYE---------");
                }
                case 19 -> {
                    camera.startRecord("1080P" , 60);
                }
                case 20 -> {
                    camera.printData();
                }
                default -> {
                    out.println("Unknown command! Try again! ");
                    out.println("\n------------------------------------");
                }
            }
        }
    }
}