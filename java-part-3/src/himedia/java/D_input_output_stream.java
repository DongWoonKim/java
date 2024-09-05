package himedia.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D_input_output_stream {

    public static void exam1() {
        // 1. 바탕화면 경로 가져오기
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        // 2. 폴더 경로 설정
        String folderPath = desktopPath + File.separator + "테스트";

        // 폴더 생성
        Path myFolder = Paths.get(folderPath);

        try {
            if ( Files.notExists(myFolder) ) {
                // 폴더 존재 X
                Files.createDirectory(myFolder);
                System.out.println("테스트 폴더가 생성되었습니다.");
            } else {
                System.out.println("폴더가 이미 존재합니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exam2() {
        
    }

    public static void main(String[] args) {
        exam1();
    }
}
