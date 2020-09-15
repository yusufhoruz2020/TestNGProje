package com.techproed.excelautomation;

import com.google.gson.stream.JsonToken;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/resources/ULKELER.xlsx";

        // Java da bir dosyayi acmak istiyorsaniz FileInputStream
        // parametre bölümüne acmak istedigimiz dosyanin adresi ( dosya yolu ya da path yazilir )
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Weorkbook (excel) dosyasini okumaya basladik
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // !. sayfaya gider ( index degeri  dan baslar)
        Sheet sheet       = workbook.getSheetAt(0);

        // 1 . satira gidelim  ( index degeri 0 dan baslar )
        Row row    = sheet.getRow(0);

        // 1 . Hücreye gidelim. ( index degeri 0 dan baslar )

        Cell ulkeler = row.getCell(0);
        Cell baskentler = row.getCell(1);
        Cell meshurlar = row.createCell(2);
        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        // Excel'e Git -> Sheet 0'a git -> 2. İndexteki Satıra git -> 1. İndexteki Hücre
        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(1));

        // peynir yazdir
        System.out.println(workbook.getSheetAt(0).getRow(4).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0 ));

        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() +1;
        System.out.println("Satır sayısı : " + satirSayisi);

        // icerisinde veri olan satir syisini almka isterseniz
        // indexi 1 den basliyor
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu SatirSayisi : "+ doluSatirSayisi);


        int sonSatirIndexi = workbook.getSheetAt(0).getLastRowNum();
        // tum ulkeler
        for (int i = 0 ; i<=sonSatirIndexi ; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        // tüm baskentler
        for (int j = 0 ; j<=sonSatirIndexi ; j++ ) {
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }

        // bir satirin son sutununun indexini alma
        // 1 ' den basliyor
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sutun Index : " + sonSutunIndex);


        System.out.println("=======================");
        //4 satirdaki tum kelimeler
        for (int i = 0 ; i<sonSutunIndex ; i ++ ) {
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(i));
        }

        for(int k = 0; k < sonSutunIndex ; k++){
            System.out.println("4. Satır " + k +". Sütun :" + workbook.getSheetAt(0).getRow(3).getCell(k) );
        }
    }
}
