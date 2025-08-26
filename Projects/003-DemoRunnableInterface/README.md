
# 001-DemoThreadClass

### Ders-04
- thread safe methods (thread güvenli metotlar): Örneğin `printf` metodu
- race conditions (yarış durumu koşulları)
- işlemci
- işletim sistemi
- thread synchronization
- device driver
- iki tane process'i konuşturmak (inter process communication - IPC mekanizması)
- thread'lerin bellekteki stack ve heap alanları

### Code Snippets
- Programı komut satırından çalıştırmak için terminalde sırasıyla şu komutlar çalıştırılır:
  - Çıktıları console'a yazdırmak için:
    ```cmd
    PS C:\Users\edaakyil\Documents\Repositories\csd\Java\JavaApp-2\Projects\001-DemoThreadClass> mvn package
    PS C:\Users\edaakyil\Documents\Repositories\csd\Java\JavaApp-2\Projects\001-DemoThreadClass> cd .\target\
    PS C:\Users\edaakyil\Documents\Repositories\csd\Java\JavaApp-2\Projects\001-DemoThreadClass\target> java -jar .\DemoThreadClass-1.0.0.jar
    ```
  - Çıktıları dosyaya yazdırmak için yazdırmak için:
    ```cmd
    PS C:\Users\edaakyil\Documents\Repositories\csd\Java\JavaApp-2\Projects\001-DemoThreadClass> mvn package
    PS C:\Users\edaakyil\Documents\Repositories\csd\Java\JavaApp-2\Projects\001-DemoThreadClass> cd .\target\
    PS C:\Users\edaakyil\Documents\Repositories\csd\Java\JavaApp-2\Projects\001-DemoThreadClass\target> java -jar .\DemoThreadClass-1.0.0.jar > output.txt
    ```
    Not: Yukarıdaki output.txt dosyası target dizini içerisinde yaratılır.