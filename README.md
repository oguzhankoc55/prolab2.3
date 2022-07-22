# Prolab2 3. Proje
# MÜZİK DOSYAM

# 1. ÖZET
“Müzik Dosyam” adlı projemizde kullanıcıların (Premium ve normal olmak üzere) Şarkı
dinleyeceği, Premium kullanıcıların çalma listelerinin takip edilebileceği ve tüm kullanıcıların çalma listelerinin oluşacağı bir müzik uygulaması için veri tabanı geliştirilmiştir. Bu proje masaüstü uygulaması olarak yapılmıştır.

# 2. GİRİŞ
Müzik Dosyam projesinde kullanmak üzere ‘MySQL Workbench’ üzerinde prolab isimli bir şema oluşturduk. Bu şemamızda projenin isterleri olan tablolarımızı oluşturduk. Burada oluşturduğumuz database ’i programımızda kullandık.
Program, buradan aldığımız bilgiler doğrultusunda kullanıcıyı başlangıçta iki seçenek
sunar. Bunlar admin ve kullanıcı seçenekleridir. Ardından Eğer admin olan kullanıcımız admin seçeneğini tercih eder ise tüm kullanıcıların şarkı , albüm, şarkıcı ve kullanıcı
özelliklerini değiştirebilme yetkisi verilir. Kullanıcı için şarkı dinleme ,kendi listeleri üzerinde değişiklik yapma yetkisi verilir .Kullanıcı ikiye ayrılır .Bunlar normal ve premiumdur. Premium kullanıcılar için ekstra olarak takip edilebilme ve para ödeme özellikleri de bulunur.


# 3. Yöntem
Program Java programla dilinde geliştirdik. Geliştirme ortamı olarak ise “Eclipse IDE
for Java Developers-2020-09” kullandık. Veri tabanı yönetim sistemi için MySQL’i kullandık.
Projemize başlarken öncelikle yol haritamızı çıkardık. Projenin isterlerini analiz edip bu isterler üzerine araştırmalar yaptık.
Kullandığımız tablolar :
## kullanici:
Bu tabloda bireyin kişisel bilgileri(id,ad,üyelik türü,email,sifre,ulke) bulunur. (1NF)

## kullanici_islem:
Bu tabloda bireyin üyelik türü bilgisi bulunur. (2NF)
## tur:
Bu tabloda şarkıların ve listelerin türleri bulunur. (1NF) ulke:Bu tabloda sanatçıların ülke bilgileri tutulur. (3NF) sanatci: Bu tabloda şarkıların sanatçı bilgisi tutulur. (2NF)
## sarki:
Bu tabloda sistemde bulunan şarkıların özellikleri tutulur.(1NF) album: Bu tabloda sistemde bulunan albümlerin özellikleri tutulur. (1NF) albüm_islem: Bu tabloda albümün içindeki şarkıların bilgileri bulunur. (2NF)
## liste: 
Bu tabloda kullanıcıların sahip olduğu listeler türlerine göre bulunur. (1NF)
## liste_islem: 
Bu tabloda listelerin içindeki şarkı bilgisi tutulur. (2NF)
## takip: 
Bu tabloda kullanıcıların takip etme durumları tutulur. (2NF)
## odenme: 
Bu tabloda Premium kullanıcıların ödeme durumları bulunur. (2NF)


# 4. Deneysel Sonuçlar
- MySQL ve java programları arasında bağlantı oluştururken sorunlar yaşadık .Bu konu hakkında araştırma yaptık.
- Tablolar arasındaki ilişkileri kurarken sıkıntı yaşadık. Deneme yanılma yöntemiyle sorunu hallettik.
- Java da görselleştirme yaparken sıkıntılar yaşadık. Bu doğrultuda araştırmalar yaptık.
# 5. Pseudo(sözde) Kod

1- Program çalıştırıldı.

2- Kullanıcı yada admin seçimi yapılır.

3- Kullanıcının bilgileri doğrulandıktan sonra kullanıcının kendi ekranı açılır. Kullanıcı admin olarak giriş yaparsa:

4- Bulunan tüm şarkılar üzerinde şarkı ekleme, düzenleme ve silme yapabilir .

5- Bulunan tüm albüm üzerinde albüm ekleme, düzenleme ve silme yapabilir .

6- Bulunan tüm şarkıcılar üzerinde şarkıcı ekleme, düzenleme ve silme yapabilir .

7- Bulunan tüm kullanıcılar üzerinde kullanıcı ekleme, düzenleme ve silme yapabilir .

8-Kullanıcı olarak  giriş yapıldıktan sonra

9- Sınıflandırmalarına göre top10 listeleri gösterilebilir.

10- İsteğe bağlı olarak kullanıcı kendi çalma listesine şarkı ekleyebilir veya kaldırabilir.

11- İsteğe bağlı olarak kullanıcı kendi takip listesine premium kullanıcı ekleyebilir veya kaldırabilir. Takip ettiği kullanıcıların çalma listesindeki şarkıları kendi listesine ekleyebilir.

12- Kullanıcı dinlemek istediği şarkı için dinle butonunu kullanabilir. Böylece şarkının dinlenme sayısı artar.

13- Eğer kullanıcı premium üye ise kullanıcının takipçiler butonu kullanıcını kendi takipçilerini görmesini sağlar.

14- Premium kullanıcının ödeme yapma ve kontrol etme yetkisi verilir.

# 6- EER Diyagramı

![image](https://user-images.githubusercontent.com/58952369/180400393-99f6baf6-65aa-4fd0-a0bd-177cf02aa83d.png)


# 7- Ekran Çıktıları

![image](https://user-images.githubusercontent.com/58952369/180400411-845d9af7-4659-4b43-90c7-ae90dde6b584.png)

![image](https://user-images.githubusercontent.com/58952369/180400445-57fcf7e3-c910-49e0-8b6e-bb67a99f9a87.png)

![image](https://user-images.githubusercontent.com/58952369/180400474-b679eded-1bf4-4b91-b974-487a5d8e1a3d.png)

![image](https://user-images.githubusercontent.com/58952369/180400503-1e3900ba-08ea-4e42-b4c5-89fba689c6d5.png)



# 8- Kaynakça

http://edestek.kocaeli.edu.tr/

https://dev.mysql.com/doc/mysql-tutorial-excerpt/8.0/en/examples.html

http://stackoverflow.com/

https://www.youtube.com/

https://www.w3schools.com/
