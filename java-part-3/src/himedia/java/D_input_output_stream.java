package himedia.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class D_input_output_stream {

    // 1. 바탕화면 경로 가져오기
    private String desktopPath;
    // 2. 폴더 경로 설정
    private String folderPath;
    // 폴더 생성
    private Path myFolder;
    private String today;
    private Path todayFile;

    public D_input_output_stream() {
        this.desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        this.folderPath = desktopPath + File.separator + "테스트";
        this.myFolder = Paths.get(folderPath);
    }

    public void exam1() {
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

    public void exam2() {
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        todayFile = myFolder.resolve(today + ".txt");

        // 오늘 날짜의 파일을 생성하고 "Hello World!"를 넣음
        if ( Files.notExists(todayFile) ) {
            // 방법.1
            /*
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(todayFile.toFile());
                String content = "Hello World!";
                fos.write(content.getBytes());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
             */
            // 방법.2 -> try - with - resources
            try ( FileOutputStream fos = new FileOutputStream(todayFile.toFile()) ) {
                String content = "Hello World";
                fos.write(content.getBytes());
                System.out.println(today + ".txt 파일을 생성하고 내용을 썼습니다.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(today + ".txt 파일이 이미 존재합니다.");
        }
    }

    public void exam3() {
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        todayFile = myFolder.resolve(today + ".txt");

        if ( Files.exists(todayFile) ) {
            try (FileInputStream fis = new FileInputStream(todayFile.toFile())) {
                int byteData;
                System.out.println("읽어오기 : " + today + ".txt");

                while ( (byteData = fis.read()) != -1 ) {
                    System.out.print((char) byteData);
                }
                System.out.println(); //줄바꿈
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(today + ".txt 파일이 존재하지 않습니다.");
        }
    }

    public static void main(String[] args) {
        D_input_output_stream d = new D_input_output_stream();
        d.exam3();
    }
}
