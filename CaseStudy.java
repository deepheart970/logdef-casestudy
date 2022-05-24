import java.util.Set;
import java.util.HashSet;

public class CaseStudy {
    public static void main(String[] args) {
        // Test veri girişleri
        int[] exArr = {1, 1, 2, 2, 3};
        migratoryBirds(exArr);
        int[] exArr2 = {1, 2, 3, 4, 5, 4, 3, 2 ,1 ,3, 4};
        migratoryBirds(exArr2, 11);
    }

    // Bu fonksiyon kuş türü adedinin girilmediği durumlarda override fonksiyon çalışması için yapılmıştır
    // Kuş türü sayısını otomatik bulur.
    public static void migratoryBirds(int[] arr){
        // HashSet veriyapısı, aynı elemandan sadece bir adet barındırır
        Set<Integer> birds = new HashSet<>();
        // Bütün kuşlar, birds Set'ine girilir
        for (int i = 0; i < arr.length; i++){
            birds.add(arr[i]);
        }
        // Kuş dizisi ve kuş türü sayısı kullanılarak asıl fonksiyon çağırılır
        migratoryBirds(arr, birds.size());
    }
    /*
        // Yukarıdaki override a alternatif olarak yapılmıştır
        public static void migratoryBirds(int[] arr){
            migratoryBirds(arr, arr.length);
        }
    */

    public static void migratoryBirds(int[] arr, int birdSpecies){
        // Girilen kuş türü boyutunda bir dizi oluşturulur
        int[] birdRepeatArray = new int[birdSpecies];
        // Hata önlemi için dizi elemanları 0 olarak atanır
        for (int i = 0; i < birdSpecies; i++){
            birdRepeatArray[i] = 0;
        }
        // arr dizisindeki her kuş okunur ve her tekrar edilen kuş, kuş tekrar dizisi indisine kaydedilir
        for (int i = 0; i < arr.length; i++){
            birdRepeatArray[arr[i]-1]++;
        }
        // dizinin ilk elemanı en çok tekrar edilen eleman kabul ediliyor
        // bunun sebebi döngü içerisinde sıradaki türler ile kıyaslanacak
        int mostRepeatAmount = birdRepeatArray[0];
        // aynı şekilde ilk elemanın karşılık geldiği kuş türü tutulur
        int mostRepeatedBird = 1;
        // döngü içerisinde bütün tekrar edilen kuş türleri arasında en çok tekrar eden en küçük
        // değerli tür aranır
        for (int i = 1; i < birdSpecies; i++){
            // okunan kuş türünün tekrar sayısı tutlandan büyükse
            if (mostRepeatAmount < birdRepeatArray[i]){
                mostRepeatAmount = birdRepeatArray[i];
                // tekrar edilen kuşun karşılık geldiği kuş enum değeri atanır
                mostRepeatedBird = i + 1;
            }
        }
        // en çok tekrar eden kuşun çıktısı verilir
        System.out.println(mostRepeatedBird);
    }
}
