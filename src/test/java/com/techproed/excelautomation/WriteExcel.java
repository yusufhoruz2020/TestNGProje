package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/resources/ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // Dosya üzerinde yazma işlemi gerçekleştireceğimiz için buraya
        // FileOutputStream class'ından bir tane nesne oluşturmamız gerekiyor.
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        // ÜLKELER  BAŞKENTLER  NEYIMESHUR  NÜFUS
        // 0. indexteki satırın, 3. indexteki hücresine NÜFUS hücresi ekleyelim
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NÜFUS");

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue(80000000);

        //0. indexteki satitin , 2. indexindeki hücreyi silelim (NeyiMeshur)



        Cell silmekIstenenHucre = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(silmekIstenenHucre);

        // 1. indexteki satiri silelim
        Row silmekIstenenSatir = workbook.getSheetAt(0).getRow(1);
        workbook.getSheetAt(0).removeRow(silmekIstenenSatir);



        // yaptığımız değişiklikleri excel dosyasına aktarır, veriyi yazar ve kaydeder.
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }

}
