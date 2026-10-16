// Kotlin - prvi koraci: zadaci za vježbu

// Svaki zadatak je u svojoj funkciji (zadatak1_1, zadatak1_2, ...),
// a main() na dnu fajla poziva sve zadatke redom.


// ============================================================
// NIVO 1 – Lakši
// ============================================================

// ------------------------------------------------------------
// Zadatak 1.1 – Lična karta
fun zadatak1_1() {
    val ime = "Hedija";
    var godine = 22;
    println("Ja se zovem $ime, imam $godine godine i živim u Živinicama.");
    godine++;
    println("Slijedeće godine ću imati $godine.");
}

// ------------------------------------------------------------
// Zadatak 1.2 – Pravougaonik
fun zadatak1_2() {
    fun area(a: Double, b: Double): Double {
        return a*b;
    }
    fun perimeter(a: Double, b: Double) = 2*a + 2*b;
    println("površina: ${area(5.0,3.5)}");
    println("obim: ${perimeter(5.0,3.5)}");
}

// ------------------------------------------------------------
// Zadatak 1.3 – Brojanje
fun zadatak1_3() {
    for (i in 1..10 step 1) print("$i ");
    print("\n")
    for (a in 10 downTo 1) print("$a ");
    print("\n")
    for (c in 2..20 step 2) print("$c ")
    print("\n")
}

// ------------------------------------------------------------
// Zadatak 1.4 – Suma niza
fun zadatak1_4() {
    val niz = intArrayOf(4,8,15,16,23,42);
    println("niz ima ${niz.size} elemenata")
    var suma = 0;
    for (i in niz) suma+=i;
    println("suma: $suma")
}


// ============================================================
// NIVO 2 – Srednji
// ============================================================

// ------------------------------------------------------------
// Zadatak 2.1 – Parni brojevi
fun zadatak2_1() {
    fun isEven(n: Int): Boolean {
        return n%2==0;
    }
    var parni = 0;
    for(i in 1..50 step 1) {
        if(isEven(i) == true) {
            print("$i ");
            parni++;
        }
    }
    print("\n")
    println("parni: $parni ")
}

// ------------------------------------------------------------
// Zadatak 2.2 – Statistika ocjena
fun zadatak2_2() {
    val ocjene = intArrayOf(7, 9, 6, 10, 8, 8, 6, 9);
    var min = ocjene[0];
    var max = ocjene[0];
    var suma = 0;
    for(i in ocjene) {
        if (i < min) {
            min = i;
        }
        else if (i>max) {
            max = i;
        }
        suma += i;
    }
    val prosjek = suma.toDouble() / ocjene.size;
    val noviProsj = "%.2f".format(prosjek);
    println("Najveća ocjena je $max");
    println("Najmanja ocjena je $min");
    println("Prosjek je $noviProsj");
}

// ------------------------------------------------------------
// Zadatak 2.3 – Tablica množenja
fun zadatak2_3() {
    for (i in 1..10 step 1) {
        for (a in 1..10 step 1) {
            print((i * a).toString().padStart(4))
        }
        print("\n")
    }
}

// ------------------------------------------------------------
// Zadatak 2.4 – Bodovi u ocjenu
fun zadatak2_4() {
    fun grade(points: Int): Int {
        if (points <= 54 ) { return 5; }
        else if(points > 54 && points <=64) { return 6;}
        else if(points > 64 && points <=74 ) {return 7;}
        else if(points >74 && points <= 84) {return 8;}
        else if(points >84 && points <= 94) {return 9;}
        else if(points >94 && points <=100) {return 10;}
        else return 0;
    }
    val ocjene = intArrayOf(45, 58, 67, 79, 88, 99);
    for (i in ocjene) {
        println("$i bodova -> ocjena je ${grade(i)}");
    }
}


// ============================================================
// NIVO 3 – Teži
// ============================================================

// ------------------------------------------------------------
// Zadatak 3.1 – Obrni niz
fun zadatak3_1() {
    fun reverseInPlace(arr: IntArray) : IntArray {
        for (i in 0 until arr.size/2) {
            val temp = arr[i];
            arr[i] = arr[arr.size - 1 - i]
            arr[arr.size - 1 - i] = temp
        }
        return arr
    }
    val niz = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    println("prije: ${niz.contentToString()}")

    reverseInPlace(niz);
    println("poslije: ${niz.contentToString()}")
}

// ------------------------------------------------------------
// Zadatak 3.2 – Prosti brojevi
fun zadatak3_2() {
    fun isPrime(n:Int) : Boolean {
        if (n<2) return false;
        for(i in 2..n-1) {
            if(n%i ==0 ) return false;
        }
        return true;
    }
    var suma = 0;
    for(a in 0..50) {
        var uslov = isPrime(a);
        if (uslov==true) {
            print("$a ")
            suma++;
        }
    }
    print("\n")
    println("Prostih brojeva od 50: $suma");
}

// ------------------------------------------------------------
// Zadatak 3.3 – Bubble sort
fun zadatak3_3() {
    var niz = intArrayOf(29,3,72,15,8,41)
    println("Prije sortiranja: ${niz.contentToString()}")
    for(i in 0 until niz.size-1) {
        for (j in 0 until niz.size-1-i) {
            if(niz[j] > niz[j+1]) {
                var temp = niz[j]
                niz[j] = niz[j+1]
                niz[j+1] = temp;
            }
        }
    }
    println("Nakon sortiranja: ${niz.contentToString()}")
}

// ------------------------------------------------------------
// Bonus zadatak – Drugi najveći
fun zadatakBonus() {
    fun secondLargest(arr: IntArray) : Int {
        var first = Int.MIN_VALUE;
        var second = Int.MIN_VALUE;
        for(i in arr) {
            if (i > first) {
                second = first;
                first = i;
            }
            else if (i < first && i > second) {
                second = i;
            }
        }
        return second;
    }
    val niz = intArrayOf(12, 45, 7, 45, 33, 21)
    println("Drugi najveći: ${secondLargest(niz)}")
}


// ------------------------------------------------------------
// main – poziva sve zadatke redom
fun main() {
    println("--- Zadatak 1.1 ---"); zadatak1_1()
    println("--- Zadatak 1.2 ---"); zadatak1_2()
    println("--- Zadatak 1.3 ---"); zadatak1_3()
    println("--- Zadatak 1.4 ---"); zadatak1_4()

    println("--- Zadatak 2.1 ---"); zadatak2_1()
    println("--- Zadatak 2.2 ---"); zadatak2_2()
    println("--- Zadatak 2.3 ---"); zadatak2_3()
    println("--- Zadatak 2.4 ---"); zadatak2_4()

    println("--- Zadatak 3.1 ---"); zadatak3_1()
    println("--- Zadatak 3.2 ---"); zadatak3_2()
    println("--- Zadatak 3.3 ---"); zadatak3_3()
    println("--- Bonus zadatak ---"); zadatakBonus()
}