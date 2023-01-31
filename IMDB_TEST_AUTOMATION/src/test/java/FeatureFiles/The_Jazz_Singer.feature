@SmokeTest
Feature: Menu uzerinden gidilerek film bulunur ve bu film arama cubugundan arattirılir. Director, Writer, Stars
  bilgilerinin aynı oldugu dogrulanir ve filmin gorsellerinin linklerinin kirik olup olmadigi dogrulanir

  Background:

    Given www.imdb.com adresine gidilir
    When Arama cubugunun sol tarafinda bulunan Menu butonuna basilir
    Then Gelen ekranda “Award & Events” basligi altinda bulunan “Oscars” butonuna tiklanir
    And “Event History” basligi altinda 1929 secilir

    Scenario: Menuden bulunan filmle arama cubugu uzerinden bulunan film ozellikleri ayni olmalidir ve
              filme ait gorsellerin linkleri kirik olmamalidir

      Then “Honorary Award” basligi altinda The Jazz Singer secilir
      And Gelen ekranda, filme ait; Director, Writer ve Stars bilgileri kayit edilir
      Then Ekranin sol ustunde bulunan “IMDb” butonuna tiklanarak “Anasayfa”ya donulur
      Given Arama cubuguna “The Jazz Singer” yazilir
      When Sonuclar arasinda gelen “The Jazz Singer”a tiklanir
      Then Gelen ekranda; The Jazz Singer'a ait Director, Writer ve Stars bilgisi kayit edilen bilgilerle ayni mi kontrol edilir
      And Kontroller yapildiktan sonra “Photos” linkine tiklanir
      Then Gelen ekranda butun fotograflarin linklerinin kirik olmadigi kontrol edilir



