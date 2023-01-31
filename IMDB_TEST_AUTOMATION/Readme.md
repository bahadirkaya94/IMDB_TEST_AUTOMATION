# IMDB(www.imdb.com) Testing

Menüden Bulunan Filmlerle Arama Çubuğu Üzerinden Bulunan Filmlerin Özelliklerinin Aynı Olup Olmadığı ve Filmlere Ait Resimlerin Linklerinin Kırık Olup Olmadığı Test Edilmiştir
## Projenin Adımları

**1-**
www.imdb.com adresine gidilir.

**2-**
Arama çubuğunun sol tarafında bulunan Menu butonuna tıklanılır.

**3-**
Gelen ekranda "Award & Events" başlığı altında blunan "Oscars" butonuna tıklanılır.

**4-**
"Event History" başlığı altında 1929'a tıklanılır.

**5-** "Honorary Award" başlığı altında bulunan The Circus'a tıklanılır.

**6-** Gelen ekranda The Circus'a ait Director, Writer ve Stars bilgileri kayıt edilir.

**7-** Ekranın sol üstünde bulunan "IMDb" butonuna tıklayarak Anasayfaya dönülür.

**8-** Arama çubuğuna "The Circus" yazılır.

**9-** Sonuçlar arasında gelen The Circus'a tıklanılır.

**10-** Gelen ekranda The Circus'a ait Director, Writer ve Stars bilgilerinin kayıt edilen bilgilerle aynı mı olduğu kontrol edilir.

**11-** Kontrol yapıldıktan sonra "Photos" butonuna tıklanılır.

**12-** Gelen ekrandaki bütün fotoğrafların linklerinin kırık olup olmadığı kontrol edilir.

**NOT** Aynı işlemler "The Jazz Singer" filmi içinde yapılmalıdır.



**BEKLENİLEN SONUÇ**

**• Director:** bilgisi değişmemeli

**• Writer:** bilgisi değişmemeli

**• Stars:** bilgisi değişmemeli.

• Filmle alakalı fotoğrafların linkleri kırık olmamalı.



## Projede Kullanılan Teknolojiler

**Programlama Dili**
Java 1.8.0

**Test Otomasyon Frameworkleri**

Selenium 4.4.0

Cucumber 7.8.1

TestNG 6.8.7

**Api Test Framework :**
Rest-Assured 4.2.0

**Web Driver :**
Github.bonigarcia 5.3.0

**Raporlama :**
Masterthought 5.7.2

**Loglama :**
Apache.log4j 2.17.1

## Testi Koşturma Adımları

1- Öncelikle proje "Clean" edilir.

2- Build Project yapılır.

3- "src/test/java/XMLFiles/IMDB_MasterReport.xml"  dosyası Run edilir.



